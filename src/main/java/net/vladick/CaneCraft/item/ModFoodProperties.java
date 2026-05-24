package net.vladick.CaneCraft.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.vladick.CaneCraft.effects.ModEffects;

public class ModFoodProperties {

    public static final FoodProperties PUPUPU = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.25f)

            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 0), 0.35f)

            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 200, 0), 0.60f)
            .fast()
            .alwaysEat()
            .build();


    public static final FoodProperties SYRUP = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(6.0f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 200, 0), 1f)
            .effect(() -> new MobEffectInstance(ModEffects.SUGAR_OVERLOAD.get(), 200, 0), 1f)
            .alwaysEat()
            .build();


    public static final FoodProperties CARAMEL = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(2.0f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 10, 0), 1f)
            .effect(() -> new MobEffectInstance(ModEffects.SUGAR_OVERLOAD.get(), 40, 0), 1f)
            .build();

    public static final FoodProperties CAR_APPLE = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(4.0f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 150, 2), 1f)
            .build();

    // поменять
    public static final FoodProperties CAR_BERR = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(7.0f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 150, 2), 1f)
            .build();
}
