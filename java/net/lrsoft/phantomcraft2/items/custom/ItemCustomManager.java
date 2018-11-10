package net.lrsoft.phantomcraft2.items.custom;

import cpw.mods.fml.common.registry.GameRegistry;
import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU.ItemPEUManager;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU.ItemswordPEU;
import net.lrsoft.phantomcraft2.items.eport.itemeport;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class ItemCustomManager {
    public static Item customitem;
 
    public static Item materialiron_part;
    public static Item materialadv_part;
    public static Item materialdia_part;
    public static Item materialextdia_part;
    
    public static Item miron_part;
    public static Item madv_part;
    public static Item madia_part;
    public static Item maextdia_part;
    
    public static Item strengthenitem;
    public static Item explodeitem;
    public static Item lightningitem;
    public static Item teloportitem;
    public static void onReg(){
    	GameRegistry.registerItem(customitem = new ItemCustom(), "customitem");
    	GameRegistry.registerItem(materialadv_part = new ItemCustomMaterial("materialadv_part"), "materialadv_part");
    	GameRegistry.registerItem(materialdia_part = new ItemCustomMaterial("materialdia_part"), "materialdia_part");
    	GameRegistry.registerItem(materialiron_part = new ItemCustomMaterial("materialiron_part"), "materialiron_part");
    	GameRegistry.registerItem(materialextdia_part = new ItemCustomMaterial("materialextdia_part"), "materialextdia_part");
    	
    	GameRegistry.registerItem(madv_part = new ItemCustomMaterial("madv_part"), "madv_part");
    	GameRegistry.registerItem(madia_part = new ItemCustomMaterial("madia_part"), "madia_part");
    	GameRegistry.registerItem(miron_part = new ItemCustomMaterial("miron_part"), "miron_part");
    	GameRegistry.registerItem(maextdia_part = new ItemCustomMaterial("maextdia_part"), "maextdia_part");
    	
    	GameRegistry.registerItem(strengthenitem = new ItemCustomMaterial("strengthenitem"), "strengthenitem");
    	GameRegistry.registerItem(explodeitem = new ItemCustomMaterial("explodeitem"), "explodeitem");
    	GameRegistry.registerItem(lightningitem = new ItemCustomMaterial("lightningitem"), "lightningitem");
    	GameRegistry.registerItem(teloportitem = new ItemCustomMaterial("rapidlyitem"), "rapidlyitem");
    }
    public static void onRecipeReg(){
       	GameRegistry.addRecipe(new ItemStack(ItemCustomManager.customitem, 1), 
        		new Object[] {"YAY", "BXB", "YAY", 
       		'A', itemeport.eport_input, 'X', itemeport.eport_save,'B',itemeport.eport_output,'Y',ItemsRegister.ph_advingot});
       	GameRegistry.addRecipe(new ItemStack(ItemCustomManager.materialadv_part, 1), 
        		new Object[] {" YX", "YXY", " Y ", 
       		 'X', itemeport.eport_impact,'Y',ItemsRegister.ph_advingot});
       	GameRegistry.addRecipe(new ItemStack(ItemCustomManager.materialdia_part, 1), 
        		new Object[] {" YX", "YXY", " Y ", 
       		 'X', itemeport.eport_impact,'Y',Items.diamond});
       	GameRegistry.addRecipe(new ItemStack(ItemCustomManager.materialextdia_part, 1), 
        		new Object[] {" YX", "YXY", " Y ", 
       		 'X', itemeport.eport_impact,'Y',ItemsRegister.ph_hyperdiamond});
       	GameRegistry.addRecipe(new ItemStack(ItemCustomManager.materialiron_part, 1), 
        		new Object[] {" YX", "YXY", " Y ", 
       		 'X', itemeport.eport_output,'Y',Items.iron_ingot});
       	GameRegistry.addRecipe(new ItemStack(ItemCustomManager.strengthenitem, 1), 
        		new Object[] {"XLX", "LYL", "XLX", 
       		 'X', itemeport.eport_impact,'Y',Items.diamond,'L',ItemsRegister.ph_advdust});
    	GameRegistry.addRecipe(new ItemStack(ItemCustomManager.explodeitem, 1), 
        		new Object[] {"XKX", "LYL", "XKX", 
       		 'X', Blocks.tnt,'Y',ItemsRegister.ph_advdust,'L',itemeport.eport_storage,'K',itemeport.eport_impact});
    	GameRegistry.addRecipe(new ItemStack(ItemCustomManager.lightningitem, 1), 
        		new Object[] {"XKX", "KYK", "XKX", 
       		 'X', ItemsRegister.ph_advingot,'Y',Blocks.obsidian,'K',itemeport.eport_impact});
    	GameRegistry.addRecipe(new ItemStack(ItemCustomManager.teloportitem, 1), 
        		new Object[] {"XKX", "KYK", "XKX", 
       		 'X', ItemsRegister.ph_advingot,'Y',Items.feather,'K',itemeport.eport_output});
    	
    	
    	
       	GameRegistry.addRecipe(new ItemStack(ItemCustomManager.maextdia_part, 1), 
        		new Object[] {"XYX", "XZX", "   ", 
       		 'X', ItemsRegister.ph_hyperdiamond,'Y',itemeport.eport_impact,'Z',itemeport.eport_input});
       	GameRegistry.addRecipe(new ItemStack(ItemCustomManager.madia_part, 1), 
        		new Object[] {"XYX", "XZX", "   ", 
       		 'X', Items.diamond,'Y',itemeport.eport_impact,'Z',itemeport.eport_input});
       	GameRegistry.addRecipe(new ItemStack(ItemCustomManager.madv_part, 1), 
        		new Object[] {"XYX", "XZX", "   ", 
       		 'X', ItemsRegister.ph_advingot,'Y',itemeport.eport_output,'Z',itemeport.eport_input});
       	GameRegistry.addRecipe(new ItemStack(ItemCustomManager.miron_part, 1), 
        		new Object[] {"XYX", "XZX", "   ", 
       		 'X', Items.iron_ingot,'Y',itemeport.eport_output,'Z',itemeport.eport_input});
       	
    }
}
