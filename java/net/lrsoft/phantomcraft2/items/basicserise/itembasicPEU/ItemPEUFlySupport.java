package net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU;

import java.util.List;

import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPEUFlySupport extends Item{
	
	  @SideOnly(Side.CLIENT)
	  public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List information, boolean advancedTooltip)
	  {
	    	  information.add("Self-cycling PEU equipment");
	  }
	  public void onUpdate(ItemStack itemStack, World world, Entity player, int slot, boolean par5){   
				if(Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed()&&player.posY<250){
					player.motionY=player.motionY+0.122;
					player.motionX=player.motionX*1.102;
					player.motionZ=player.motionZ*1.102;
				}					
	    player.fallDistance=0;  	 
	  }
}
