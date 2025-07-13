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
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ARCANE_STONE)
                .add(ModBlocks.ELIXIR_GEM_ORE)
                .add(ModBlocks.SHADOW_STONE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ELIXIR_GEM_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_MOON_LIT_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);


    }
}
