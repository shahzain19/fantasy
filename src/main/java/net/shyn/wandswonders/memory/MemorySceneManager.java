package net.shyn.wandswonders.memory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

import java.util.HashMap;
import java.util.Map;

public class MemorySceneManager {
    private static final Map<String, MemoryScene> SCENES = new HashMap<>();

    static {
        SCENES.put("fire_king", new FireKingMemory());
        // Add more:
        // SCENES.put("forest_druid", new ForestDruidMemory());
    }

    public static void playScene(String id, ServerWorld world, PlayerEntity player) {
        MemoryScene scene = SCENES.get(id);
        if (scene != null) {
            scene.play(world, player);
        } else {
            player.sendMessage(net.minecraft.text.Text.of("§7[Memory] Nothing happens..."), false);
        }
    }
}
