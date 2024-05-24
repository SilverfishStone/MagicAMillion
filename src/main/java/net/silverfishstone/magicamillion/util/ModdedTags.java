package net.silverfishstone.magicamillion.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.silverfishstone.magicamillion.MagicAMillion;

public class ModdedTags {
    public static class Blocks {

        public static final TagKey<Block> SCULK = tag("sculk") ;
        public static final TagKey<Block> DESERT_TREASURE_POSSIBLE = tag("desert_treasure_possible") ;
        public static final TagKey<Block> OCEAN_TREASURE_POSSIBLE = tag("ocean_treasure_possible") ;

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(MagicAMillion.MODID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> STARCH = tag("starch");
        public static final TagKey<Item> FARM_FOODS = tag("farm_foods");
        public static final TagKey<Item> DESERT_TREASURE = tag("desert_treasure");
        public static final TagKey<Item> OCEAN_TREASURE = tag("ocean_treasure");
        public static final TagKey<Item> RANDOM_TREASURE = tag("random_treasure");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(MagicAMillion.MODID, name));
        }
    }

    public static class Effects {

        public static final TagKey<MobEffect> HURTFUL = tag("hurtful");

        private static TagKey<MobEffect> tag(String name) {
            return ModdedTags.createEffect(new ResourceLocation(MagicAMillion.MODID, name));
        }
    }
    public static TagKey<MobEffect> createEffect(final ResourceLocation name) {
        return TagKey.create(Registries.MOB_EFFECT, name);
    }

    public static class EntityTypes {

        public static final TagKey<EntityType<?>> NETHER = create("nether");
    }
    private static TagKey<EntityType<?>> create(String pName) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(MagicAMillion.MODID, pName));
    }
}
