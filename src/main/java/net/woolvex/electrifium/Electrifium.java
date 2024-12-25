package net.woolvex.electrifium;

import net.fabricmc.api.ModInitializer;
import net.woolvex.electrifium.item.ModItemGroups;
import net.woolvex.electrifium.item.ModItems;
import net.woolvex.electrifium.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Electrifium implements ModInitializer {
	public static final String MOD_ID = "electrifium";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();



	}
}
