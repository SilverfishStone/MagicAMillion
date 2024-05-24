package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ShieldEnchantment extends Enchantment {
    public ShieldEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 10 * pEnchantmentLevel;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 35;
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.is(Items.SHIELD);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return stack.is(Items.SHIELD);
    }
}
