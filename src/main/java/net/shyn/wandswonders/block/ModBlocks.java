package net.shyn.wandswonders.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.shyn.wandswonders.WandsWonders;
import net.shyn.wandswonders.block.custom.*;
import net.shyn.wandswonders.world.tree.ModSaplingGenerators;

/**
 * Central place to define and register all custom blocks for the mod.
 * Uses ModBlockRegistry to auto-handle registration of both Block and BlockItem.
 * This avoids repeating Registry code and simplifies block creation.
 */
public class ModBlocks {

    // ========== BASIC BLOCKS ==========
    public static final Block FLOWER_CARPET = ModBlockRegistry.register("flower_carpet",
            () -> new CarpetBlock(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));
    public static final Block GLIDED_MARBLE_TILE = ModBlockRegistry.register("glided_marble_tile",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));
    public static final Block ARCANE_STONE = ModBlockRegistry.register("arcane_stone",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));
    public static final Block LUNAFLARE_LEAVES = ModBlockRegistry.register("lunaflare_leaves",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));
    public static final Block MOSSLIAD_STONE = ModBlockRegistry.register("mossliad_stone",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));
    public static final Block OBSIDIAN_BRICK = ModBlockRegistry.register("obsidian_brick",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));
    public static final Block STARBOUND_TILE = ModBlockRegistry.register("starbound_tile",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block BLACK_PATH_DWARF = ModBlockRegistry.register("black_path_dwarf",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));
    public static final Block BAZAAR_STALL_BLOCK = ModBlockRegistry.register("bazaar_stall_block",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));
    public static final Block COBBLE_PATH = ModBlockRegistry.register("cobble_path",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));
    public static final Block FROST_BRICK = ModBlockRegistry.register("frost_brick",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block VOID_BRICK = ModBlockRegistry.register("void_brick",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block MAGMA_BRICKS = ModBlockRegistry.register("magma_bricks",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block SKY_STONE_BLUE = ModBlockRegistry.register("sky_stone_blue",
            () -> new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));

    public static final Block SKYSTONE_TILE = ModBlockRegistry.register("skystone_tile",
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

    public static final Block PINK_GARNET_ORE = ModBlockRegistry.register("pink_garnet_ore",
            () -> new ExperienceDroppingBlock(
                    UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .strength(3.0f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE)
            ));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = ModBlockRegistry.register("pink_garnet_deepslate_ore",
            () -> new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create()
                            .strength(4.5f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE)
            ));


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

    // ========== STONE WALLS ==========

    public static final Block ARCANE_STONE_WALL = ModBlockRegistry.register("arcane_stone_wall",
            () -> new WallBlock(AbstractBlock.Settings.copy(ARCANE_STONE)));

    public static final Block DUST_STONE_WALL = ModBlockRegistry.register("dust_stone_wall",
            () -> new WallBlock(AbstractBlock.Settings.copy(DUST_STONE)));

    public static final Block SHADOW_STONE_WALL = ModBlockRegistry.register("shadow_stone_wall",
            () -> new WallBlock(AbstractBlock.Settings.copy(SHADOW_STONE)));

    public static final Block OBSIDIAN_BRICK_WALL = ModBlockRegistry.register("obsidian_brick_wall",
            () -> new WallBlock(AbstractBlock.Settings.copy(OBSIDIAN_BRICK)));

    public static final Block VOID_BRICK_WALL = ModBlockRegistry.register("void_brick_wall",
            () -> new WallBlock(AbstractBlock.Settings.copy(VOID_BRICK)));

    public static final Block FROST_BRICK_WALL = ModBlockRegistry.register("frost_brick_wall",
            () -> new WallBlock(AbstractBlock.Settings.copy(FROST_BRICK)));

    public static final Block MAGMA_BRICKS_WALL = ModBlockRegistry.register("magma_bricks_wall",
            () -> new WallBlock(AbstractBlock.Settings.copy(MAGMA_BRICKS)));





    // ========== DRIFTWOOD SET ==========

    public static final Block DRIFTWOOD_LOG = ModBlockRegistry.register("driftwood_log",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block DRIFTWOOD_WOOD = ModBlockRegistry.register("driftwood_wood",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_DRIFTWOOD_LOG = ModBlockRegistry.register("stripped_driftwood_log",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final Block STRIPPED_DRIFTWOOD_WOOD = ModBlockRegistry.register("stripped_driftwood_wood",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block DRIFTWOOD_PLANKS = ModBlockRegistry.register("driftwood_planks",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block DRIFTWOOD_LEAVES = ModBlockRegistry.register("driftwood_leaves",
            () -> new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    public static final Block DRIFTWOOD_SAPLING = ModBlockRegistry.register("driftwood_sapling",
            () -> new SaplingBlock(ModSaplingGenerators.DRIFTWOOD, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


    public static final Block MOONWOOD_LOG = ModBlockRegistry.register("moonwood_log",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block MOONWOOD_WOOD = ModBlockRegistry.register("moonwood_wood",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_MOONWOOD_LOG = ModBlockRegistry.register("stripped_moonwood_log",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final Block STRIPPED_MOONWOOD_WOOD = ModBlockRegistry.register("stripped_moonwood_wood",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block MOONWOOD_PLANKS = ModBlockRegistry.register("moonwood_planks",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block MOONWOOD_LEAVES = ModBlockRegistry.register("moonwood_leaves",
            () -> new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    public static final Block GLOW_SPRUCE_LOG = ModBlockRegistry.register("glow_spruce_log",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LOG)));

    public static final Block GLOW_SPRUCE_WOOD = ModBlockRegistry.register("glow_spruce_wood",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)));

    public static final Block STRIPPED_GLOW_SPRUCE_LOG = ModBlockRegistry.register("stripped_glow_spruce_log",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_SPRUCE_LOG)));

    public static final Block STRIPPED_GLOW_SPRUCE_WOOD = ModBlockRegistry.register("stripped_glow_spruce_wood",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_SPRUCE_WOOD)));

    public static final Block GLOW_SPRUCE_PLANKS = ModBlockRegistry.register("glow_spruce_planks",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));

    public static final Block GLOW_SPRUCE_LEAVES = ModBlockRegistry.register("glow_spruce_leaves",
            () -> new LeavesBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LEAVES)));

    public static final Block GLOW_SPRUCE_SAPLING = ModBlockRegistry.register("glow_spruce_sapling",
            () -> new SaplingBlock(ModSaplingGenerators.GLOW_SPRUCE, AbstractBlock.Settings.copy(Blocks.SPRUCE_SAPLING)));

    public static final Block SUNFLARE_TREE_LOG = ModBlockRegistry.register("sunflare_tree_log",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_LOG).luminance(state -> 4)));

    public static final Block SUNFLARE_TREE_WOOD = ModBlockRegistry.register("sunflare_tree_wood",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD).luminance(state -> 4)));

    public static final Block STRIPPED_SUNFLARE_TREE_LOG = ModBlockRegistry.register("stripped_sunflare_tree_log",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_ACACIA_LOG)));

    public static final Block STRIPPED_SUNFLARE_TREE_WOOD = ModBlockRegistry.register("stripped_sunflare_tree_wood",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_ACACIA_WOOD)));

    public static final Block SUNFLARE_TREE_PLANKS = ModBlockRegistry.register("sunflare_tree_planks",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));

    public static final Block SUNFLARE_TREE_LEAVES = ModBlockRegistry.register("sunflare_tree_leaves",
            () -> new LeavesBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_LEAVES).luminance(state -> 3)));

    public static final Block SUNFLARE_TREE_SAPLING = ModBlockRegistry.register("sunflare_tree_sapling",
            () -> new SaplingBlock(ModSaplingGenerators.SUNFLARE_TREE, AbstractBlock.Settings.copy(Blocks.ACACIA_SAPLING)));


    public static final Block SUNFLARE_TREE_STAIRS = ModBlockRegistry.register("sunflare_tree_stairs",
            () -> new StairsBlock(SUNFLARE_TREE_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.ACACIA_STAIRS)));

    public static final Block SUNFLARE_TREE_SLAB = ModBlockRegistry.register("sunflare_tree_slab",
            () -> new SlabBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_SLAB)));




    public static final Block ORACLE_TREE_LOG = ModBlockRegistry.register("oracle_tree_log",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_LOG).luminance(state -> 2)));

    public static final Block ORACLE_TREE_WOOD = ModBlockRegistry.register("oracle_tree_wood",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD).luminance(state -> 2)));

    public static final Block STRIPPED_ORACLE_TREE_LOG = ModBlockRegistry.register("stripped_oracle_tree_log",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_DARK_OAK_LOG)));

    public static final Block STRIPPED_ORACLE_TREE_WOOD = ModBlockRegistry.register("stripped_oracle_tree_wood",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_DARK_OAK_WOOD)));

    public static final Block ORACLE_TREE_PLANKS = ModBlockRegistry.register("oracle_tree_planks",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));

    public static final Block ORACLE_TREE_LEAVES = ModBlockRegistry.register("oracle_tree_leaves",
            () -> new LeavesBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_LEAVES).luminance(state -> 1)));

    public static final Block ORACLE_TREE_SAPLING = ModBlockRegistry.register("oracle_tree_sapling",
            () -> new SaplingBlock(ModSaplingGenerators.ORACLE_TREE, AbstractBlock.Settings.copy(Blocks.DARK_OAK_SAPLING)));


    public static final Block ORACLE_TREE_STAIRS = ModBlockRegistry.register("oracle_tree_stairs",
            () -> new StairsBlock(ORACLE_TREE_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.DARK_OAK_STAIRS)));

    public static final Block ORACLE_TREE_SLAB = ModBlockRegistry.register("oracle_tree_slab",
            () -> new SlabBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_SLAB)));

    public static final Block AlCHEMY_CAULDRON = ModBlockRegistry.register("alchemy_cauldron",
            () -> new AlchemyCauldronBlock(AbstractBlock.Settings.copy(Blocks.CAULDRON)));

        public static final Block STUDY_TABLE = ModBlockRegistry.register("study_table",
                () -> new StudyTableBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));


    // ========== WOOD SLABS & FENCES ==========

    public static final Block DRIFTWOOD_SLAB = ModBlockRegistry.register("driftwood_slab",
            () -> new SlabBlock(AbstractBlock.Settings.copy(DRIFTWOOD_PLANKS)));
    public static final Block DRIFTWOOD_FENCE = ModBlockRegistry.register("driftwood_fence",
            () -> new FenceBlock(AbstractBlock.Settings.copy(DRIFTWOOD_PLANKS)));

    public static final Block MOONWOOD_SLAB = ModBlockRegistry.register("moonwood_slab",
            () -> new SlabBlock(AbstractBlock.Settings.copy(MOONWOOD_PLANKS)));
    public static final Block MOONWOOD_FENCE = ModBlockRegistry.register("moonwood_fence",
            () -> new FenceBlock(AbstractBlock.Settings.copy(MOONWOOD_PLANKS)));

    public static final Block GLOW_SPRUCE_SLAB = ModBlockRegistry.register("glow_spruce_slab",
            () -> new SlabBlock(AbstractBlock.Settings.copy(GLOW_SPRUCE_PLANKS)));
    public static final Block GLOW_SPRUCE_FENCE = ModBlockRegistry.register("glow_spruce_fence",
            () -> new FenceBlock(AbstractBlock.Settings.copy(GLOW_SPRUCE_PLANKS)));

    public static final Block FACTION_SHRINE = ModBlockRegistry.register("faction_shrine",
            () -> new FactionShrineBlock(AbstractBlock.Settings.create().nonOpaque()));


    public static final Block MOSSY_OAK_LOG = ModBlockRegistry.register("mossy_oak_log",
            () -> new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block SHADOW_OAK_SAPLING = ModBlockRegistry.register("shadow_oak_sapling",
            () -> new SaplingBlock(SaplingGenerator.OAK, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block SHIP_CONTROLLER = ModBlockRegistry.register("ship_controller",
            () -> new ShipControllerBlock(AbstractBlock.Settings.create().strength(3.0f).requiresTool()));







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
