package net.silverfishstone.magicamillion.mobeffect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class CorrosionEffect extends MobEffect {
    public CorrosionEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        DamageSource corrode =
                new DamageSources(pLivingEntity.level().registryAccess()).magic();
        if (pLivingEntity.getHealth() >= pAmplifier) {
            pLivingEntity.hurt(corrode, pAmplifier);
        } else if (pLivingEntity.getHealth() >= 2) {
            pLivingEntity.hurt(corrode, 1);
        }
    }

    //This effect functions essentially like poison.

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
