package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.MendingEnchantment;
import net.minecraftforge.common.Tags;

public class SiftingEnchantment extends Enchantment {
    public SiftingEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 12 * pEnchantmentLevel;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 26;
    }

    public int getMaxLevel() {
        return 4;
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.is(ItemTags.SHOVELS);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return stack.is(ItemTags.SHOVELS);
    }

    @Override
    public boolean checkCompatibility(Enchantment pEnch) {
        return !(pEnch.equals(Enchantments.SILK_TOUCH)) && super.checkCompatibility(pEnch);
    }
}
