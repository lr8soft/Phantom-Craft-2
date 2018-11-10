package net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU;

import cpw.mods.fml.common.registry.GameRegistry;
import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.basicserise.ItemBasicManager;
import net.lrsoft.phantomcraft2.items.basicserise.Itembasicaxe;
import net.lrsoft.phantomcraft2.items.basicserise.Itembasicpickaxe;
import net.lrsoft.phantomcraft2.items.basicserise.Itembasicspade;
import net.lrsoft.phantomcraft2.items.basicserise.Itembasicsword;
import net.lrsoft.phantomcraft2.items.eport.itemeport;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemPEUManager {
	public static Item PEUsword;
	public static Item PEUspade;
	public static Item PEUaxe;
	public static Item PEUpickaxe;
	
	public static Item PEUhelmet;
	public static Item PEUchestplate;
	public static Item PEUleggings;
	public static Item PEUboots;
	
	public static ToolMaterial peusword = EnumHelper.addToolMaterial("peusword", 0, 502, 8.0F, 4.0F, 20);
	public static ToolMaterial peuaxe = EnumHelper.addToolMaterial("peuaxe", 0, 502, 8.0F, 4.0F, 20);
	public static ToolMaterial peupickaxe = EnumHelper.addToolMaterial("peupickaxe", 3, 502, 8.0F, 4.0F, 20); 
	public static ToolMaterial peuspade = EnumHelper.addToolMaterial("peuspade", 0, 502, 8.0F, 4.0F, 20);
	
    public static void onReg(){
		  GameRegistry.registerItem(PEUsword = new ItemswordPEU("PEUsword", peusword), "PEUsword");
		  GameRegistry.registerItem(PEUaxe = new ItemaxePEU("PEUaxe",  peuaxe), "PEUaxe");
		  GameRegistry.registerItem(PEUpickaxe=new ItempickaxePEU("PEUpickaxe", peupickaxe),"PEUpickaxe");
		  GameRegistry.registerItem(PEUspade=new ItemspadePEU("PEUspade",  peuspade),"PEUspade");
	}
    public static void onRecipeReg(){
    	GameRegistry.addRecipe(new ItemStack(ItemPEUManager.PEUsword, 1), 
    		new Object[] {" # ", " A ", " X ", '#', ItemsRegister.ph_advingot, 'X', Items.stick,'A',itemeport.eport_output});
    	GameRegistry.addRecipe(new ItemStack(ItemPEUManager.PEUpickaxe, 1), 
        		new Object[] {"#A#", " X ", " X ", '#', ItemsRegister.ph_advingot, 'X', Items.stick,'A',itemeport.eport_output});
    	GameRegistry.addRecipe(new ItemStack(ItemPEUManager.PEUaxe, 1), 
        		new Object[] {"## ", "#A ", " X ", '#', ItemsRegister.ph_advingot, 'X', Items.stick,'A',itemeport.eport_input});
    	GameRegistry.addRecipe(new ItemStack(ItemPEUManager.PEUspade, 1), 
        		new Object[] {" # ", " X ", " X ", '#', ItemsRegister.ph_advingot, 'X', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(ItemsRegister.ph_PEUgun, 1), 
        		new Object[] {"A X", " B ", "X C", 'A', ItemsRegister.ph_advingot, 'X', Items.iron_ingot,'B',Items.bow,'C',itemeport.eport_impact});
    	GameRegistry.addRecipe(new ItemStack(ItemsRegister.ph_PEUFlySupport, 1), 
        		new Object[] {"XAX", "BDB", "XEX", 
    		'A', itemeport.eport_storage, 'X', Blocks.glass_pane,'B',itemeport.eport_enrich,'D',Items.feather,'E',itemeport.eport_impact});  
    	
    }
}
