package net.shyn.wandswonders.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.shyn.wandswonders.WandsWonders;
import net.shyn.wandswonders.screen.StudyTableScreenHandler;

public class ModScreenHandlers {
    public static final ScreenHandlerType<StudyTableScreenHandler> STUDY_TABLE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER,
                    Identifier.of(WandsWonders.MOD_ID, "study_table_screen_handler"),
                    new ExtendedScreenHandlerType<>(StudyTableScreenHandler::new, BlockPos.PACKET_CODEC));

    public static final ScreenHandlerType<AlchemyCauldronScreenHandler> ALCHEMY_CAULDRON_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER,
                    Identifier.of(WandsWonders.MOD_ID, "alchemy_cauldron_screen_handler"),
                    new ExtendedScreenHandlerType<>(AlchemyCauldronScreenHandler::new, BlockPos.PACKET_CODEC));


    public static void registerScreenHandlers() {
        WandsWonders.LOGGER.info("Registering Screen Handlers for " + WandsWonders.MOD_ID);
    }
}
