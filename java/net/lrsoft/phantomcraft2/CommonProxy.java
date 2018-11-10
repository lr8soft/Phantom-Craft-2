package net.lrsoft.phantomcraft2;
import net.lrsoft.phantomcraft2.blocks.BlocksRegister;
import net.lrsoft.phantomcraft2.blocks.PEU.BlockPEUManager;
import net.lrsoft.phantomcraft2.blocks.PEU.PEUtransport;
import net.lrsoft.phantomcraft2.guis.rtCountainerAPEUStorage;
import net.lrsoft.phantomcraft2.guis.rtCountainerASPEU;
import net.lrsoft.phantomcraft2.guis.rtCountainerCustomTable;
import net.lrsoft.phantomcraft2.guis.rtCountainerEnergyProduce;
import net.lrsoft.phantomcraft2.guis.rtCountainerPEUFurnace;
import net.lrsoft.phantomcraft2.guis.rtCountainerPEUSE;
import net.lrsoft.phantomcraft2.guis.rtCountainerPEUStorage;
import net.lrsoft.phantomcraft2.guis.rtCountainerRECT;
import net.lrsoft.phantomcraft2.guis.rtCountainerRecycle;
import net.lrsoft.phantomcraft2.guis.rtCountainerSPEU;
import net.lrsoft.phantomcraft2.guis.rtCountainerStateExchange;
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
import net.lrsoft.phantomcraft2.worldgen.WorldGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler{
	 public void preInit(FMLPreInitializationEvent event)
	    {
		 BlocksRegister.blockregister();//register blocks
		 ItemsRegister.itemsregister();
		 BlocksRegister.meterialsmelting();
		 BlockPEUManager.blockregister();
	    }

     public void init(FMLInitializationEvent event)
     {
	     GameRegistry.registerWorldGenerator(new WorldGenerator(), 0);
	     ItemsRegister.itemsrecipe();
	     BlocksRegister.onRecipeReg();
	     BlockPEUManager.onRecipeReg();
     }

     public void postInit(FMLPostInitializationEvent event)
     {
        
     }
   	@Override 
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{ 
		switch(ID) {
		case 2018216001:
			return new rtCountainerStateExchange(player.inventory, (rtTEStateExchange)player.worldObj.getTileEntity(x, y, z));
		case 2018217001:
			return new rtCountainerEnergyProduce(player.inventory, (rtTEEnergyProduce)player.worldObj.getTileEntity(x, y, z));
		case 2018218001:
			return new rtCountainerPEUFurnace(player.inventory, (rtTEPEUFurnace)player.worldObj.getTileEntity(x, y, z));
		case 2018220002:
			return new rtCountainerPEUStorage(player.inventory, (rtTEPEUStorage)player.worldObj.getTileEntity(x, y, z));
		case 2018220003:
			return new rtCountainerSPEU(player.inventory, (rtTESPEU)player.worldObj.getTileEntity(x, y, z));
		case 2018222001:
			return new rtCountainerPEUSE(player.inventory, (rtTEPEUSE)player.worldObj.getTileEntity(x, y, z));
		case 2018222002:
			return new rtCountainerASPEU(player.inventory, (rtTEASPEU)player.worldObj.getTileEntity(x, y, z));
		case 2018223001:
			return new rtCountainerAPEUStorage(player.inventory, (rtTEAPEUStorage)player.worldObj.getTileEntity(x, y, z));
		case 2018302001:
			return new rtCountainerCustomTable(player.inventory, (rtTECustomTable)player.worldObj.getTileEntity(x, y, z));
		case 2018311001:
			return new rtCountainerRECT(player.inventory, (rtTERECT)player.worldObj.getTileEntity(x, y, z));
		case 2018311002:
			return new rtCountainerRecycle(player.inventory, (rtTERecycle)player.worldObj.getTileEntity(x, y, z));
		}
		return null;
	} 
	@Override 
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{ 
		return null;
	}

}
