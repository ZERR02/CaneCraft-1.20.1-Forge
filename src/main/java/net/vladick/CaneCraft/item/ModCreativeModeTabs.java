package net.vladick.CaneCraft.item;


import com.mojang.brigadier.LiteralMessage;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.vladick.CaneCraft.CaneCraft;
import net.vladick.CaneCraft.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CaneCraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CANECRAFT_BLOCKS_TAB = CREATIVE_MODE_TABS.register("canecraft_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.STEM_BLOCK.get()))
                    .title(Component.translatable("creativetab.canecraft.canecraft_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.STEM_BLOCK.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> CANECRAFT_EQUIPS_TAB = CREATIVE_MODE_TABS.register("canecraft_equips_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CANE_SWORD.get()))
                    .withTabsBefore(CANECRAFT_BLOCKS_TAB.getId())
                    .title(Component.translatable("creativetab.canecraft.canecraft_equips_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CANE_HELMET.get());
                        output.accept(ModItems.CANE_CHESTPLATE.get());
                        output.accept(ModItems.CANE_LEGGINGS.get());
                        output.accept(ModItems.CANE_BOOTS.get());
                        output.accept(ModItems.CANE_SWORD.get());
                        output.accept(ModItems.CANE_PICKAXE.get());
                        output.accept(ModItems.CANE_AXE.get());
                        output.accept(ModItems.CANE_SHOVEL.get());
                        output.accept(ModItems.CANE_HOE.get());
                        //output.accept(ModItems.ROM.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> CANECRAFT_ITEMS_TAB = CREATIVE_MODE_TABS.register("canecraft_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEM.get()))
                    .withTabsBefore(CANECRAFT_BLOCKS_TAB.getId())
                    .title(Component.translatable("creativetab.canecraft.canecraft_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.STEM.get());
                        output.accept(ModItems.MORTAR_PESTLE.get());
                        output.accept(ModItems.BAGASSE.get());
                        output.accept(ModItems.STEM_STICK.get());
                        output.accept(ModItems.COBBLE_STICK.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> CANECRAFT_FOODS_TAB = CREATIVE_MODE_TABS.register("canecraft_foods_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CARAMEL.get()))
                    .withTabsBefore(CANECRAFT_BLOCKS_TAB.getId())
                    .title(Component.translatable("creativetab.canecraft.canecraft_foods_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CANE_JUICE.get());
                        output.accept(ModItems.CANE_SYRUP.get());
                        output.accept(ModItems.CARAMEL.get());
                        output.accept(ModItems.CAR_APPLE.get());
                        output.accept(ModItems.CAR_BERR.get());
                    }).build());








    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
