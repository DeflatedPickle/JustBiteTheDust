package com.deflatedpickle.justbitethedust.handlers;

import com.deflatedpickle.justbitethedust.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.Set;

public class FuelHandler implements IFuelHandler{
    public static Set<Pair<Item, Integer>> fuelList = new HashSet<>();

    @Override
    public int getBurnTime(ItemStack fuel){
        if (fuel != null && !fuel.isEmpty()) {
            for (Pair<Item, Integer> item : fuelList) {
                // System.out.println(OreDictionary.getOreName(OreDictionary.getOreIDs(new ItemStack(item.getLeft()))[0]));
                if (fuel.isItemEqual(OreDictionary.getOres(OreDictionary.getOreName(OreDictionary.getOreIDs(new ItemStack(item.getLeft()))[0])).get(0))) {
                    // System.out.println("Registering Fuel: " + fuel);
                    return item.getRight();
                }
            }
        }
        return 0;
    }
}
