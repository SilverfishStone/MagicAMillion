package net.silverfishstone.magicamillion.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.silverfishstone.magicamillion.MagicAMillion;
import net.silverfishstone.magicamillion.util.ModdedTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModdedBlockTagGenerator extends BlockTagsProvider {
    public ModdedBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MagicAMillion.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModdedTags.Blocks.SCULK)
                .add(Blocks.SCULK,
                        Blocks.SCULK_CATALYST,
                        Blocks.SCULK_SENSOR,
                        Blocks.SCULK_VEIN,
                        Blocks.CALIBRATED_SCULK_SENSOR,
                        Blocks.SCULK_SHRIEKER);

        this.tag(ModdedTags.Blocks.DESERT_TREASURE_POSSIBLE)
                .add(Blocks.SAND,
                        Blocks.RED_SAND);
        this.tag(ModdedTags.Blocks.OCEAN_TREASURE_POSSIBLE)
                .add(Blocks.SAND,
                        Blocks.GRAVEL);
    }
}
