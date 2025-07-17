package net.shyn.wandswonders.magic;

import net.shyn.wandswonders.magic.spells.FlyingSpell;
import net.shyn.wandswonders.magic.spells.HealSpell;

import java.util.HashMap;
import java.util.Map;

public class SpellRegistry {
    private static final Map<String, Spell> SPELLS = new HashMap<>();

    public static final Spell HEAL = register("heal", new HealSpell());
    public static final Spell FLYING = register("flying", new FlyingSpell());



    public static Spell register(String id, Spell spell) {
        SPELLS.put(id, spell);
        return spell;
    }

    public static Spell get(String id) {
        return SPELLS.get(id);
    }

    public static Map<String, Spell> getAll() {
        return SPELLS;
    }
}
