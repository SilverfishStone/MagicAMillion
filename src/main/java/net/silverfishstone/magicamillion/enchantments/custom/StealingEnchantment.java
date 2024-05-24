package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;
import net.silverfishstone.magicamillion.enchantments.ModifiedEnchantments;

public class StealingEnchantment extends Enchantment {
    public int type;
    public StealingEnchantment(Rarity pRarity, EnchantmentCategory pCategory, int type, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
        this.type = type;
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        LivingEntity tacky = (LivingEntity) pTarget;
        Level world = tacky.level();
        int min = 0;
        int max = (tacky.getMainHandItem().getEnchantmentLevel(ModifiedEnchantments.THEFT_GUARD.get()) + tacky.getItemBySlot(EquipmentSlot.HEAD).getEnchantmentLevel(ModifiedEnchantments.THEFT_GUARD.get()) + tacky.getItemBySlot(EquipmentSlot.CHEST).getEnchantmentLevel(ModifiedEnchantments.THEFT_GUARD.get()) + tacky.getItemBySlot(EquipmentSlot.LEGS).getEnchantmentLevel(ModifiedEnchantments.THEFT_GUARD.get()) + tacky.getItemBySlot(EquipmentSlot.FEET).getEnchantmentLevel(ModifiedEnchantments.THEFT_GUARD.get())) * 3;
        int i = (int)Math.floor(Math.random() * (max - min + 1) + min);
        if (i == 0) {
            this.steal(tacky, world);
        }
    }

    public void steal (LivingEntity tacky, Level world) {
        //Determines the type of stealing enchantment. Type 1 removes an entity's weapon, and type to removes its armor.
        if (type == 1) {
            ItemStack tackystack = tacky.getMainHandItem();
            ItemEntity drop = new ItemEntity(world, tacky.position().x, tacky.position().y, tacky.position().z, tackystack);
            drop.setPickUpDelay(10);
            world.addFreshEntity(drop);
            tacky.setItemInHand(tacky.getUsedItemHand(), new ItemStack(Items.AIR));
        } if (type == 2) {
            ItemStack tackyhead = tacky.getItemBySlot(EquipmentSlot.HEAD);
            ItemEntity droph = new ItemEntity(world, tacky.position().x, tacky.position().y, tacky.position().z, tackyhead);
            ItemStack tackybody = tacky.getItemBySlot(EquipmentSlot.CHEST);
            ItemEntity dropb = new ItemEntity(world, tacky.position().x, tacky.position().y, tacky.position().z, tackybody);
            ItemStack tackylegs = tacky.getItemBySlot(EquipmentSlot.LEGS);
            ItemEntity dropl = new ItemEntity(world, tacky.position().x, tacky.position().y, tacky.position().z, tackylegs);
            ItemStack tackyboots = tacky.getItemBySlot(EquipmentSlot.FEET);
            ItemEntity drops = new ItemEntity(world, tacky.position().x, tacky.position().y, tacky.position().z, tackyboots);
            droph.setPickUpDelay(10);
            world.addFreshEntity(droph);
            tacky.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.AIR));
            droph.setPickUpDelay(10);
            world.addFreshEntity(dropb);
            tacky.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.AIR));
            droph.setPickUpDelay(10);
            world.addFreshEntity(dropl);
            tacky.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.AIR));
            droph.setPickUpDelay(10);
            world.addFreshEntity(drops);
            tacky.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.AIR));
        }
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 10 * pEnchantmentLevel;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 35;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return !(pOther instanceof StealingEnchantment);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        Item weap = pStack.getItem();
        return weap instanceof SwordItem || weap instanceof BowItem || weap instanceof CrossbowItem;
    }
}
