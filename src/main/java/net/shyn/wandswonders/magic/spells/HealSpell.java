package net.shyn.wandswonders.magic.spells;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.shyn.wandswonders.magic.Spell;

public class HealSpell implements Spell {
    @Override
    public void cast(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            player.heal(6.0F); // Heals 3 hearts

            ((net.minecraft.server.world.ServerWorld) world).spawnParticles(
                    ParticleTypes.HAPPY_VILLAGER,
                    player.getX(),
                    player.getY() + 1,
                    player.getZ(),
                    20,
                    0.5, 0.5, 0.5,
                    0.1
            );

            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1.2f, 1.0f);
        }
    }
}
