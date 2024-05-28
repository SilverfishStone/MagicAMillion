package net.silverfishstone.magicamillion.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.silverfishstone.magicamillion.MagicAMillion;
import net.silverfishstone.magicamillion.util.ModdedTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModdedItemTagGenerator extends ItemTagsProvider {
    public ModdedItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, MagicAMillion.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModdedTags.Items.STARCH)
                .add(Items.BREAD)
                .add(Items.COOKIE)
                .add(Items.PUMPKIN_PIE)
                .add(Items.MUSHROOM_STEW);

        this.tag(ModdedTags.Items.FARM_FOODS)
                .add(Items.BREAD)
                .add(Items.COOKED_BEEF)
                .add(Items.COOKED_CHICKEN)
                .add(Items.COOKED_COD)
                .add(Items.COOKED_MUTTON)
                .add(Items.COOKED_RABBIT)
                .add(Items.COOKED_PORKCHOP)
                .add(Items.COOKED_SALMON)
                .add(Items.GOLDEN_APPLE)
                .add(Items.GOLDEN_CARROT)
                .add(Items.ENCHANTED_GOLDEN_APPLE)
                .add(Items.CARROT)
                .add(Items.BAKED_POTATO)
                .add(Items.BEETROOT_SOUP)
                .add(Items.SUSPICIOUS_STEW)
                .add(Items.PUMPKIN_PIE)
                .add(Items.MUSHROOM_STEW);

        this.tag(ModdedTags.Items.DESERT_TREASURE)
                .add(Items.GOLD_NUGGET)
                .add(Items.GOLD_INGOT)
                .add(Items.IRON_NUGGET)
                .add(Items.DEAD_BUSH)
                .add(Items.CACTUS)
                .add(Items.RAW_GOLD)
                .add(Items.IRON_PICKAXE);

        this.tag(ModdedTags.Items.OCEAN_TREASURE)
                .add(Items.GOLD_NUGGET)
                .add(Items.IRON_NUGGET)
                .add(Items.NAUTILUS_SHELL)
                .add(Items.SPYGLASS)
                .add(Items.PUFFERFISH)
                .add(Items.IRON_SWORD);

        this.tag(ModdedTags.Items.RANDOM_TREASURE)
                .add(Items.GOLD_NUGGET)
                .add(Items.IRON_NUGGET);

        this.tag(ModdedTags.Items.ELYTRA)
                .add(Items.ELYTRA);

        this.tag(ModdedTags.Items.DIAMOND_STUFFS)
                .add(Items.DIAMOND_AXE)
                .add(Items.DIAMOND_PICKAXE)
                .add(Items.DIAMOND_SHOVEL)
                .add(Items.DIAMOND_HOE)
                .add(Items.DIAMOND_SWORD)
                .add(Items.DIAMOND_BOOTS)
                .add(Items.DIAMOND_LEGGINGS)
                .add(Items.DIAMOND_CHESTPLATE)
                .add(Items.DIAMOND_HELMET);

        this.tag(ModdedTags.Items.NETHERITE_STUFFS)
                .add(Items.NETHERITE_AXE)
                .add(Items.NETHERITE_PICKAXE)
                .add(Items.NETHERITE_SHOVEL)
                .add(Items.NETHERITE_HOE)
                .add(Items.NETHERITE_SWORD)
                .add(Items.NETHERITE_BOOTS)
                .add(Items.NETHERITE_LEGGINGS)
                .add(Items.NETHERITE_CHESTPLATE)
                .add(Items.NETHERITE_HELMET);
    }
}
