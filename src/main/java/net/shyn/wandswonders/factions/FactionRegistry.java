package net.shyn.wandswonders.factions;

import net.minecraft.util.Identifier;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Holds all loaded factions globally.
 */
public class FactionRegistry {
    private static final Map<Identifier, Faction> FACTIONS = new HashMap<>();

    public static void register(Faction faction) {
        FACTIONS.put(faction.id, faction);
    }

    public static Faction get(Identifier id) {
        return FACTIONS.get(id);
    }

    public static Map<Identifier, Faction> getAll() {
        return Collections.unmodifiableMap(FACTIONS);
    }

    public static void clear() {
        FACTIONS.clear();
    }
}
