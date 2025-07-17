package net.shyn.wandswonders.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.shyn.wandswonders.WandsWonders;
import net.shyn.wandswonders.block.ModBlocks;
import net.shyn.wandswonders.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // Arcane Stone Recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_STONE)
                .pattern(" G ")
                .pattern("GEG")
                .pattern(" G ")
                .input('G', ModItems.PINK_GARNET)
                .input('E', Items.STONE)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .offerTo(exporter);

        // Sunflare Tree stairs and slab
        createSlabRecipe(ModBlocks.SUNFLARE_TREE_PLANKS, ModBlocks.SUNFLARE_TREE_SLAB, exporter);
        createStairsRecipe(ModBlocks.SUNFLARE_TREE_PLANKS, ModBlocks.SUNFLARE_TREE_STAIRS, exporter);

        // Oracle Tree stairs and slab
        createSlabRecipe(ModBlocks.ORACLE_TREE_PLANKS, ModBlocks.ORACLE_TREE_SLAB, exporter);
        createStairsRecipe(ModBlocks.ORACLE_TREE_PLANKS, ModBlocks.ORACLE_TREE_STAIRS, exporter);

        // Bubbling Cauldron shapeless recipes
        createCauldronRecipe(exporter, Items.SPIDER_EYE,        Items.FERMENTED_SPIDER_EYE, "fermented_spider_eye");
        createCauldronRecipe(exporter, Items.SWEET_BERRIES,      ModItems.PINK_GARNET,       "sweet_berries_to_garnet");
        createCauldronRecipe(exporter, Items.PHANTOM_MEMBRANE,   ModItems.MOON_LIT_SWORD,    "phantom_membrane_to_moonlit_sword");
        createCauldronRecipe(exporter, Items.BLAZE_POWDER,       Items.MAGMA_CREAM,           "blaze_powder_to_magma_cream");
        createCauldronRecipe(exporter, Items.PUFFERFISH,         ModItems.CAULIFLOWER,       "pufferfish_to_cauliflower");
        createCauldronRecipe(exporter, Items.GOLD_NUGGET,        ModItems.PINK_GARNET,       "gold_nugget_to_2_garnet", 2);
        createCauldronRecipe(exporter, Items.GLOW_INK_SAC,       ModItems.ELIXIR_GEM,        "glow_ink_sac_to_elixir");
        createCauldronRecipe(exporter, Items.BONE,               Items.BONE_MEAL,            "bone_to_bonemeal",         5);
    }

    private void createSlabRecipe(Block base, Block slab, RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, slab, 6)
                .pattern("###")
                .input('#', base)
                .criterion(hasItem(base), conditionsFromItem(base))
                .offerTo(exporter);
    }

    private void createStairsRecipe(Block base, Block stairs, RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, stairs, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', base)
                .criterion(hasItem(base), conditionsFromItem(base))
                .offerTo(exporter);
    }

    /**
     * Creates a bubbling cauldron shapeless recipe with default count 1.
     */
    private void createCauldronRecipe(RecipeExporter exporter, net.minecraft.item.Item input, net.minecraft.item.Item output, String name) {
        createCauldronRecipe(exporter, input, output, name, 1);
    }

    /**
     * Creates a bubbling cauldron shapeless recipe with specified output count.
     */
    private void createCauldronRecipe(RecipeExporter exporter, net.minecraft.item.Item input, net.minecraft.item.Item output, String name, int count) {
        ShapelessRecipeJsonBuilder builder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, count)
                .input(input)
                .criterion(hasItem(input), conditionsFromItem(input));
        builder.offerTo(exporter, Identifier.of(WandsWonders.MOD_ID, "bubbling_cauldron/" + name));
    }
}
