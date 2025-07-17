package net.shyn.wandswonders.component;

import net.minecraft.nbt.NbtCompound;

public class ManaComponent {
    private int mana = 100;
    private int maxMana = 100;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.min(mana, maxMana);
    }

    public void addMana(int amount) {
        this.mana = Math.min(this.mana + amount, maxMana);
    }

    public void subtractMana(int amount) {
        this.mana = Math.max(this.mana - amount, 0);
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int max) {
        this.maxMana = max;
    }

    public void readFromNbt(NbtCompound tag) {
        this.mana = tag.getInt("Mana");
        this.maxMana = tag.getInt("MaxMana");
    }

    public void writeToNbt(NbtCompound tag) {
        tag.putInt("Mana", this.mana);
        tag.putInt("MaxMana", this.maxMana);
    }
}
