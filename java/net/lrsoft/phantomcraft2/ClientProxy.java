package net.lrsoft.phantomcraft2;

import net.lrsoft.phantomcraft2.guis.GuiAPEUStorage;
import net.lrsoft.phantomcraft2.guis.GuiASPEU;
import net.lrsoft.phantomcraft2.guis.GuiCustomTable;
import net.lrsoft.phantomcraft2.guis.GuiEnergyProduce;
import net.lrsoft.phantomcraft2.guis.GuiPEUFurnace;
import net.lrsoft.phantomcraft2.guis.GuiPEUSE;
import net.lrsoft.phantomcraft2.guis.GuiPEUStorage;
import net.lrsoft.phantomcraft2.guis.GuiRECT;
import net.lrsoft.phantomcraft2.guis.GuiRecycle;
import net.lrsoft.phantomcraft2.guis.GuiSPEU;
import net.lrsoft.phantomcraft2.guis.GuiStateExchange;
import net.lrsoft.phantomcraft2.guis.rtCountainerEnergyProduce;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
	    public void preInit(FMLPreInitializationEvent event)
	    {
	        super.preInit(event);
	    }
	public void initializeItemRenderer() {
		
	}
	    @Override
	    public void init(FMLInitializationEvent event)
	    {
	        super.init(event);
	    }
	    @Override
	    public void postInit(FMLPostInitializationEvent event)
	    {
	        super.postInit(event);
	    }
	    @Override
	    public Object getClientGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z)
	    {
			switch(ID) {
			case 2018216001:
				return new GuiStateExchange(player.inventory, (rtTEStateExchange)player.worldObj.getTileEntity(x, y, z));
			case 2018217001:
				return new GuiEnergyProduce(player.inventory, (rtTEEnergyProduce)player.worldObj.getTileEntity(x, y, z));
			case 2018218001:
				return new GuiPEUFurnace(player.inventory, (rtTEPEUFurnace)player.worldObj.getTileEntity(x, y, z));
			case 2018220002:
				return new GuiPEUStorage(player.inventory, (rtTEPEUStorage)player.worldObj.getTileEntity(x, y, z));
			case 2018220003:
				return new GuiSPEU(player.inventory, (rtTESPEU)player.worldObj.getTileEntity(x, y, z));
			case 2018222001:
				return new GuiPEUSE(player.inventory, (rtTEPEUSE)player.worldObj.getTileEntity(x, y, z));
			case 2018222002:
				return new GuiASPEU(player.inventory, (rtTEASPEU)player.worldObj.getTileEntity(x, y, z));
			case 2018223001:
				return new GuiAPEUStorage(player.inventory, (rtTEAPEUStorage)player.worldObj.getTileEntity(x, y, z));
			case 2018302001:
				return new GuiCustomTable(player.inventory, (rtTECustomTable)player.worldObj.getTileEntity(x, y, z));
			case 2018311001:
				return new GuiRECT(player.inventory, (rtTERECT)player.worldObj.getTileEntity(x, y, z));
			case 2018311002:
				return new GuiRecycle(player.inventory, (rtTERecycle)player.worldObj.getTileEntity(x, y, z));
			}
	    	return null;
	    }
}

