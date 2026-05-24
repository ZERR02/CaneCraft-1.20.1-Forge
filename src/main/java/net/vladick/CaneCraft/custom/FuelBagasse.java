package net.vladick.CaneCraft.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class FuelBagasse extends Item {
    private int BurrTime = 0;

    public FuelBagasse(Properties properties, int burrTime) {
        super(properties);
        this.BurrTime = burrTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.BurrTime;
    }
}
