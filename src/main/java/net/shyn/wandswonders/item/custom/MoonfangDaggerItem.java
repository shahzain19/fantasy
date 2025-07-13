package net.shyn.wandswonders.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MoonfangDaggerItem extends SwordItem {

    public MoonfangDaggerItem(ToolMaterial material, Settings settings) {
        super(material, settings.maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            Vec3d look = player.getRotationVec(1.0f);
            Vec3d newPos = player.getPos().add(look.multiply(4.0)); // 4-block dash
            player.requestTeleport(newPos.x, newPos.y, newPos.z);

            // Optional: play sound
            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.2f);
        }

        return TypedActionResult.success(player.getStackInHand(hand), world.isClient());
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.NONE;
    }
}
