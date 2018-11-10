package net.lrsoft.phantomcraft2.blocks.PEU;

import java.util.LinkedHashMap;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.sun.prism.Graphics;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU.ItemPEUManager;
import net.lrsoft.phantomcraft2.items.custom.ItemCustomManager;
import net.lrsoft.phantomcraft2.items.finalserise.ItemFinalManager;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.network.ForgeNetworkHandler;
public class rtTEtransport extends TileEntity implements IInventory {
    public int transportSPEED=10;
    public int tablePEU=0;
    public int maxPEU=100;
    public boolean isPEU=false;
    public Short itsPEU=0;
    public static int[] blockpos=new int[] {19,233,666};
    public static final String[] blockname=new String[] {"0null","1null","2null","3null","4null","5null","6null"};
    public static Object laser=null;
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
    {
      return AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord, this.zCoord, this.xCoord + 1, this.yCoord + 1, this.zCoord + 1);
    }
		@Override
		public void updateEntity() {
			super.updateEntity();
			blockpos[0]=this.xCoord;
			blockpos[1]=this.yCoord;
			blockpos[2]=this.zCoord;
			 if(!this.worldObj.isRemote){
			   maxPEU=100;
               blockname[1]=this.worldObj.getBlock(this.xCoord+1, this.yCoord, this.zCoord).getClass().getName();
               blockname[2]=this.worldObj.getBlock(this.xCoord-1, this.yCoord, this.zCoord).getClass().getName();
               blockname[3]=this.worldObj.getBlock(this.xCoord, this.yCoord+1, this.zCoord).getClass().getName();
               blockname[4]=this.worldObj.getBlock(this.xCoord, this.yCoord-1, this.zCoord).getClass().getName();
               blockname[5]=this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord+1).getClass().getName();
               blockname[6]=this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord-1).getClass().getName();
               NBTTagCompound tag=new NBTTagCompound();
        	   TileEntity tile = null;
        	   TileEntity targettile=null;
               for(int i=0; i < 7; i++) {
            	   if(blockname[i]=="net.lrsoft.phantomcraft2.blocks.blocksolarPEU"||
            			   blockname[i]=="net.lrsoft.phantomcraft2.blocks.blockPEUAdvSolar"||
            			   blockname[i]=="net.lrsoft.phantomcraft2.blocks.blockenergyproduce"||
            			   blockname[i]=="net.lrsoft.phantomcraft2.blocks.PEU.PEUtransport"||
            			   blockname[i]=="net.lrsoft.phantomcraft2.blocks.blockAPEUStorage"||
            			   blockname[i]=="net.lrsoft.phantomcraft2.blocks.blockPEUStorage"){
            		   switch(i){
            		   case 1:
            			   tile = this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
            			   break;
            		   case 2:
            			   tile=this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
            			   break;
            		   case 3:
            			   tile=this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord);
            			   break;
            		   case 4:
            			   tile=this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord);
            			   break;
            		   case 5:
            			   tile=this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
            			   break;
            		   case 6:
            			   tile= this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
            			   break;
            		   }
            		   tile.writeToNBT(tag);
            		   itsPEU=tag.getShort("tablePEU");
            		   if(tag.hasKey("tablePEU")==true){
            		     if(tablePEU+transportSPEED<=maxPEU&&itsPEU-transportSPEED>=0){
            			   tablePEU=tablePEU+transportSPEED;
            			   itsPEU=(short) (itsPEU-transportSPEED);
            		     }else if(tablePEU<maxPEU&&tablePEU+transportSPEED>maxPEU&&itsPEU-transportSPEED>=0){
            			   itsPEU=(short) (itsPEU-(maxPEU-tablePEU));
            			   tablePEU=maxPEU;
            		     }
            		     if(tablePEU>maxPEU){
            			   tablePEU=maxPEU;
            		     }
            		     tag.setShort("tablePEU",itsPEU);
            		   }
            		   
            		   long itPEUL=tag.getLong("tablePEUL");
            		   if(tag.hasKey("tablePEUL")==true){
            			  // System.out.println("longtype");
            			   if(tablePEU+transportSPEED<=maxPEU&&itPEUL-transportSPEED>=0){
                			   tablePEU=tablePEU+transportSPEED;
                			   itPEUL=itPEUL-transportSPEED;
                		   }else if(tablePEU<maxPEU&&tablePEU+transportSPEED>maxPEU&&itPEUL-transportSPEED>=0){
                			   itPEUL=itPEUL-(maxPEU-tablePEU);
                			   tablePEU=maxPEU;
                		   }
                		   if(tablePEU>maxPEU){
                			   tablePEU=maxPEU;
                		   }  
                		   tag.setLong("tablePEUL", itPEUL);
            		   }
            		   tile.readFromNBT(tag);
            	   }
               }
              // Block.blockRegistry.getNameForObject(BlockPEUManager.PEUinput);
               int dist=12;
               for (int sx = -dist; sx <= dist; sx++) {
            	      for (int sy = -dist; sy <= dist; sy++) {
            	        for (int sz = -dist; sz <= dist; sz++)
            	        {
            	        	Block temp = this.worldObj.getBlock(this.xCoord+sx,this.yCoord+sy,this.zCoord+sz);
            	        	if(temp.equals(BlockPEUManager.PEUinput)==true){
            	        		int targetPEU,targetMaxPEU;
            	        		NBTTagCompound tgtag=new NBTTagCompound();
            	        		int tx,ty,tz;
            	        		tx=this.xCoord+sx;
            	        		ty=this.yCoord+sy;
            	        		tz=this.zCoord+sz;
            	        		//System.out.println(tx+" "+ty+" "+tz+"  Find it!!!!");
            	        		this.worldObj.getTileEntity(tx, ty, tz).writeToNBT(tgtag);;
            	        		 // int targetPEU=0,targetMaxPEU=0;
                       		   if(tgtag.hasKey("tablePEU")==true){ 
                       		     targetPEU=tgtag.getShort("tablePEU");
                       		     targetMaxPEU=tgtag.getShort("maxPEU");
                       		     if(targetPEU+transportSPEED<=targetMaxPEU&&tablePEU-transportSPEED>=0){
                       			   targetPEU=transportSPEED+targetPEU;
                       			   tablePEU=tablePEU-transportSPEED;
                       		     }
                       		  tgtag.setShort("tablePEU",(short) targetPEU);
                       		this.worldObj.getTileEntity(tx, ty, tz).readFromNBT(tgtag);
            	        	}
                       		
            	        }
            	      }
            	    }
               }
        
           }
		 }
			private Object i(int i) {
			// TODO Auto-generated method stub
			return null;
	     	}

			@Override
			public ItemStack getStackInSlotOnClosing(int var1) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getInventoryName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean hasCustomInventoryName() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isUseableByPlayer(EntityPlayer var1) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void openInventory() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void closeInventory() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean isItemValidForSlot(int var1, ItemStack var2) {
				// TODO Auto-generated method stub
				return false;
			}

			

			@Override
			public int getInventoryStackLimit() {
				// TODO Auto-generated method stub
				return 64;
			}

		    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
		    {
		        super.readFromNBT(par1NBTTagCompound);
		        this.tablePEU = par1NBTTagCompound.getShort("tablePEU");
		        this.maxPEU = par1NBTTagCompound.getShort("maxPEU");
		    }

		    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
		    {
		        super.writeToNBT(par1NBTTagCompound);
		        par1NBTTagCompound.setShort("tablePEU", (short)this.tablePEU);
		        par1NBTTagCompound.setShort("maxPEU", (short)this.maxPEU);
		    }

			@Override
			public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getSizeInventory() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public ItemStack getStackInSlot(int p_70301_1_) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void setInventorySlotContents(int p_70299_1_,
					ItemStack p_70299_2_) {
				// TODO Auto-generated method stub
				
			}
}
