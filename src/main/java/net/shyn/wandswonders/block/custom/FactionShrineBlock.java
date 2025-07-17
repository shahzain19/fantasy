package net.shyn.wandswonders.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.shyn.wandswonders.factions.Faction;
import net.shyn.wandswonders.factions.FactionRegistry;
import net.shyn.wandswonders.factions.player.FactionManager;
import net.shyn.wandswonders.factions.player.PlayerFactionData;

public class FactionShrineBlock extends Block {
    public FactionShrineBlock(Settings settings) {
        super(settings);
    }



    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;

        Identifier biomeId = world.getBiome(pos).getKey().map(id -> id.getValue()).orElse(null);

        Faction faction = null;
        for (Faction f : FactionRegistry.getAll().values()) {
            if (f.getBiome().equals(biomeId)) {
                faction = f;
                break;
            }
        }

        if (faction == null) {
            player.sendMessage(Text.literal("❌ No faction linked to this shrine's biome."), false);
            return ActionResult.SUCCESS;
        }

        PlayerFactionData data = FactionManager.get((ServerWorld) world, player.getUuid());
        int rep = data.getReputation(faction.getId());

        player.sendMessage(Text.literal("this is a shrine of some one" + faction.name), false);
        player.sendMessage(Text.literal("📊 Reputation: " + rep), false);

        return ActionResult.SUCCESS;
    }
}
