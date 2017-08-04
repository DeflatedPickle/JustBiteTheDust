package com.deflatedpickle.justbitethedust.items;

import com.deflatedpickle.justbitethedust.Reference;
import com.deflatedpickle.justbitethedust.init.ModCreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBase extends Item {
    public String base;
    private String original;
    public String type;
    public int colour;

    public ItemBase(String base, String original, String type){
        this.base = base;
        this.original = original;
        this.type = type;

        setUnlocalizedName(base.substring(original.length()).toLowerCase() + type.replaceAll(" ", ""));
        setRegistryName(Reference.MOD_ID + ":" + base.substring(original.length()) + "_" + type.toLowerCase().replaceAll(" ", "_"));

        // Vanilla
        if (type.equals("Nugget")) {
            setCreativeTab(ModCreativeTabs.tabNugget);
        }
        else if (type.equals("Dust")) {
            setCreativeTab(ModCreativeTabs.tabDust);
        }
        else if (type.equals("Rod")) {
            setCreativeTab(ModCreativeTabs.tabRod);
        }
        else if (type.equals("Fuel Tiny")) {
            setCreativeTab(ModCreativeTabs.tabFuelTiny);
        }

        // Industrial Craft
        else if (type.equals("Dust Tiny")) {
            setCreativeTab(ModCreativeTabs.tabDustTiny);
        }
        else if (type.equals("Ore Crushed")) {
            setCreativeTab(ModCreativeTabs.tabOreCrushed);
        }
        else if (type.equals("Ore Crushed Purified")) {
            setCreativeTab(ModCreativeTabs.tabOreCrushedPurified);
        }
        else if (type.equals("Casing Item")) {
            setCreativeTab(ModCreativeTabs.tabCasingItem);
        }
        else if (type.equals("Plate Dense")) {
            setCreativeTab(ModCreativeTabs.tabDensePlate);
        }

        // Mekanism
        else if (type.equals("Dust Dirty")) {
            setCreativeTab(ModCreativeTabs.tabDustDirty);
        }
        else if (type.equals("Shard")) {
            setCreativeTab(ModCreativeTabs.tabShard);
        }
        else if (type.equals("Clump")) {
            setCreativeTab(ModCreativeTabs.tabClump);
        }
        else if (type.equals("Crystal")) {
            setCreativeTab(ModCreativeTabs.tabCrystal);
        }

        // Esteemed-Innovation
        else if (type.equals("Ore Smashed")) {
            setCreativeTab(ModCreativeTabs.tabOreSmashed);
        }

        // Thermal Foundation
        else if (type.equals("Coin")) {
            setCreativeTab(ModCreativeTabs.tabCoin);
        }

        // ExNihilo
        else if (type.equals("Broken Ore")) {
            setCreativeTab(ModCreativeTabs.tabOreBroken);
        }
        else if (type.equals("Broken Nether Ore")) {
            setCreativeTab(ModCreativeTabs.tabOreBrokenNether);
        }
        else if (type.equals("Broken End Ore")) {
            setCreativeTab(ModCreativeTabs.tabOreBrokenEnd);
        }

        // Grouped
        else if (type.equals("Gear")) {
            setCreativeTab(ModCreativeTabs.tabGear);
        }
        else if (type.equals("Plate")) {
            setCreativeTab(ModCreativeTabs.tabPlate);
        }
/*        else {
            setCreativeTab(ModCreativeTabs.tabOther);
        }*/
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack){
        String extra;
        String name = base.substring(original.length());

        if (base.contains("Refined")){
            name = base.substring(5, 12) + " " + base.substring(12);
        }

        if (type.contains("Broken")){
            extra = type.contains("Nether") ? "Nether " : type.contains("End") ? "End " : "";
            return "Broken " + name + " " + extra + "Ore";
        }
        else if (type.contains("Tiny") && type.contains("Dust")) {
            return "Tiny Pile of " + name + " Dust";
        }
        else if (type.contains("Purified")) {
            return "Purified Crushed " + name + " Ore";
        }
        else if (type.contains("Crushed")) {
            return "Crushed " + name + " Ore";
        }
        else if (type.contains("Casing")){
            return name + " Item Casing";
        }
        else if (type.contains("Dense")){
            return "Dense " + name + " Plate";
        }
        else if (type.contains("Smashed")){
            return "Smashed " + name + " Ore";
        }
        else if (type.contains("Tiny") && type.contains("Fuel")){
            extra = base.contains("Coke") ? "Coal " : "";
            return "Tiny " + extra + name;
        }
        else {
            return name + " " + type;
        }
    }
}
