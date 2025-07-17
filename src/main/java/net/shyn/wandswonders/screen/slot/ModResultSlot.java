package net.shyn.wandswonders.screen.slot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class ModResultSlot extends Slot {

    public ModResultSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    // ❌ Prevent placing anything into this slot
    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }

    // ✅ When the player takes the item, we can run custom logic here
    @Override
    public void onTakeItem(PlayerEntity player, ItemStack stack) {
        super.onTakeItem(player, stack);
        // You can add sound, particles, or trigger an advancement
        player.playSound(net.minecraft.sound.SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, 1.0F, 1.0F);
    }
}
