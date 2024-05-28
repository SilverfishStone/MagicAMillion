package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.core.Holder;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.*;
import net.silverfishstone.magicamillion.enchantments.ModifiedEnchantments;

import java.util.Objects;

public class CustomProtectionEnchantment extends Enchantment {
    public final int type;

    public CustomProtectionEnchantment(Rarity pRarity, EnchantmentCategory pCategory,  int pType, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
        this.type = pType;
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 5;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 45;
    }

    public int getMaxLevel() {
        return 4;
    }

    public int getDamageProtection(int pLevel, DamageSource pSource) {
        //Determines which version of protection and reduces damage accordingly
        int prot = 0;
        if (pSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            prot = 0;
        } else if (this.type == 1 && (pSource.is(DamageTypes.WITHER) || (pSource.is(DamageTypes.WITHER_SKULL) || (pSource.getEntity().getType().equals(EntityType.WITHER_SKELETON)) || (pSource.getEntity().getType().equals(EntityType.WITHER))))) {
            prot = pLevel * 2;
        } else if (this.type == 2 && (pSource.getEntity().getType().equals(MobType.UNDEAD))) {
            prot = pLevel * 2;
        } else if (this.type == 3 && (pSource.is(DamageTypes.DROWN) || (pSource.getEntity().getType().equals(EntityType.GUARDIAN)) || (pSource.getEntity().getType().equals(EntityType.ELDER_GUARDIAN)))) {
            prot = pLevel * 2;
        }
        return prot;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return !(pOther instanceof CustomProtectionEnchantment || pOther instanceof  ProtectionEnchantment);
    }
}