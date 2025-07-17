package net.shyn.wandswonders.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.shyn.wandswonders.screen.slot.ModResultSlot;

public class AlchemyCauldronScreenHandler extends ScreenHandler {

    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final BlockPos pos;
    private final World world;

    public final Slot inputA;
    public final Slot inputB;
    public final Slot inputC;
    public final Slot output;

    public boolean hasRecipeIngredients() {
        return !inventory.getStack(0).isEmpty()
                && !inventory.getStack(1).isEmpty()
                && !inventory.getStack(2).isEmpty();
    }

    public Slot getOutputSlot() {
        return this.output;
    }



    public
    AlchemyCauldronScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        this(syncId, playerInventory, new SimpleInventory(4), new ArrayPropertyDelegate(2), pos);
    }

    public AlchemyCauldronScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory,
                                        PropertyDelegate delegate, BlockPos pos) {
        super(ModScreenHandlers.ALCHEMY_CAULDRON_SCREEN_HANDLER, syncId);
        this.inventory = inventory;
        this.propertyDelegate = delegate;
        this.pos = pos;
        this.world = playerInventory.player.getWorld();

        this.addProperties(delegate);



        // Ingredient slots
        this.inputA = this.addSlot(new Slot(inventory, 0, 30, 35));
        this.inputB = this.addSlot(new Slot(inventory, 1, 48, 35));
        this.inputC = this.addSlot(new Slot(inventory, 2, 66, 35));

        // Result slot
        this.output = this.addSlot(new Slot(inventory, 3, 120, 17) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });
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
    public ItemStack quickMove(PlayerEntity player, int index) {
        return ItemStack.EMPTY; // You can handle shift-clicking later
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

    public boolean canCraft() {
        return !inputA.getStack().isEmpty()
                && !inputB.getStack().isEmpty()
                && !inputC.getStack().isEmpty()
                && output.getStack().isEmpty();
    }

    // Screen Factory class
    public static class Factory implements net.minecraft.screen.NamedScreenHandlerFactory {
        private final BlockPos pos;

        public Factory(BlockPos pos) {
            this.pos = pos;
        }

        @Override
        public net.minecraft.text.Text getDisplayName() {
            return net.minecraft.text.Text.literal("Alchemy Cauldron");
        }

        @Override
        public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
            return new AlchemyCauldronScreenHandler(syncId, playerInventory, pos);
        }
    }
}
