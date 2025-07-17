package net.shyn.wandswonders.world.structure;// net/shyn/wandswonders/command/BazaarCommand.java

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.shyn.wandswonders.world.structure.BazaarStructure;

import static net.minecraft.server.command.CommandManager.literal;

public class BazaarCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                literal("spawn_bazaar")
                        .requires(source -> source.hasPermissionLevel(2))
                        .executes(context -> {
                            ServerCommandSource source = context.getSource();
                            ServerWorld world = source.getWorld();

                            // ✅ Get block position from source's position (floored)
                            BlockPos pos = BlockPos.ofFloored(source.getPosition());

                            // Place the structure
                            BazaarStructure.place(world, pos);

                            source.sendFeedback(() -> Text.literal("✅ Bazaar spawned at your position!"), false);
                            return 1;
                        })
        );
    }
}
