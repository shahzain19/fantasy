package net.shyn.wandswonders.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.shyn.wandswonders.block.entity.StudyTableBlockEntity;
import net.shyn.wandswonders.screen.slot.ModResultSlot;

public class StudyTableScreenHandler extends ScreenHandler {

    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final BlockPos pos;
    private final World world;

    // Expose input/result slots to screen
    public final Slot inputFragment;
    public final Slot inputInk;
    public final Slot inputScroll;
    public final Slot outputSlot;

    public StudyTableScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        this(syncId, playerInventory, (StudyTableBlockEntity) playerInventory.player.getWorld().getBlockEntity(pos),
                new ArrayPropertyDelegate(2), pos);
    }

    public StudyTableScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory,
                                   PropertyDelegate delegate, BlockPos pos) {
        super(ModScreenHandlers.STUDY_TABLE_SCREEN_HANDLER, syncId);
        this.inventory = inventory;
        this.propertyDelegate = delegate;
        this.pos = pos;
        this.world = playerInventory.player.getWorld();

        // Sync state
        this.addProperties(delegate);

        // Input slots
        this.inputFragment = this.addSlot(new Slot(inventory, 0, 38, 35)); // Knowledge Fragment
        this.inputInk     = this.addSlot(new Slot(inventory, 1, 56, 35)); // Ink
        this.inputScroll  = this.addSlot(new Slot(inventory, 2, 74, 35)); // Blank Scroll

        // Output slot
        this.outputSlot   = this.addSlot(new ModResultSlot(inventory, 3, 122, 35));

        // Player inventory + hotbar
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 70 + row * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 128));
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        // Implement if you want shift-click transfers
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return inventory.canPlayerUse(player);
    }

    public PropertyDelegate getPropertyDelegate() {
        return this.propertyDelegate;
    }

    public BlockPos getBlockPos() {
        return pos;
    }

    // ✅ UI logic helper — should show glow overlay
    public boolean canCraft() {
        return !inputFragment.getStack().isEmpty()
                && !inputInk.getStack().isEmpty()
                && !inputScroll.getStack().isEmpty()
                && outputSlot.getStack().isEmpty();
    }
}
