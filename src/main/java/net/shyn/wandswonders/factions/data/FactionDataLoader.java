package net.shyn.wandswonders.factions.data;

import com.google.gson.*;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import net.shyn.wandswonders.factions.Faction;
import net.shyn.wandswonders.factions.FactionRegistry;

import java.util.Map;

/**
 * Loads all JSON faction definitions from data/wandswonders/factions/
 */
public class FactionDataLoader extends JsonDataLoader implements IdentifiableResourceReloadListener {
    public FactionDataLoader(Gson gson) {
        super(gson, "factions"); // Looks inside data/modid/factions/
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> jsons, ResourceManager resourceManager, Profiler profiler) {
        FactionRegistry.clear();

        for (Map.Entry<Identifier, JsonElement> entry : jsons.entrySet()) {
            try {
                JsonObject obj = entry.getValue().getAsJsonObject();
                Identifier id = entry.getKey();

                String name = obj.get("name").getAsString();
                int color = Integer.decode(obj.get("color").getAsString());
                Identifier biome = Identifier.of(obj.get("biome").getAsString());

                JsonArray rewardsJson = obj.getAsJsonArray("rewards");
                String[] rewards = new String[rewardsJson.size()];
                for (int i = 0; i < rewardsJson.size(); i++) {
                    rewards[i] = rewardsJson.get(i).getAsString();
                }

                JsonObject reps = obj.getAsJsonObject("reputationThresholds");
                int hostile = reps.get("hostile").getAsInt();
                int neutral = reps.get("neutral").getAsInt();
                int trusted = reps.get("trusted").getAsInt();
                int ally = reps.get("ally").getAsInt();

                Faction faction = new Faction(id, name, color, biome, rewards, hostile, neutral, trusted, ally);
                FactionRegistry.register(faction);
                System.out.println("[Factions] Loaded faction: " + faction.id + " (" + faction.name + ")");
            } catch (Exception e) {
                System.err.println("[Factions] Failed to load faction: " + entry.getKey());
                e.printStackTrace();
            }
        }
    }

    @Override
    public Identifier getFabricId() {
        return null;
    }
}
