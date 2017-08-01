package com.deflatedpickle.justbitethedust.init;

import com.deflatedpickle.justbitethedust.JustBiteTheDust;
import com.deflatedpickle.justbitethedust.items.ItemBase;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class ModItems {
    public static List<ItemBase> item_list = new ArrayList();

    public static void init(){
        for (String ore : OreDictionary.getOreNames()) {
            if (!OreDictionary.getOres(ore).isEmpty()) {
                if (!ore.contains("Brick") && !ore.contains("Base")) {
                    if (ore.startsWith("ingot")) {
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
                }
            }
        }
    }

    private static void registerItem(String base, String original, String type){
        ItemBase item = new ItemBase(base, original, type);

        GameRegistry.register(item);
        JustBiteTheDust.proxy.registerItemModel(item, type);
        item_list.add(item);

        String oredict = type.substring(0, 1).toLowerCase() + StringUtils.capitalize(type.replaceAll(" ", "")).substring(1) + base.substring(original.length()).replaceAll(" ", "");

        if (type.equals("Dust Tiny")){
            for (String ore : OreDictionary.getOreNames()) {
                if (ore.contains("dust") && ore.contains(base.substring(4)) && !ore.contains("Tiny")) {
                    ModCrafting.add_recipe(item, ore, type);
                }
            }
        } else if (type.equals("Rod")){
            OreDictionary.registerOre(oredict.replace("rod", "stick"), item);
        } else
            ModCrafting.add_recipe(item, base, type);

        if (type.toLowerCase().contains("crushed"))
            oredict = "c" + oredict.substring(4);

        OreDictionary.registerOre(oredict, item);
    }
}
