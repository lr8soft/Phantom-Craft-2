package net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU;

import java.util.List;

import org.lwjgl.opengl.GL11;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemswordPEU extends ItemSword{
	  public ItemswordPEU(String unlocalizedName, ToolMaterial material) {
			super(material);
			// TODO Auto-generated constructor stub
	        this.setUnlocalizedName("PEUsword");
	        this.setTextureName("phtc2:PEUsword");
	        this.setCreativeTab(phantomcraft2.tabPHTC2);
		}
	  @SideOnly(Side.CLIENT)
	  public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List information, boolean advancedTooltip)
	  {
		//  NBTTagCompound tag = new NBTTagCompound();
        try{
		  int a=itemStack.stackTagCompound.getInteger("storedPEU");
		  information.add("Stored PEU "+a+"/"+itemPEUList.PEUsword);
		  if(a>itemPEUList.PEUsword) itemStack.stackTagCompound.setInteger("storedPEU",itemPEUList.PEUsword);
        }catch(Exception e){}
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
	  /*
	  @SideOnly(Side.CLIENT)
	  public void registerIcons(IIconRegister iconRegister)
	  {
	    this.textures = new IIcon[2];
	    
	    this.textures[0] = iconRegister.registerIcon("phtc2:" + getUnlocalizedName().substring(4) + "." + InternalName.off.name());
	    this.textures[1] = iconRegister.registerIcon("phtc2:" + getUnlocalizedName().substring(4) + "." + InternalName.active.name());
	  
	  Tessellator t = Tessellator.instance; //获取实例
                       		GL11.glTranslated(tx, ty, tz);
                       		GL11.glTranslated(this.xCoord, this.yCoord,this.zCoord);
                       		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f); //光照相关
                            t.startDrawingQuads(); //开始绘制
                            t.setBrightness(15728880); 
                            t.draw();
                            GL11.glEnable(GL11.GL_CULL_FACE);
                            GL11.glEnable(GL11.GL_LIGHTING);
                            GL11.glDisable(GL11.GL_BLEND); 
                            GL11.glPopMatrix();
	  
	  }*/


}
