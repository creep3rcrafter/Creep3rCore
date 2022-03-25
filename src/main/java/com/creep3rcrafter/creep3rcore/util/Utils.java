package com.creep3rcrafter.creep3rcore.util;

import net.minecraft.block.Block;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.client.model.generators.ModelProvider;

public class Utils {
    public static void explode(World world, BlockPos blockPos) {
        explode(world, blockPos, 4f);
    }

    public static void explode(World world, BlockPos blockPos, float radius) {
        explode(world, blockPos, radius, false);
    }

    public static void explode(World world, BlockPos blockPos, float radius, boolean fire) {
        world.explode(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), radius, fire, Explosion.Mode.BREAK);
    }

    public static void dropXP(World world, BlockPos blockPos) {
        int i = 3 + world.random.nextInt(5) + world.random.nextInt(5);
        while (i > 0) {
            int j = ExperienceOrbEntity.getExperienceValue(i);
            i -= j;
            world.addFreshEntity(new ExperienceOrbEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), j));
        }
    }
    public static int cropAgeToIndex(int age) {
        if (age > 6) {
            return 3;
        } else if (age > 3) {
            return 2;
        } else if (age > 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public static String name(Item item) {
        return item.getRegistryName().getPath();
    }
    public static String name(Block block) {
        return block.getRegistryName().getPath();
    }

    public static ResourceLocation itemTexture(Item item) {
        ResourceLocation name = item.getRegistryName();
        return new ResourceLocation(name.getNamespace(), ModelProvider.ITEM_FOLDER + "/" + name.getPath());
    }
    public static ResourceLocation itemTexture(Block block) {
        ResourceLocation name = block.getRegistryName();
        return new ResourceLocation(name.getNamespace(), ModelProvider.ITEM_FOLDER + "/" + name.getPath());
    }
    public static ResourceLocation blockTexture(Item item) {
        ResourceLocation name = item.getRegistryName();
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath());
    }
    public static ResourceLocation blockTexture(Block block) {
        ResourceLocation name = block.getRegistryName();
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath());
    }
}
