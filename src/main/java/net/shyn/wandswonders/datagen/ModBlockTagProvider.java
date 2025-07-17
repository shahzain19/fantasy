package net.shyn.wandswonders.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.shyn.wandswonders.block.ModBlocks;
import net.shyn.wandswonders.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        // ====== Mineable Tags ======
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ARCANE_STONE)
                .add(ModBlocks.ELIXIR_GEM_ORE)
                .add(ModBlocks.SHADOW_STONE)
                .add(ModBlocks.ARCANE_STONE_STAIRS)
                .add(ModBlocks.ARCANE_STONE_SLAB)
                .add(ModBlocks.SHADOW_STONE_STAIRS)
                .add(ModBlocks.SHADOW_STONE_SLAB)
                .add(ModBlocks.DUST_STONE)
                .add(ModBlocks.DUST_STONE_STAIRS)
                .add(ModBlocks.DUST_STONE_SLAB)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
                .add(ModBlocks.GLOW_LAMP);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ELIXIR_GEM_ORE)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        // ====== Custom Tool Requirements ======
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_MOON_LIT_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        // ====== Logs That Burn ======
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.DRIFTWOOD_LOG)
                .add(ModBlocks.DRIFTWOOD_WOOD)
                .add(ModBlocks.STRIPPED_DRIFTWOOD_LOG)
                .add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD)

                .add(ModBlocks.MOONWOOD_LOG)
                .add(ModBlocks.MOONWOOD_WOOD)
                .add(ModBlocks.STRIPPED_MOONWOOD_LOG)
                .add(ModBlocks.STRIPPED_MOONWOOD_WOOD)

                .add(ModBlocks.GLOW_SPRUCE_LOG)
                .add(ModBlocks.GLOW_SPRUCE_WOOD)
                .add(ModBlocks.STRIPPED_GLOW_SPRUCE_LOG)
                .add(ModBlocks.STRIPPED_GLOW_SPRUCE_WOOD)

                .add(ModBlocks.SUNFLARE_TREE_LOG)
                .add(ModBlocks.SUNFLARE_TREE_WOOD)
                .add(ModBlocks.STRIPPED_SUNFLARE_TREE_LOG)
                .add(ModBlocks.STRIPPED_SUNFLARE_TREE_WOOD)

                .add(ModBlocks.ORACLE_TREE_LOG)
                .add(ModBlocks.ORACLE_TREE_WOOD)
                .add(ModBlocks.STRIPPED_ORACLE_TREE_LOG)
                .add(ModBlocks.STRIPPED_ORACLE_TREE_WOOD);

        // ====== Planks ======
        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.DRIFTWOOD_PLANKS)
                .add(ModBlocks.MOONWOOD_PLANKS)
                .add(ModBlocks.GLOW_SPRUCE_PLANKS)
                .add(ModBlocks.SUNFLARE_TREE_PLANKS)
                .add(ModBlocks.ORACLE_TREE_PLANKS)
                .add(ModBlocks.PIR_PLANK);

        // ====== Stairs ======
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.PIR_PLANK_STAIRS)
                .add(ModBlocks.SUNFLARE_TREE_STAIRS)
                .add(ModBlocks.ORACLE_TREE_STAIRS);

        // ====== Slabs ======
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.PIR_PLANK_SLAB)
                .add(ModBlocks.SUNFLARE_TREE_SLAB)
                .add(ModBlocks.ORACLE_TREE_SLAB);
    }
}
