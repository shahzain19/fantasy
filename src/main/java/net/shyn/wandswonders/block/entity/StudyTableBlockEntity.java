    package net.shyn.wandswonders.block.entity;

    import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
    import net.minecraft.item.Item;
    import net.minecraft.particle.ParticleTypes;
    import net.minecraft.server.world.ServerWorld;
    import net.minecraft.sound.SoundCategory;
    import net.minecraft.sound.SoundEvents;
    import net.shyn.wandswonders.block.ModBlocks;
    import net.shyn.wandswonders.item.ModItems;
    import net.shyn.wandswonders.item.custom.MagicWandItem;
    import net.shyn.wandswonders.magic.Spell;
    import net.shyn.wandswonders.magic.SpellRegistry;
    import net.shyn.wandswonders.screen.StudyTableScreenHandler;
    import net.minecraft.block.BlockState;
    import net.minecraft.block.entity.BlockEntity;
    import net.minecraft.entity.player.PlayerEntity;
    import net.minecraft.entity.player.PlayerInventory;
    import net.minecraft.inventory.Inventories;
    import net.minecraft.item.ItemStack;
    import net.minecraft.nbt.NbtCompound;
    import net.minecraft.network.PacketByteBuf;
    import net.minecraft.registry.RegistryWrapper;
    import net.minecraft.screen.ScreenHandler;
    import net.minecraft.server.network.ServerPlayerEntity;
    import net.minecraft.text.Text;
    import net.minecraft.util.collection.DefaultedList;
    import net.minecraft.util.math.BlockPos;
    import net.minecraft.world.World;
    import org.jetbrains.annotations.Nullable;

    public class StudyTableBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
        private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY); // 3 input + 1 output

        public StudyTableBlockEntity(BlockPos pos, BlockState state) {
            super(ModBlockEntities.STUDY_TABLE_BE, pos, state);
        }

        @Override
        public DefaultedList<ItemStack> getItems() {
            return inventory;
        }

        // ✔ Saving inventory data
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

        // ✔ GUI screen title
        @Override
        public Text getDisplayName() {
            return Text.literal("Study Table");
        }

        private String getSpellFromInk(Item item) {
            if (item == ModItems.NATURAL_INK) return "flying";
            // else if (item == ModItems.NETHER_INK) return "fireball";
            // Add more ink → spell mappings here

            return null;
        }


        // ✔ Send position to client when opening screen
        @Override
        public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
            return this.getPos();
        }

        // ✔ Provide the screen handler
        @Override
        public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
            return new StudyTableScreenHandler(syncId, playerInventory, this.getPos());
        }

        // Called from tick() if you hook it up
        public void tryCraftWand() {
            ItemStack frag = inventory.get(0);   // Knowledge Fragment
            ItemStack ink = inventory.get(1);    // Natural Ink
            ItemStack scroll = inventory.get(2); // Blank Scroll
            ItemStack output = inventory.get(3); // Output slot

            if (!frag.isEmpty() && frag.getItem() == ModItems.KNOWLEDGE_FRAGMENT
                    && !ink.isEmpty()
                    && !scroll.isEmpty() && scroll.getItem() == ModItems.BLANK_SCROLL
                    && output.isEmpty()) {

                // Map the ink item to a spell ID
                String spellId = getSpellFromInk(ink.getItem());

                if (spellId != null) {
                    Spell spell = SpellRegistry.get(spellId);
                    if (spell != null) {
                        ItemStack wand = MagicWandItem.createWandWithSpell(spell);
                        inventory.set(3, wand);

                        frag.decrement(1);
                        ink.decrement(1);
                        scroll.decrement(1);

                        markDirty();
                    }
                }
            System.out.println("[DEBUG] Crafted wand with spell: " + spellId);
                world.playSound(null, pos, SoundEvents.ENTITY_ILLUSIONER_CAST_SPELL, SoundCategory.BLOCKS, 1f, 1f);
                ((ServerWorld) world).spawnParticles(ParticleTypes.ENCHANT, pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5,
                        25, 0.3, 0.4, 0.3, 0.01);

            }
        }

        // Optional: Hook this in your ModBlocks class if you use ticking
        public static void tick(World world, BlockPos pos, BlockState state, StudyTableBlockEntity blockEntity) {
            if (!world.isClient) {
                blockEntity.tryCraftWand();
            }
        }
    }
