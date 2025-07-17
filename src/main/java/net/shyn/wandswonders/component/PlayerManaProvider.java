package net.shyn.wandswonders.component;

import java.util.WeakHashMap;
import net.minecraft.entity.player.PlayerEntity;

public class PlayerManaProvider {
    private static final WeakHashMap<PlayerEntity, ManaComponent> MANA_MAP = new WeakHashMap<>();

    public static ManaComponent get(PlayerEntity player) {
        return MANA_MAP.computeIfAbsent(player, p -> new ManaComponent());
    }
}
