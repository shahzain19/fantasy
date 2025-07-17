package net.shyn.wandswonders.factions.player;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class PlayerFactionData {
    private final Map<Identifier, Integer> reputationMap = new HashMap<>();
    private Identifier currentFaction;

    // --- Reputation Handling ---

    public void setReputation(Identifier factionId, int value) {
        reputationMap.put(factionId, value);
    }

    public void addReputation(Identifier factionId, int delta) {
        int current = getReputation(factionId);
        reputationMap.put(factionId, current + delta);
    }

    public int getReputation(Identifier factionId) {
        return reputationMap.getOrDefault(factionId, 0);
    }

    public String getStanding(Identifier factionId) {
        int rep = getReputation(factionId);
        if (rep >= 100) return "Allied";
        if (rep >= 50) return "Friendly";
        if (rep >= 10) return "Neutral";
        if (rep >= -10) return "Untrusted";
        if (rep >= -50) return "Hostile";
        return "Enemy";
    }

    // --- Current Faction ---

    public void setCurrentFaction(Identifier factionId) {
        this.currentFaction = factionId;
    }

    public Identifier getCurrentFaction() {
        return this.currentFaction;
    }

    // --- NBT Save/Load ---

    public void saveToNbt(NbtCompound tag) {
        NbtCompound repTag = new NbtCompound();
        for (Map.Entry<Identifier, Integer> entry : reputationMap.entrySet()) {
            repTag.putInt(entry.getKey().toString(), entry.getValue());
        }
        tag.put("FactionReputation", repTag);

        if (currentFaction != null) {
            tag.putString("CurrentFaction", currentFaction.toString());
        }
    }

    public void loadFromNbt(NbtCompound tag) {
        reputationMap.clear();
        if (tag.contains("FactionReputation")) {
            NbtCompound repTag = tag.getCompound("FactionReputation");
            for (String key : repTag.getKeys()) {
                reputationMap.put(Identifier.of(key), repTag.getInt(key));
            }
        }

        if (tag.contains("CurrentFaction")) {
            currentFaction = Identifier.of(tag.getString("CurrentFaction"));
        } else {
            currentFaction = null;
        }
    }

    public void adjustReputation(Identifier factionId, int delta) {

    }
}
