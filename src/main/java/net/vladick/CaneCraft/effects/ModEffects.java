package net.vladick.CaneCraft.effects;

import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vladick.CaneCraft.CaneCraft;
import net.vladick.CaneCraft.custom.CustomEffect;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CaneCraft.MOD_ID);

    public static final RegistryObject<CustomEffect> SUGAR_OVERLOAD = MOB_EFFECTS.register("sugar_overload",
            () -> new CustomEffect(MobEffectCategory.HARMFUL,  0xFFAA00));


    public static void register(IEventBus bus) {
        MOB_EFFECTS.register(bus);
    }
}
