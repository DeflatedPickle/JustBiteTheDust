package com.deflatedpickle.justbitethedust;

import com.deflatedpickle.justbitethedust.init.ModCrafting;
import com.deflatedpickle.justbitethedust.init.ModItems;
import com.deflatedpickle.justbitethedust.init.ModCreativeTabs;
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

import java.util.Arrays;
import java.util.List;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, dependencies = "after:*")
public class JustBiteTheDust {
    @Instance
    public static JustBiteTheDust instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final Logger logger = LogManager.getLogger(Reference.NAME);

    public static boolean installed_industrialcraft = Loader.isModLoaded("ic2");
    public static boolean installed_thermalfoundation = Loader.isModLoaded("thermalfoundation");
    public static boolean installed_buildcraft = Loader.isModLoaded("buildcraft");
    public static boolean installed_railcraft = Loader.isModLoaded("railcraft");
    public static boolean installed_mekanism = Loader.isModLoaded("mekanism");
    public static boolean installed_esteemedinnovation = Loader.isModLoaded("esteemedinnovation");
    public static boolean installed_immersiveengineering = Loader.isModLoaded("immersiveengineering");

    private static boolean installed_exnihilo = Loader.isModLoaded("exnihilo");
    private static boolean installed_exnihiloadscensio = Loader.isModLoaded("exnihiloadscensio");

    private static List<Boolean> mods_gear = Arrays.asList(installed_thermalfoundation, installed_buildcraft, installed_railcraft, installed_immersiveengineering);
    private static List<Boolean> mods_plate = Arrays.asList(installed_industrialcraft, installed_thermalfoundation, installed_immersiveengineering);

    private static List<Boolean> mods_exnihilo = Arrays.asList(installed_exnihilo, installed_exnihiloadscensio);

    public static boolean is_mod_gear = mods_gear.contains(true);
    public static boolean is_mod_plate = mods_plate.contains(true);

    public static boolean is_mod_exnihilo = mods_exnihilo.contains(true);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Starting preInit.");

        ModCreativeTabs.init();
        ModItems.init();

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
