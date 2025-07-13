package net.shyn.wandswonders.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.shyn.wandswonders.WandsWonders;
import net.shyn.wandswonders.block.ModBlocks;
import net.shyn.wandswonders.block.custom.ModArmorMaterials;
import net.shyn.wandswonders.item.custom.MoonfangDaggerItem;

import java.util.List;

public class ModItems {
    public static final Item ELIXIR_GEM = registerItem("elixir_gem", new Item(new Item.Settings()));
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));

    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.cauliflower.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });


    public static final Item MOONFANG_DAGGER = registerItem("moonfang_dagger",
            new MoonfangDaggerItem(ModToolMaterials.PINK_GARNET, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 5, -1.5f))));

    public static final Item MOON_LIT_SWORD = registerItem("moon_lit_sword",
            new SwordItem(ModToolMaterials.PINK_GARNET,
                    new Item.Settings()
                            .attributeModifiers
                                    (SwordItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 3, -2.4f)))
            );

    public static final Item MOON_LIT_AXE = registerItem("moon_lit_axe",
            new AxeItem(ModToolMaterials.PINK_GARNET,
                    new Item.Settings()
                            .attributeModifiers
                                    (AxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 6, -3.2f)))
    );
    public static final Item MOON_LIT_PICKAXE = registerItem("moon_lit_pickaxe",
            new PickaxeItem(ModToolMaterials.PINK_GARNET,
                    new Item.Settings()
                            .attributeModifiers
                                    (PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 3, -2.4f)))
    );
    public static final Item MOON_LIT_SHOVEL = registerItem("moon_lit_shovel",
            new ShovelItem(ModToolMaterials.PINK_GARNET,
                    new Item.Settings()
                            .attributeModifiers
                                    (ShovelItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 3, -2.4f)))
    );
    public static final Item MOON_LIT_HOE = registerItem("moon_lit_hoe",
            new SwordItem(ModToolMaterials.PINK_GARNET,
                    new Item.Settings()
                            .attributeModifiers
                                    (SwordItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 0, -3)))
    );

    public static final Item PINK_GARNET_HELMET = registerItem("pink_garnet_helmet",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item PINK_GARNET_CHESTPLATE = registerItem("pink_garnet_chestplate",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item PINK_GARNET_LEGGINGS = registerItem("pink_garnet_leggings",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item PINK_GARNET_BOOTS = registerItem("pink_garnet_boots",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));


    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds",
            new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP, new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WandsWonders.MOD_ID, name), item);
    }

    public static void registerModItems() {
        WandsWonders.LOGGER.info("Registering Mod Items for " + WandsWonders.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ELIXIR_GEM);
            entries.add(PINK_GARNET);
        });
    }
}
