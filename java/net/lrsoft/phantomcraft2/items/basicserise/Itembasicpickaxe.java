package net.lrsoft.phantomcraft2.items.basicserise;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;
public class Itembasicpickaxe extends ItemPickaxe{
public Itembasicpickaxe(String unlocalizedName, ToolMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
        this.setUnlocalizedName("basicpickaxe");
        this.setTextureName("phtc2:basicpickaxe");
        this.setHarvestLevel(unlocalizedName, 3);
        this.setCreativeTab(phantomcraft2.tabPHTC2);
	}

}