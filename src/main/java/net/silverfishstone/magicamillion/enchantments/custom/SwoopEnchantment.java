package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SwoopEnchantment extends ElytraEnchantment {
    public SwoopEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        DamageSource swoop =
                new DamageSources(pAttacker.level().registryAccess()).playerAttack((Player) pAttacker);
        //if gliding, deal extra damage.
        if (pAttacker.isFallFlying()) {
            pTarget.hurt(swoop, pLevel * 4);
        }
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }
}
