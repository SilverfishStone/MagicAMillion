package net.silverfishstone.magicamillion.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.silverfishstone.magicamillion.MagicAMillion;
import net.silverfishstone.magicamillion.enchantments.ModifiedEnchantments;
import net.silverfishstone.magicamillion.mobeffect.ModdedMobEffects;
import net.silverfishstone.magicamillion.util.ModdedTags;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = MagicAMillion.MODID)
public class ModdedEvents {
    static EquipmentSlot head = EquipmentSlot.HEAD;
    static EquipmentSlot chest = EquipmentSlot.CHEST;
    static EquipmentSlot legs = EquipmentSlot.LEGS;
    static EquipmentSlot feet = EquipmentSlot.FEET;

    @SubscribeEvent
    public static void sinkylinky(TickEvent.PlayerTickEvent event) {
        ItemStack sloth = event.player.getItemBySlot(head);
        ItemStack slotb = event.player.getItemBySlot(chest);
        ItemStack slotl = event.player.getItemBySlot(legs);
        ItemStack slots = event.player.getItemBySlot(feet);
        sinklinkink(event.player);
        lightflight(event.player);
        hellflight(event.player);
        antidote(event.player, sloth, slotb, slotl, slots);
        webWalk(event.player);
        witherdote(event.player, sloth, slotb, slotl, slots);
    }

    public static void sinklinkink(LivingEntity player) {
        if ((player.getItemBySlot(head).getEnchantmentLevel(ModifiedEnchantments.DEVIL_FRUIT.get()) >= 1) && player.isEyeInFluidType(Fluids.WATER.getFluidType())) {
            player.addEffect(new MobEffectInstance(ModdedMobEffects.SUNKEN.get(), 100));
        }
    }
    public static void lightflight(LivingEntity player) {
        if (player.isFallFlying() && player.getItemBySlot(chest).getEnchantmentLevel(ModifiedEnchantments.LIGHT_FLIGHT.get()) == 1) {
            player.resetFallDistance();
        }

    }
    public static void hellflight(LivingEntity player) {
        if (player.isFallFlying() && player.getItemBySlot(chest).getEnchantmentLevel(ModifiedEnchantments.FLAMEPROOF.get()) == 1) {
            player.extinguishFire();
            if (!player.isInFluidType(Fluids.LAVA.getFluidType())) {
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 5, 0, true, false));
            }
        }
    }

    @SubscribeEvent
    public static void farmersCurse(LivingEntityUseItemEvent event) {
        LivingEntity player = event.getEntity();
        ItemStack slot1 = player.getItemBySlot(head);
        ItemStack slot2 = player.getItemBySlot(chest);
        ItemStack slot3 = player.getItemBySlot(legs);
        ItemStack slot4 = player.getItemBySlot(feet);
        ItemStack slot5 = player.getMainHandItem();
        if (((slot1.getEnchantmentLevel(ModifiedEnchantments.FARMERS_CURSE.get()) >= 1) || (slot2.getEnchantmentLevel(ModifiedEnchantments.FARMERS_CURSE.get()) >= 1) || (slot3.getEnchantmentLevel(ModifiedEnchantments.FARMERS_CURSE.get()) >= 1) || (slot4.getEnchantmentLevel(ModifiedEnchantments.FARMERS_CURSE.get()) >= 1))) {
            if (slot5.is(ModdedTags.Items.FARM_FOODS)) {
                player.stopUsingItem();
                //Prevents player from eating any food in the "Farm Foods" list.
            }
        }
    }
    public static void antidote(LivingEntity player, ItemStack slot1, ItemStack slot2, ItemStack slot3, ItemStack slot4) {
        //Credit to https://github.com/ochotonida/artifacts/blob/1.20.x/common/src/main/java/artifacts/item/wearable/belt/AntidoteVesselItem.java
        //The enchantment was not originally inspired by this artifact, but I did use the code to help me build this enchantment.
        if ((slot1.getEnchantmentLevel(ModifiedEnchantments.ANTIDOTE.get()) >= 1) || (slot2.getEnchantmentLevel(ModifiedEnchantments.ANTIDOTE.get()) >= 1) || (slot3.getEnchantmentLevel(ModifiedEnchantments.ANTIDOTE.get()) >= 1) || (slot4.getEnchantmentLevel(ModifiedEnchantments.ANTIDOTE.get()) >= 1)) {
            int dote = 0;
            if (slot1.getEnchantmentLevel(ModifiedEnchantments.ANTIDOTE.get()) >= dote) {
                dote = slot1.getEnchantmentLevel(ModifiedEnchantments.ANTIDOTE.get());
            }
            if (slot2.getEnchantmentLevel(ModifiedEnchantments.ANTIDOTE.get()) >= dote) {
                dote = slot2.getEnchantmentLevel(ModifiedEnchantments.ANTIDOTE.get());
            }
            if (slot3.getEnchantmentLevel(ModifiedEnchantments.ANTIDOTE.get()) >= dote) {
                dote = slot3.getEnchantmentLevel(ModifiedEnchantments.ANTIDOTE.get());
            }
            if (slot4.getEnchantmentLevel(ModifiedEnchantments.ANTIDOTE.get()) >= dote) {
                dote = slot4.getEnchantmentLevel(ModifiedEnchantments.ANTIDOTE.get());
            }

            // credit to ochotonida. This limits the max duration of effects
            Map<MobEffect, MobEffectInstance> effects = new HashMap<>();
            int maxEffectDuration;
            if (dote != 0) {
                maxEffectDuration = 1200 / dote;
            } else {
                maxEffectDuration = 1200;
            }
            player.getActiveEffectsMap().forEach((effect, instance) -> {
                if ((!effect.isBeneficial() || effect.equals(ModdedTags.Effects.HURTFUL) || effect.getCategory() == MobEffectCategory.HARMFUL) && instance.getDuration() > maxEffectDuration) {
                    effects.put(effect, instance);
                }
            });

            effects.forEach((effect, instance) -> {
                player.removeEffectNoUpdate(effect);
                if (maxEffectDuration > 0) {
                    player.addEffect(new MobEffectInstance(effect, maxEffectDuration, instance.getAmplifier(), instance.isAmbient(), instance.isVisible(), instance.showIcon()));
                }
            });
        }
    }

    @SubscribeEvent
    public static void poisonBlock(LivingHurtEvent event) {
        LivingEntity victim = event.getEntity();
        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
        float amount = event.getAmount();
        ItemStack hand = victim.getUseItem();
        if ((hand.getEnchantmentLevel(ModifiedEnchantments.POISON_SHIELD.get()) >= 1) && victim.isBlocking() && amount == 0) {
            attacker.addEffect(new MobEffectInstance(MobEffects.POISON, 100 * hand.getEnchantmentLevel(ModifiedEnchantments.POISON_SHIELD.get())));
        }
    }

    //Soul Slowness is basically an inverse Soul Speed enchantment.
    private static final UUID SPEED_MODIFIER_SOUL_SLOW_UUID = UUID.fromString("0bd7899b-713e-42d4-982b-ad828e15e89d");

    @SubscribeEvent
    public static void soulSlow(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        AttributeModifier modifier = new AttributeModifier(SPEED_MODIFIER_SOUL_SLOW_UUID, "Soul speed slow", -(0.03F * (1.0F + 1.1F)), AttributeModifier.Operation.ADDITION);
        if (entity.getFeetBlockState().is(BlockTags.SOUL_SPEED_BLOCKS)) {
            if ((entity.getItemBySlot(EquipmentSlot.FEET).getEnchantmentLevel(ModifiedEnchantments.SOUL_SLOWNESS.get()) >= 1) && !Objects.requireNonNull(entity.getAttribute(Attributes.MOVEMENT_SPEED)).hasModifier(modifier)) {
                Objects.requireNonNull(entity.getAttribute(Attributes.MOVEMENT_SPEED)).addTransientModifier(modifier);
            }
        } else {
            Objects.requireNonNull(entity.getAttribute(Attributes.MOVEMENT_SPEED)).removeModifier(SPEED_MODIFIER_SOUL_SLOW_UUID);
        }
    }

    //Sculk Speed is a Soul Speed enchantment with different trigger blocks.
    private static final UUID SPEED_MODIFIER_SCULK_SPEED_UUID = UUID.fromString("043880de-dc61-41b5-bab6-346526c1138f");

    @SubscribeEvent
    public static void sculkSpeed(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        int i = (entity.getItemBySlot(EquipmentSlot.FEET).getEnchantmentLevel(ModifiedEnchantments.SCULK_SPEED.get()));
        AttributeModifier modifier = new AttributeModifier(SPEED_MODIFIER_SCULK_SPEED_UUID, "Sculk Speed", (0.03F * (1.0F + (float) i * 0.35F)), AttributeModifier.Operation.ADDITION);
        if (entity.getBlockStateOn().is(ModdedTags.Blocks.SCULK)) {
            if ((entity.getItemBySlot(EquipmentSlot.FEET).getEnchantmentLevel(ModifiedEnchantments.SCULK_SPEED.get()) >= 1) && !Objects.requireNonNull(entity.getAttribute(Attributes.MOVEMENT_SPEED)).hasModifier(modifier)) {
                Objects.requireNonNull(entity.getAttribute(Attributes.MOVEMENT_SPEED)).addTransientModifier(modifier);
            }
        } else {
            Objects.requireNonNull(entity.getAttribute(Attributes.MOVEMENT_SPEED)).removeModifier(SPEED_MODIFIER_SCULK_SPEED_UUID);
        }
    }

    @SubscribeEvent
    public static void siftSand(BlockEvent.BreakEvent event) {
        BlockState state = event.getState();
        BlockPos pos = event.getPos();
        Player entity = event.getPlayer();
        Level world = event.getPlayer().level();
        int neg = -42;
        int min = 1;
        int max = -((entity.getMainHandItem().getEnchantmentLevel(ModifiedEnchantments.SIFTING.get()) * 10) + neg);
        int i = (int)Math.floor(Math.random() * (max - min + 1) + min);
        //Loot dropped by the "Sifting" enchantment can be configured by adding to or changing the tags that this code reads.
        if (state.is(ModdedTags.Blocks.DESERT_TREASURE_POSSIBLE) && world.getBiome(pos).is(Tags.Biomes.IS_DESERT) || world.getBiome(pos).is(BiomeTags.HAS_DESERT_PYRAMID)) {
            if ((i == 1) && entity.getMainHandItem().getEnchantmentLevel(ModifiedEnchantments.SIFTING.get()) >= 1 && !entity.isCreative() && world.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
             world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
             ItemEntity treasure = new ItemEntity(world, pos.getCenter().x, pos.getCenter().y, pos.getCenter().z, new ItemStack((Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ModdedTags.Items.DESERT_TREASURE).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
             ItemEntity treasure2 = new ItemEntity(world, pos.getCenter().x, pos.getCenter().y, pos.getCenter().z, new ItemStack((Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ModdedTags.Items.DESERT_TREASURE).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
             ItemEntity treasure3 = new ItemEntity(world, pos.getCenter().x, pos.getCenter().y, pos.getCenter().z, new ItemStack((Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ModdedTags.Items.DESERT_TREASURE).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
             treasure.setPickUpDelay(10);
             world.addFreshEntity(treasure);
                int minF = 1;
                int maxF = (entity.getMainHandItem().getEnchantmentLevel(Enchantments.BLOCK_FORTUNE));
                int F = (int)Math.floor(Math.random() * (maxF - minF + 1) + minF);
                if (F == 1) {
                    world.addFreshEntity(treasure2);
                }
                if (F >= 2) {
                    world.addFreshEntity(treasure2);
                    world.addFreshEntity(treasure3);
                }
            }
        } else if (state.is(ModdedTags.Blocks.OCEAN_TREASURE_POSSIBLE) && world.getBiome(pos).is(BiomeTags.IS_OCEAN)) {
            if ((i == 1) && entity.getMainHandItem().getEnchantmentLevel(ModifiedEnchantments.SIFTING.get()) >= 1 && !entity.isCreative() && world.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
                world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                ItemEntity treasure = new ItemEntity(world, pos.getCenter().x, pos.getCenter().y, pos.getCenter().z, new ItemStack((Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ModdedTags.Items.OCEAN_TREASURE).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
                ItemEntity treasure2 = new ItemEntity(world, pos.getCenter().x, pos.getCenter().y, pos.getCenter().z, new ItemStack((Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ModdedTags.Items.OCEAN_TREASURE).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
                ItemEntity treasure3 = new ItemEntity(world, pos.getCenter().x, pos.getCenter().y, pos.getCenter().z, new ItemStack((Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ModdedTags.Items.OCEAN_TREASURE).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
                treasure.setPickUpDelay(10);
                world.addFreshEntity(treasure);
                int minF = 0;
                int maxF = (entity.getMainHandItem().getEnchantmentLevel(Enchantments.BLOCK_FORTUNE));
                int F = (int)Math.floor(Math.random() * (maxF - minF + 1) + minF);
                if (F == 1) {
                    world.addFreshEntity(treasure2);
                }
                if (F >= 2) {
                    world.addFreshEntity(treasure2);
                    world.addFreshEntity(treasure3);
                }
            }
        } else {
            if ((i == 1) && entity.getMainHandItem().getEnchantmentLevel(ModifiedEnchantments.SIFTING.get()) >= 1 && !entity.isCreative() && world.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
                world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                ItemEntity treasure = new ItemEntity(world, pos.getCenter().x, pos.getCenter().y, pos.getCenter().z, new ItemStack((Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ModdedTags.Items.RANDOM_TREASURE).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
                ItemEntity treasure2 = new ItemEntity(world, pos.getCenter().x, pos.getCenter().y, pos.getCenter().z, new ItemStack((Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ModdedTags.Items.RANDOM_TREASURE).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
                ItemEntity treasure3 = new ItemEntity(world, pos.getCenter().x, pos.getCenter().y, pos.getCenter().z, new ItemStack((Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ModdedTags.Items.RANDOM_TREASURE).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
                treasure.setPickUpDelay(10);
                world.addFreshEntity(treasure);
                int minF = 1;
                int maxF = (entity.getMainHandItem().getEnchantmentLevel(Enchantments.BLOCK_FORTUNE));
                int F = (int)Math.floor(Math.random() * (maxF - minF + 1) + minF);
                if (F == 1) {
                    world.addFreshEntity(treasure2);
                }
                if (F >= 2) {
                    world.addFreshEntity(treasure2);
                    world.addFreshEntity(treasure3);
                }
            }
        }
    }
    public static void webWalk(LivingEntity player) {
        BlockPos onCenter = player.blockPosition();
        BlockPos on = BlockPos.containing(player.blockPosition().getCenter());
        BlockPos above1 = on.above(1);
        BlockPos east = (BlockPos.containing(player.getX() + 0.35, player.getY(), player.getZ()));
        BlockPos west = (BlockPos.containing(player.getX() - 0.35, player.getY(), player.getZ()));
        BlockPos north = (BlockPos.containing(player.getX(), player.getY(), player.getZ() - 0.35));
        BlockPos south = (BlockPos.containing(player.getX(), player.getY(), player.getZ() + 0.35));
        Level world = player.level();
        BlockState state = world.getBlockState(on);
        BlockState web = Blocks.COBWEB.defaultBlockState();
        if ((player.getItemBySlot(EquipmentSlot.LEGS).getEnchantmentLevel(ModifiedEnchantments.ARACHNIDS_BLESSING.get()) >= 1) && (world.getBlockState(on).is(Blocks.COBWEB) || world.getBlockState(south).is(Blocks.COBWEB) || world.getBlockState(north).is(Blocks.COBWEB) || world.getBlockState(east).is(Blocks.COBWEB) || world.getBlockState(west).is(Blocks.COBWEB) || world.getBlockState(above1).is(Blocks.COBWEB))) {
            player.makeStuckInBlock(state, new Vec3(1.55D, (double) 2.5F, 1.55D));
        }
    }

    public static void witherdote(LivingEntity player, ItemStack slot1, ItemStack slot2, ItemStack slot3, ItemStack slot4) {
        if ((slot1.getEnchantmentLevel(ModifiedEnchantments.WITHER_PROTECTION.get()) >= 1) || (slot2.getEnchantmentLevel(ModifiedEnchantments.WITHER_PROTECTION.get()) >= 1) || (slot3.getEnchantmentLevel(ModifiedEnchantments.WITHER_PROTECTION.get()) >= 1) || (slot4.getEnchantmentLevel(ModifiedEnchantments.WITHER_PROTECTION.get()) >= 1)) {
            int dote = 0;
            if (slot1.getEnchantmentLevel(ModifiedEnchantments.WITHER_PROTECTION.get()) >= dote) {
                dote = slot1.getEnchantmentLevel(ModifiedEnchantments.WITHER_PROTECTION.get());
            }
            if (slot2.getEnchantmentLevel(ModifiedEnchantments.WITHER_PROTECTION.get()) >= dote) {
                dote = slot2.getEnchantmentLevel(ModifiedEnchantments.WITHER_PROTECTION.get());
            }
            if (slot3.getEnchantmentLevel(ModifiedEnchantments.WITHER_PROTECTION.get()) >= dote) {
                dote = slot3.getEnchantmentLevel(ModifiedEnchantments.WITHER_PROTECTION.get());
            }
            if (slot4.getEnchantmentLevel(ModifiedEnchantments.WITHER_PROTECTION.get()) >= dote) {
                dote = slot4.getEnchantmentLevel(ModifiedEnchantments.WITHER_PROTECTION.get());
            }

            // credit to ochotonida. This limits the max duration of effects
            Map<MobEffect, MobEffectInstance> effects = new HashMap<>();
            int maxEffectDuration;
            if (dote != 0) {
                maxEffectDuration = 400 / dote;
            } else {
                maxEffectDuration = 400;
            }
            player.getActiveEffectsMap().forEach((effect, instance) -> {
                if (effect.equals(MobEffects.WITHER) && instance.getDuration() > maxEffectDuration) {
                    effects.put(effect, instance);
                }
            });

            effects.forEach((effect, instance) -> {
                player.removeEffectNoUpdate(effect);
                if (maxEffectDuration > 0) {
                    player.addEffect(new MobEffectInstance(effect, maxEffectDuration, instance.getAmplifier(), instance.isAmbient(), instance.isVisible(), instance.showIcon()));
                }
            });
        }
    }
}

