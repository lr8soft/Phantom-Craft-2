package net.lrsoft.phantomcraft2.items.basicserise;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.common.util.EnumHelper;
public class Itembasicspade extends ItemSpade{
public Itembasicspade(String unlocalizedName, ToolMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
        this.setUnlocalizedName("basicspade");
        this.setTextureName("phtc2:basicspade");
        this.setCreativeTab(phantomcraft2.tabPHTC2);
	}

}