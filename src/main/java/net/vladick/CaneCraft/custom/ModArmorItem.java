package net.vladick.CaneCraft.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.vladick.CaneCraft.item.ModArmorMaterials;

import java.util.Map;

public class ModArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmorMaterials.CANE, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 0,
                            false, false, true)).build();

    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide) {
            if (hasFullSuitofArmorOn(player)) {
                evaluateArmorEffects(player);
            } else {
                // Если фулл-сета нет вообще, убираем эффекты от этого класса брони
                removeArmorEffects(player);
            }
        }
    }

    public void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            } else {
                // Если надет фулл-сет, но из ДРУГОГО материала, снимаем текущий эффект
                if (player.hasEffect(mapStatusEffect.getEffect())) {
                    player.removeEffect(mapStatusEffect.getEffect());
                }
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial, MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            // Клонируем эффект из карты, чтобы бесконечные -1 тики применились корректно
            player.addEffect(new MobEffectInstance(mapStatusEffect));
        }
    }

    private void removeArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            MobEffectInstance mapStatusEffect = entry.getValue();
            if (player.hasEffect(mapStatusEffect.getEffect())) {
                player.removeEffect(mapStatusEffect.getEffect());
            }
        }
    }

    public boolean hasFullSuitofArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial targetMaterial, Player player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ModArmorItem)) {
                return false;
            }
        }

        // Защита от Null: проверяем, что предметы в слотах действительно существуют
        ItemStack bootsStack = player.getInventory().getArmor(0);
        ItemStack leggingsStack = player.getInventory().getArmor(1);
        ItemStack chestplateStack = player.getInventory().getArmor(2);
        ItemStack helmetStack = player.getInventory().getArmor(3);

        if (bootsStack.isEmpty() || leggingsStack.isEmpty() || chestplateStack.isEmpty() || helmetStack.isEmpty()) {
            return false;
        }

        ArmorItem boots = ((ArmorItem) bootsStack.getItem());
        ArmorItem leggings = ((ArmorItem) leggingsStack.getItem());
        ArmorItem chestplate = ((ArmorItem) chestplateStack.getItem());
        ArmorItem helmet = ((ArmorItem) helmetStack.getItem());

        // Исправлено: теперь сверяется с переданным targetMaterial
        return helmet.getMaterial() == targetMaterial && chestplate.getMaterial() == targetMaterial &&
                leggings.getMaterial() == targetMaterial && boots.getMaterial() == targetMaterial;
    }
}
