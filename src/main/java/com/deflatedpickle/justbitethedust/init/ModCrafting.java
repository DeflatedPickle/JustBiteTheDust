package com.deflatedpickle.justbitethedust.init;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;


public class ModCrafting {
    private static Set<Pair<Item, String>> recipes_nugget = new HashSet();
    private static Set<Pair<Item, String>> recipes_gear = new HashSet();
    private static Set<Pair<Item, String>> recipes_plate = new HashSet();

    public static void register(){
        for (Pair<Item, String> pair : recipes_nugget){
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(pair.getLeft(), 9), pair.getRight()));
            GameRegistry.addShapelessRecipe(OreDictionary.getOres(pair.getRight()).get(0).copy(), Collections.nCopies(9, pair.getLeft()).toArray());
        }

        for (Pair<Item, String> pair : recipes_gear){
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(pair.getLeft()), " M ", "MIM", " M ", 'M', pair.getRight(), 'I', Items.IRON_INGOT));
        }

        for (Pair<Item, String> pair : recipes_plate){
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(pair.getLeft(), 4), pair.getRight()));
        }
    }

    public static void add_recipe(Item base, String metal, String type){
        if (type.equals("Nugget")) {
            recipes_nugget.add(Pair.of(base, metal));
        }
        else if (type.equals("Gear")){
            recipes_gear.add(Pair.of(base, metal));
        }
        else if (type.equals("Plate")) {
            recipes_plate.add(Pair.of(base, metal));
        }
    }
}
