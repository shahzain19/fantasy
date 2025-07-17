package net.shyn.wandswonders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.resource.ResourceType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.shyn.wandswonders.block.ModBlocks;
import net.shyn.wandswonders.block.entity.ModBlockEntities;
import net.shyn.wandswonders.entity.ModEntities;
import net.shyn.wandswonders.command.FactionCommand;
import net.shyn.wandswonders.factions.data.FactionDataLoader;
import net.shyn.wandswonders.villager.ModVillagers;
import net.shyn.wandswonders.item.ModItemGroups;
import net.shyn.wandswonders.item.ModItems;
import net.shyn.wandswonders.screen.ModScreenHandlers;
import net.shyn.wandswonders.system.ManaRegenerationHandler;
import net.shyn.wandswonders.world.gen.ModWorldGen;
import net.shyn.wandswonders.world.structure.BazaarCommand;
import net.shyn.wandswonders.world.structure.ModStructureHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WandsWonders implements ModInitializer {
	public static final String MOD_ID = "wandswonders";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout());
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModWorldGen.onInitialize();
		ManaRegenerationHandler.register();

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			FactionCommand.register(dispatcher);
		});


		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new FactionDataLoader(gson));

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			BazaarCommand.register(dispatcher);
		});



		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		ModEntities.registerEntities();

		ModVillagers.registerVillagers();

		// ✅ Register attributes for faction_guard
		FabricDefaultAttributeRegistry.register(
				ModEntities.FACTION_GUARD,
				createFactionGuardAttributes()
		);


		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(CommandManager.literal("spawnhouse")
					.requires(source -> source.hasPermissionLevel(2))
					.executes(context -> {
						ServerCommandSource source = context.getSource();
						ServerWorld world = source.getWorld();
						BlockPos pos = source.getPlayer().getBlockPos().add(0, 0, 5); // 5 blocks in front

						ModStructureHelper.generateStructure(world, pos, Identifier.of("wandswonders", "bazaar_shop"));
						return 1;
					}));
		});





		StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_LOG, ModBlocks.STRIPPED_DRIFTWOOD_LOG);
		StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_WOOD, ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LEAVES, 30, 60);

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIFTWOOD_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLOW_SPRUCE_SAPLING, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIFTWOOD_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLOW_SPRUCE_LEAVES, RenderLayer.getCutout());



	}

	private DefaultAttributeContainer createFactionGuardAttributes() {
        return null;
    }
}