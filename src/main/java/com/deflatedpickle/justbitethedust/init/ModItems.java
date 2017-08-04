package com.deflatedpickle.justbitethedust.init;

import com.deflatedpickle.justbitethedust.JustBiteTheDust;
import com.deflatedpickle.justbitethedust.handlers.FuelHandler;
import com.deflatedpickle.justbitethedust.items.ItemBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

public class ModItems {
    public static List<ItemBase> item_list = new ArrayList<>();
    private static Integer ingots = 0;
    private static Integer gems = 0;
    private static Integer fuels = 0;

    private static Map<String, Integer> registeredItems = new HashMap<>();

    public static void init(){
        JustBiteTheDust.logger.info("Started Searching Items.");
        for (String ore : OreDictionary.getOreNames()) {
            if (!OreDictionary.getOres(ore).isEmpty()) {
                if (!ore.contains("Brick") && !ore.contains("Base")) {
                    if (ore.startsWith("ingot")) {
                        ingots ++;
                        if (OreDictionary.getOres("nugget" + ore).isEmpty()) {
                            registerItem(ore, "ingot", "Nugget");
                            registerItem(ore, "ingot", "Dust");
                            registerItem(ore, "ingot", "Rod");

                            if (JustBiteTheDust.installed_industrialcraft) {
                                registerItem(ore, "ingot", "Dust Tiny");
                                registerItem(ore, "ingot", "Ore Crushed");
                                registerItem(ore, "ingot", "Ore Crushed Purified");
                                registerItem(ore, "ingot", "Casing Item");
                                registerItem(ore, "ingot", "Plate Dense");
                            }

                            if (JustBiteTheDust.installed_thermalfoundation){
                                registerItem(ore, "ingot", "Coin");
                            }

                            if (JustBiteTheDust.installed_mekanism){
                                registerItem(ore, "ingot", "Dust Dirty");
                                registerItem(ore, "ingot", "Shard");
                                registerItem(ore, "ingot", "Clump");
                                registerItem(ore, "ingot", "Crystal");
                            }

                            if (JustBiteTheDust.installed_esteemedinnovation){
                                registerItem(ore, "ingot", "Ore Smashed");
                            }

                            if (JustBiteTheDust.is_mod_exnihilo) {
                                registerItem(ore, "ingot", "Ore Broken");
                                registerItem(ore, "ingot", "Ore Broken Nether");
                                registerItem(ore, "ingot", "Ore Broken End");
                            }

                            if (JustBiteTheDust.is_mod_gear)
                                registerItem(ore, "ingot", "Gear");

                            if (JustBiteTheDust.is_mod_plate)
                                registerItem(ore, "ingot", "Plate");
                        }
                    }
                    else if (ore.startsWith("gem")) {
                        gems ++;
                        if (OreDictionary.getOres("gem" + ore).isEmpty()) {
                            registerItem(ore, "gem", "Nugget");
                            registerItem(ore, "gem", "Dust");
                            registerItem(ore, "gem", "Rod");

                            if (JustBiteTheDust.installed_industrialcraft) {
                                registerItem(ore, "gem", "Dust Tiny");
                                registerItem(ore, "gem", "Ore Crushed");
                                registerItem(ore, "gem", "Ore Crushed Purified");
                                registerItem(ore, "gem", "Casing Item");
                                registerItem(ore, "gem", "Plate Dense");
                            }

                            if (JustBiteTheDust.installed_thermalfoundation){
                                registerItem(ore, "gem", "Coin");
                            }

                            if (JustBiteTheDust.installed_mekanism){
                                registerItem(ore, "gem", "Dust Dirty");
                                registerItem(ore, "gem", "Shard");
                                registerItem(ore, "gem", "Clump");
                                registerItem(ore, "gem", "Crystal");
                            }

                            if (JustBiteTheDust.installed_esteemedinnovation){
                                registerItem(ore, "gem", "Ore Smashed");
                            }

                            if (JustBiteTheDust.is_mod_exnihilo) {
                                registerItem(ore, "gem", "Ore Broken");
                                registerItem(ore, "gem", "Ore Broken Nether");
                                registerItem(ore, "gem", "Ore Broken End");
                            }

                            if (JustBiteTheDust.is_mod_gear)
                                registerItem(ore, "gem", "Gear");

                            if (JustBiteTheDust.is_mod_plate)
                                registerItem(ore, "gem", "Plate");
                        }
                    }
                    if (ore.startsWith("fuel")){
                        fuels ++;
                        if (OreDictionary.getOres("fuel" + ore).isEmpty()){
                            registerItem(ore, "fuel", "Fuel Tiny");
                        }
                    }
                }
            }
        }
        JustBiteTheDust.logger.info("Finished Searching Items.");
        JustBiteTheDust.logger.info(String.format("Searched; %d Ingots, %d Gems and %d Fuels | %d in total.", ingots, gems, fuels, ingots + gems + fuels));
        JustBiteTheDust.logger.info(String.format("Generated; %s | %d in total.", registeredItems.toString(), item_list.size()));
    }

    private static void registerItem(String base, String original, String type){
        ItemBase item = new ItemBase(base, original, type);
        // System.out.println(base + " | " + original + " | " + type);

        GameRegistry.register(item);
        JustBiteTheDust.proxy.registerItemModel(item, type);
        item_list.add(item);

        String oredict = type.substring(0, 1).toLowerCase() + StringUtils.capitalize(type.replaceAll(" ", "")).substring(1) + base.substring(original.length()).replaceAll(" ", "");

        // Crafting Recipes
        if (type.equals("Dust Tiny")){
            for (String ore : OreDictionary.getOreNames()) {
                if (ore.contains("dust") && ore.contains(base.substring(4)) && !ore.contains("Tiny")) {
                    ModCrafting.add_recipe(item, ore, type);
                }
            }
        }
        else {
            ModCrafting.add_recipe(item, base, type);
        }

        // Extra OreDictionary Names
        if (type.equals("Rod")){
            OreDictionary.registerOre(oredict.replace("rod", "stick"), item);
        }

        // Different OreDictionary Names
        if (type.toLowerCase().contains("crushed")) {
            oredict = "c" + oredict.substring(4);
        }

        // Register Fuel
        if (type.contains("Fuel")){
            Integer burn_time = TileEntityFurnace.getItemBurnTime(OreDictionary.getOres(base).get(0)) / 8;
            // burn_time = TileEntityFurnace.getItemBurnTime(new ItemStack(Items.COAL));
            // System.out.println("Adding Fuel: " + "Tiny " + base + " | With Burn Time: " + burn_time / 8);
            if (base.contains("Coke")){
                burn_time = TileEntityFurnace.getItemBurnTime(new ItemStack(Items.COAL)) * 2 / 8;
            }
            FuelHandler.fuelList.add(Pair.of(item, burn_time));
        }

        OreDictionary.registerOre(oredict, item);

        if (!registeredItems.containsKey(type)){
            registeredItems.put(type, 1);
        }
        else {
            registeredItems.put(type, registeredItems.get(type) + 1);
        }
    }
}
