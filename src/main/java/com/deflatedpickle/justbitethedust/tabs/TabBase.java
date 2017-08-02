package com.deflatedpickle.justbitethedust.tabs;

import com.deflatedpickle.justbitethedust.Reference;
import com.deflatedpickle.justbitethedust.init.ModCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TabBase extends CreativeTabs {
    private String label;

    public TabBase(String label) {
        super("tab_"+ Reference.MOD_ID + "_" + label);
        this.label = label;
    }

/*    @Override
    public boolean hasSearchBar(){
        return true;
    }*/

    @Override
    public ItemStack getTabIconItem(){
        return randomItem(this.label);
    }

    private static ItemStack randomItem(String search_for) {
        Random random = new Random();
        List<Item> list = new ArrayList<>();

        for (Item item : ForgeRegistries.ITEMS.getValues()) {
            if (item.getRegistryName().toString().contains("justbitethedust")) {
                if (!search_for.equals("other")){
                    if (item.getRegistryName().toString().split("justbitethedust")[1].contains(search_for)) {
                        if (search_for.equals("dust") && item.getRegistryName().toString().contains("tiny")) {
                            continue;
                        }
                        else if (search_for.equals("ore_crushed") && item.getRegistryName().toString().contains("purified")){
                            continue;
                        }
                        else if (search_for.equals("plate") && item.getRegistryName().toString().contains("dense")){
                            continue;
                        }
                        else {
                            list.add(item);
                        }
                    }
                }
                else{
                    list.add(item);
                }
            }
        }

        if (!list.isEmpty()) {
            ItemStack chosen_item = new ItemStack(list.get(random.nextInt(list.size())));
            System.out.println(chosen_item);
            return chosen_item;
        } else {
            return new ItemStack(Items.AIR);
        }
    }
}
