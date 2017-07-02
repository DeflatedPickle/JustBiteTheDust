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
                            registerItem(ore, "ingot", "Dust Tiny");
                            registerItem(ore, "ingot", "Gear");
                            registerItem(ore, "ingot", "Plate");

                            registerItem(ore, "ingot", "Broken Ore");
                            registerItem(ore, "ingot", "Broken Nether Ore");
                            registerItem(ore, "ingot", "Broken End Ore");
                        }
                    }
                    else if (ore.startsWith("gem")) {
                        if (OreDictionary.getOres("gem" + ore).isEmpty()) {
                            registerItem(ore, "gem", "Nugget");
                            registerItem(ore, "gem", "Dust");
                            registerItem(ore, "gem", "Dust Tiny");
                            registerItem(ore, "gem", "Gear");
                            registerItem(ore, "gem", "Plate");

                            registerItem(ore, "gem", "Broken Ore");
                            registerItem(ore, "gem", "Broken Nether Ore");
                            registerItem(ore, "gem", "Broken End Ore");
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
        ModCrafting.add_recipe(item, base, type);
        OreDictionary.registerOre(type.substring(0, 1).toLowerCase() + StringUtils.capitalize(type.replaceAll(" ", "")).substring(1) + base.substring(original.length()).replaceAll(" ", ""), item);
    }
}
