package net.silverfishstone.magicamillion.damage;


import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.silverfishstone.magicamillion.MagicAMillion;

public interface CustomDamageTypes {
    ResourceKey<DamageType> BACKFIRE = ResourceKey.create(Registries.DAMAGE_TYPE,
            new ResourceLocation(MagicAMillion.MODID, "backfire"));
}
