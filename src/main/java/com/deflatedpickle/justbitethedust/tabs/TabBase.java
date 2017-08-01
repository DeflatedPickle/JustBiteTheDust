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
                            break;
                        }
                        else if (search_for.equals("ore_crushed") && item.getRegistryName().toString().contains("purified")){
                            break;
                        }
                        else if (search_for.equals("plate") && item.getRegistryName().toString().contains("dense")){
                            break;
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
            return new ItemStack(list.get(random.nextInt(list.size())));
        } else {
            return new ItemStack(Items.AIR);
        }
    }
}
