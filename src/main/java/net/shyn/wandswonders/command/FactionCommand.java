package net.shyn.wandswonders.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.shyn.wandswonders.entity.ModEntities;
import net.shyn.wandswonders.entity.custom.FactionGuardEntity;
import net.shyn.wandswonders.factions.FactionRegistry;
import net.shyn.wandswonders.factions.player.FactionManager;
import net.shyn.wandswonders.factions.player.PlayerFactionData;
import net.shyn.wandswonders.world.structure.ModStructureHelper;

public class FactionCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("factions")
                // /factions list
                .then(CommandManager.literal("list")
                        .executes(ctx -> {
                            FactionRegistry.getAll().forEach((id, faction) -> {
                                ctx.getSource().sendFeedback(
                                        () -> Text.literal("✅ " + faction.name + " [" + id + "]"), false);
                            });
                            return 1;
                        })
                )

                .then(CommandManager.literal("spawn")
                        .then(CommandManager.argument("structure", IdentifierArgumentType.identifier())
                                .executes(ctx -> {
                                    ServerPlayerEntity player = ctx.getSource().getPlayer();
                                    ServerWorld world = ctx.getSource().getWorld();
                                    BlockPos pos = player.getBlockPos().add(0, 1, 0);

                                    Identifier id = IdentifierArgumentType.getIdentifier(ctx, "structure");

                                    boolean result = ModStructureHelper.generateStructure(world, pos, id);

                                    if (result) {
                                        ctx.getSource().sendFeedback(() -> Text.literal("✅ Structure spawned: " + id), false);
                                    } else {
                                        ctx.getSource().sendError(Text.literal("❌ Failed to spawn structure: " + id));
                                    }

                                    return 1;
                                })
                        )
                )

                .then(CommandManager.literal("join")
                        .then(CommandManager.argument("faction", IdentifierArgumentType.identifier())
                                .executes(ctx -> {
                                    ServerPlayerEntity player = ctx.getSource().getPlayer();
                                    Identifier id = IdentifierArgumentType.getIdentifier(ctx, "faction");

                                    var faction = FactionRegistry.get(id);
                                    if (faction == null) {
                                        ctx.getSource().sendError(Text.literal("❌ No such faction: " + id));
                                        return 0;
                                    }

                                    var data = FactionManager.get(player);
                                    data.setCurrentFaction(id);

                                    ctx.getSource().sendFeedback(() ->
                                            Text.literal("✅ You are now part of: " + faction.name), false);

                                    return 1;
                                }))
                )


                // /factions getrep <faction_id>
                .then(CommandManager.literal("getrep")
                        .then(CommandManager.argument("faction", IdentifierArgumentType.identifier())
                                .executes(ctx -> {
                                    ServerPlayerEntity player = ctx.getSource().getPlayer();
                                    Identifier factionId = IdentifierArgumentType.getIdentifier(ctx, "faction");

                                    PlayerFactionData data = FactionManager.get(player);
                                    int rep = data.getReputation(factionId);

                                    ctx.getSource().sendFeedback(() ->
                                            Text.literal("📊 Reputation with " + factionId + ": " + rep), false);
                                    return 1;
                                })
                        )
                )

                // /factions setrep <faction_id> <amount>
                .then(CommandManager.literal("setrep")
                        .then(CommandManager.argument("faction", IdentifierArgumentType.identifier())
                                .then(CommandManager.argument("amount", IntegerArgumentType.integer())
                                        .executes(ctx -> {
                                            ServerPlayerEntity player = ctx.getSource().getPlayer();
                                            Identifier factionId = IdentifierArgumentType.getIdentifier(ctx, "faction");
                                            int amount = IntegerArgumentType.getInteger(ctx, "amount");

                                            PlayerFactionData data = FactionManager.get(player);
                                            data.setReputation(factionId, amount);

                                            ctx.getSource().sendFeedback(() ->
                                                    Text.literal("✅ Set rep with " + factionId + " to " + amount), false);
                                            return 1;
                                        })
                                )
                        )
                )

                // /factions adjustrep <faction_id> <amount>
                .then(CommandManager.literal("adjustrep")
                        .then(CommandManager.argument("faction", IdentifierArgumentType.identifier())
                                .then(CommandManager.argument("amount", IntegerArgumentType.integer())
                                        .executes(ctx -> {
                                            ServerPlayerEntity player = ctx.getSource().getPlayer();
                                            Identifier factionId = IdentifierArgumentType.getIdentifier(ctx, "faction");
                                            int delta = IntegerArgumentType.getInteger(ctx, "amount");

                                            PlayerFactionData data = FactionManager.get(player);
                                            data.adjustReputation(factionId, delta);

                                            ctx.getSource().sendFeedback(() ->
                                                    Text.literal("🔁 Adjusted rep with " + factionId + " by " + delta), false);
                                            return 1;
                                        })
                                )
                        )
                )
                .then(CommandManager.literal("spawnguard")
                        .then(CommandManager.argument("faction", IdentifierArgumentType.identifier())
                                .executes(ctx -> {
                                    try {
                                        ServerPlayerEntity player = ctx.getSource().getPlayer();
                                        ServerWorld world = ctx.getSource().getWorld();
                                        BlockPos pos = player.getBlockPos().add(0, 1, 0);

                                        Identifier factionId = IdentifierArgumentType.getIdentifier(ctx, "faction");
                                        System.out.println("➡️ Requested to spawn guard for: " + factionId);

                                        if (ModEntities.FACTION_GUARD == null) {
                                            System.out.println("❌ FACTION_GUARD entity is null!");
                                            ctx.getSource().sendError(Text.literal("❌ Guard entity type not registered."));
                                            return 0;
                                        }

                                        var faction = FactionRegistry.get(factionId);
                                        if (faction == null) {
                                            System.out.println("❌ No such faction: " + factionId);
                                            ctx.getSource().sendError(Text.literal("❌ Unknown faction: " + factionId));
                                            return 0;
                                        }

                                        // ✅ Create entity with correct constructor
                                        FactionGuardEntity guard = ModEntities.FACTION_GUARD.create(world);
                                        if (guard == null) {
                                            System.out.println("❌ Failed to create guard instance!");
                                            ctx.getSource().sendError(Text.literal("❌ Failed to create guard instance."));
                                            return 0;
                                        }

                                        guard.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                                        guard.setFaction(factionId);

                                        System.out.println("✅ Guard created and initialized.");

                                        boolean spawned = world.spawnEntity(guard);
                                        System.out.println("🌱 Spawn result: " + spawned);

                                        if (!spawned) {
                                            ctx.getSource().sendError(Text.literal("❌ Failed to spawn guard."));
                                            return 0;
                                        }

                                        ctx.getSource().sendFeedback(() ->
                                                Text.literal("🛡️ Spawned guard for faction: " + faction.name), false);

                                        return 1;
                                    } catch (Exception e) {
                                        e.printStackTrace(); // 🔥 will log exact crash
                                        ctx.getSource().sendError(Text.literal("❌ Unexpected error: " + e.getMessage()));
                                        return 0;
                                    }
                                })
                        )

                )


        );
    }
}
