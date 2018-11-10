package net.lrsoft.phantomcraft2.items.custom;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.minecraft.item.Item;

public class ItemCustomMaterial extends Item{
	public ItemCustomMaterial(String name){
    this.setCreativeTab(phantomcraft2.tabPHTC2);
    this.setUnlocalizedName(name);
    this.setTextureName("phtc2:customtool/"+name);
    this.setMaxStackSize(1);
    this.setFull3D();
    this.setHasSubtypes(true);
    }

}