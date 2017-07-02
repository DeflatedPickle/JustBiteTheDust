package com.deflatedpickle.justbitethedust.proxy;

import com.deflatedpickle.justbitethedust.items.ItemBase;

public interface CommonProxy {
    public void init();

    public void registerItemModel(ItemBase nugget, String type);
}
