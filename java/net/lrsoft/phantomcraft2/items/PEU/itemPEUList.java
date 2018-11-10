package net.lrsoft.phantomcraft2.items.PEU;

import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.basicserise.ItemBasicManager;
import net.lrsoft.phantomcraft2.items.eport.itemeport;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class itemPEUList {
	public static int basicPEUbattery=2000;
	public static int advPEUbattery=10000;//10,000PEU
	
	public static int PEUaxe=1000;
	public static int PEUsword=1000;
	public static int PEUspade=1000;
	public static int PEUpickaxe=1000;
	public static int PEUgun=2000;
	public static int PEUarmor=1000;
	public static int PEUshieid=5000;
	
	public static int PEUfarmor=4000;
	public static int PEUfsword=2000;
	public static int PEUfpickaxe=2000;
	
	public static int PEUcustom=3000;
	public static void onRecipeReg(){
		GameRegistry.addRecipe(new ItemStack(ItemsRegister.ph_basicbattery, 1), 
		 new Object[] {"ABA", "CXC", "ABA", 
		 'B', ItemsRegister.normalingot, 'X', itemeport.eport_save,'C',ItemsRegister.ph_advingot,'A',Items.iron_ingot});
		
		GameRegistry.addRecipe(new ItemStack(ItemsRegister.ph_advbattery, 1), 
		 new Object[] {"ABA", "CXC", "ABA", 
		'B', itemeport.eport_storage, 'X', ItemsRegister.ph_basicbattery,'A',ItemsRegister.ph_advingot,'C',itemeport.eport_enrich});
	
		GameRegistry.addRecipe(new ItemStack(ItemsRegister.ph_PEUshield, 1), 
        		new Object[] {"#X#", "#Z#", "#X#", '#', ItemsRegister.ph_advingot, 'X', ItemsRegister.ph_advdust,'Z',Items.golden_apple});
	}
}
