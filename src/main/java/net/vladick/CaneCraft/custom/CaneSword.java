package net.vladick.CaneCraft.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;

public class CaneSword extends SwordItem {
    public CaneSword(Tiers tier, int Damage, float Attackspeed, Item.Properties properties) {
        super(tier, Damage, Attackspeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {

        target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 1), attacker);
        attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 2), attacker);

        return super.hurtEnemy(itemStack, target, attacker);
    }
}
