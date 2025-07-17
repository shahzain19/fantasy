// FactionGuardEntity.java
package net.shyn.wandswonders.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.shyn.wandswonders.factions.player.FactionManager;

public class FactionGuardEntity extends VillagerEntity {
    private Identifier faction;

    public FactionGuardEntity(EntityType<? extends VillagerEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.6D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true, player -> {
            if (!(player instanceof ServerPlayerEntity) || this.faction == null) return false;
            int rep = FactionManager.get((ServerPlayerEntity) player).getReputation(this.faction);
            return rep < -25;
        }));
    }

    public void setFaction(Identifier factionId) {
        this.faction = factionId;
    }

    public Identifier getFaction() {
        return this.faction;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        if (faction != null) {
            nbt.putString("Faction", faction.toString());
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("Faction")) {
            faction = Identifier.of(nbt.getString("Faction"));
        }
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return VillagerEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0);
    }
}
