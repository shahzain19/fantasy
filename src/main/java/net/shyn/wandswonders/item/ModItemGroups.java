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
    public static final ItemGroup GEM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(WandsWonders.MOD_ID, "gem_items"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.ELIXIR_GEM)).displayName(Text.translatable("itemgroup.wandswonder.gem_items"))
                    .entries(((displayContext, entries) -> {
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

                    }))

                    .build());

    public static final ItemGroup FANTASY_BUILDING_BLOCKS = Registry.register(Registries.ITEM_GROUP, Identifier.of(WandsWonders.MOD_ID, "fantasy_building_blocks"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModBlocks.ARCANE_STONE)).displayName(Text.translatable("itemgroup.wandswonder.fantasy_building_blocks"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.ARCANE_STONE);
                        entries.add(ModBlocks.ELIXIR_GEM_ORE);
                        entries.add(ModBlocks.ARCANE_STONE_STAIRS);
                        entries.add(ModBlocks.ARCANE_STONE_SLAB);
                        entries.add(ModBlocks.SHADOW_STONE);
                        entries.add(ModBlocks.SHADOW_STONE_STAIRS);
                        entries.add(ModBlocks.SHADOW_STONE_SLAB);
                        entries.add(ModBlocks.DUST_STONE);
                        entries.add(ModBlocks.DUST_STONE_STAIRS);
                        entries.add(ModBlocks.DUST_STONE_SLAB);
                        entries.add(ModBlocks.PIR_PLANK);
                        entries.add(ModBlocks.PIR_PLANK_STAIRS);
                        entries.add(ModBlocks.PIR_PLANK_SLAB);

                        entries.add(ModBlocks.GLOW_LAMP);
                    })).build());


    public static void registerItemGroups(){



        WandsWonders.LOGGER.info("Registering Item Groups for"+WandsWonders.MOD_ID);
    }
}
