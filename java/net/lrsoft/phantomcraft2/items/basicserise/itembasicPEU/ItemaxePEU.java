package net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU;

import java.util.List;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemaxePEU extends ItemAxe{
	 public ItemaxePEU(String unlocalizedName, ToolMaterial material){
		 super(material);
	     this.setUnlocalizedName("PEUaxe");
	     this.setTextureName("phtc2:PEUaxe");
	     this.setCreativeTab(phantomcraft2.tabPHTC2);
	 }
	  @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List information, boolean advancedTooltip)
	{
		//  NBTTagCompound tag = new NBTTagCompound();
      try{
		  int a=itemStack.stackTagCompound.getInteger("storedPEU");
		  information.add("Stored PEU "+a+"/"+itemPEUList.PEUaxe);
		  if(a>itemPEUList.PEUaxe) itemStack.stackTagCompound.setInteger("storedPEU",itemPEUList.PEUaxe);
      }catch(Exception e){

      }
	}
	  @Override
	  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		  if(!world.isRemote){
		     try{
			   if(itemStack.stackTagCompound.getInteger("storedPEU")-20>=0){ 
			      player.addPotionEffect(new PotionEffect(Potion.heal.getId(),50));
			      itemStack.stackTagCompound.setInteger("storedPEU",itemStack.stackTagCompound.getInteger("storedPEU")-20);
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
