package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.silverfishstone.magicamillion.enchantments.ModifiedEnchantments;
import net.silverfishstone.magicamillion.mobeffect.ModdedMobEffects;

public class BackfireCurse extends Enchantment {
    public BackfireCurse(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        DamageSource backfire =
                new DamageSources(pAttacker.level().registryAccess()).mobAttack(pAttacker);
        //Testing for enchantments to deal special damage if applicable.
        if (pAttacker.getMainHandItem().getEnchantmentLevel(Enchantments.SHARPNESS) >= 1) {
            pAttacker.hurt(backfire, (pAttacker.getMainHandItem().getEnchantmentLevel(Enchantments.SHARPNESS)) + 2);
        } else {
            pAttacker.hurt(backfire, 2);
        }
        if (pAttacker.getMainHandItem().getEnchantmentLevel(ModifiedEnchantments.SHULKIFY.get()) >= 1) {
            pAttacker.addEffect(new MobEffectInstance(MobEffects.LEVITATION, (pAttacker.getMainHandItem().getEnchantmentLevel(ModifiedEnchantments.SHULKIFY.get()))*100));
        }
        if (pAttacker.getMainHandItem().getEnchantmentLevel(Enchantments.FIRE_ASPECT) >= 1) {
            pAttacker.setSecondsOnFire((pAttacker.getMainHandItem().getEnchantmentLevel(Enchantments.FIRE_ASPECT) * 5));
        }
        if (pAttacker.getMainHandItem().getEnchantmentLevel(ModifiedEnchantments.CORROSION.get()) >= 1) {
            pAttacker.addEffect(new MobEffectInstance(ModdedMobEffects.CORROSION.get(), (pAttacker.getMainHandItem().getEnchantmentLevel(ModifiedEnchantments.CORROSION.get()))*100));
        }
        if (pAttacker.getMainHandItem().getEnchantmentLevel(ModifiedEnchantments.ERODING.get()) >= 1) {
            pAttacker.addEffect(new MobEffectInstance(ModdedMobEffects.CORROSION.get(), (pAttacker.getMainHandItem().getEnchantmentLevel(ModifiedEnchantments.ERODING.get()))*100));
        }
        if (pAttacker.getMainHandItem().getEnchantmentLevel(ModifiedEnchantments.ICED.get()) >= 1) {
            int min = 0;
            int max = 2;
            int i = (int)Math.floor(Math.random() * (max - min + 1) + min);
            if (i == 1) {
                pAttacker.addEffect(new MobEffectInstance(ModdedMobEffects.ICED.get(), 200 * (pAttacker.getMainHandItem().getEnchantmentLevel(ModifiedEnchantments.ICED.get())), 0, true, false));
            }
        }
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    public boolean isCurse() {
        return true;
    }
}
