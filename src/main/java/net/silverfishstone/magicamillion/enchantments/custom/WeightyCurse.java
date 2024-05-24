package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class WeightyCurse extends Enchantment {
    public WeightyCurse(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, @NotNull Entity pAttacker, int pLevel) {
       pTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1, false, false));
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    public boolean isCurse() {
        return true;
    }
}
