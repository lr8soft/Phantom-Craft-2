package net.lrsoft.phantomcraft2.items.basicserise;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
public class Itembasicsword extends ItemSword{
public Itembasicsword(String unlocalizedName, ToolMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
        this.setUnlocalizedName("basicsword");
        this.setTextureName("phtc2:basicsword");
        this.setCreativeTab(phantomcraft2.tabPHTC2);
	}

}