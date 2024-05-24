package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.Tags;
import net.silverfishstone.magicamillion.MagicAMillion;
import net.silverfishstone.magicamillion.util.ModdedTags;
import org.jetbrains.annotations.NotNull;

public class WaveStruckEnchantment extends Enchantment {
    public WaveStruckEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 10 * pEnchantmentLevel;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 35;
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        LivingEntity victim = (LivingEntity) pTarget;
        DamageSource hurting =
                new DamageSources(pAttacker.level().registryAccess()).mobAttack(pAttacker);
        //test if victim is correct type of mob. "Nether Mobs" can be configured by datapacks or added to in other mods.
        if (victim.getType().is(ModdedTags.EntityTypes.NETHER)) {
            victim.hurt(hurting, pLevel * 2.5F);
        }
    }

    public int getMaxLevel() {
        return 5;
    }

    @Override
    public boolean checkCompatibility(Enchantment pEnch) {
        return !(pEnch.equals(Enchantments.SMITE)) && !(pEnch.equals(Enchantments.BANE_OF_ARTHROPODS)) && super.checkCompatibility(pEnch);
    }
}
