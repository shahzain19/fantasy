package net.shyn.wandswonders.magic.spells;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.shyn.wandswonders.magic.Spell;

public class FlyingSpell implements Spell {
    @Override
    public void cast(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            player.addVelocity(0, 1.2, 0); // upward boost
            player.velocityModified = true;

            ((net.minecraft.server.world.ServerWorld) world).spawnParticles(
                    ParticleTypes.CLOUD,
                    player.getX(),
                    player.getY() + 1,
                    player.getZ(),
                    15,
                    0.3, 0.3, 0.3,
                    0.01
            );

            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_PHANTOM_FLAP, SoundCategory.PLAYERS, 1f, 1f);
        }
    }
}
