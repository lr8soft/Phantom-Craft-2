package net.lrsoft.phantomcraft2.guis;

import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class rtTEPEUSE extends TileEntity implements IInventory {
    public long tablePEU = 0;
    public long maxPEU = 50000;
    public int tranSPEED=500;
	private ItemStack stack[] = new ItemStack[3];
		@Override
		public void updateEntity() {
			super.updateEntity();
			maxPEU = 50000;
			if (tablePEU<0) tablePEU=-tablePEU;
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
					if(PEUItem.stackTagCompound.getBoolean("isPEU")==true){
						long k=PEUItem.stackTagCompound.getLong("maxPEU");
						if(PEUItem.stackTagCompound.getLong("storedPEU")<k){
							if(tablePEU-tranSPEED>0){
								PEUItem.stackTagCompound.setLong("storedPEU", a+tranSPEED);
								tablePEU=tablePEU-tranSPEED;
							}else{
								PEUItem.stackTagCompound.setLong("storedPEU", (int) (a+tablePEU));
								tablePEU=0;
							}
						}
					}
				}
				if(inputItem!=null){
				if(inputItem.getItem()==ItemsRegister.energydust){
					if(tablePEU-getItemPEU(inputItem)>=0){
						if(outputItem==null){
						    setInventorySlotContents(1,new ItemStack(ItemsRegister.ph_advdust));
						    tablePEU=tablePEU-getItemPEU(inputItem);
						    if(inputItem.stackSize==1){
						    	 setInventorySlotContents(0,null);	
						    }else{
						    	inputItem.stackSize--;
						    }
						}else if(outputItem.getItem()==ItemsRegister.ph_advdust && outputItem.stackSize+1<=64){
							outputItem.stackSize++;
							tablePEU=tablePEU-getItemPEU(inputItem);
						    if(inputItem.stackSize==1){
						    	 setInventorySlotContents(0,null);	
						    }else{
						    	inputItem.stackSize--;
						    }
						}
					}
				}
				
				if(inputItem.getItem()==ItemsRegister.normalingot){
					if(tablePEU-getItemPEU(inputItem)>=0){
						if(outputItem==null){
						    setInventorySlotContents(1,new ItemStack(ItemsRegister.ph_advingot));
						    tablePEU=tablePEU-getItemPEU(inputItem);
						    if(inputItem.stackSize==1){
						    	 setInventorySlotContents(0,null);	
						    }else{
						    	inputItem.stackSize--;
						    }
						}else if(outputItem.getItem()==ItemsRegister.ph_advingot && outputItem.stackSize+1<=64){
							outputItem.stackSize++;
							tablePEU=tablePEU-getItemPEU(inputItem);
						    if(inputItem.stackSize==1){
						    	 setInventorySlotContents(0,null);	
						    }else{
						    	inputItem.stackSize--;
						    }
						}
					}
				}
				
				if(inputItem.getItem()==Items.diamond){
					if(tablePEU-getItemPEU(inputItem)>=0){
						if(outputItem==null){
						    setInventorySlotContents(1,new ItemStack(ItemsRegister.ph_hyperdiamond));
						    tablePEU=tablePEU-getItemPEU(inputItem);
						    if(inputItem.stackSize==1){
						    	 setInventorySlotContents(0,null);	
						    }else{
						    	inputItem.stackSize--;
						    }
						}else if(outputItem.getItem()==ItemsRegister.ph_hyperdiamond && outputItem.stackSize+1<=64){
							outputItem.stackSize++;
							tablePEU=tablePEU-getItemPEU(inputItem);
						    if(inputItem.stackSize==1){
						    	 setInventorySlotContents(0,null);	
						    }else{
						    	inputItem.stackSize--;
						    }
						}
					}
				}
				
				if(inputItem.getItem()==Items.coal){
					if(tablePEU-getItemPEU(inputItem)>=0){
						if(outputItem==null){
						    setInventorySlotContents(1,new ItemStack(Items.diamond));
						    tablePEU=tablePEU-getItemPEU(inputItem);
						    if(inputItem.stackSize==1){
						    	 setInventorySlotContents(0,null);	
						    }else{
						    	inputItem.stackSize--;
						    }
						}else if(outputItem.getItem()==Items.diamond && outputItem.stackSize+1<=64){
							outputItem.stackSize++;
							tablePEU=tablePEU-getItemPEU(inputItem);
						    if(inputItem.stackSize==1){
						    	 setInventorySlotContents(0,null);	
						    }else{
						    	inputItem.stackSize--;
						    }
						}
					}
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
		        this.tablePEU = par1NBTTagCompound.getLong("tablePEUL");
		        this.maxPEU = par1NBTTagCompound.getLong("maxPEU");
		    }

		    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
		    {
		        super.writeToNBT(par1NBTTagCompound);
		        par1NBTTagCompound.setLong("tablePEUL", this.tablePEU);
		        par1NBTTagCompound.setLong("maxPEU", this.maxPEU);
		        par1NBTTagCompound.setBoolean("longtype", true);
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
		    
		    public static int getItemPEU(ItemStack p_145952_0_)
		    {
		        if (p_145952_0_ == null)
		        {
		            return 0;
		        }
		        else
		        {
		            Item item = p_145952_0_.getItem();
		            if (item == ItemsRegister.energydust) return 600;
		            if (item == ItemsRegister.normalingot) return 600;
		            if (item == Items.diamond) return 20000;
		            if (item == Items.coal) return 10000;
		            return GameRegistry.getFuelValue(p_145952_0_);
		        }
		    }
		}
