package net.lrsoft.phantomcraft2;

import org.lwjgl.opengl.Display;

import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.MinecraftException;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartEvent;
import net.minecraftforge.event.entity.minecart.MinecartUpdateEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid=phantomcraft2.MODID,name=phantomcraft2.MODNAME, version=phantomcraft2.VERSION)
public class phantomcraft2 {
public static final String MODID="phtc2";	
public static final String MODNAME="Phantom Craft 2";	
public static final String VERSION="Zeta v1.0.1";	
public static final String INFO="Powered by LT_lrsoft";
@Mod.Instance(phantomcraft2.MODID)
public static phantomcraft2 instance;
@SidedProxy(clientSide = "net.lrsoft.phantomcraft2.ClientProxy",serverSide = "net.lrsoft.phantomcraft2.CommonProxy")
public static CommonProxy proxy; 
public static final CreativeTabs tabPHTC2 = new CreativeTabs("tabPHTC2"){
    @Override 
    public Item getTabIconItem() {
        return ItemsRegister.ph_advbattery;
    }
};
@EventHandler
public void preInit(FMLPreInitializationEvent event)
{
    proxy.preInit(event);
    NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
}

@EventHandler
public void init(FMLInitializationEvent event)
{
    proxy.init(event);
}

@EventHandler
public void postInit(FMLPostInitializationEvent event)
{
    proxy.postInit(event);
}
}   

