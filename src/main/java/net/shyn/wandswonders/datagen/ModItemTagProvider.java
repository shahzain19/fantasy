package net.shyn.wandswonders.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
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
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.PINK_GARNET)
                .add(ModItems.ELIXIR_GEM);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.MOON_LIT_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.MOONFANG_DAGGER);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.MOON_LIT_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.MOON_LIT_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.MOON_LIT_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.MOON_LIT_HOE);

    }
}
