package com.creep3rcrafter.creep3rcore.util.register;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class Register {

    public static void register(IEventBus eventBus, DeferredRegister deferredRegister) {
        deferredRegister.register(eventBus);
    }

    public static boolean always(BlockState blockState, IBlockReader blockReader, BlockPos blockPos, EntityType<?> entityType) {
        return (boolean) true;
    }
    public static boolean always(BlockState blockState, IBlockReader blockReader, BlockPos blockPos) {
        return (boolean) true;
    }
    public static boolean always() {
        return (boolean) true;
    }

    public static <T extends Block> RegistryObject<T> registerBlock(DeferredRegister ITEMS, DeferredRegister BLOCKS, String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(ITEMS, name, toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<T> registerBlock(DeferredRegister ITEMS, DeferredRegister BLOCKS, String name, Supplier<T> block, ItemGroup itemGroup) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(ITEMS, name, toReturn, itemGroup);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<T> registerBlockWithoutItem(DeferredRegister BLOCKS, String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(DeferredRegister ITEMS, String name, RegistryObject<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static <T extends Block> void registerBlockItem(DeferredRegister ITEMS, String name, RegistryObject<T> block, ItemGroup itemGroup) {
        ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(itemGroup)));
    }
}
