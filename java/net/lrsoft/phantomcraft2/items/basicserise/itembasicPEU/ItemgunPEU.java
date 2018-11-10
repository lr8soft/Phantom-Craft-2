package net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU;

import java.util.List;

import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySmallFireball;
public class ItemgunPEU extends Item{
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List information, boolean advancedTooltip)
	{
		//  NBTTagCompound tag = new NBTTagCompound();
       try{
		  int a=itemStack.stackTagCompound.getInteger("storedPEU");
		  information.add("Stored PEU "+a+"/"+itemPEUList.PEUgun);
		  if(a>itemPEUList.PEUgun) itemStack.stackTagCompound.setInteger("storedPEU",itemPEUList.PEUgun);
       }catch(Exception e){

      }
    }
	  @Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		  if(!world.isRemote){
		    try{
		 		int a=itemStack.stackTagCompound.getInteger("storedPEU");
		 		if(a-50>=0){
				   if(player.inventory.consumeInventoryItem(Items.arrow)){
				    	EntityArrow entity=new EntityArrow(world,player,7F);
				    	entity.canBePickedUp=0;
					    world.spawnEntityInWorld(entity);
					    itemStack.damageItem(2, player); 
					    itemStack.stackTagCompound.setInteger("storedPEU",a-50);
					    player.inventory.addItemStackToInventory(new ItemStack(Items.arrow));
				   } 
		 		}
		    }catch(Exception e){

		    }
	      }
		  return itemStack;
      }
	  public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean par5){
		  int a=0;
	      try{
	    	 a=itemStack.stackTagCompound.getInteger("storedPEU");
	    	 if(a-5>0&&itemStack.getItemDamage()>0){
	    		 itemStack.stackTagCompound.setInteger("storedPEU",a-5);
	    		 itemStack.setItemDamage(itemStack.getItemDamage()-1);
	    	 }
	      }catch(Exception e){
	    	 
	      }
	      
	  }
}
