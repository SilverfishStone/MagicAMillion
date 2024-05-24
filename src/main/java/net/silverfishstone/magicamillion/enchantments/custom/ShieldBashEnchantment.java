package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.Objects;

public class ShieldBashEnchantment extends ShieldEnchantment {
    public ShieldBashEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        LivingEntity entity = (LivingEntity) pTarget;
        DamageSource shield =
                new DamageSources(pAttacker.level().registryAccess()).mobAttack(pAttacker);
        entity.hurt(shield, pLevel * 2);
    }

    public int getMaxLevel() {
        return 3;
    }


}
