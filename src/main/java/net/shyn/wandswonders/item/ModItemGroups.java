package net.shyn.wandswonders.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.shyn.wandswonders.WandsWonders;
import net.shyn.wandswonders.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup GEM_ITEMS_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(WandsWonders.MOD_ID, "gem_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.ELIXIR_GEM))
                    .displayName(Text.translatable("itemgroup.wandswonder.gem_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ELIXIR_GEM);
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModBlocks.SHADOW_STONE);

                        entries.add(ModItems.MOON_LIT_SWORD);
                        entries.add(ModItems.MOON_LIT_PICKAXE);
                        entries.add(ModItems.MOON_LIT_AXE);
                        entries.add(ModItems.MOON_LIT_SHOVEL);
                        entries.add(ModItems.MOON_LIT_HOE);
                        entries.add(ModItems.MOONFANG_DAGGER);
                        entries.add(ModItems.CAULIFLOWER_SEEDS);

                        entries.add(ModItems.PINK_GARNET_HELMET);
                        entries.add(ModItems.PINK_GARNET_CHESTPLATE);
                        entries.add(ModItems.PINK_GARNET_LEGGINGS);
                        entries.add(ModItems.PINK_GARNET_BOOTS);

                        // Driftwood
                        entries.add(ModBlocks.DRIFTWOOD_LOG);
                        entries.add(ModBlocks.DRIFTWOOD_WOOD);
                        entries.add(ModBlocks.STRIPPED_DRIFTWOOD_LOG);
                        entries.add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
                        entries.add(ModBlocks.DRIFTWOOD_PLANKS);
                        entries.add(ModBlocks.DRIFTWOOD_LEAVES);
                        entries.add(ModBlocks.DRIFTWOOD_SAPLING);

                        // Moonwood
                        entries.add(ModBlocks.MOONWOOD_LOG);
                        entries.add(ModBlocks.MOONWOOD_WOOD);
                        entries.add(ModBlocks.STRIPPED_MOONWOOD_LOG);
                        entries.add(ModBlocks.STRIPPED_MOONWOOD_WOOD);
                        entries.add(ModBlocks.MOONWOOD_PLANKS);
                        entries.add(ModBlocks.MOONWOOD_LEAVES);

                        // Glow Spruce
                        entries.add(ModBlocks.GLOW_SPRUCE_LOG);
                        entries.add(ModBlocks.GLOW_SPRUCE_WOOD);
                        entries.add(ModBlocks.STRIPPED_GLOW_SPRUCE_LOG);
                        entries.add(ModBlocks.STRIPPED_GLOW_SPRUCE_WOOD);
                        entries.add(ModBlocks.GLOW_SPRUCE_PLANKS);
                        entries.add(ModBlocks.GLOW_SPRUCE_LEAVES);
                        entries.add(ModBlocks.GLOW_SPRUCE_SAPLING);

                        entries.add(ModItems.OBSIDIANFORGE_PICKAXE);
                        entries.add(ModItems.OBSDIANFORGE_AXE);
                        entries.add(ModItems.OBSIDIANFORGE_SHOVEL);
                        entries.add(ModItems.OBSIDIANFORGE_HOE);
                        entries.add(ModItems.OBSDIANFORGE_BLADE);
                        entries.add(ModItems.OBSIDIANFORGE_HAMMER);
                        entries.add(ModItems.FACTION_WAND);
                        entries.add(ModBlocks.FACTION_SHRINE);

                        entries.add(ModBlocks.MOSSY_OAK_LOG);

                        entries.add(ModBlocks.SHIP_CONTROLLER);

                    })
                    .build()
    );

    public static final ItemGroup FANTASY_BUILDING_BLOCKS = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(WandsWonders.MOD_ID, "fantasy_building_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.ARCANE_STONE))
                    .displayName(Text.translatable("itemgroup.wandswonder.fantasy_building_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ARCANE_STONE);
                        entries.add(ModBlocks.ELIXIR_GEM_ORE);
                        entries.add(ModBlocks.ARCANE_STONE_STAIRS);
                        entries.add(ModBlocks.ARCANE_STONE_SLAB);
                        entries.add(ModBlocks.ARCANE_STONE_WALL);

                        entries.add(ModBlocks.SHADOW_STONE);
                        entries.add(ModBlocks.SHADOW_STONE_STAIRS);
                        entries.add(ModBlocks.SHADOW_STONE_SLAB);
                        entries.add(ModBlocks.SHADOW_STONE_WALL);

                        entries.add(ModBlocks.DUST_STONE);
                        entries.add(ModBlocks.DUST_STONE_STAIRS);
                        entries.add(ModBlocks.DUST_STONE_SLAB);
                        entries.add(ModBlocks.DUST_STONE_WALL);

                        entries.add(ModBlocks.PIR_PLANK);
                        entries.add(ModBlocks.PIR_PLANK_STAIRS);
                        entries.add(ModBlocks.PIR_PLANK_SLAB);

                        // Sunflare Tree
                        entries.add(ModBlocks.SUNFLARE_TREE_LOG);
                        entries.add(ModBlocks.SUNFLARE_TREE_WOOD);
                        entries.add(ModBlocks.STRIPPED_SUNFLARE_TREE_LOG);
                        entries.add(ModBlocks.STRIPPED_SUNFLARE_TREE_WOOD);
                        entries.add(ModBlocks.SUNFLARE_TREE_PLANKS);
                        entries.add(ModBlocks.SUNFLARE_TREE_LEAVES);
                        entries.add(ModBlocks.SUNFLARE_TREE_SAPLING);
                        entries.add(ModBlocks.SUNFLARE_TREE_STAIRS);
                        entries.add(ModBlocks.SUNFLARE_TREE_SLAB);

                        // Oracle Tree
                        entries.add(ModBlocks.ORACLE_TREE_LOG);
                        entries.add(ModBlocks.ORACLE_TREE_WOOD);
                        entries.add(ModBlocks.STRIPPED_ORACLE_TREE_LOG);
                        entries.add(ModBlocks.STRIPPED_ORACLE_TREE_WOOD);
                        entries.add(ModBlocks.ORACLE_TREE_PLANKS);
                        entries.add(ModBlocks.ORACLE_TREE_LEAVES);
                        entries.add(ModBlocks.ORACLE_TREE_SAPLING);
                        entries.add(ModBlocks.ORACLE_TREE_STAIRS);
                        entries.add(ModBlocks.ORACLE_TREE_SLAB);

                        // Extra Blocks
                        entries.add(ModBlocks.AlCHEMY_CAULDRON);
                        entries.add(ModBlocks.GLOW_LAMP);
                        entries.add(ModItems.WOODEN_SPOON);
                        entries.add(ModItems.MAGIC_WAND);
                        entries.add(ModItems.NATURAL_INK);
                        entries.add(ModItems.BLANK_SCROLL);
                        entries.add(ModItems.KNOWLEDGE_FRAGMENT);
                        entries.add(ModItems.MEMORY_RELIC_FIRE_KING);
                        entries.add(ModItems.MEMORY_RELIC_FOREST_DRUID);
                        entries.add(ModItems.MEMORY_RELIC_SHADOW_PRINCE);
                        entries.add(ModBlocks.STUDY_TABLE);
                        entries.add(ModBlocks.OBSIDIAN_BRICK);
                        entries.add(ModBlocks.OBSIDIAN_BRICK_WALL);
                        entries.add(ModBlocks.MOSSLIAD_STONE);
                        entries.add(ModBlocks.LUNAFLARE_LEAVES);
                        entries.add(ModBlocks.GLIDED_MARBLE_TILE);
                        entries.add(ModBlocks.FLOWER_CARPET);

                        // Fantasy Theme
                        entries.add(ModBlocks.STARBOUND_TILE);
                        entries.add(ModBlocks.BAZAAR_STALL_BLOCK);
                        entries.add(ModBlocks.BLACK_PATH_DWARF);
                        entries.add(ModBlocks.COBBLE_PATH);
                        entries.add(ModBlocks.FROST_BRICK);
                        entries.add(ModBlocks.FROST_BRICK_WALL);
                        entries.add(ModBlocks.VOID_BRICK);
                        entries.add(ModBlocks.VOID_BRICK_WALL);
                        entries.add(ModBlocks.MAGMA_BRICKS);
                        entries.add(ModBlocks.MAGMA_BRICKS_WALL);
                        entries.add(ModBlocks.SKY_STONE_BLUE);
                        entries.add(ModBlocks.SKYSTONE_TILE);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

                        // Slabs & Fences
                        entries.add(ModBlocks.DRIFTWOOD_SLAB);
                        entries.add(ModBlocks.DRIFTWOOD_FENCE);
                        entries.add(ModBlocks.MOONWOOD_SLAB);
                        entries.add(ModBlocks.MOONWOOD_FENCE);
                        entries.add(ModBlocks.GLOW_SPRUCE_SLAB);
                        entries.add(ModBlocks.GLOW_SPRUCE_FENCE);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        WandsWonders.LOGGER.info("Registering Item Groups for " + WandsWonders.MOD_ID);
        // Just by referencing the static fields, they're already registered.
        // But this function helps keep the call in your mod initializer.
    }
}
