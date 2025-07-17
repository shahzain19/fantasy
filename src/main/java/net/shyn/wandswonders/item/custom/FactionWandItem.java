package net.shyn.wandswonders.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.shyn.wandswonders.factions.Faction;
import net.shyn.wandswonders.factions.FactionRegistry;

public class FactionWandItem extends Item {
    public FactionWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));

        BlockPos pos = user.getBlockPos();
        Identifier biomeId = world.getBiome(pos).getKey().map(id -> id.getValue()).orElse(null);

        Faction found = null;
        for (Faction faction : FactionRegistry.getAll().values()) {
            if (faction.getBiome().equals(biomeId)) {
                found = faction;
                break;
            }
        }

        if (found != null) {
            user.sendMessage(Text.literal("📜 This biome belongs to the faction: §a" + found.name), false);
        } else {
            user.sendMessage(Text.literal("❌ No faction controls this biome."), false);
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }
}
