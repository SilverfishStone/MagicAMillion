package net.silverfishstone.magicamillion.enchantments.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class EndsCurse extends Enchantment {
    public EndsCurse(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        Level level = pTarget.level();
        //Copied from the chorus fruit teleport event. Why rewrite when a class already exists?
        if (!level.isClientSide) {
            double d0 = pTarget.getX();
            double d1 = pTarget.getY();
            double d2 = pTarget.getZ();

            for(int i = 0; i < 16; ++i) {
                double d3 = pTarget.getX() + (pTarget.getRandom().nextDouble() - 0.5D) * 16.0D;
                double d4 = Mth.clamp(pTarget.getY() + (double)(pTarget.getRandom().nextInt(16) - 8), (double)level.getMinBuildHeight(), (double)(level.getMinBuildHeight() + ((ServerLevel)level).getLogicalHeight() - 1));
                double d5 = pTarget.getZ() + (pTarget.getRandom().nextDouble() - 0.5D) * 16.0D;
                if (pTarget.isPassenger()) {
                    pTarget.stopRiding();
                }

                Vec3 vec3 = pTarget.position();
                level.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(pTarget));
                net.minecraftforge.event.entity.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(pTarget, d3, d4, d5);
                if (pTarget.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                    SoundEvent soundevent = pTarget instanceof Fox ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
                    level.playSound((Player)null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                    pTarget.playSound(soundevent, 1.0F, 1.0F);
                    break;
                }
            }
        }
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    public boolean isCurse() {
        return true;
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }
}
