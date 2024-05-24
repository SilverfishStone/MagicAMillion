package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.silverfishstone.magicamillion.mobeffect.ModdedMobEffects;

public class CorrosionEnchantment extends Enchantment {
    public CorrosionEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        LivingEntity entity = (LivingEntity) pTarget;
        entity.addEffect(new MobEffectInstance(ModdedMobEffects.CORROSION.get(), 100 * pLevel));
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

    @Override
    public boolean checkCompatibility(Enchantment pEnch) {
        return !(pEnch.equals(Enchantments.FIRE_ASPECT)) && super.checkCompatibility(pEnch);
    }
}
