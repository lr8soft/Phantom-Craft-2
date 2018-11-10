package net.lrsoft.phantomcraft2.guis;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class rtTERecycle extends TileEntity implements IInventory {
    public int tablePEU = 0;
    public int maxPEU = 2000;
    public int tranSPEED=100;
    public int recycleEnergy=0;
	private ItemStack stack[] = new ItemStack[3];
		@Override
		public void updateEntity() {
			super.updateEntity();
			maxPEU = 2000;
			if(!this.worldObj.isRemote){
				ItemStack inputItem = getStackInSlot(0);
				ItemStack outputItem = getStackInSlot(1);
				ItemStack PEUItem=getStackInSlot(2);
				if (PEUItem != null) {
					int a=0;
					try{
					  a=PEUItem.stackTagCompound.getInteger("storedPEU");
					}catch(Exception e){}	
					if(a>0&&tablePEU<maxPEU){
						if(tablePEU+tranSPEED<maxPEU&&a-tranSPEED>=0){
							tablePEU=tablePEU+tranSPEED;
							PEUItem.stackTagCompound.setInteger("storedPEU",a-tranSPEED);
						}else if(tablePEU+tranSPEED<maxPEU&&a-tranSPEED<0){
							tablePEU=tablePEU+a;
							PEUItem.stackTagCompound.setInteger("storedPEU",0);
						}else if(tablePEU+tranSPEED>=maxPEU&&a-tranSPEED>=0){
							PEUItem.stackTagCompound.setInteger("storedPEU",(int) (maxPEU-tablePEU));
							tablePEU=maxPEU;
						}else if(tablePEU+tranSPEED>=maxPEU&&a-tranSPEED<0){
							tablePEU=maxPEU;
							PEUItem.stackTagCompound.setInteger("storedPEU",0);
						}
					}	
				}
				if(inputItem!=null){
				    if(inputItem.getItem().getCreativeTab().equals(phantomcraft2.tabPHTC2)==true&&tablePEU-10>=0){
				     if(inputItem.stackSize-1>0){	
				    	  recycleEnergy=recycleEnergy+10;
				    	  inputItem.stackSize--;
				    	  tablePEU=tablePEU-10;
				      }else if(inputItem.stackSize-1==0){
				    		  setInventorySlotContents(0,null);
					    	  recycleEnergy=recycleEnergy+10;
					    	  tablePEU=tablePEU-10;
				      }
				    } else{
				    	if(inputItem.stackSize-1>0){	
					    	  recycleEnergy=recycleEnergy+2;
					    	  inputItem.stackSize--;
					    	  tablePEU=tablePEU-10;
	    	
					    }else if(inputItem.stackSize-1==0){
					    		  setInventorySlotContents(0,null);
						    	  recycleEnergy=recycleEnergy+2;
						    	  tablePEU=tablePEU-10;
					    }
				    }
				}
				if(recycleEnergy-20>=0){
					if(outputItem==null){
						setInventorySlotContents(1,new ItemStack(ItemsRegister.energydust));
						recycleEnergy=recycleEnergy-20;
					}else if(outputItem.getItem()==ItemsRegister.energydust){
						outputItem.stackSize++;
						recycleEnergy=recycleEnergy-20;
					}
				}
				
			}
					

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
			public ItemStack decrStackSize(int par1, int par2) {
				// TODO Auto-generated method stub
				if (this.stack[par1] != null) {
					ItemStack var3;
					if (this.stack[par1].stackSize <= par2) {
						var3 = this.stack[par1];
						this.stack[par1] = null;
						return var3;
					} else {
						var3 = this.stack[par1].splitStack(par2);
						if (this.stack[par1].stackSize == 0) {
							this.stack[par1] = null;
						}
						return var3;
					}
				} else {
					return null;
				}
			}
			
			@Override
			public ItemStack getStackInSlot(int var1) {
				// TODO Auto-generated method stub
				return stack[var1];
			}
			@Override
			public int getSizeInventory() {
				// TODO Auto-generated method stub
				return stack.length;
			}
			@Override
			public int getInventoryStackLimit() {
				// TODO Auto-generated method stub
				return 64;
			}
			@Override
			public void setInventorySlotContents(int var1, ItemStack var2) {
				// TODO Auto-generated method stub
				stack[var1] = var2;
			}
		    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
		    {
		        super.readFromNBT(par1NBTTagCompound);
		        NBTTagList var2 = par1NBTTagCompound.getTagList("Items", 10);
		        this.stack = new ItemStack[this.getSizeInventory()];
		        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
		        {
		            NBTTagCompound var4 = (NBTTagCompound)var2.getCompoundTagAt(var3);
		            byte var5 = var4.getByte("Slot");
		            if (var5 >= 0 && var5 < this.stack.length)
		            {
		                this.stack[var5] = ItemStack.loadItemStackFromNBT(var4);
		            }
		        }
		        this.tablePEU = par1NBTTagCompound.getShort("tablePEU");
		        this.maxPEU = par1NBTTagCompound.getShort("maxPEU");
		        this.recycleEnergy = par1NBTTagCompound.getShort("recycleEnergy");
		    }

		    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
		    {
		        super.writeToNBT(par1NBTTagCompound);
		        par1NBTTagCompound.setShort("tablePEU", (short) this.tablePEU);
		        par1NBTTagCompound.setShort("maxPEU", (short) this.maxPEU);
		        par1NBTTagCompound.setShort("recycleEnergy", (short) this.recycleEnergy);
		        NBTTagList var2 = new NBTTagList();
		        for (int var3 = 0; var3 < this.stack.length; ++var3)
		        {
		            if (this.stack[var3] != null)
		            {
		                NBTTagCompound var4 = new NBTTagCompound();
		                var4.setByte("Slot", (byte)var3);
		                this.stack[var3].writeToNBT(var4);
		                var2.appendTag(var4);
		            }
		        }
		        par1NBTTagCompound.setTag("Items", var2);
		    }
		    }
