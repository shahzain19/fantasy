package net.shyn.wandswonders.memory;

import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity.RemovalReason;

import java.util.Set;

public class FireKingMemory implements MemoryScene {


    @Override
    public void play(ServerWorld world, PlayerEntity player) {
        Vec3d origin = player.getPos();
        float yaw = player.getYaw();
        float pitch = player.getPitch();

        // 🧊 Lock player movement for cinematic effect
        player.getAbilities().flying = true;
        player.setNoGravity(true);
        player.setVelocity(0, 0, 0);player.teleport(
                world,
                origin.x, origin.y, origin.z,
                Set.of(), // use empty set for default behavior
                yaw,
                pitch
        );

        player.sendAbilitiesUpdate();

        // 🌀 Start fade-in / vision effect
        player.sendMessage(Text.of("§d[Memory Vision] The heat of ancient flames surrounds you..."), false);
        world.playSound(null, origin.getX(), origin.getY(), origin.getZ(), SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.PLAYERS, 0.8f, 1.1f);
        spawnParticles(world, origin, ParticleTypes.REVERSE_PORTAL, 40);

        // 👻 Spawn ghost actor: Fire King
        ArmorStandEntity fireKing = new ArmorStandEntity(world, origin.x + 2, origin.y, origin.z);
        fireKing.setInvisible(true);
        fireKing.setNoGravity(true);
        fireKing.setInvulnerable(true);
        fireKing.setGlowing(true);
        fireKing.setSilent(true);
        fireKing.setCustomName(Text.of("§c🔥 The Fire King 🔥"));
        fireKing.setCustomNameVisible(true);
        world.spawnEntity(fireKing);

        // ⏱️ Cutscene timeline
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                world.getServer().execute(() -> {
                    player.sendMessage(Text.of("§c[Fire King]: You seek the Ember Crown..."), false);
                    world.playSound(null, origin.getX(), origin.getY(), origin.getZ(), SoundEvents.ENTITY_BLAZE_AMBIENT, SoundCategory.PLAYERS, 1f, 1.1f);
                    spawnParticles(world, origin, ParticleTypes.FLAME, 20);
                });

                Thread.sleep(4000);
                world.getServer().execute(() -> {
                    player.sendMessage(Text.of("§c[Fire King]: The pyres must be lit before the Ash Moon rises."), false);
                    world.playSound(null, origin.getX(), origin.getY(), origin.getZ(), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.PLAYERS, 1f, 1f);
                    spawnParticles(world, origin, ParticleTypes.SMOKE, 30);
                });

                Thread.sleep(4000);
                world.getServer().execute(() -> {
                    player.sendMessage(Text.of("§c[Fire King]: Fail, and the fire will consume you too."), false);
                    spawnParticles(world, origin, ParticleTypes.LARGE_SMOKE, 20);
                });

                Thread.sleep(4000);
                world.getServer().execute(() -> {
                    fireKing.remove(RemovalReason.DISCARDED);
                    player.sendMessage(Text.of("§7[Memory Fades] Silence returns..."), false);
                    world.spawnParticles(ParticleTypes.EXPLOSION, origin.x, origin.y + 1, origin.z, 5, 0.3, 0.3, 0.3, 0.02);
                    world.playSound(null, origin.getX(), origin.getY(), origin.getZ(), SoundEvents.ENTITY_GHAST_DEATH, SoundCategory.PLAYERS, 0.6f, 0.4f);
                });

                Thread.sleep(2000);
                world.getServer().execute(() -> {
                    // 🎮 Restore control
                    player.setNoGravity(false);
                    player.getAbilities().flying = false;
                    player.sendAbilitiesUpdate();
                    player.sendMessage(Text.of("§aYou return from the memory."), false);
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void spawnParticles(ServerWorld world, Vec3d center, net.minecraft.particle.ParticleEffect type, int count) {
        for (int i = 0; i < count; i++) {
            double dx = (world.random.nextDouble() - 0.5) * 2;
            double dy = world.random.nextDouble() * 2;
            double dz = (world.random.nextDouble() - 0.5) * 2;
            world.spawnParticles(type, center.x + dx, center.y + 1 + dy, center.z + dz, 1, 0, 0, 0, 0.01);
        }
    }
}
