package net.shyn.wandswonders.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shyn.wandswonders.WandsWonders;
import net.shyn.wandswonders.entity.custom.FactionGuardEntity;

public class ModEntities {

    public static final EntityType<FactionGuardEntity> FACTION_GUARD = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(WandsWonders.MOD_ID, "faction_guard"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FactionGuardEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.95f)) // same as villager
                    .build()
    );

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(FACTION_GUARD, FactionGuardEntity.createAttributes());
    }


    public static void registerEntities() {
        WandsWonders.LOGGER.info("✅ Registered custom entities.");
    }
}
