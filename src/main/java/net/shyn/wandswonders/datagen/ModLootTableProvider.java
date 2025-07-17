package net.shyn.wandswonders.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.shyn.wandswonders.block.ModBlocks;
import net.shyn.wandswonders.block.custom.CauliflowerCropBlock;
import net.shyn.wandswonders.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ARCANE_STONE);
        addDrop(ModBlocks.ELIXIR_GEM_ORE, oreDrops(ModBlocks.ELIXIR_GEM_ORE, ModItems.ELIXIR_GEM));

        addDrop(ModBlocks.ARCANE_STONE_STAIRS);
        addDrop(ModBlocks.ARCANE_STONE_SLAB, slabDrops(ModBlocks.ARCANE_STONE_SLAB));


        addDrop(ModBlocks.DRIFTWOOD_LOG);
        addDrop(ModBlocks.DRIFTWOOD_WOOD);
        addDrop(ModBlocks.STRIPPED_DRIFTWOOD_LOG);
        addDrop(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
        addDrop(ModBlocks.DRIFTWOOD_PLANKS);
        addDrop(ModBlocks.DRIFTWOOD_SAPLING);

        addDrop(ModBlocks.DRIFTWOOD_LEAVES, leavesDrops(ModBlocks.DRIFTWOOD_LEAVES, ModBlocks.DRIFTWOOD_SAPLING, 0.0625f));


        // Moonwood
        addDrop(ModBlocks.MOONWOOD_LOG);
        addDrop(ModBlocks.MOONWOOD_WOOD);
        addDrop(ModBlocks.STRIPPED_MOONWOOD_LOG);
        addDrop(ModBlocks.STRIPPED_MOONWOOD_WOOD);
        addDrop(ModBlocks.MOONWOOD_PLANKS);
        addDrop(ModBlocks.MOONWOOD_LEAVES, leavesDrops(ModBlocks.MOONWOOD_LEAVES, Block.getBlockFromItem(Items.SPRUCE_SAPLING), 0.0625f));


        addDrop(ModBlocks.GLOW_SPRUCE_LOG);
        addDrop(ModBlocks.GLOW_SPRUCE_WOOD);
        addDrop(ModBlocks.STRIPPED_GLOW_SPRUCE_LOG);
        addDrop(ModBlocks.STRIPPED_GLOW_SPRUCE_WOOD);
        addDrop(ModBlocks.GLOW_SPRUCE_PLANKS);
        addDrop(ModBlocks.GLOW_SPRUCE_SAPLING);

        addDrop(ModBlocks.GLOW_SPRUCE_LEAVES, leavesDrops(ModBlocks.GLOW_SPRUCE_LEAVES, ModBlocks.GLOW_SPRUCE_SAPLING, 0.0625f));


        // Sunflare Tree
        addDrop(ModBlocks.SUNFLARE_TREE_LOG);
        addDrop(ModBlocks.SUNFLARE_TREE_WOOD);
        addDrop(ModBlocks.STRIPPED_SUNFLARE_TREE_LOG);
        addDrop(ModBlocks.STRIPPED_SUNFLARE_TREE_WOOD);
        addDrop(ModBlocks.SUNFLARE_TREE_PLANKS);
        addDrop(ModBlocks.SUNFLARE_TREE_SAPLING);
        addDrop(ModBlocks.SUNFLARE_TREE_LEAVES, leavesDrops(ModBlocks.SUNFLARE_TREE_LEAVES, ModBlocks.SUNFLARE_TREE_SAPLING, 0.0625f));

// Oracle Tree
        addDrop(ModBlocks.ORACLE_TREE_LOG);
        addDrop(ModBlocks.ORACLE_TREE_WOOD);
        addDrop(ModBlocks.STRIPPED_ORACLE_TREE_LOG);
        addDrop(ModBlocks.STRIPPED_ORACLE_TREE_WOOD);
        addDrop(ModBlocks.ORACLE_TREE_PLANKS);
        addDrop(ModBlocks.ORACLE_TREE_SAPLING);
        addDrop(ModBlocks.ORACLE_TREE_LEAVES, leavesDrops(ModBlocks.ORACLE_TREE_LEAVES, ModBlocks.ORACLE_TREE_SAPLING, 0.0625f));

// Sunflare Tree Extras
        addDrop(ModBlocks.SUNFLARE_TREE_STAIRS);
        addDrop(ModBlocks.SUNFLARE_TREE_SLAB, slabDrops(ModBlocks.SUNFLARE_TREE_SLAB));

// Oracle Tree Extras
        addDrop(ModBlocks.ORACLE_TREE_STAIRS);
        addDrop(ModBlocks.ORACLE_TREE_SLAB, slabDrops(ModBlocks.ORACLE_TREE_SLAB));


    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
