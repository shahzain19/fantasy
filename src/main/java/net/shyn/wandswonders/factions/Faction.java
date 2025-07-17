package net.shyn.wandswonders.factions;

import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * Represents a single Faction with its properties loaded from JSON.
 */
public class Faction {
    public final Identifier id;
    public final String name;
    public final int color;
    public final Identifier biome;
    public final String[] rewards;
    public final int hostileRep;
    public final int neutralRep;
    public final int trustedRep;
    public final int allyRep;

    public Faction(
            Identifier id,
            String name,
            int color,
            Identifier biome,
            String[] rewards,
            int hostileRep,
            int neutralRep,
            int trustedRep,
            int allyRep
    ) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.biome = biome;
        this.rewards = rewards;
        this.hostileRep = hostileRep;
        this.neutralRep = neutralRep;
        this.trustedRep = trustedRep;
        this.allyRep = allyRep;
    }

    public Text getDisplayName() {
        return Text.literal(name);
    }

    public Identifier getId() {
        return id;
    }

    public int getColor() {
        return color;
    }

    public Identifier getBiome() {
        return biome;
    }

    public int getReputationTier(int rep) {
        if (rep >= allyRep) return 3;
        if (rep >= trustedRep) return 2;
        if (rep >= neutralRep) return 1;
        return 0;
    }
}
