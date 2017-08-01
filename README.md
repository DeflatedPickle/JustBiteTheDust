# JustBiteTheDust
Another AOBD clone.

## How To Add New Items:
1. Add the texture file to [here](https://github.com/DeflatedPickle/JustBiteTheDust/tree/master/src/main/resources/assets/justbitethedust/textures/items).
2. Add a model file for the texture [here](https://github.com/DeflatedPickle/JustBiteTheDust/tree/master/src/main/resources/assets/justbitethedust/models/item).
3. If the item is from a specific mod:
    1. Add a variable for the mod [here](https://github.com/DeflatedPickle/JustBiteTheDust/blob/master/src/main/java/com/deflatedpickle/justbitethedust/JustBiteTheDust.java).
4. Add a `registerItem()` function for the item, for both ingot and gem [here](https://github.com/DeflatedPickle/JustBiteTheDust/blob/master/src/main/java/com/deflatedpickle/justbitethedust/init/ModItems.java).
    1. If the item is from a specific mod: put an `if` statement around the `registerItem()` function.
5. If the name of the item needs to be changed to be readable:
    1. Add an `if` statement to the `registerItem()` function (see "Dust Tiny" example).
6. Create a new tab for the item [here](https://github.com/DeflatedPickle/JustBiteTheDust/blob/master/src/main/java/com/deflatedpickle/justbitethedust/init/ModCreativeTabs.java).
7. Add an `else if` statement for the item type [here](https://github.com/DeflatedPickle/JustBiteTheDust/blob/master/src/main/java/com/deflatedpickle/justbitethedust/items/ItemBase.java).
8. Add the tab to [here](https://github.com/DeflatedPickle/JustBiteTheDust/blob/master/src/main/resources/assets/justbitethedust/lang/en_US.lang).