package com.deflatedpickle.justbitethedust.init;

import com.deflatedpickle.justbitethedust.JustBiteTheDust;
import com.deflatedpickle.justbitethedust.tabs.TabBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModCreativeTabs {
    public static TabBase tabNugget;
    public static TabBase tabDust;
    public static TabBase tabDustTiny;
    public static TabBase tabGear;
    public static TabBase tabPlate;

    public static TabBase tabBrokenOre;
    public static TabBase tabBrokenNetherOre;
    public static TabBase tabBrokenEndOre;

    // public static TabBase tabOther;

    public static void init(){
        tabNugget = new TabBase("nugget");
        tabDust = new TabBase("dust");

        if (JustBiteTheDust.installed_industrialcraft)
            tabDustTiny = new TabBase("dust_tiny");

        if (JustBiteTheDust.is_mod_gear)
            tabGear = new TabBase("gear");

        if (JustBiteTheDust.is_mod_plate)
            tabPlate = new TabBase("plate");

        if (JustBiteTheDust.is_mod_exnihilo) {
            tabBrokenOre = new TabBase("broken_ore");
            tabBrokenNetherOre = new TabBase("broken_nether_ore");
            tabBrokenEndOre = new TabBase("broken_end_ore");
        }

        // tabOther = new TabBase("other");
    }

    public static ItemStack random_item(String search_for) {
        Random random = new Random();
        List<Item> list = new ArrayList<>();

        for (Item item : ForgeRegistries.ITEMS.getValues()) {
            if (item.getRegistryName().toString().contains("justbitethedust")) {
                if (!search_for.equals("other")){
                    if (item.getRegistryName().toString().split("justbitethedust")[1].contains(search_for)) {
                        if (search_for.equals("dust") && item.getRegistryName().toString().contains("tiny")) {
                            break;
                        } else {
                            list.add(item);
                        }
                    }
                }
                else{
                    list.add(item);
                }
            }
        }

        return new ItemStack(list.get(random.nextInt(list.size())));
    }
}
