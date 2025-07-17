package net.shyn.wandswonders.world.structure;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.Optional;

public class ModStructureHelper {

    public static boolean generateStructure(ServerWorld world, BlockPos pos, Identifier structureId) {
        Optional<StructureTemplate> template = world.getStructureTemplateManager().getTemplate(structureId);

        System.out.println("➡️ Trying to load: " + structureId);

        if (template.isEmpty()) {
            System.out.println("⚠️ Structure not found: " + structureId);
            return false;
        }

        StructurePlacementData placementData = new StructurePlacementData();
        boolean placed = template.get().place(world, pos, pos, placementData, world.random, 2);

        if (!placed) {
            System.out.println("⚠️ Failed to place structure: " + structureId + " at " + pos);
        }

        return placed;
    }
}
