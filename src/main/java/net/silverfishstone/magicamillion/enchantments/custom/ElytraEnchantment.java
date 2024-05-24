package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ElytraEnchantment extends Enchantment {
    public ElytraEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.is(Items.ELYTRA);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return stack.is(Items.ELYTRA);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 21 * pEnchantmentLevel;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 35;
    }
}
