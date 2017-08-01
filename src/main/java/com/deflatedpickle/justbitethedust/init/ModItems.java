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
                                registerItem(ore, "ingot", "Crushed Ore");
                                registerItem(ore, "ingot", "Crushed Ore Purified");
                            }

                            if (JustBiteTheDust.installed_thermalfoundation){
                                registerItem(ore, "ingot", "Coin");
                            }

                            if (JustBiteTheDust.is_mod_exnihilo) {
                                registerItem(ore, "ingot", "Broken Ore");
                                registerItem(ore, "ingot", "Broken Nether Ore");
                                registerItem(ore, "ingot", "Broken End Ore");
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
                                registerItem(ore, "gem", "Crushed Ore");
                                registerItem(ore, "gem", "Crushed Ore Purified");
                            }

                            if (JustBiteTheDust.installed_thermalfoundation){
                                registerItem(ore, "gem", "Coin");
                            }

                            if (JustBiteTheDust.is_mod_exnihilo) {
                                registerItem(ore, "gem", "Broken Ore");
                                registerItem(ore, "gem", "Broken Nether Ore");
                                registerItem(ore, "gem", "Broken End Ore");
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

    public static void registerItem(String base, String original, String type){
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

        if (type.contains("Crushed"))
            oredict = oredict.replace("Ore", "");

        OreDictionary.registerOre(oredict, item);
    }
}
