package com.deflatedpickle.justbitethedust.items;

import com.deflatedpickle.justbitethedust.Reference;
import com.deflatedpickle.justbitethedust.init.ModCreativeTabs;
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
            setCreativeTab(ModCreativeTabs.tabNugget);
        }
        else if (type.equals("Dust")) {
            setCreativeTab(ModCreativeTabs.tabDust);
        }
        else if (type.equals("Rod")) {
            setCreativeTab(ModCreativeTabs.tabRod);
        }
        else if (type.equals("Dust Tiny")) {
            setCreativeTab(ModCreativeTabs.tabDustTiny);
        }
        else if (type.equals("Crushed Ore")) {
            setCreativeTab(ModCreativeTabs.tabCrushedOre);
        }
        else if (type.equals("Crushed Ore Purified")) {
            setCreativeTab(ModCreativeTabs.tabPurifiedOre);
        }
        else if (type.equals("Coin")) {
            setCreativeTab(ModCreativeTabs.tabCoin);
        }
        else if (type.equals("Gear")) {
            setCreativeTab(ModCreativeTabs.tabGear);
        }
        else if (type.equals("Plate")) {
            setCreativeTab(ModCreativeTabs.tabPlate);
        }

        else if (type.equals("Broken Ore")) {
            setCreativeTab(ModCreativeTabs.tabBrokenOre);
        }
        else if (type.equals("Broken Nether Ore")) {
            setCreativeTab(ModCreativeTabs.tabBrokenNetherOre);
        }
        else if (type.equals("Broken End Ore")) {
            setCreativeTab(ModCreativeTabs.tabBrokenEndOre);
        }
/*        else {
            setCreativeTab(ModCreativeTabs.tabOther);
        }*/
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack){
        String extra;
        if (type.contains("Broken")){
            extra = type.contains("Nether") ? "Nether " : type.contains("End") ? "End " : "";

            return "Broken " + base.substring(original.length()) + " " + extra + "Ore";
        }
        else if (type.contains("Tiny")) {
            return "Tiny Pile of " + base.substring(original.length()) + " Dust";
        }
        else if (type.contains("Purified")) {
            return "Purified Crushed " + base.substring(original.length()) + " Ore";
        }
        else if (type.contains("Crushed")) {
            return "Crushed " + base.substring(original.length()) + " Ore";
        }
        else {
            return base.substring(original.length()) + " " + type;
        }
    }
}
