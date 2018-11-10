package net.lrsoft.phantomcraft2.blocks.PEU;

import cpw.mods.fml.common.registry.GameRegistry;
import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.blocks.blocks;
import net.lrsoft.phantomcraft2.guis.rtTEStateExchange;
import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.custom.ItemCustomManager;
import net.lrsoft.phantomcraft2.items.eport.itemeport;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class BlockPEUManager {
	public static Block PEUtransport;
	public static Block PEUinput;
	 public static void blockregister(){
		 PEUtransport=new PEUtransport(Material.rock);
		 PEUtransport.setBlockName("PEUtransport");
		 PEUtransport.setBlockTextureName("phtc2:PEUtransport");
		 PEUtransport.setHardness(2.0f);
		 PEUtransport.setHarvestLevel("pickaxe", 0);
		 PEUtransport.setStepSound(Block.soundTypeStone);
		 PEUtransport.setCreativeTab(phantomcraft2.tabPHTC2);
	  	 GameRegistry.registerBlock(PEUtransport, "PEUtransport");
	  	 GameRegistry.registerTileEntity(rtTEtransport.class, "rtTEtransport");
	  	 
	  	PEUinput=new PEUinput(Material.rock);
	  	PEUinput.setBlockName("PEUinput");
	  	PEUinput.setBlockTextureName("phtc2:PEUinput");
	  	PEUinput.setHardness(2.0f);
	  	PEUinput.setHarvestLevel("pickaxe", 0);
	  	PEUinput.setStepSound(Block.soundTypeStone);
	  	PEUinput.setCreativeTab(phantomcraft2.tabPHTC2);
	  	 GameRegistry.registerBlock(PEUinput, "PEUinput");
	  	 GameRegistry.registerTileEntity(rtTEinput.class, "rtTEPEUinput");
	 }
     public static void onRecipeReg(){
    	 GameRegistry.addRecipe(new ItemStack(PEUtransport, 3), 
         		new Object[] {"ACA", "BXB", "ACA", 
        		'A', ItemsRegister.normalingot, 'X', itemeport.eport_input,'B',itemeport.eport_output,'C',ItemsRegister.energydust});
    	 GameRegistry.addRecipe(new ItemStack(PEUinput, 3), 
          		new Object[] {"ACA", "BXB", "ACA", 
         		'A', ItemsRegister.normalingot, 'X', itemeport.eport_output,'B',itemeport.eport_input,'C',ItemsRegister.energydust});
     }
}
