package net.shyn.wandswonders;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.shyn.wandswonders.client.ManaHudOverlay;
import net.shyn.wandswonders.screen.AlchemyCauldronScreen;
import net.shyn.wandswonders.screen.ModScreenHandlers;
import net.shyn.wandswonders.screen.StudyTableScreen;
import net.shyn.wandswonders.screen.StudyTableScreenHandler;

public class WandsWondersClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.STUDY_TABLE_SCREEN_HANDLER, StudyTableScreen::new);
        ManaHudOverlay.register(); // Register the HUD
        HandledScreens.register(ModScreenHandlers.ALCHEMY_CAULDRON_SCREEN_HANDLER, AlchemyCauldronScreen::new);

    }
}
