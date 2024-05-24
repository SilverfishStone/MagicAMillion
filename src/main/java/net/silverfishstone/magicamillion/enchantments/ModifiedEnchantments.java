package net.silverfishstone.magicamillion.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.magicamillion.MagicAMillion;
import net.silverfishstone.magicamillion.enchantments.custom.*;

public class ModifiedEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MagicAMillion.MODID);

    public static RegistryObject<Enchantment> CLOAKING =
            ENCHANTMENTS.register("cloaking",
                    () -> new CloakingEnchantment(Enchantment.Rarity.COMMON,
                            EnchantmentCategory.ARMOR));

    public static RegistryObject<Enchantment> SHULKIFY =
            ENCHANTMENTS.register("shulkify",
                    () -> new ShulkifyEnchantment(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.WEAPON));

    public static RegistryObject<Enchantment> BLASTING =
            ENCHANTMENTS.register("blasting",
                    () -> new BlastingEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.ARMOR));

    public static RegistryObject<Enchantment> WEIGHTY =
            ENCHANTMENTS.register("weighty",
                    () -> new WeightyCurse(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.ARMOR));

    public static RegistryObject<Enchantment> BACKFIRE =
            ENCHANTMENTS.register("backfire",
                    () -> new BackfireCurse(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.WEAPON));

    public static RegistryObject<Enchantment> DEVIL_FRUIT =
            ENCHANTMENTS.register("devil_fruit",
                    () -> new DevilFruitCurse(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.ARMOR_HEAD));

    public static RegistryObject<Enchantment> LIGHT_FLIGHT =
            ENCHANTMENTS.register("light_flight",
                    () -> new ElytraEnchantment(Enchantment.Rarity.COMMON,
                            EnchantmentCategory.WEARABLE));

    public static RegistryObject<Enchantment> FLAMEPROOF =
            ENCHANTMENTS.register("flameproof",
                    () -> new ElytraEnchantment(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.WEARABLE));

    public static RegistryObject<Enchantment> VOLATILE =
            ENCHANTMENTS.register("volatile",
                    () -> new VolatileEnchantment(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.CROSSBOW));

    public static RegistryObject<Enchantment> ENDS_CURSE =
            ENCHANTMENTS.register("ends_curse",
                    () -> new EndsCurse(Enchantment.Rarity.RARE,
                            EnchantmentCategory.ARMOR));

    public static RegistryObject<Enchantment> FARMERS_CURSE =
            ENCHANTMENTS.register("farmers_curse",
                    () -> new FarmersCurse(Enchantment.Rarity.COMMON,
                            EnchantmentCategory.ARMOR));

    public static RegistryObject<Enchantment> SOUL_SLOWNESS =
            ENCHANTMENTS.register("soul_slowness",
                    () -> new SoulSlowness(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.ARMOR_FEET));

    public static RegistryObject<Enchantment> SCULK_SPEED =
            ENCHANTMENTS.register("sculk_speed",
                    () -> new SculkSpeedEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.ARMOR_FEET));

    public static RegistryObject<Enchantment> WHIRLPOOL =
            ENCHANTMENTS.register("whirlpool",
                    () -> new WhirlpoolEnchantment(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.TRIDENT));

    public static RegistryObject<Enchantment> DAVY_JONES =
            ENCHANTMENTS.register("davy_jones",
                    () -> new DavyJonesEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.TRIDENT));

    public static RegistryObject<Enchantment> SHIELD_BASH =
            ENCHANTMENTS.register("shield_bash",
                    () -> new ShieldBashEnchantment(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.BREAKABLE));

    public static RegistryObject<Enchantment> WAVE_STRUCK =
            ENCHANTMENTS.register("wave_struck",
                    () -> new WaveStruckEnchantment(Enchantment.Rarity.COMMON,
                            EnchantmentCategory.TRIDENT));

    public static RegistryObject<Enchantment> WATERLOGGED =
            ENCHANTMENTS.register("waterlogged",
                    () -> new WaveStruckEnchantment(Enchantment.Rarity.COMMON,
                            EnchantmentCategory.WEAPON));

    public static RegistryObject<Enchantment> ANTIDOTE =
            ENCHANTMENTS.register("antidote",
                    () -> new AntidoteEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.ARMOR));

    public static RegistryObject<Enchantment> ICED =
            ENCHANTMENTS.register("iced",
                    () -> new IcedEnchantment(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.CROSSBOW));

    public static RegistryObject<Enchantment> CORROSION =
            ENCHANTMENTS.register("corrosion",
                    () -> new CorrosionEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.CROSSBOW));

    public static RegistryObject<Enchantment> ERODING =
            ENCHANTMENTS.register("eroding",
                    () -> new CorrosionEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.WEAPON));

    public static RegistryObject<Enchantment> POISON_GUARD =
            ENCHANTMENTS.register("poison_guard",
                    () -> new PoisonShieldEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.ARMOR));

    public static RegistryObject<Enchantment> POISON_SHIELD =
            ENCHANTMENTS.register("poison_shield",
                    () -> new ShieldEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.BREAKABLE));

    public static RegistryObject<Enchantment> SIFTING =
            ENCHANTMENTS.register("sifting",
                    () -> new SiftingEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.DIGGER));

    public static RegistryObject<Enchantment> SWOOP =
            ENCHANTMENTS.register("swoop",
                    () -> new SwoopEnchantment(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.WEARABLE));

    public static RegistryObject<Enchantment> ARACHNIDS_BLESSING =
            ENCHANTMENTS.register("arachnids_blessing",
                    () -> new ArachnidBlessingEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.ARMOR_LEGS));

    public static RegistryObject<Enchantment> BANDIT =
            ENCHANTMENTS.register("bandit",
                    () -> new StealingEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.BREAKABLE, 1));

    public static RegistryObject<Enchantment> DISROBE =
            ENCHANTMENTS.register("disrobe",
                    () -> new StealingEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.BREAKABLE, 2));

    public static RegistryObject<Enchantment> WITHER_PROTECTION =
            ENCHANTMENTS.register("wither_protection",
                    () -> new CustomProtectionEnchantment(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.ARMOR, 1));

    public static RegistryObject<Enchantment> UNDEATH_PROTECTION =
            ENCHANTMENTS.register("undeath_protection",
                    () -> new CustomProtectionEnchantment(Enchantment.Rarity.COMMON,
                            EnchantmentCategory.ARMOR, 2));

    public static RegistryObject<Enchantment> AQUA_PROTECTION =
            ENCHANTMENTS.register("aqua_protection",
                    () -> new CustomProtectionEnchantment(Enchantment.Rarity.COMMON,
                            EnchantmentCategory.ARMOR, 3));

    public static RegistryObject<Enchantment> THEFT_GUARD =
            ENCHANTMENTS.register("theft_guard",
                    () -> new CustomProtectionEnchantment(Enchantment.Rarity.COMMON,
                            EnchantmentCategory.ARMOR, 4));




    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}


