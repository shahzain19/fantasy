package net.shyn.wandswonders.world.structure;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.shyn.wandswonders.WandsWonders;

import java.util.Optional;

public class BazaarStructure {
    public static void place(ServerWorld world, BlockPos originalPos) {
        Identifier id = Identifier.of(WandsWonders.MOD_ID, "bazaar_shop");
        Optional<StructureTemplate> template = world.getStructureTemplateManager().getTemplate(id);

        if (template.isEmpty()) {
            System.out.println("❌ Structure not found: " + id);
            return;
        }

        // 👇 Offset the structure to appear 5 blocks ahead and on surface
        BlockPos spawnPos = originalPos.add(0, 0, 5); // in front of player

        // Try to raise the structure up if it's underground
        int groundY = world.getChunk(spawnPos).getHeightmap(Heightmap.Type.WORLD_SURFACE).get(spawnPos.getX() & 15, spawnPos.getZ() & 15);
        spawnPos = new BlockPos(spawnPos.getX(), groundY, spawnPos.getZ());


        StructurePlacementData placementData = new StructurePlacementData()
                .setIgnoreEntities(false)
                .setMirror(BlockMirror.NONE)
                .setRotation(BlockRotation.NONE);

        boolean success = template.get().place(world, spawnPos, spawnPos, placementData, world.getRandom(), 2);

        if (success) {
            System.out.println("✅ Bazaar structure placed at " + spawnPos.toShortString());
        } else {
            System.out.println("⚠️ Failed to place bazaar at " + spawnPos.toShortString());
        }

        System.out.println("Trying to load structure...");
        System.out.println("Identifier: " + id);

        if (template == null) {
            System.out.println("❌ Failed to load structure template.");
            return;
        }

    }
}
