package com.deflatedpickle.justbitethedust.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModTabs {
    public static CreativeTabs tabNugget = new CreativeTabs("tab_justbitethedust_nugget") {
        @Override
        public ItemStack getTabIconItem() {
            return randomitem("nugget");
        }
    };

    public static CreativeTabs tabDust = new CreativeTabs("tab_justbitethedust_dust") {
        @Override
        public ItemStack getTabIconItem() {
            return randomitem("dust");
        }
    };

    public static CreativeTabs tabDustTiny = new CreativeTabs("tab_justbitethedust_dust_tiny") {
        @Override
        public ItemStack getTabIconItem() {
            return randomitem("dust_tiny");
        }
    };

    public static CreativeTabs tabGear = new CreativeTabs("tab_justbitethedust_gear") {
        @Override
        public ItemStack getTabIconItem() {
            return randomitem("gear");
        }
    };

    public static CreativeTabs tabPlate = new CreativeTabs("tab_justbitethedust_plate") {
        @Override
        public ItemStack getTabIconItem() {
            return randomitem("plate");
        }
    };

    public static CreativeTabs tabBrokenOre = new CreativeTabs("tab_justbitethedust_broken_ore") {
        @Override
        public ItemStack getTabIconItem() {
            return randomitem("broken_ore");
        }
    };

    public static CreativeTabs tabBrokenNetherOre = new CreativeTabs("tab_justbitethedust_broken_nether_ore") {
        @Override
        public ItemStack getTabIconItem() {
            return randomitem("broken_nether_ore");
        }
    };

    public static CreativeTabs tabBrokenEndOre = new CreativeTabs("tab_justbitethedust_broken_end_ore") {
        @Override
        public ItemStack getTabIconItem() {
            return randomitem("broken_end_ore");
        }
    };

    public static ItemStack randomitem(String search_for) {
        Random random = new Random();
        List<Item> list = new ArrayList<>();

        for (Item item : ForgeRegistries.ITEMS.getValues()) {
            if (item.getRegistryName().toString().contains("justbitethedust")) {
                if (item.getRegistryName().toString().split("justbitethedust")[1].contains(search_for)) {
                    if (search_for.equals("dust") && item.getRegistryName().toString().contains("tiny")) {
                        break;
                    } else {
                        list.add(item);
                    }
                }
            }
        }

        return new ItemStack(list.get(random.nextInt(list.size())));
    }
}
