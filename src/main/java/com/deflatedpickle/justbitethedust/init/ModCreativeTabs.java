package com.deflatedpickle.justbitethedust.init;

import com.deflatedpickle.justbitethedust.JustBiteTheDust;
import com.deflatedpickle.justbitethedust.tabs.TabBase;

public class ModCreativeTabs {
    // Vanilla
    public static TabBase tabNugget;
    public static TabBase tabDust;
    public static TabBase tabRod;

    // IndustrialCraft
    public static TabBase tabDustTiny;
    public static TabBase tabOreCrushed;
    public static TabBase tabOreCrushedPurified;
    public static TabBase tabCasingItem;
    public static TabBase tabDensePlate;

    // Thermal Foundation
    public static TabBase tabCoin;

    // Mekanism
    public static TabBase tabDustDirty;
    public static TabBase tabShard;
    public static TabBase tabClump;
    public static TabBase tabCrystal;

    // Esteemed-Innovation
    public static TabBase tabOreSmashed;

    // ExNihilo
    public static TabBase tabOreBroken;
    public static TabBase tabOreBrokenNether;
    public static TabBase tabOreBrokenEnd;

    // Grouped
    public static TabBase tabGear;
    public static TabBase tabPlate;

    // public static TabBase tabOther;

    public static void init(){
        tabNugget = new TabBase("nugget");
        tabDust = new TabBase("dust");
        tabRod = new TabBase("rod");

        if (JustBiteTheDust.installed_industrialcraft) {
            tabDustTiny = new TabBase("dust_tiny");
            tabOreCrushed = new TabBase("ore_crushed");
            tabOreCrushedPurified = new TabBase("ore_crushed_purified");
            tabCasingItem = new TabBase("casing_item");
            tabDensePlate = new TabBase("plate_dense");
        }

        if (JustBiteTheDust.installed_industrialcraft) {
            tabCoin = new TabBase("coin");
        }

        if (JustBiteTheDust.installed_mekanism){
            tabDustDirty = new TabBase("dust_dirty");
            tabShard = new TabBase("shard");
            tabClump = new TabBase("clump");
            tabCrystal = new TabBase("crystal");
        }

        if (JustBiteTheDust.installed_esteemedinnovation){
            tabOreSmashed = new TabBase("ore_smashed");
        }

        if (JustBiteTheDust.is_mod_exnihilo) {
            tabOreBroken = new TabBase("ore_broken");
            tabOreBrokenNether = new TabBase("ore_broken_nether");
            tabOreBrokenEnd = new TabBase("ore_broken_end");
        }

        if (JustBiteTheDust.is_mod_gear)
            tabGear = new TabBase("gear");

        if (JustBiteTheDust.is_mod_plate)
            tabPlate = new TabBase("plate");

        // tabOther = new TabBase("other");
    }
}
