package net.vladick.CaneCraft.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.vladick.CaneCraft.effects.ModEffects;

public class CustomEffect  extends MobEffect {
    public CustomEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide()) {

            MobEffectInstance currentInstance = entity.getEffect(ModEffects.SUGAR_OVERLOAD.get());

            if(currentInstance != null) {
                int remainingTicks = currentInstance.getDuration();

                entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, remainingTicks, amplifier, false, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, remainingTicks, amplifier, false, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, remainingTicks, 0, false, false, false));
            }

        }
        super.applyEffectTick(entity, amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}
