package com.creep3rcrafter.creep3rcore;

import com.creep3rcrafter.creep3rcore.client.renderer.RisingBlockRenderer;
import com.creep3rcrafter.creep3rcore.register.ModEntities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Creep3rCore.MOD_ID)
public class Creep3rCore {
    public static final String MOD_ID = "creep3rcore";

    public Creep3rCore() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntities.register(eventBus);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.RISING_BLOCK.get(), RisingBlockRenderer::new);
    }
}
