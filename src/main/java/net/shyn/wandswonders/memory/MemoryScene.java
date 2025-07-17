package net.shyn.wandswonders.memory;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.player.PlayerEntity;

public interface MemoryScene {
    void play(ServerWorld world, PlayerEntity player);
}
