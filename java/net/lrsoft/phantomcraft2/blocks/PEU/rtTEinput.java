package net.lrsoft.phantomcraft2.blocks.PEU;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.AxisAlignedBB;

public class rtTEinput extends TileEntity implements IInventory {
    public int transportSPEED=10;
    public int tablePEU=0;
    public int maxPEU=10;
    public Short itsPEU=0;
    public boolean isPEUinput=true;
    public static final String[] blockname=new String[] {"0null","1null","2null","3null","4null","5null","6null"};
    
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
    {
      return AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord, this.zCoord, this.xCoord + 1, this.yCoord + 2, this.zCoord + 1);
    }
		@Override
		public void updateEntity() {
			super.updateEntity();
			 if(!this.worldObj.isRemote){
			   maxPEU=30;
			   isPEUinput=true;
               blockname[1]=this.worldObj.getBlock(this.xCoord+1, this.yCoord, this.zCoord).getClass().getName();
               blockname[2]=this.worldObj.getBlock(this.xCoord-1, this.yCoord, this.zCoord).getClass().getName();
               blockname[3]=this.worldObj.getBlock(this.xCoord, this.yCoord+1, this.zCoord).getClass().getName();
               blockname[4]=this.worldObj.getBlock(this.xCoord, this.yCoord-1, this.zCoord).getClass().getName();
               blockname[5]=this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord+1).getClass().getName();
               blockname[6]=this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord-1).getClass().getName();
               NBTTagCompound tag=new NBTTagCompound();
        	   TileEntity tile = null;
        	   TileEntity targettile=null;
               for(int k=0;k<7;k++){
            		   NBTTagCompound targettag=new NBTTagCompound();
            		   switch(k){
            		   case 1:
            			   targettile = this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
            			   break;
            		   case 2:
            			   targettile=this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
            			   break;
            		   case 3:
            			   targettile=this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord);
            			   break;
            		   case 4:
            			   targettile=this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord);
            			   break;
            		   case 5:
            			   targettile=this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
            			   break;
            		   case 6:
            			   targettile= this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
            			   break;
            		   }
            		   
            		   
            		   if(targettile!=null){
            			 targettile.writeToNBT(targettag);
              		     short targetPEU=0,targetMaxPEU=0;
              		   if(targettag.hasKey("tablePEUL")==true){ 
            			   //System.out.println("longtype");
            			   long tPEU,tMPEU;
            			   tPEU=targettag.getLong("tablePEUL");
            			   tMPEU=targettag.getLong("maxPEU");
              		     if(tPEU+transportSPEED<=tMPEU&&tablePEU-transportSPEED>=0){
              		    	tPEU=transportSPEED+tPEU;
              			   tablePEU=tablePEU-transportSPEED;
              		     }
              		     targettag.setLong("tablePEUL", tPEU);
              		     targettile.readFromNBT(targettag);
            		   }
              		   if(targettag.hasKey("tablePEU")==true){ 
              		     targetPEU=targettag.getShort("tablePEU");
              		     targetMaxPEU=targettag.getShort("maxPEU");
              		     if(targetPEU+transportSPEED<=targetMaxPEU&&tablePEU-transportSPEED>=0){
              			   targetPEU=(short) (transportSPEED+targetPEU);
              			   tablePEU=tablePEU-transportSPEED;
              		     }
              		     targettag.setShort("tablePEU",(short) targetPEU);
              		     targettile.readFromNBT(targettag);
              		     
              		   } 
            		  

            		   }
            		   
            		   
            		   
            	   }
			 }
			 }
            public static void getTE(int i,TileEntity targette){
            	
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
		        this.isPEUinput=par1NBTTagCompound.getBoolean("isPEUinput");
		    }

		    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
		    {
		        super.writeToNBT(par1NBTTagCompound);
		        par1NBTTagCompound.setShort("tablePEU", (short)this.tablePEU);
		        par1NBTTagCompound.setShort("maxPEU", (short)this.maxPEU);
		        par1NBTTagCompound.setBoolean("isPEUinput", this.isPEUinput);
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
