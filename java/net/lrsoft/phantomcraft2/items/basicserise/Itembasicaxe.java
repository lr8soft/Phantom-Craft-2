package net.lrsoft.phantomcraft2.items.basicserise;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;

public class Itembasicaxe extends ItemAxe{
 public Itembasicaxe(String unlocalizedName, ToolMaterial material){
	 super(material);
     this.setUnlocalizedName("basicaxe");
     this.setTextureName("phtc2:basicaxe");
     this.setCreativeTab(phantomcraft2.tabPHTC2);
 }

}
