package net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU;

import java.util.List;

import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPEUShield extends Item{
	 @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List information, boolean advancedTooltip)
	{
		//  NBTTagCompound tag = new NBTTagCompound();
       try{
		  int a=itemStack.stackTagCompound.getInteger("storedPEU");
		  information.add("Stored PEU "+a+"/"+itemPEUList.PEUshieid);
		  if(a>itemPEUList.PEUshieid) itemStack.stackTagCompound.setInteger("storedPEU",itemPEUList.PEUshieid);
       }catch(Exception e){}
    }
	 public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean par5){
		 int k=0;
		float a= world.getPlayerEntityByName(entity.getCommandSenderName()).getHealth();
		try{
			k=itemStack.stackTagCompound.getInteger("storedPEU");
	       }catch(Exception e){}
		 if (a<20&&a+0.5f<20.0f&&k-5>=0){
			 a=a+0.5f;
			 world.getPlayerEntityByName(entity.getCommandSenderName()).setHealth(a);
			 k=k-5;
			 itemStack.stackTagCompound.setInteger("storedPEU",k);
		 }
	 }
}
