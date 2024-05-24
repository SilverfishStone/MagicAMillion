package net.silverfishstone.magicamillion.datagen.loot;


import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import java.util.function.Supplier;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.Codec;

import com.google.common.base.Suppliers;
import net.silverfishstone.magicamillion.MagicAMillion;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = MagicAMillion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AddLootModifier {
    public static class AddShulkify extends LootModifier {
        public static final Supplier<Codec<AddShulkify>> CODEC = Suppliers
                .memoize(() -> RecordCodecBuilder.create(instance -> codecStart(instance).and(ResourceLocation.CODEC.fieldOf("lootTable").forGetter(m -> m.lootTable)).apply(instance, AddShulkify::new)));
        private final ResourceLocation lootTable;

        public AddShulkify(LootItemCondition[] conditions, ResourceLocation lootTable) {
            super(conditions);
            this.lootTable = lootTable;
        }

        @Override
        protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
            context.getResolver().getLootTable(lootTable).getRandomItemsRaw(context, generatedLoot::add);
            return generatedLoot;
        }

        @Override
        public Codec<? extends IGlobalLootModifier> codec() {
            return CODEC.get();
        }
    }
    public static class AddSlowness extends LootModifier {
        public static final Supplier<Codec<AddSlowness>> CODEC = Suppliers
                .memoize(() -> RecordCodecBuilder.create(instance -> codecStart(instance).and(ResourceLocation.CODEC.fieldOf("lootTable").forGetter(m -> m.lootTable)).apply(instance, AddSlowness::new)));
        private final ResourceLocation lootTable;

        public AddSlowness(LootItemCondition[] conditions, ResourceLocation lootTable) {
            super(conditions);
            this.lootTable = lootTable;
        }

        @Override
        protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
            context.getResolver().getLootTable(lootTable).getRandomItemsRaw(context, generatedLoot::add);
            return generatedLoot;
        }

        @Override
        public Codec<? extends IGlobalLootModifier> codec() {
            return CODEC.get();
        }
    }
    public static class AddSculkSpeed extends LootModifier {
        public static final Supplier<Codec<AddSculkSpeed>> CODEC = Suppliers
                .memoize(() -> RecordCodecBuilder.create(instance -> codecStart(instance).and(ResourceLocation.CODEC.fieldOf("lootTable").forGetter(m -> m.lootTable)).apply(instance, AddSculkSpeed::new)));
        private final ResourceLocation lootTable;

        public AddSculkSpeed(LootItemCondition[] conditions, ResourceLocation lootTable) {
            super(conditions);
            this.lootTable = lootTable;
        }

        @Override
        protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
            context.getResolver().getLootTable(lootTable).getRandomItemsRaw(context, generatedLoot::add);
            return generatedLoot;
        }

        @Override
        public Codec<? extends IGlobalLootModifier> codec() {
            return CODEC.get();
        }
    }
    public static class AddShovelDigModifier extends LootModifier {
        public static final Supplier<Codec<AddShovelDigModifier>> CODEC = Suppliers.memoize(()
                -> RecordCodecBuilder.create(inst -> codecStart(inst).and(ForgeRegistries.ITEMS.getCodec()
                .fieldOf("item").forGetter(m -> m.item)).apply(inst, AddShovelDigModifier::new)));
        private final Item item;

        public AddShovelDigModifier(LootItemCondition[] conditionsIn, Item item) {
            super(conditionsIn);
            this.item = item;
        }

        @Override
        protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
            for(LootItemCondition condition : this.conditions) {
                if(!condition.test(context)) {
                    return generatedLoot;
                }
            }

            generatedLoot.add(new ItemStack(this.item));

            return generatedLoot;
        }

        @Override
        public Codec<? extends IGlobalLootModifier> codec() {
            return CODEC.get();
        }
    }

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MagicAMillion.MODID);
    public static final RegistryObject<Codec<AddShulkify>> SHULKIFY_MOD = LOOT_MODIFIERS.register("shulkify_end_chest", AddShulkify.CODEC);
    public static final RegistryObject<Codec<AddSlowness>> SLOW_MOD = LOOT_MODIFIERS.register("soul_slow_chest", AddSlowness.CODEC);
    public static final RegistryObject<Codec<AddSculkSpeed>> SCULK_SPEED = LOOT_MODIFIERS.register("sculk_speed_chest", AddSculkSpeed.CODEC);
    public static final RegistryObject<Codec<AddShovelDigModifier>> SHOVEL_SIFT = LOOT_MODIFIERS.register("sand_sifting", AddShovelDigModifier.CODEC);

    @SubscribeEvent
    public static void register(FMLConstructModEvent event) {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        event.enqueueWork(() -> {
            LOOT_MODIFIERS.register(bus);
        });
    }
}
