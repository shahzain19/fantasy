package net.shyn.wandswonders.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.shyn.wandswonders.WandsWonders;
import net.shyn.wandswonders.block.custom.CauliflowerCropBlock;
import net.shyn.wandswonders.block.custom.Glowlamp;

/**
 * Central place to define and register all custom blocks for the mod.
 * Uses ModBlockRegistry to auto-handle registration of both Block and BlockItem.
 * This avoids repeating Registry code and simplifies block creation.
 */
public class ModBlocks {

    // ========== BASIC BLOCKS ==========
    public static final Block ARCANE_STONE = ModBlockRegistry.register("arcane_stone",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block CAULIFLOWER_CROP = registerBlockWithoutBlockItem("cauliflower_crop",
            new CauliflowerCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));


    public static final Block DUST_STONE = ModBlockRegistry.register("dust_stone",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block PIR_PLANK = ModBlockRegistry.register("pir_plank",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block SHADOW_STONE = ModBlockRegistry.register("shadow_stone",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block ELIXIR_GEM_ORE = ModBlockRegistry.register("elixir_gem_ore",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    // ========== CUSTOM BLOCKS ==========
    public static final Block GLOW_LAMP = ModBlockRegistry.register("glow_lamp",
            () -> new Glowlamp(AbstractBlock.Settings.create()
                    .strength(1.0f)
                    .requiresTool()
                    .luminance(state -> state.get(Glowlamp.CLICKED) ? 15 : 0)));

    // ========== STAIRS ==========
    public static final Block ARCANE_STONE_STAIRS = ModBlockRegistry.register("arcane_stone_stairs",
            () -> new StairsBlock(ARCANE_STONE.getDefaultState(), AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block PIR_PLANK_STAIRS = ModBlockRegistry.register("pir_plank_stairs",
            () -> new StairsBlock(PIR_PLANK.getDefaultState(), AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block DUST_STONE_STAIRS = ModBlockRegistry.register("dust_stone_stairs",
            () -> new StairsBlock(DUST_STONE.getDefaultState(), AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block SHADOW_STONE_STAIRS = ModBlockRegistry.register("shadow_stone_stairs",
            () -> new StairsBlock(SHADOW_STONE.getDefaultState(), AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    // ========== SLABS ==========
    public static final Block ARCANE_STONE_SLAB = ModBlockRegistry.register("arcane_stone_slab",
            () -> new SlabBlock(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block PIR_PLANK_SLAB = ModBlockRegistry.register("pir_plank_slab",
            () -> new SlabBlock(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block DUST_STONE_SLAB = ModBlockRegistry.register("dust_stone_slab",
            () -> new SlabBlock(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block SHADOW_STONE_SLAB = ModBlockRegistry.register("shadow_stone_slab",
            () -> new SlabBlock(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    /**
     * Called in the main mod initializer.
     * No manual registration logic needed here anymore — handled by ModBlockRegistry.
     */

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(WandsWonders.MOD_ID, name), block);
    }


    public static void registerModBlocks() {
        // Logging only — everything else handled automatically
    }
}
