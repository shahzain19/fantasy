package net.shyn.wandswonders.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.shyn.wandswonders.screen.AlchemyCauldronScreenHandler;
import org.jetbrains.annotations.Nullable;

public class AlchemyCauldronBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos> {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    public AlchemyCauldronBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ALCHEMY_CAULDRON_BE, pos, state);
    }

    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Alchemy Cauldron");
    }

    // 👇 This provides the position to the client
    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
        return getPos();
    }

    // 👇 This constructs the correct screen handler
    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AlchemyCauldronScreenHandler(syncId, playerInventory, this.getPos());
    }

    // 💡 Brewing logic will go here later
    public static void tick(World world, BlockPos pos, BlockState state, AlchemyCauldronBlockEntity blockEntity) {
        // TODO: Alchemy logic here
    }
}
