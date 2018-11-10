package net.lrsoft.phantomcraft2.items.PEU;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.guis.rtTEStateExchange;
import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU.ItemPEUManager;
import net.lrsoft.phantomcraft2.items.custom.ItemCustomManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import java.util.LinkedList;
import java.util.List;

import scala.Console;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class itembasicPEUbattery extends Item {

	  @SideOnly(Side.CLIENT)
	  public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List information, boolean advancedTooltip)
	  {
		//  NBTTagCompound tag = new NBTTagCompound();
          try{
		  int a=itemStack.stackTagCompound.getInteger("storedPEU");
		  information.add("Stored PEU "+a+"/"+itemPEUList.basicPEUbattery);
		  if(a>itemPEUList.basicPEUbattery) itemStack.stackTagCompound.setInteger("storedPEU",itemPEUList.basicPEUbattery);
		  if(a<0) itemStack.stackTagCompound.setInteger("storedPEU",-a);
          }catch(Exception e){
        //	  System.out.println(e);
          }
	  }
	  @Override
	  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
	      String lrsoft="Noob coder,silly method.";
		  try{
		  itemStack.stackTagCompound.getInteger("storedPEU");//检测电池的能量是否报错
		  int a=0;
		  for(int i=0; i < 9; i++) {
			  a=itemStack.stackTagCompound.getInteger("storedPEU");
			  if(player.inventory.getStackInSlot(i)!=null&&a>0){
				    if(player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUaxe||
				    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUboots||
				    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUchestplate||
				    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUhelmet||
				    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUleggings||
				    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUpickaxe||
				    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUspade||
				    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUsword||
				    	player.inventory.getStackInSlot(i).getItem()==ItemsRegister.ph_PEUgun||
				    	player.inventory.getStackInSlot(i).getItem()==ItemCustomManager.customitem||
				    	player.inventory.getStackInSlot(i).getItem()==ItemsRegister.ph_PEUshield){                        
				    	try{//在已经冲过电情况下尝试直接加
				    		if(player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUaxe&&itemPEUList.PEUaxe>player.inventory.getStackInSlot(i).stackTagCompound.getInteger("storedPEU")||
							    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUboots&&itemPEUList.PEUarmor>player.inventory.getStackInSlot(i).stackTagCompound.getInteger("storedPEU")||
							    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUchestplate&&itemPEUList.PEUarmor>player.inventory.getStackInSlot(i).stackTagCompound.getInteger("storedPEU")||
							    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUhelmet&&itemPEUList.PEUarmor>player.inventory.getStackInSlot(i).stackTagCompound.getInteger("storedPEU")||
							    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUleggings&&itemPEUList.PEUarmor>player.inventory.getStackInSlot(i).stackTagCompound.getInteger("storedPEU")||
							    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUpickaxe&&itemPEUList.PEUpickaxe>player.inventory.getStackInSlot(i).stackTagCompound.getInteger("storedPEU")||
							    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUspade&&itemPEUList.PEUspade>player.inventory.getStackInSlot(i).stackTagCompound.getInteger("storedPEU")||
							    	player.inventory.getStackInSlot(i).getItem()==ItemsRegister.ph_PEUgun&&itemPEUList.PEUgun>player.inventory.getStackInSlot(i).stackTagCompound.getInteger("storedPEU")||
							    	player.inventory.getStackInSlot(i).getItem()==ItemPEUManager.PEUsword&&itemPEUList.PEUsword>player.inventory.getStackInSlot(i).stackTagCompound.getInteger("storedPEU")||
							    	player.inventory.getStackInSlot(i).getItem()==ItemCustomManager.customitem&&itemPEUList.PEUcustom>player.inventory.getStackInSlot(i).stackTagCompound.getInteger("storedPEU")||
							    	player.inventory.getStackInSlot(i).getItem()==ItemsRegister.ph_PEUshield&&itemPEUList.PEUshieid>player.inventory.getStackInSlot(i).stackTagCompound.getInteger("storedPEU")){				    		
				    		   player.inventory.getStackInSlot(i).stackTagCompound.setInteger("storedPEU", 
				    			player.inventory.getStackInSlot(i).stackTagCompound.getInteger("storedPEU")+10);
				    		   itemStack.stackTagCompound.setInteger("storedPEU",itemStack.stackTagCompound.getInteger("storedPEU")-10);
				    		   player.addChatMessage(new ChatComponentTranslation("StoredPEU:"+itemStack.stackTagCompound.getInteger("storedPEU")+"/"+itemPEUList.basicPEUbattery));
				    		}
				    	}catch(Exception b){//大胆的尝试失败了
				    		player.inventory.getStackInSlot(i).stackTagCompound.setInteger("storedPEU",10);//直接加
				    		itemStack.stackTagCompound.setInteger("storedPEU",itemStack.stackTagCompound.getInteger("storedPEU")-10);
				        }
				    }    	
			//	System.out.println(i);
			  }
			}
		  }catch(Exception e){
			 // itemStack.stackTagCompound.setInteger("storedPEU",0);
		  }
		return itemStack;
	  }
}
