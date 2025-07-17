package net.shyn.wandswonders.magic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

/**
 * Represents a spell that can be cast by the player.
 * All spells must implement this interface.
 */
public interface Spell {
    /**
     * Called when the spell is cast.
     *
     * @param world The world in which the spell is cast
     * @param player The player casting the spell
     * @param hand The hand used to cast the spell
     */
    void cast(World world, PlayerEntity player, Hand hand);
}
