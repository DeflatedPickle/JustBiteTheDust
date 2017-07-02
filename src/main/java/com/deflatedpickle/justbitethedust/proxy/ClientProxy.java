package com.deflatedpickle.justbitethedust.proxy;

import com.deflatedpickle.justbitethedust.JustBiteTheDust;
import com.deflatedpickle.justbitethedust.init.ModItems;
import com.deflatedpickle.justbitethedust.items.ItemBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.oredict.OreDictionary;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ClientProxy implements CommonProxy{
    @Override
    public void init() {
        ((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new IResourceManagerReloadListener() {
            @Override
            public void onResourceManagerReload(IResourceManager resourceManager) {
                for (ItemBase nug : ModItems.item_list) {
                    for (ItemStack ingot : OreDictionary.getOres(String.format("ingot%s", nug.base.substring(5)))) {
                        generateColour(ingot, nug);
                    }
                    for (ItemStack gem : OreDictionary.getOres(String.format("gem%s", nug.base.substring(3)))) {
                        generateColour(gem, nug);
                    }
                    registerItemColour(nug);
                }
            }
        });
    }

    @Override
    public void registerItemModel(ItemBase item, String type){
        String model = "";
        if (type.equals("Nugget")) {
            List<String> list = Arrays.asList("", "_sideways", "_thermalfoundation");
            model = list.get(new Random().nextInt(list.size()));
        }
        else if (type.equals("Dust")){
            List<String> list = Arrays.asList("", "_appliedenergistics", "_electricalage", "_magneticraft", "_mekanism", "_thermalfoundation", "_industrialcraft");
            model = list.get(new Random().nextInt(list.size()));
        }
        else if (type.equals("Gear")) {
            List<String> list = Arrays.asList("_buildcraft", "_railcraft", "_rotarycraft", "_thermalfoundation");
            model = list.get(new Random().nextInt(list.size()));
        }
        else if (type.equals("Plate")) {
            List<String> list = Arrays.asList("_electricalage", "_fsp", "_industrialcraft", "_railcraft");
            model = list.get(new Random().nextInt(list.size()));
        }

        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation("justbitethedust:" + type.toLowerCase().replaceAll(" ", "_") + model, "inventory"));
    }

    public static void registerItemColour(ItemBase item){
        final int colour = item.colour;
        ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
        itemColors.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(ItemStack stack, int tintIndex) {
                if (tintIndex == 0) {
                    return colour;
                } else {
                    return -1;
                }
            }
        }, item);
    }

    public void generateColour(ItemStack base, ItemBase item){
        IBakedModel model = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(base, null, null);
        List<BakedQuad> quads = model.getQuads(null, null, 0);

        for (BakedQuad quad : quads) {
            TextureAtlasSprite sprite = quad.getSprite();
            int[] rgba = sprite.getFrameTextureData(0)[0];
            BufferedImage image = new BufferedImage(sprite.getIconWidth(), sprite.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            image.setRGB(0, 0, sprite.getIconWidth(), sprite.getIconHeight(), rgba, 0, sprite.getIconWidth());
            Image scaled = image.getScaledInstance(1, 1, BufferedImage.TYPE_INT_ARGB);

            BufferedImage buff_scaled = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            buff_scaled.getGraphics().drawImage(scaled, 0, 0, null);

            int colour = buff_scaled.getRGB(0, 0);

            item.colour = colour;
        }
    }
}
