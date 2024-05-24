package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;

public class BlastingEnchantment extends Enchantment {
    public BlastingEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        Level level = pTarget.level();
        level.explode(pTarget, pTarget.getX(), pTarget.getY() - 1, pTarget.getZ(), pLevel, Level.ExplosionInteraction.NONE);
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

    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
