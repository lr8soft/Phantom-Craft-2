package net.lrsoft.phantomcraft2.items.basicserise;

import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemBasicManager {
	public static Item basichelmet;
	public static Item basicchestplate;
	public static Item basicleggings;
	public static Item basicboots;
	
	public static Item basicsword; 
	 public static Item basicaxe; 
	 public static Item basicpickaxe;
	 public static Item basicspade;
		public static ToolMaterial bsword = EnumHelper.addToolMaterial("bsword", 0, 220, 8.0F, 2.0F, 16);
		public static ToolMaterial baxe = EnumHelper.addToolMaterial("baxe", 0, 220, 8.0F, 2.0F, 16);
		public static ToolMaterial bpickaxe = EnumHelper.addToolMaterial("bpickaxe", 2, 220, 8.0F, 2.0F, 16); 
		public static ToolMaterial bspade = EnumHelper.addToolMaterial("bspade", 0, 220, 8.0F, 2.0F, 16);
     public static void onReg(){
		  GameRegistry.registerItem(basicsword = new Itembasicsword("basicsword", bsword), "basicsword");
		  GameRegistry.registerItem(basicaxe = new Itembasicaxe("basicaxe",  baxe), "basicaxe");
		  GameRegistry.registerItem(basicpickaxe=new Itembasicpickaxe("basicpickaxe", bpickaxe),"basicpickaxe");
		  GameRegistry.registerItem(basicspade=new Itembasicspade("basicspade",  bspade),"basicspade");
	}
	public static void onRecipeReg(){
		 GameRegistry.addRecipe(new ItemStack(ItemBasicManager.basicsword, 1), new Object[] {" # ", " # ", " X ", '#', ItemsRegister.normalingot, 'X', Items.stick});
		 GameRegistry.addRecipe(new ItemStack(ItemBasicManager.basicspade, 1), new Object[] {" # ", " X ", " X ", '#', ItemsRegister.normalingot, 'X', Items.stick});
		 GameRegistry.addRecipe(new ItemStack(ItemBasicManager.basicpickaxe, 1), new Object[] {"###", " X ", " X ", '#', ItemsRegister.normalingot, 'X', Items.stick});
		 GameRegistry.addRecipe(new ItemStack(ItemBasicManager.basicaxe, 1), new Object[] {"## ", "#X ", " X ", '#', ItemsRegister.normalingot, 'X', Items.stick});
	}
}
