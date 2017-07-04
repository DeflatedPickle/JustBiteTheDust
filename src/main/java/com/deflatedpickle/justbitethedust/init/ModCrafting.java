package com.deflatedpickle.justbitethedust.init;

import com.deflatedpickle.justbitethedust.JustBiteTheDust;
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
    private static Set<Pair<Item, String>> recipes_dust = new HashSet();
    private static Set<Pair<Item, String>> recipes_dust_tiny = new HashSet();
    private static Set<Pair<Item, String>> recipes_gear = new HashSet();
    private static Set<Pair<Item, String>> recipes_plate = new HashSet();

    public static void register(){
        for (Pair<Item, String> pair : recipes_nugget){
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(pair.getLeft(), 9), pair.getRight()));
            GameRegistry.addShapelessRecipe(OreDictionary.getOres(pair.getRight()).get(0).copy(), Collections.nCopies(9, pair.getLeft()).toArray());
        }

        for (Pair<Item, String> pair : recipes_dust) {
            GameRegistry.addSmelting(pair.getLeft(), OreDictionary.getOres(pair.getRight()).get(0).copy(), 0.7f);
        }

        if (JustBiteTheDust.installed_industrialcraft) {
            for (Pair<Item, String> pair : recipes_dust_tiny) {
                GameRegistry.addShapelessRecipe(OreDictionary.getOres(pair.getRight()).get(0).copy(), Collections.nCopies(9, pair.getLeft()).toArray());
            }
        }

        if (JustBiteTheDust.is_mod_gear) {
            for (Pair<Item, String> pair : recipes_gear) {
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(pair.getLeft()), " M ", "MIM", " M ", 'M', pair.getRight(), 'I', Items.IRON_INGOT));
            }
        }

        if (JustBiteTheDust.is_mod_plate) {
            for (Pair<Item, String> pair : recipes_plate) {
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(pair.getLeft()), pair.getRight(), "craftingToolForgeHammer"));
            }
        }
    }

    public static void add_recipe(Item output, String input, String type){
        if (type.equals("Nugget")) {
            recipes_nugget.add(Pair.of(output, input));
        }
        else if (type.equals("Dust")){
            recipes_dust.add(Pair.of(output, input));
        }
        else if (type.equals("Dust Tiny")){
            recipes_dust_tiny.add(Pair.of(output, input));
        }
        else if (type.equals("Gear")){
            recipes_gear.add(Pair.of(output, input));
        }
        else if (type.equals("Plate")) {
            recipes_plate.add(Pair.of(output, input));
        }
    }
}
