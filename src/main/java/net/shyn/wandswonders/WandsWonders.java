package net.shyn.wandswonders;

import net.fabricmc.api.ModInitializer;

import net.shyn.wandswonders.block.ModBlocks;
import net.shyn.wandswonders.item.ModItemGroups;
import net.shyn.wandswonders.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WandsWonders implements ModInitializer {
	public static final String MOD_ID = "wandswonders";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
	}
}