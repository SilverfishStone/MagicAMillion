package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SoulSlowness extends Enchantment {
    public SoulSlowness(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    public boolean isCurse() {
        return true;
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }
}
