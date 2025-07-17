package net.shyn.wandswonders.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.shyn.wandswonders.WandsWonders;
import net.shyn.wandswonders.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator DRIFTWOOD = new SaplingGenerator(WandsWonders.MOD_ID + ":driftwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.DRIFTWOOD_KEY), Optional.empty());

    public static final SaplingGenerator GLOW_SPRUCE = new SaplingGenerator(WandsWonders.MOD_ID + ":glow_spruce",
            Optional.empty(), Optional.of(ModConfiguredFeatures.GLOW_SPRUCE_KEY), Optional.empty());

    public static final SaplingGenerator SUNFLARE_TREE = new SaplingGenerator(WandsWonders.MOD_ID + ":sunflare_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.SUNFLARE_TREE_KEY), Optional.empty());

    public static final SaplingGenerator ORACLE_TREE = new SaplingGenerator(WandsWonders.MOD_ID + ":oracle_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.ORACLE_TREE_KEY), Optional.empty());


}
