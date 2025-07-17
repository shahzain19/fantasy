package net.shyn.wandswonders.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.shyn.wandswonders.component.ManaComponent;
import net.shyn.wandswonders.component.PlayerManaProvider;
import net.shyn.wandswonders.item.ModItems;
import net.shyn.wandswonders.magic.Spell;
import net.shyn.wandswonders.magic.SpellRegistry;
import org.jetbrains.annotations.Nullable;

public class MagicWandItem extends Item {

    public MagicWandItem(Settings settings) {
        super(settings);
    }

    public static ItemStack createWandWithSpell(Spell spell) {
        ItemStack stack = new ItemStack(ModItems.MAGIC_WAND);

        for (var entry : SpellRegistry.getAll().entrySet()) {
            if (entry.getValue().equals(spell)) {
                NbtCompound data = new NbtCompound();
                data.putString("spell", entry.getKey());
                stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(data));
                break;
            }
        }

        return stack;
    }

    @Nullable
    private static String getSpellId(ItemStack stack) {
        NbtComponent comp = stack.get(DataComponentTypes.CUSTOM_DATA);
        if (comp != null && comp.getNbt().contains("spell")) {
            return comp.getNbt().getString("spell");
        }
        return null;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        String spellId = getSpellId(stack);

        if (!world.isClient && spellId != null) {
            Spell spell = SpellRegistry.get(spellId);
            if (spell != null) {
                ManaComponent mana = PlayerManaProvider.get(user);
                int cost = 10;

                if (mana.getMana() >= cost) {
                    mana.subtractMana(cost); // 🟦 Reduce mana
                    spell.cast(world, user, hand); // 🪄 Cast the spell
                    user.sendMessage(net.minecraft.text.Text.literal("🪄 Spell cast! Mana: " + mana.getMana()), true);
                } else {
                    user.sendMessage(net.minecraft.text.Text.literal("❌ Not enough mana!"), true);
                }
            }
        }

        return TypedActionResult.success(stack, world.isClient());
    }

}
