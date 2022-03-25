package com.creep3rcrafter.creep3rcore.util.data;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CCItemModelProvider extends ItemModelProvider {

    public CCItemModelProvider(DataGenerator generator, String modID, ExistingFileHelper existingFileHelper) {
        super(generator, modID, existingFileHelper);
    }

    @Override
    public void registerModels() {
        /*
        itembuilder("nether_carrot");
        */
    }

    public void itembuilder(String name) {
        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }

    public void itembuilder(Block block) {
        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        getBuilder(block.getRegistryName().toString()).parent(itemGenerated).texture("layer0", "item/" + block.getRegistryName().toString());
    }


}
