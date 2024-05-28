package net.silverfishstone.magicamillion.mobeffect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.magicamillion.MagicAMillion;

public class ModdedMobEffects
{
    private static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MagicAMillion.MODID);

    public static final RegistryObject<MobEffect> CLOAKED = MOB_EFFECTS.register("cloaked", () -> new CloakedEffect(MobEffectCategory.BENEFICIAL, 0x260078));
    public static final RegistryObject<MobEffect> SUNKEN = MOB_EFFECTS.register("sunken", () -> new SunkenEffect(MobEffectCategory.HARMFUL, 0x29BCCB));
    public static final RegistryObject<MobEffect> WHIRLPOOL = MOB_EFFECTS.register("whirlpool", () -> new WhirlpoolEffect(MobEffectCategory.HARMFUL, 0x06366D));
    public static final RegistryObject<MobEffect> ICED = MOB_EFFECTS.register("iced", () -> new IcedEffect(MobEffectCategory.HARMFUL, 0xDAEBFF).addAttributeModifier(Attributes.MOVEMENT_SPEED, "7101DE1E-1CE1-9111-110E-516C0F160191", -0.5F, AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final RegistryObject<MobEffect> CORROSION = MOB_EFFECTS.register("corrosion", () -> new CorrosionEffect(MobEffectCategory.HARMFUL, 0x3E0078));
    public static final RegistryObject<MobEffect> SOUL_FLAME = MOB_EFFECTS.register("soul_flame", () -> new SoulFlameEffect(MobEffectCategory.HARMFUL, 0x457290));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
