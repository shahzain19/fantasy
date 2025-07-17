package net.shyn.wandswonders.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Items;
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
        blockStateModelGenerator.registerLog(ModBlocks.DRIFTWOOD_LOG).log(ModBlocks.DRIFTWOOD_LOG).wood(ModBlocks.DRIFTWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_DRIFTWOOD_LOG).log(ModBlocks.STRIPPED_DRIFTWOOD_LOG).wood(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DRIFTWOOD_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.DRIFTWOOD_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.DRIFTWOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);


        blockStateModelGenerator.registerLog(ModBlocks.MOONWOOD_LOG).log(ModBlocks.MOONWOOD_LOG).wood(ModBlocks.MOONWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MOONWOOD_LOG).log(ModBlocks.STRIPPED_MOONWOOD_LOG).wood(ModBlocks.STRIPPED_MOONWOOD_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOONWOOD_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.MOONWOOD_LEAVES, TexturedModel.LEAVES);

        blockStateModelGenerator.registerLog(ModBlocks.GLOW_SPRUCE_LOG).log(ModBlocks.GLOW_SPRUCE_LOG).wood(ModBlocks.GLOW_SPRUCE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_GLOW_SPRUCE_LOG).log(ModBlocks.STRIPPED_GLOW_SPRUCE_LOG).wood(ModBlocks.STRIPPED_GLOW_SPRUCE_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLOW_SPRUCE_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.GLOW_SPRUCE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.GLOW_SPRUCE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);


        blockStateModelGenerator.registerLog(ModBlocks.ORACLE_TREE_LOG).log(ModBlocks.ORACLE_TREE_LOG).wood(ModBlocks.ORACLE_TREE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ORACLE_TREE_LOG).log(ModBlocks.STRIPPED_ORACLE_TREE_LOG).wood(ModBlocks.STRIPPED_ORACLE_TREE_WOOD);
        blockStateModelGenerator.registerSingleton(ModBlocks.ORACLE_TREE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.ORACLE_TREE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool oracleTreepool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ORACLE_TREE_PLANKS);
        oracleTreepool.stairs(ModBlocks.ORACLE_TREE_STAIRS);
        oracleTreepool.slab(ModBlocks.ORACLE_TREE_SLAB);

        blockStateModelGenerator.registerLog(ModBlocks.SUNFLARE_TREE_LOG).log(ModBlocks.SUNFLARE_TREE_LOG).wood(ModBlocks.SUNFLARE_TREE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_SUNFLARE_TREE_LOG).log(ModBlocks.STRIPPED_SUNFLARE_TREE_LOG).wood(ModBlocks.STRIPPED_SUNFLARE_TREE_WOOD);
        blockStateModelGenerator.registerSingleton(ModBlocks.SUNFLARE_TREE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.SUNFLARE_TREE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool sunflareTreePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SUNFLARE_TREE_PLANKS);
        sunflareTreePool.stairs(ModBlocks.SUNFLARE_TREE_STAIRS);
        sunflareTreePool.slab(ModBlocks.SUNFLARE_TREE_SLAB);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AlCHEMY_CAULDRON);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STUDY_TABLE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OBSIDIAN_BRICK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSLIAD_STONE);
        blockStateModelGenerator.registerSingleton(ModBlocks.FLOWER_CARPET, TexturedModel.CARPET);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLIDED_MARBLE_TILE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STARBOUND_TILE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BAZAAR_STALL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLACK_PATH_DWARF);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLE_PATH);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FROST_BRICK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOID_BRICK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGMA_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SKY_STONE_BLUE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SKYSTONE_TILE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        blockStateModelGenerator.registerLog(ModBlocks.MOSSY_OAK_LOG)
                .log(ModBlocks.MOSSY_OAK_LOG)
                .wood(Blocks.OAK_WOOD); // no need to register new wood unless you want

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SHIP_CONTROLLER);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FACTION_SHRINE);





    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELIXIR_GEM, Models.GENERATED);

        itemModelGenerator.register(ModItems.FACTION_WAND, Models.GENERATED);

        itemModelGenerator.register(ModItems.OBSIDIANFORGE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSDIANFORGE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIANFORGE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIANFORGE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSDIANFORGE_BLADE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIANFORGE_HAMMER, Models.HANDHELD);




        itemModelGenerator.register(ModItems.MOON_LIT_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOON_LIT_AXE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.MOON_LIT_PICKAXE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.MOON_LIT_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOON_LIT_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOONFANG_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.MAGIC_WAND, Models.HANDHELD);


        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_CHESTPLATE));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_BOOTS));

        itemModelGenerator.register(ModItems.KNOWLEDGE_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLANK_SCROLL, Models.GENERATED);
        itemModelGenerator.register(ModItems.NATURAL_INK, Models.GENERATED);

        itemModelGenerator.register(ModItems.MEMORY_RELIC_SHADOW_PRINCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MEMORY_RELIC_FOREST_DRUID, Models.GENERATED);
        itemModelGenerator.register(ModItems.MEMORY_RELIC_FIRE_KING, Models.GENERATED);



    }
}