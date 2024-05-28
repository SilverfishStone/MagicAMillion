package net.silverfishstone.magicamillion.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MagicNumbersConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> pickaxeaxe;
    public static final ForgeConfigSpec.ConfigValue<Integer> swoe;
    public static final ForgeConfigSpec.ConfigValue<Integer> shover;
    public static final ForgeConfigSpec.ConfigValue<Integer> wearable;
    public static final ForgeConfigSpec.ConfigValue<Integer> tierV;
    public static final ForgeConfigSpec.ConfigValue<Integer> tierVI;
    public static final ForgeConfigSpec.ConfigValue<Integer> tierVII;
    public static final ForgeConfigSpec.ConfigValue<Integer> tierVIII;
    public static final ForgeConfigSpec.ConfigValue<Integer> tierIX;
    public static final ForgeConfigSpec.ConfigValue<Integer> unknown_tool;

    static {
        BUILDER.push("Config for MagicAMillion");

        pickaxeaxe = BUILDER.define("pickaxe & axe", 3);
        swoe = BUILDER.define("sword & hoe", 2);
        shover = BUILDER.define("shovel & brush", 1);
        unknown_tool = BUILDER.define("unknown_tool", 2);
        wearable = BUILDER.define("wearable", 4);
        tierV = BUILDER.define("custom level 5", 5);
        tierVI = BUILDER.define("custom level 6", 6);
        tierVII = BUILDER.define("custom level 7", 7);
        tierVIII = BUILDER.define("custom level 8", 8);
        tierIX = BUILDER.define("custom level 9", 9);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}