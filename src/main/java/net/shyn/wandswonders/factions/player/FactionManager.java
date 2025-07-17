package net.shyn.wandswonders.factions.player;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FactionManager {
    private static final Map<UUID, PlayerFactionData> dataMap = new HashMap<>();

    public static PlayerFactionData get(ServerPlayerEntity player) {
        return dataMap.computeIfAbsent(player.getUuid(), uuid -> new PlayerFactionData());
    }

    // ✅ NEW: access with UUID + World (for blocks, shrines, etc.)
    public static PlayerFactionData get(World world, UUID playerUuid) {
        return dataMap.computeIfAbsent(playerUuid, uuid -> new PlayerFactionData());
    }

    public static void unload(ServerPlayerEntity player) {
        dataMap.remove(player.getUuid());
    }
}
