package net.silverfishstone.magicamillion.mobeffect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.Fluids;

public class SunkenEffect extends MobEffect {
    public SunkenEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        pLivingEntity.setSwimming(false);
        pLivingEntity.sinkInFluid(Fluids.WATER.getFluidType());
    }
    //Entities with this effect can not move upward in water.

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
