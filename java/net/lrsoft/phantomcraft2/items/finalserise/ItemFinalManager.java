package net.lrsoft.phantomcraft2.items.finalserise;

import cpw.mods.fml.common.registry.GameRegistry;
import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU.ItemPEUManager;
import net.lrsoft.phantomcraft2.items.eport.itemeport;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemFinalManager {
	public static Item PEUfinalhelmet;
	public static Item PEUfinalchestplate;
	public static Item PEUfinalleggings;
	public static Item PEUfinalboots;
	
	public static Item PEUfinalsword; 
	public static Item PEUfinalpickaxe;
	 
	public static ToolMaterial peufsword = EnumHelper.addToolMaterial("peufsword", 0, 2499, 10.0F, 5.0F, 28);
	public static ToolMaterial peufpickaxe = EnumHelper.addToolMaterial("peufpickaxe", 4, 2499, 10.0F, 5.0F, 28); 
	
	public static void onReg(){
		  GameRegistry.registerItem(PEUfinalsword = new Itemfinalsword("PEUfinalsword", peufsword), "PEUfinalsword");
		  GameRegistry.registerItem(PEUfinalpickaxe=new Itemfinalpickaxe("PEUfinalpickaxe", peufpickaxe),"PEUfinalpickaxe");
	}
	public static void onRecipeReg(){
	 	GameRegistry.addRecipe(new ItemStack(ItemFinalManager.PEUfinalsword, 1), 
	    		new Object[] {" # ", " X ", " A ", '#', ItemsRegister.ph_hyperdiamond, 'X', ItemPEUManager.PEUsword,'A',itemeport.eport_impact});
	    GameRegistry.addRecipe(new ItemStack(ItemFinalManager.PEUfinalpickaxe, 1), 
	        	new Object[] {"#A#", " X ", " # ", '#', ItemsRegister.ph_hyperdiamond, 'X', ItemPEUManager.PEUpickaxe,'A',itemeport.eport_impact});
	}
}
