package com.deflatedpickle.justbitethedust.items;

import com.deflatedpickle.justbitethedust.JustBiteTheDust;
import com.deflatedpickle.justbitethedust.Reference;
import com.deflatedpickle.justbitethedust.init.ModTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBase extends Item {
    public String base;
    public String original;
    public String type;
    public int colour;

    public ItemBase(String base, String original, String type){
        this.base = base;
        this.original = original;
        this.type = type;

        setUnlocalizedName(base.substring(original.length()).toLowerCase() + type.replaceAll(" ", ""));
        setRegistryName(Reference.MOD_ID + ":" + base.substring(original.length()) + "_" + type.toLowerCase().replaceAll(" ", "_"));

        if (type.equals("Nugget")) {
            setCreativeTab(ModTabs.tabNugget);
        }
        else if (type.equals("Dust")) {
            setCreativeTab(ModTabs.tabDust);
        }
        else if (type.equals("Dust Tiny")) {
            setCreativeTab(ModTabs.tabDustTiny);
        }
        else if (type.equals("Gear")) {
            setCreativeTab(ModTabs.tabGear);
        }
        else if (type.equals("Plate")) {
            setCreativeTab(ModTabs.tabPlate);
        }
        else if (type.equals("Broken Ore")) {
            setCreativeTab(ModTabs.tabBrokenOre);
        }
        else if (type.equals("Broken Nether Ore")) {
            setCreativeTab(ModTabs.tabBrokenNetherOre);
        }
        else if (type.equals("Broken End Ore")) {
            setCreativeTab(ModTabs.tabBrokenEndOre);
        }
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack){
        if (type.contains("Tiny")) {
            return "Tiny Pile of " + base.substring(original.length()) + " Ore";
        }

        String extra;
        if (!type.contains("Broken")) {
            return base.substring(original.length()) + " " + type;
        } else {
            extra = type.contains("Nether") ? "Nether " : type.contains("End") ? "End " : "";

            return "Broken " + base.substring(original.length()) + " " + extra + "Ore";
        }
    }
}
