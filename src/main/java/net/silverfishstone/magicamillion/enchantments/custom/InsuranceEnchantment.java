package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.silverfishstone.magicamillion.util.ModdedTags;

public class InsuranceEnchantment extends Enchantment {
    public InsuranceEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    //Inspired by a PhoenixSC bit

    /*
    Insurance is fully customizable and should be compatible with any mod.
     */


    public int getMinCost(int pEnchantmentLevel) {
        return 10 * pEnchantmentLevel;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 35;
    }

    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        Item breakable = pStack.getItem();
        return !(pStack.is(ModdedTags.Items.ELYTRA) || breakable instanceof ElytraItem || breakable instanceof ArmorItem) && breakable.canBeDepleted();
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        Item breakable = stack.getItem();
        return !(stack.is(ModdedTags.Items.ELYTRA) || breakable instanceof ElytraItem || breakable instanceof ArmorItem) && breakable.canBeDepleted();
    }

    @Override
    public boolean checkCompatibility(Enchantment pEnch) {
        return !(pEnch.equals(Enchantments.MENDING)) && super.checkCompatibility(pEnch);
    }
}
