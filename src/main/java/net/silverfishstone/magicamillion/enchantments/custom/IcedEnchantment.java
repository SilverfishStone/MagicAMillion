package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.silverfishstone.magicamillion.mobeffect.ModdedMobEffects;

public class IcedEnchantment extends Enchantment {
    public IcedEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        LivingEntity entity = (LivingEntity) pTarget;
        int min = 0;
        int max = 2;
        int i = (int)Math.floor(Math.random() * (max - min + 1) + min);
        if (i == 1) {
            entity.addEffect(new MobEffectInstance(ModdedMobEffects.ICED.get(), 200 * pLevel, 0, true, false));
        }
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 25 * pEnchantmentLevel;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 41;
    }

    public int getMaxLevel() {
        return 3;
    }
}
