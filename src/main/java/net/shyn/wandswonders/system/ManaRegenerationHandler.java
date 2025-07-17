package net.shyn.wandswonders.system;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.shyn.wandswonders.component.PlayerManaProvider;

public class ManaRegenerationHandler implements ServerTickEvents.EndTick {
    private int tickCounter = 0;

    @Override
    public void onEndTick(net.minecraft.server.MinecraftServer server) {
        tickCounter++;
        if (tickCounter >= 40) { // every 2 seconds (20 ticks/sec)
            tickCounter = 0;

            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                var mana = PlayerManaProvider.get(player);
                mana.addMana(1); // regenerate 1 mana
            }
        }
    }

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(new ManaRegenerationHandler());
    }
}
