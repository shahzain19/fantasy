package net.shyn.wandswonders.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.shyn.wandswonders.memory.MemorySceneManager;

public class MemoryRelicItem extends Item {
    private final String memoryId;

    public MemoryRelicItem(Settings settings, String memoryId) {
        super(settings);
        this.memoryId = memoryId; // example: "fire_king", "forest_druid"
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient) {
            ServerWorld serverWorld = (ServerWorld) world;

            // Common Effects
            player.sendMessage(Text.of("§dA vision floods your mind..."), true);
            world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.PLAYERS, 1.0f, 1.2f);

            // Soul Particles
            for (int i = 0; i < 30; i++) {
                double dx = (world.random.nextDouble() - 0.5) * 1.5;
                double dy = world.random.nextDouble() * 1.5;
                double dz = (world.random.nextDouble() - 0.5) * 1.5;
                serverWorld.spawnParticles(ParticleTypes.SOUL, player.getX() + dx, player.getY() + 1 + dy, player.getZ() + dz, 1, 0, 0, 0, 0.01);
            }

            // Trigger the unique memory cutscene
            MemorySceneManager.playScene(memoryId, serverWorld, player);
        }

        return TypedActionResult.success(stack, world.isClient());
    }

}
