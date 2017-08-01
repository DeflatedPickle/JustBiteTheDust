package com.deflatedpickle.justbitethedust.init;

import com.deflatedpickle.justbitethedust.JustBiteTheDust;
import com.deflatedpickle.justbitethedust.tabs.TabBase;

public class ModCreativeTabs {
    public static TabBase tabNugget;
    public static TabBase tabDust;
    public static TabBase tabRod;

    public static TabBase tabDustTiny;
    public static TabBase tabCrushedOre;
    public static TabBase tabPurifiedOre;

    public static TabBase tabCoin;

    public static TabBase tabGear;
    public static TabBase tabPlate;

    public static TabBase tabBrokenOre;
    public static TabBase tabBrokenNetherOre;
    public static TabBase tabBrokenEndOre;

    // public static TabBase tabOther;

    public static void init(){
        tabNugget = new TabBase("nugget");
        tabDust = new TabBase("dust");
        tabRod = new TabBase("rod");

        if (JustBiteTheDust.installed_industrialcraft) {
            tabDustTiny = new TabBase("dust_tiny");
            tabCrushedOre = new TabBase("crushed_ore");
            tabPurifiedOre = new TabBase("crushed_ore_purified");
        }

        if (JustBiteTheDust.installed_industrialcraft) {
            tabCoin = new TabBase("coin");
        }

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
}
