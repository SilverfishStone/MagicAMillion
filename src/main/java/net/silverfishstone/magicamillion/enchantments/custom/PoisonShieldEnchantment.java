package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;

public class PoisonShieldEnchantment extends Enchantment {
    public PoisonShieldEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        LivingEntity entity = (LivingEntity) pAttacker;
        int min = 0;
        int max = 2;
        int i = (int)Math.floor(Math.random() * (max - min + 1) + min);
        if (i == 1) {
            entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100 * pLevel));
        }
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 10 * pEnchantmentLevel;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 35;
    }

    public int getMaxLevel() {
        return 4;
    }
}
