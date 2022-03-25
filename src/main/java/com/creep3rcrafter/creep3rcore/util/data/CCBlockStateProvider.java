package com.creep3rcrafter.creep3rcore.util.data;

import com.creep3rcrafter.creep3rcore.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CCBlockStateProvider extends BlockStateProvider {

    public CCBlockStateProvider(DataGenerator gen, String modID, ExistingFileHelper exFileHelper) {
        super(gen, modID, exFileHelper);
    }

    @Override
    public void registerStatesAndModels() {
        /*
        cropBuilder(ModBlocks.NETHER_CARROTS.get());
        caneBuilder(ModBlocks.SULFUR_CANE_BLOCK.get());
        farmlandBuilder(ModBlocks.NYLIUM_FARMLAND.get());
        blockAndItemBuilder(ModBlocks.LIVE_SOUL_SAND.get());
        */
    }

    public ResourceLocation itemTexture(Block block) {
        ResourceLocation name = block.getRegistryName();
        return new ResourceLocation(name.getNamespace(), ModelProvider.ITEM_FOLDER + "/" + name.getPath());
    }

    public ResourceLocation blockTexture(Block block) {
        ResourceLocation name = block.getRegistryName();
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath());
    }

    public void blockItemBuilder(Block block) {
        itemModels().withExistingParent(Utils.name(block), blockTexture(block));
    }

    public void blockAndItemBuilder(Block block) {
        simpleBlock(block);
        itemModels().withExistingParent(Utils.name(block), blockTexture(block));
    }

    public void farmlandBuilder(String name, Block block) {
        ModelFile farmlandTemplate = models().getExistingFile(mcLoc("block/template_farmland"));
        getVariantBuilder(block).forAllStates(state -> {
            return ConfiguredModel.builder().modelFile(models().getBuilder(name).parent(farmlandTemplate)
                            .texture("dirt", modLoc("block/" + name + "_other"))
                            .texture("top", modLoc("block/" + name + "_top")))
                    .build();
        });
        blockItemBuilder(block);
    }

    public void farmlandBuilder(Block block) {
        ModelFile farmlandTemplate = models().getExistingFile(mcLoc("block/template_farmland"));
        getVariantBuilder(block).forAllStates(state -> {
            return ConfiguredModel.builder().modelFile(models().getBuilder(Utils.name(block)).parent(farmlandTemplate)
                            .texture("dirt", modLoc("block/" + Utils.name(block) + "_other"))
                            .texture("top", modLoc("block/" + Utils.name(block) + "_top")))
                    .build();
        });
        blockItemBuilder(block);
    }

    public void cropBuilder(String name, Block block) {
        CropsBlock cropsBlock = (CropsBlock) block;
        getVariantBuilder(block).forAllStates(state -> {
            int i = Utils.cropAgeToIndex(state.getValue(cropsBlock.AGE));
            return ConfiguredModel.builder()
                    .modelFile(models().crop(name + i, modLoc("block/" + name + i)))
                    .build();
        });
    }

    public void cropBuilder(Block block) {
        CropsBlock cropsBlock = (CropsBlock) block;
        getVariantBuilder(block).forAllStates(state -> {
            int i = Utils.cropAgeToIndex(state.getValue(cropsBlock.AGE));
            return ConfiguredModel.builder()
                    .modelFile(models().crop(Utils.name(block) + i, modLoc("block/" + Utils.name(block) + i)))
                    .build();
        });
    }

    public void caneBuilder(String name, Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            return ConfiguredModel.builder()
                    .modelFile(models().cross(name, modLoc("block/" + name)))
                    .build();
        });
    }

    public void caneBuilder(Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            return ConfiguredModel.builder()
                    .modelFile(models().cross(Utils.name(block), modLoc("block/" + Utils.name(block))))
                    .build();
        });
    }
}
