package com.deflatedpickle.justbitethedust.proxy;

import com.deflatedpickle.justbitethedust.handlers.FuelHandler;
import com.deflatedpickle.justbitethedust.items.ItemBase;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ServerProxy implements CommonProxy{
    @Override
    public void init() {
        GameRegistry.registerFuelHandler(new FuelHandler());
    }

    @Override
    public void registerItemModel(ItemBase nugget, String type){
    }
}
