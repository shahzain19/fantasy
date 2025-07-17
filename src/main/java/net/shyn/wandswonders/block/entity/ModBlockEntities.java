package net.shyn.wandswonders.block.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shyn.wandswonders.WandsWonders;
import net.shyn.wandswonders.block.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<StudyTableBlockEntity> STUDY_TABLE_BE;
    public static BlockEntityType<AlchemyCauldronBlockEntity> ALCHEMY_CAULDRON_BE;


    public static void register() {
        STUDY_TABLE_BE = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(WandsWonders.MOD_ID, "study_table_be"),
                BlockEntityType.Builder.create(StudyTableBlockEntity::new, ModBlocks.STUDY_TABLE).build()
        );
    }

    public static void registerBlockEntities() {
        STUDY_TABLE_BE = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(WandsWonders.MOD_ID, "study_table"),
                BlockEntityType.Builder.create(StudyTableBlockEntity::new, ModBlocks.STUDY_TABLE).build()
        );

        ALCHEMY_CAULDRON_BE = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(WandsWonders.MOD_ID, "alchemy_cauldron"),
                BlockEntityType.Builder.create(AlchemyCauldronBlockEntity::new, ModBlocks.AlCHEMY_CAULDRON).build()
        );


        WandsWonders.LOGGER.info("Registered Study Table Block Entity!");
    }

}
