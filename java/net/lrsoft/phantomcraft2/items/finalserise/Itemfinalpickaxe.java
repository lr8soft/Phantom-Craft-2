package net.lrsoft.phantomcraft2.items.finalserise;

import java.util.List;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Itemfinalpickaxe extends ItemPickaxe{
    public Itemfinalpickaxe(String unlocalizedName, ToolMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
        this.setUnlocalizedName("PEUfpickaxe");
        this.setTextureName("phtc2:PEUfpickaxe");
        this.setHarvestLevel(unlocalizedName, 3);
        this.setCreativeTab(phantomcraft2.tabPHTC2);
	}
	  @SideOnly(Side.CLIENT)
	  public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List information, boolean advancedTooltip)
	  {
		//  NBTTagCompound tag = new NBTTagCompound();
         try{
	    	  int a=itemStack.stackTagCompound.getInteger("storedPEU");
	    	  information.add("Stored PEU "+a+"/"+itemPEUList.PEUfpickaxe);
	    	  if(a>itemPEUList.PEUfpickaxe) itemStack.stackTagCompound.setInteger("storedPEU",itemPEUList.PEUfpickaxe);
         }catch(Exception e){
    	   //   System.out.println(e);
         }
	  }
/*	  @Override
	  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		  if(!world.isRemote){
		     try{
			   if(itemStack.stackTagCompound.getInteger("storedPEU")-20>=0){ 
			      player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(),200));
			      player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(),200));
			      itemStack.stackTagCompound.setInteger("storedPEU",itemStack.stackTagCompound.getInteger("storedPEU")-50);
			   }
		     }catch(Exception e){
		        System.out.println(e);
		     }
		  }
		return itemStack;
	  }*/
	  public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean par5){
		  int a=0;
	      try{
	    	 a=itemStack.stackTagCompound.getInteger("storedPEU");
	    	 if(a-5>0&&itemStack.getItemDamage()>0){
	    		 itemStack.stackTagCompound.setInteger("storedPEU",a-5);
	    		 itemStack.setItemDamage(itemStack.getItemDamage()-1);
	    	 }
	      }catch(Exception e){}
	      
	       try{//////////////////Enchantment
	        	itemStack.stackTagCompound.getBoolean("isfirstuse");
	        }catch(Exception e){
	        	itemStack.addEnchantment(Enchantment.efficiency, 3+(int)(Math.random()*3));
	        	itemStack.addEnchantment(Enchantment.fortune, 2+(int)(Math.random()*2));
	        	itemStack.addEnchantment(Enchantment.unbreaking, 2+(int)(Math.random()*2));
	        	itemStack.stackTagCompound.setBoolean("isfirstuse",false);
	        }
	      
	  }
}

