package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;

public class VolatileEnchantment extends Enchantment {
    public VolatileEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        Level level = pAttacker.level();
        int min = 0;
        int max = 2;
        int i = (int)Math.floor(Math.random() * (max - min + 1) + min);
        if (i == 1) {
            level.explode((Entity)pAttacker, level.damageSources().mobAttack(pAttacker), null, pTarget.position(), pLevel * 0.5F, false, Level.ExplosionInteraction.NONE);
        }
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 25 * pEnchantmentLevel;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 41;
    }

    public int getMaxLevel() {
        return 2;
    }
}
