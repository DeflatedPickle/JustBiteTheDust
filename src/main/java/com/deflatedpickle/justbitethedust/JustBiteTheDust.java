package com.deflatedpickle.justbitethedust;

import com.deflatedpickle.justbitethedust.init.ModCrafting;
import com.deflatedpickle.justbitethedust.init.ModItems;
import com.deflatedpickle.justbitethedust.init.ModTabs;
import com.deflatedpickle.justbitethedust.proxy.CommonProxy;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, dependencies = "after:*")
public class JustBiteTheDust {
    @Instance
    public static JustBiteTheDust instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final Logger logger = LogManager.getLogger(Reference.NAME);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Starting preInit.");

        ModItems.init();
        new ModTabs();

        logger.info("Finished preInit.");
    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {
        logger.info("Starting Init.");

        proxy.init();
        ModCrafting.register();

        logger.info("Finished Init.");
    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
        logger.info("Starting preInit.");

        logger.info("Finished Init.");
    }
}
