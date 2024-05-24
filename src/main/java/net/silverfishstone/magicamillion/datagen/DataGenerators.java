package net.silverfishstone.magicamillion.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.silverfishstone.magicamillion.MagicAMillion;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = MagicAMillion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> LookupProvider = event.getLookupProvider();

        ModdedBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new ModdedBlockTagGenerator(packOutput, LookupProvider,  MagicAMillion.MODID, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModdedItemTagGenerator(packOutput, LookupProvider, blockTagGenerator.contentsGetter(),  MagicAMillion.MODID, existingFileHelper));

    }

}
