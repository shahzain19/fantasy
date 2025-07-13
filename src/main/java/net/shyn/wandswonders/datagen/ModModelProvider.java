package net.shyn.wandswonders.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.shyn.wandswonders.block.ModBlocks;
import net.shyn.wandswonders.block.custom.CauliflowerCropBlock;
import net.shyn.wandswonders.block.custom.Glowlamp;
import net.shyn.wandswonders.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool arcaneStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ARCANE_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ELIXIR_GEM_ORE);

        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);


        arcaneStonePool.stairs(ModBlocks.ARCANE_STONE_STAIRS);
        arcaneStonePool.slab(ModBlocks.ARCANE_STONE_SLAB);

        BlockStateModelGenerator.BlockTexturePool shadowStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SHADOW_STONE);

        shadowStonePool.stairs(ModBlocks.SHADOW_STONE_STAIRS);
        shadowStonePool.slab(ModBlocks.SHADOW_STONE_SLAB);

        BlockStateModelGenerator.BlockTexturePool dustStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUST_STONE);

        dustStonePool.stairs(ModBlocks.DUST_STONE_STAIRS);
        dustStonePool.slab(ModBlocks.DUST_STONE_SLAB);

        BlockStateModelGenerator.BlockTexturePool PirPlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PIR_PLANK);

        PirPlankPool.stairs(ModBlocks.PIR_PLANK_STAIRS);
        PirPlankPool.slab(ModBlocks.PIR_PLANK_SLAB);


        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.GLOW_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.GLOW_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.GLOW_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(Glowlamp.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELIXIR_GEM, Models.GENERATED);

        itemModelGenerator.register(ModItems.MOON_LIT_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOON_LIT_AXE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.MOON_LIT_PICKAXE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.MOON_LIT_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOON_LIT_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOONFANG_DAGGER, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_CHESTPLATE));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_BOOTS));


    }
}