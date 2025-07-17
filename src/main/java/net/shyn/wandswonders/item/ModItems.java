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
import net.shyn.wandswonders.item.custom.*;
import net.shyn.wandswonders.magic.SpellRegistry;

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

    public static final Item WOODEN_SPOON = registerItem("wooden_spoon", new Item(new Item.Settings()));

    public static final Item MAGIC_WAND = registerItem("magic_wand",
            new MagicWandItem(new Item.Settings().maxCount(1).fireproof()));

    public static final Item KNOWLEDGE_FRAGMENT = registerItem("knowledge_fragment",
            new KnowledgeFragmentItem(new Item.Settings().maxCount(64)));

    public static final Item BLANK_SCROLL = registerItem("blank_scroll",
            new BlankScrollItem(new Item.Settings().maxCount(32)));

    public static final Item NATURAL_INK = registerItem("natural_ink",
            new NaturalInkItem(new Item.Settings().maxCount(16)));

    public static final Item MEMORY_RELIC_FIRE_KING = registerItem("memory_relic_fire_king",
            new MemoryRelicItem(new Item.Settings().maxCount(1).fireproof(), "fire_king"));

    public static final Item MEMORY_RELIC_FOREST_DRUID = registerItem("memory_relic_forest_druid",
            new MemoryRelicItem(new Item.Settings().maxCount(1).fireproof(), "forest_druid"));

    public static final Item MEMORY_RELIC_SHADOW_PRINCE = registerItem("memory_relic_shadow_prince",
            new MemoryRelicItem(new Item.Settings().maxCount(1).fireproof(), "shadow_prince"));

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

    public static final Item OBSDIANFORGE_BLADE = registerItem("obsidianforge_blade",
            new SwordItem(ModToolMaterials.OBSIDIANFORGE,
                    new Item.Settings()
                            .attributeModifiers
                                    (SwordItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 7, -3.5f)))
    );

    public static final Item OBSDIANFORGE_AXE = registerItem("obsidianforge_axe",
            new AxeItem(ModToolMaterials.OBSIDIANFORGE,
                    new Item.Settings()
                            .attributeModifiers
                                    (AxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 6, -3.2f)))
    );
    public static final Item OBSIDIANFORGE_PICKAXE = registerItem("obsidianforge_pickaxe",
            new PickaxeItem(ModToolMaterials.OBSIDIANFORGE,
                    new Item.Settings()
                            .attributeModifiers
                                    (PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 3, -2.4f)))
    );
    public static final Item OBSIDIANFORGE_SHOVEL = registerItem("obsidianforge_shovel",
            new ShovelItem(ModToolMaterials.OBSIDIANFORGE,
                    new Item.Settings()
                            .attributeModifiers
                                    (ShovelItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 3, -2.4f)))
    );
    public static final Item OBSIDIANFORGE_HOE = registerItem("obsidianforge_hoe",
            new SwordItem(ModToolMaterials.OBSIDIANFORGE,
                    new Item.Settings()
                            .attributeModifiers
                                    (SwordItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 0, -3)))
    );
    public static final Item OBSIDIANFORGE_HAMMER = registerItem("obsidianforge_hammer",
            new SwordItem(ModToolMaterials.OBSIDIANFORGE,
                    new Item.Settings()
                            .attributeModifiers
                                    (SwordItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 0, -3)))
    );
    public static final Item SHIP_CONTROLLER = registerItem("ship_controller",
            new BlockItem(ModBlocks.SHIP_CONTROLLER, new Item.Settings()));

    public static final Item FACTION_WAND = registerItem("faction_wand",
            new FactionWandItem(new Item.Settings().maxCount(1))
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
