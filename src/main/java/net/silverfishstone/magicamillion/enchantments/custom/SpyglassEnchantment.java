package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpyglassItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SpyglassEnchantment extends Enchantment {
    public SpyglassEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        Item glass = pStack.getItem();
        return glass instanceof SpyglassItem;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        Item glass = stack.getItem();
        return glass instanceof SpyglassItem;
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 5 * pEnchantmentLevel;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 35;
    }
}
