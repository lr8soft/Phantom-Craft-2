package net.lrsoft.phantomcraft2.items.eport;

import cpw.mods.fml.common.registry.GameRegistry;
import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.items;
import net.lrsoft.phantomcraft2.items.basicserise.ItemBasicManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class itemeport {
	 public static Item eport_input;
	 public static Item eport_output;
	 public static Item eport_save;	 
	 
	 public static Item eport_impact;
	 public static Item eport_enrich;
	 public static Item eport_storage;
       public static void onReg(){
    	   eport_input=new items();
    	   eport_input.setUnlocalizedName("eport_input");
    	   eport_input.setTextureName("phtc2:eport_input");
    	   eport_input.setMaxStackSize(64);
    	   eport_input.setCreativeTab(phantomcraft2.tabPHTC2);
  		   GameRegistry.registerItem(eport_input, "eport_input");
  		   
  	       eport_output=new items();
  		   eport_output.setUnlocalizedName("eport_output");
  		   eport_output.setTextureName("phtc2:eport_output");
  		   eport_output.setMaxStackSize(64);
  		   eport_output.setCreativeTab(phantomcraft2.tabPHTC2);
  		   GameRegistry.registerItem(eport_output, "eport_output");
  		   
  		   eport_save=new items();
  		   eport_save.setUnlocalizedName("eport_save");
  		   eport_save.setTextureName("phtc2:eport_save");
  		   eport_save.setMaxStackSize(64);
  		   eport_save.setCreativeTab(phantomcraft2.tabPHTC2);
    	   GameRegistry.registerItem(eport_save, "eport_save");
    	   
    	   eport_impact=new items();
    	   eport_impact.setUnlocalizedName("eport_impact");
    	   eport_impact.setTextureName("phtc2:eport_impact");
    	   eport_impact.setMaxStackSize(64);
    	   eport_impact.setCreativeTab(phantomcraft2.tabPHTC2);
    	   GameRegistry.registerItem(eport_impact, "eport_impact");
    	   
    	   eport_enrich=new items();
    	   eport_enrich.setUnlocalizedName("eport_enrich");
    	   eport_enrich.setTextureName("phtc2:eport_enrich");
    	   eport_enrich.setMaxStackSize(64);
    	   eport_enrich.setCreativeTab(phantomcraft2.tabPHTC2);
    	   GameRegistry.registerItem(eport_enrich, "eport_enrich");
    	   
    	   eport_storage=new items();
    	   eport_storage.setUnlocalizedName("eport_storage");
    	   eport_storage.setTextureName("phtc2:eport_storage");
    	   eport_storage.setMaxStackSize(64);
    	   eport_storage.setCreativeTab(phantomcraft2.tabPHTC2);
    	   GameRegistry.registerItem(eport_storage, "eport_storage");
       }
       public static void onRecipeReg(){
    	   GameRegistry.addRecipe(new ItemStack(itemeport.eport_input, 1), 
    			   new Object[] {"XAX", "ABA", "XAX", 'X', Blocks.glass_pane, 'A', ItemsRegister.energydust,'B',new ItemStack(Items.dye,1,4)});
    	   GameRegistry.addRecipe(new ItemStack(itemeport.eport_output, 1), 
    			   new Object[] {"XAX", "ABA", "XAX", 'X', Blocks.glass_pane, 'A', ItemsRegister.energydust,'B',Items.redstone});
    	   GameRegistry.addRecipe(new ItemStack(itemeport.eport_save, 1), 
    			   new Object[] {"XAX", "ABA", "XAX", 'X', Blocks.glass_pane, 'A', ItemsRegister.energydust,'B',ItemsRegister.ph_advdust});
    	   GameRegistry.addRecipe(new ItemStack(itemeport.eport_impact, 1), 
    		   new Object[] {"ABA", "XCX", "ABA",
    		   'X', Items.gunpowder, 'A', Blocks.glass_pane,'C',ItemsRegister.ph_advdust,'B',itemeport.eport_output});
    	   GameRegistry.addRecipe(new ItemStack(itemeport.eport_enrich, 1), 
        		   new Object[] {"ABA", "XCX", "ABA",
        		   'X', itemeport.eport_save, 'A', Blocks.glass_pane,'C',Items.diamond,'B',ItemsRegister.ph_advdust});
    	   GameRegistry.addRecipe(new ItemStack(itemeport.eport_storage, 1), 
        		   new Object[] {"ABA", "BCB", "ABA",
        		    'A', Blocks.glass_pane,'C',Items.diamond,'B',ItemsRegister.ph_advdust});
       }
}
