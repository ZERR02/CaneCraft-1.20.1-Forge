package net.vladick.CaneCraft.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.vladick.CaneCraft.CaneCraft;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    CANE("cane", 7, new int[] {2, 3,2, 2}, 25, SoundEvents.ARMOR_EQUIP_LEATHER, 1f, 0f,
            () -> Ingredient.of(ModItems.BAGASSE.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final int[]  protectAmounts;
    private final int enchantmentAmounts;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = new int[] {11, 16, 16, 13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectAmounts, int enchantmentAmounts, SoundEvent equipSound,
                      float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectAmounts = protectAmounts;
        this.enchantmentAmounts = enchantmentAmounts;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentAmounts;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return CaneCraft.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
