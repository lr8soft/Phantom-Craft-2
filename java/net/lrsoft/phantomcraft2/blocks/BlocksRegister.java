package net.lrsoft.phantomcraft2.blocks;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.guis.rtTEAPEUStorage;
import net.lrsoft.phantomcraft2.guis.rtTEASPEU;
import net.lrsoft.phantomcraft2.guis.rtTECustomTable;
import net.lrsoft.phantomcraft2.guis.rtTEEnergyProduce;
import net.lrsoft.phantomcraft2.guis.rtTEPEUFurnace;
import net.lrsoft.phantomcraft2.guis.rtTEPEUSE;
import net.lrsoft.phantomcraft2.guis.rtTEPEUStorage;
import net.lrsoft.phantomcraft2.guis.rtTERECT;
import net.lrsoft.phantomcraft2.guis.rtTERecycle;
import net.lrsoft.phantomcraft2.guis.rtTESPEU;
import net.lrsoft.phantomcraft2.guis.rtTEStateExchange;
import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.basicserise.ItemBasicManager;
import net.lrsoft.phantomcraft2.items.custom.ItemCustomManager;
import net.lrsoft.phantomcraft2.items.eport.itemeport;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BlocksRegister {
       public static Block normalore;
       public static Block energyore;
       public static Block stateexchange;
       public static Block energyproduce;
       public static Block PEUfurnace;
       public static Block PEUStorage;
       public static Block PEUSolar;
       public static Block PEUstateexchange;
       public static Block PEUASolar;
       public static Block PEUAStorage;
       public static Block CustomTable;
       public static Block reCustomTable;
       public static Block PEURecycle;
       public static void blockregister(){
     	normalore=new blocks(Material.rock);
     	normalore.setBlockName("normalore");
    	normalore.setBlockTextureName("phtc2:normalore");
       	normalore.setHardness(2.0f);
     	normalore.setHarvestLevel("pickaxe", 0);
	    normalore.setStepSound(Block.soundTypeStone);
     	normalore.setCreativeTab(phantomcraft2.tabPHTC2);
  	    GameRegistry.registerBlock(normalore, "normalore");
  	    
    	energyore=new blocks(Material.rock);
    	energyore.setBlockName("energyore");
    	energyore.setBlockTextureName("phtc2:energyore");
    	energyore.setHardness(2.0f);
    	energyore.setHarvestLevel("pickaxe", 0);
    	energyore.setStepSound(Block.soundTypeStone);
    	energyore.setCreativeTab(phantomcraft2.tabPHTC2);
  	    GameRegistry.registerBlock(energyore, "energyore");
  	    
    	stateexchange=new blockstateexchange(Material.iron);
     	stateexchange.setBlockName("stateexchange");
    	stateexchange.setBlockTextureName("phtc2:stateexchange");
    	stateexchange.setHardness(2.0f);
    	stateexchange.setHarvestLevel("pickaxe", 1);
    	stateexchange.setStepSound(Block.soundTypeMetal);
    	stateexchange.setCreativeTab(phantomcraft2.tabPHTC2);
  	    GameRegistry.registerBlock(stateexchange, "stateexchange");
  	    GameRegistry.registerTileEntity(rtTEStateExchange.class, "TEStateExchange");
  	    
  	    energyproduce=new blockenergyproduce(Material.iron);
      	energyproduce.setBlockName("energyproduce");
     	energyproduce.setBlockTextureName("phtc2:energyproduce");
    	energyproduce.setHardness(2.0f);
    	energyproduce.setHarvestLevel("pickaxe", 1);
    	energyproduce.setStepSound(Block.soundTypeMetal);
    	energyproduce.setCreativeTab(phantomcraft2.tabPHTC2);
  	    GameRegistry.registerBlock(energyproduce, "energyproduce");
  	    GameRegistry.registerTileEntity(rtTEEnergyProduce.class, "TEEnergyProduce");
  	    
  	    PEUfurnace=new blockPEUfurnace(Material.iron);
  	    PEUfurnace.setBlockName("PEUfurnace");
  	    PEUfurnace.setBlockTextureName("phtc2:PEUfurnace");
     	PEUfurnace.setHardness(2.0f);
     	PEUfurnace.setHarvestLevel("pickaxe", 1);
    	PEUfurnace.setStepSound(Block.soundTypeMetal);
     	PEUfurnace.setCreativeTab(phantomcraft2.tabPHTC2);
  	    GameRegistry.registerBlock(PEUfurnace, "PEUfurnace");
  	    GameRegistry.registerTileEntity(rtTEPEUFurnace.class, "TEPEUFurnace");
  	    
  	    PEUStorage=new blockPEUStorage(Material.iron);
  	    PEUStorage.setBlockName("PEUStorage");
  	    PEUStorage.setBlockTextureName("phtc2:PEUStorage");
     	PEUStorage.setHardness(2.0f);
    	PEUStorage.setHarvestLevel("pickaxe", 1);
    	PEUStorage.setStepSound(Block.soundTypeMetal);
    	PEUStorage.setCreativeTab(phantomcraft2.tabPHTC2);
  	    GameRegistry.registerBlock(PEUStorage, "PEUStorage");
  	    GameRegistry.registerTileEntity(rtTEPEUStorage.class, "TEPEUStorage");
  	    
  	    PEUSolar=new blocksolarPEU(Material.iron);
    	PEUSolar.setBlockName("PEUSolar");
    	PEUSolar.setBlockTextureName("phtc2:PEUSolar");
    	PEUSolar.setHardness(2.0f);
  	    PEUSolar.setHarvestLevel("pickaxe", 1);
  	    PEUSolar.setStepSound(Block.soundTypeMetal);
     	PEUSolar.setCreativeTab(phantomcraft2.tabPHTC2);
  	    GameRegistry.registerBlock(PEUSolar, "PEUSolar");
  	    GameRegistry.registerTileEntity(rtTESPEU.class, "TEPEUSolar");
  	    
  	    PEUstateexchange=new blockPEUSE(Material.iron);
  	    PEUstateexchange.setBlockName("PEUstateexchange");
  	    PEUstateexchange.setBlockTextureName("phtc2:PEUstateexchange");
  	    PEUstateexchange.setHardness(2.0f);
  	    PEUstateexchange.setHarvestLevel("pickaxe", 1);
  	    PEUstateexchange.setStepSound(Block.soundTypeMetal);
  	    PEUstateexchange.setCreativeTab(phantomcraft2.tabPHTC2);
  	    GameRegistry.registerBlock(PEUstateexchange, "PEUstateexchange");
  	    GameRegistry.registerTileEntity(rtTEPEUSE.class, "TEPEUSE");
  	    
  	    PEUASolar=new blockPEUAdvSolar(Material.iron);
    	PEUASolar.setBlockName("PEUASolar");
    	PEUASolar.setBlockTextureName("phtc2:PEUASolar");
    	PEUASolar.setHardness(2.0f);
  	    PEUASolar.setHarvestLevel("pickaxe", 1);
  	    PEUASolar.setStepSound(Block.soundTypeMetal);
     	PEUASolar.setCreativeTab(phantomcraft2.tabPHTC2);
  	    GameRegistry.registerBlock(PEUASolar, "PEUASolar");
  	    GameRegistry.registerTileEntity(rtTEASPEU.class, "TEAPEUSolar");
  	    
  	    PEUAStorage=new blockAPEUStorage(Material.iron);
    	PEUAStorage.setBlockName("PEUAStorage");
    	PEUAStorage.setBlockTextureName("phtc2:PEUAStorage");
    	PEUAStorage.setHardness(2.0f);
    	PEUAStorage.setHarvestLevel("pickaxe", 1);
  	    PEUAStorage.setStepSound(Block.soundTypeMetal);
  	    PEUAStorage.setCreativeTab(phantomcraft2.tabPHTC2);
  	    GameRegistry.registerBlock(PEUAStorage, "PEUAStorage");
  	    GameRegistry.registerTileEntity(rtTEAPEUStorage.class, "TEAPEUStorage");
  	    
  	    CustomTable=new blockCustomTable(Material.iron);
     	CustomTable.setBlockName("CustomTable");
     	CustomTable.setBlockTextureName("phtc2:CustomTable");
    	CustomTable.setHardness(2.0f);
    	CustomTable.setHarvestLevel("pickaxe", 1);
    	CustomTable.setStepSound(Block.soundTypeMetal);
    	CustomTable.setCreativeTab(phantomcraft2.tabPHTC2);
  	    GameRegistry.registerBlock(CustomTable, "CustomTable");
  	    GameRegistry.registerTileEntity(rtTECustomTable.class, "TECustomTable");
  	    
  	    reCustomTable=new blockRECT(Material.iron);
  	    reCustomTable.setBlockName("reCustomTable");
  	    reCustomTable.setBlockTextureName("phtc2:reCustomTable");
  	    reCustomTable.setHardness(2.0f);
  	    reCustomTable.setHarvestLevel("pickaxe", 1);
  	    reCustomTable.setStepSound(Block.soundTypeMetal);
  	    reCustomTable.setCreativeTab(phantomcraft2.tabPHTC2);
	    GameRegistry.registerBlock(reCustomTable, "reCustomTable");
	    GameRegistry.registerTileEntity(rtTERECT.class, "TERECT");
	    
	    PEURecycle=new blockRecycle(Material.iron);
	    PEURecycle.setBlockName("PEURecycle");
	    PEURecycle.setBlockTextureName("phtc2:PEURecycle");
	    PEURecycle.setHardness(2.0f);
	    PEURecycle.setHarvestLevel("pickaxe", 1);
	    PEURecycle.setStepSound(Block.soundTypeMetal);
	    PEURecycle.setCreativeTab(phantomcraft2.tabPHTC2);
  	    GameRegistry.registerBlock(PEURecycle, "PEURecycle");
  	    GameRegistry.registerTileEntity(rtTERecycle.class, "TERecycle");
  	    
      }
     public static void meterialsmelting(){
       GameRegistry.addSmelting(energyore, new ItemStack(ItemsRegister.energydust), 0.5f);
       GameRegistry.addSmelting(normalore, new ItemStack(ItemsRegister.normalingot), 0.5f);
     }
     public static void onRecipeReg(){
       GameRegistry.addRecipe(new ItemStack(BlocksRegister.stateexchange, 1), 
    	 new Object[] {"ACA", "BDB", "ABA", 
    	 'A', Items.iron_ingot, 'B', ItemsRegister.energydust,'C',itemeport.eport_input,'D',itemeport.eport_output}); 
       GameRegistry.addRecipe(new ItemStack(BlocksRegister.energyproduce, 1), 
    	 new Object[] {"ACA", "BDB", "ABA", 
    	 'A', Items.iron_ingot, 'B', ItemsRegister.energydust,'C',itemeport.eport_output,'D',itemeport.eport_save});
       GameRegistry.addRecipe(new ItemStack(BlocksRegister.PEUfurnace, 1), 
    	 new Object[] {"ACA", "BDB", "ABA", 
    	 'A', ItemsRegister.normalingot, 'B', Items.iron_ingot,'D',Blocks.furnace,'C',itemeport.eport_input});  
       GameRegistry.addRecipe(new ItemStack(BlocksRegister.PEUStorage, 1), 
    	 new Object[] {"ACA", "CDC", "ACA", 
    	 'A', Items.iron_ingot, 'C',itemeport.eport_save,'D',Items.diamond}); 
       GameRegistry.addRecipe(new ItemStack(BlocksRegister.PEUSolar, 1), 
    	 new Object[] {"XXX", "ABA", "CDC", 
    	 'X', Blocks.glass, 'A',Items.coal,'B',itemeport.eport_enrich,'C',ItemsRegister.ph_advdust,'D',BlocksRegister.energyproduce}); 
       GameRegistry.addRecipe(new ItemStack(BlocksRegister.PEUstateexchange, 1), 
    	 new Object[] {"ABA", "CXC", "ABA", 
    	 'A', Items.iron_ingot, 'C',itemeport.eport_storage,'B',itemeport.eport_enrich,'X',BlocksRegister.stateexchange});     
       GameRegistry.addRecipe(new ItemStack(BlocksRegister.PEUASolar, 1), 
    	 new Object[] {"CDC", "ABA", "CDC", 
    	 'C', ItemsRegister.ph_advingot, 'A',itemeport.eport_storage,'B',itemeport.eport_enrich,'D',BlocksRegister.PEUSolar});
       GameRegistry.addRecipe(new ItemStack(BlocksRegister.PEUAStorage, 1), 
    	 new Object[] {"ACA", "EDE", "ACA", 
    	 'A', ItemsRegister.ph_advingot, 'C',itemeport.eport_storage,'D',BlocksRegister.PEUStorage,'E',itemeport.eport_enrich}); 
       GameRegistry.addRecipe(new ItemStack(BlocksRegister.CustomTable, 1), 
    	 new Object[] {"ACA", "DXD", "ACA", 
    	 'A', Items.iron_ingot, 'C',itemeport.eport_input,'X',ItemCustomManager.customitem,'D',itemeport.eport_output}); 
       GameRegistry.addRecipe(new ItemStack(BlocksRegister.reCustomTable, 1), 
    	 new Object[] {"ACA", "D D", "ACA", 
    	 'A', Items.iron_ingot, 'C',itemeport.eport_input,'D',itemeport.eport_output}); 
       GameRegistry.addRecipe(new ItemStack(BlocksRegister.PEURecycle, 1), 
    	    	 new Object[] {"ACA", "CXC", "ACA", 
    	    	 'A', Items.iron_ingot, 'C',itemeport.eport_input,'X',itemeport.eport_enrich}); 
     
     }
}
