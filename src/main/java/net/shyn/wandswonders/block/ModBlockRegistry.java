package net.shyn.wandswonders.block;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shyn.wandswonders.WandsWonders;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * ModBlockRegistry simplifies block + block item registration.
 * You register blocks using: ModBlockRegistry.register("name", () -> new Block(...));
 *
 * It automatically:
 * - Registers the block to the game
 * - Registers the BlockItem so it appears in creative
 * - Stores the block in a map so it can be used later (e.g. for ItemGroups)
 */
public class ModBlockRegistry {

    // Stores all registered blocks in the order added (for creative tab, etc.)
    private static final Map<String, Block> BLOCKS = new LinkedHashMap<>();

    /**
     * Registers a block and its corresponding BlockItem with a given name.
     *
     * @param name           The name of the block (used for ID)
     * @param blockSupplier  A supplier that creates the block (can be normal block, slab, stairs, etc.)
     * @return The registered Block object
     */
    public static Block register(String name, Supplier<Block> blockSupplier) {
        // Create the block from the supplier
        Block block = blockSupplier.get();

        // Save it to the map (for item group population)
        BLOCKS.put(name, block);

        // Register the block in the game registry
        Registry.register(Registries.BLOCK, Identifier.of(WandsWonders.MOD_ID, name), block);

        // Register a matching BlockItem so it can show in the inventory
        Registry.register(Registries.ITEM, Identifier.of(WandsWonders.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));

        return block;
    }

    /**
     * Returns a list of all registered blocks.
     * Useful for auto-populating creative tabs.
     */
    public static Map<String, Block> getAllBlocks() {
        return BLOCKS;
    }
}
