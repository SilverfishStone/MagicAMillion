package net.silverfishstone.magicamillion.mobeffect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class WhirlpoolEffect extends MobEffect {
    public WhirlpoolEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        Level level = pLivingEntity.level();
        pLivingEntity.turn(12, 0);
        int min = 0;
        int max = 2;
        int i = (int)Math.floor(Math.random() * (max - min + 1) + min);
        Vec3 vec36 = new Vec3(i - 1, 0.4D, i - 1);
        pLivingEntity.setDeltaMovement(vec36.multiply(0.1, 0.8F, 0.1));
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
