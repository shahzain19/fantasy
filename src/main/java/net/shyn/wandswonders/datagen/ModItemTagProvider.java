package net.shyn.wandswonders.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.shyn.wandswonders.block.ModBlocks;
import net.shyn.wandswonders.item.ModItems;
import net.shyn.wandswonders.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        // Custom Mod Item Tags
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.PINK_GARNET)
                .add(ModItems.ELIXIR_GEM);

        // Tool Tags
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.MOON_LIT_SWORD)
                .add(ModItems.MOONFANG_DAGGER);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.MOON_LIT_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.MOON_LIT_SHOVEL);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.MOON_LIT_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.MOON_LIT_HOE);

        // Log Tags
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.DRIFTWOOD_LOG.asItem())
                .add(ModBlocks.DRIFTWOOD_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DRIFTWOOD_LOG.asItem())
                .add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD.asItem())

                .add(ModBlocks.GLOW_SPRUCE_LOG.asItem())
                .add(ModBlocks.GLOW_SPRUCE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_GLOW_SPRUCE_LOG.asItem())
                .add(ModBlocks.STRIPPED_GLOW_SPRUCE_WOOD.asItem())

                .add(ModBlocks.SUNFLARE_TREE_LOG.asItem())
                .add(ModBlocks.SUNFLARE_TREE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_SUNFLARE_TREE_LOG.asItem())
                .add(ModBlocks.STRIPPED_SUNFLARE_TREE_WOOD.asItem())

                .add(ModBlocks.ORACLE_TREE_LOG.asItem())
                .add(ModBlocks.ORACLE_TREE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_ORACLE_TREE_LOG.asItem())
                .add(ModBlocks.STRIPPED_ORACLE_TREE_WOOD.asItem())




                .add(ModBlocks.MOONWOOD_LOG.asItem())
                .add(ModBlocks.MOONWOOD_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MOONWOOD_LOG.asItem())
                .add(ModBlocks.STRIPPED_MOONWOOD_WOOD.asItem());


        // Plank Tags
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.DRIFTWOOD_PLANKS.asItem())
                .add(ModBlocks.MOONWOOD_PLANKS.asItem())
                .add(ModBlocks.GLOW_SPRUCE_PLANKS.asItem())
                .add(ModBlocks.SUNFLARE_TREE_PLANKS.asItem())
                .add(ModBlocks.ORACLE_TREE_PLANKS.asItem())
        ;
    }
}
