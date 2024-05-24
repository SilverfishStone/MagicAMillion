package net.silverfishstone.magicamillion.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.silverfishstone.magicamillion.MagicAMillion;

public class MagicGlobalLootModifiersGen extends GlobalLootModifierProvider {
    public MagicGlobalLootModifiersGen(PackOutput output) {
        super(output, MagicAMillion.MODID);
    }

    @Override
    protected void start() {
    }
}
