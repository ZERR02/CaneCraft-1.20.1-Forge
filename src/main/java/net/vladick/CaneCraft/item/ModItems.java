package net.vladick.CaneCraft.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vladick.CaneCraft.CaneCraft;
import net.vladick.CaneCraft.custom.*;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CaneCraft.MOD_ID);

    public static final RegistryObject<Item> BAGASSE = ITEMS.register("bagasse",
            () -> new FuelBagasse(new Item.Properties().stacksTo(64), 400));

    public static final RegistryObject<Item> STEM= ITEMS.register("stem",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> STEM_STICK = ITEMS.register("stem_stick",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> COBBLE_STICK = ITEMS.register("cobble_stick",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> CANE_JUICE = ITEMS.register("cane_juice",
            () -> new HoneyBottleItem(new Item.Properties().stacksTo(1).food(ModFoodProperties.PUPUPU)));
    public static final RegistryObject<Item> CANE_SYRUP = ITEMS.register("cane_syrup",
            () -> new HoneyBottleItem(new Item.Properties().stacksTo(1).food(ModFoodProperties.SYRUP)));

    public static final RegistryObject<Item> CARAMEL = ITEMS.register("caramel",
            () -> new Item(new Item.Properties().stacksTo(64).food(ModFoodProperties.CARAMEL)));

    public static final RegistryObject<Item> CAR_APPLE = ITEMS.register("car_apple",
            () -> new Item(new Item.Properties().stacksTo(64).food(ModFoodProperties.CAR_APPLE)));

    public static final RegistryObject<Item> CAR_BERR = ITEMS.register("car_berr",
            () -> new Item(new Item.Properties().stacksTo(64).food(ModFoodProperties.CAR_BERR)));

    public static final RegistryObject<Item> MORTAR_PESTLE = ITEMS.register("mortar_pestle",
            () -> new Item(new Item.Properties().stacksTo(1).durability(15)) {

                @Override
                public boolean hasCraftingRemainingItem() {
                    return true;
                }

                @Override
                public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
                    ItemStack damagedStack = itemStack.copy();


                    damagedStack.setDamageValue(damagedStack.getDamageValue() + 1);


                    if (damagedStack.getDamageValue() >= damagedStack.getMaxDamage()) {
                        return ItemStack.EMPTY;
                    }

                    return damagedStack;
                }
            }
    );

    public static final RegistryObject<Item> CANE_SWORD = ITEMS.register("cane_sword",
            () -> new CaneSword(Tiers.STONE,3, -2, new Item.Properties()));

    public static final RegistryObject<Item> CANE_AXE = ITEMS.register("cane_axe",
            () -> new CaneAxe(Tiers.STONE,5, -3.0f, new Item.Properties()));

    public static final RegistryObject<Item> CANE_SHOVEL = ITEMS.register("cane_shovel",
            () -> new CaneShovel(Tiers.STONE,2, -2f, new Item.Properties()));


    public static final RegistryObject<Item> CANE_PICKAXE = ITEMS.register("cane_pickaxe",
            () -> new CanePickaxe(Tiers.STONE,2, -2f, new Item.Properties()));


    public static final RegistryObject<Item> CANE_HOE = ITEMS.register("cane_hoe",
            () -> new CaneHoe(Tiers.STONE,2, -2f, new Item.Properties()));

    public static final RegistryObject<Item> CANE_CHESTPLATE = ITEMS.register("cane_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.CANE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> CANE_LEGGINGS = ITEMS.register("cane_leggings",
            () -> new ModArmorItem(ModArmorMaterials.CANE, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> CANE_HELMET = ITEMS.register("cane_helmet",
            () -> new ModArmorItem(ModArmorMaterials.CANE, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> CANE_BOOTS = ITEMS.register("cane_boots",
            () -> new ModArmorItem(ModArmorMaterials.CANE, ArmorItem.Type.BOOTS, new Item.Properties()));

    /*public static final RegistryObject<Item> ROM = ITEMS.register("rom",
            () -> new Item(new Item.Properties().stacksTo(64))); */


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
