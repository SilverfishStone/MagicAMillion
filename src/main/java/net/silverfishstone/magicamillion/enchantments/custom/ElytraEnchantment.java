package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.silverfishstone.magicamillion.util.ModdedTags;

public class ElytraEnchantment extends Enchantment {
    public ElytraEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        Item elytra = pStack.getItem();
        return pStack.is(ModdedTags.Items.ELYTRA) || elytra instanceof ElytraItem;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        Item elytra = stack.getItem();
        return stack.is(ModdedTags.Items.ELYTRA) || elytra instanceof ElytraItem;
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 21 * pEnchantmentLevel;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 35;
    }
}
