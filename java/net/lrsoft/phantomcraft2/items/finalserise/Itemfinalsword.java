package net.lrsoft.phantomcraft2.items.finalserise;

import java.util.List;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Itemfinalsword extends ItemSword{
	  public Itemfinalsword(String unlocalizedName, ToolMaterial material) {
			super(material);
			// TODO Auto-generated constructor stub
	        this.setUnlocalizedName("PEUfsword");
	        this.setTextureName("phtc2:PEUfsword");
	        this.setCreativeTab(phantomcraft2.tabPHTC2);
		}
	  @SideOnly(Side.CLIENT)
	  public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List information, boolean advancedTooltip)
	  {
		//  NBTTagCompound tag = new NBTTagCompound();
      try{
		  int a=itemStack.stackTagCompound.getInteger("storedPEU");
		  information.add("Stored PEU "+a+"/"+itemPEUList.PEUfsword);
		  if(a>itemPEUList.PEUfsword) itemStack.stackTagCompound.setInteger("storedPEU",itemPEUList.PEUfsword);
      }catch(Exception e){
    	//  System.out.println(e);
      }
	  }
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
	        	itemStack.addEnchantment(Enchantment.sharpness, 3+(int)(Math.random()*3));
	        	itemStack.addEnchantment(Enchantment.looting, 2+(int)(Math.random()*2));
	        	itemStack.addEnchantment(Enchantment.unbreaking, 2+(int)(Math.random()*2));
	        	itemStack.stackTagCompound.setBoolean("isfirstuse",false);
	        }
	      
	  }
}
