package net.lrsoft.phantomcraft2.guis;

import net.lrsoft.phantomcraft2.items.custom.ItemCustomManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class rtTERECT extends TileEntity implements IInventory {
    public int tablePEU = 0;
    public int maxPEU = 2000;
    public int transportSPEED=100;
	private ItemStack stack[] = new ItemStack[4];
		@Override
		public void updateEntity() {
			super.updateEntity();
			maxPEU = 2000;
			 if(!this.worldObj.isRemote){
				ItemStack coreItem = getStackInSlot(0);	   
				ItemStack PEUItem = getStackInSlot(1);	 
				ItemStack materialItem = getStackInSlot(2);	
				ItemStack strengthenItem = getStackInSlot(3);
				if(PEUItem!=null){
					int b=0;
					try{
					  b=PEUItem.stackTagCompound.getInteger("storedPEU");
					}catch(Exception e){
						b=0;
					}
					if(b>0&&tablePEU<maxPEU){
						if(tablePEU+transportSPEED<maxPEU&&b-transportSPEED>=0){
							tablePEU=tablePEU+transportSPEED;
							PEUItem.stackTagCompound.setInteger("storedPEU",b-transportSPEED);
						}else if(tablePEU+transportSPEED<maxPEU&&b-transportSPEED<0){
							tablePEU=tablePEU+b;
							PEUItem.stackTagCompound.setInteger("storedPEU",0);
						}else if(tablePEU+transportSPEED>=maxPEU&&b-transportSPEED>=0){
							PEUItem.stackTagCompound.setInteger("storedPEU",b-transportSPEED);
							tablePEU=maxPEU;
						}else if(tablePEU+transportSPEED>=maxPEU&&b-transportSPEED<0){
							tablePEU=maxPEU;
							PEUItem.stackTagCompound.setInteger("storedPEU",0);
						}
					}
				}
				if(coreItem!=null&&materialItem==null){
				  if(coreItem.getItem()==ItemCustomManager.customitem){
					  int itemtype=coreItem.getItem().getDamage(coreItem);
					  System.out.println(itemtype);
					  switch(itemtype){
					  case 1:
						  if(tablePEU-1000>=0&&materialItem==null){
							  tablePEU=tablePEU-1000;
							  setInventorySlotContents(2, new ItemStack(ItemCustomManager.materialiron_part));
							  coreItem.getItem().setDamage(coreItem, 0);
							  coreItem.stackTagCompound.setString("tooltype", "NULL");
						      coreItem.stackTagCompound.setString("toolmaterial", "NULL");
						  }
						  break;
					  case 2:
						  if(tablePEU-1000>=0&&materialItem==null){
							  tablePEU=tablePEU-1000;
							  setInventorySlotContents(2, new ItemStack(ItemCustomManager.materialadv_part));
							  coreItem.getItem().setDamage(coreItem, 0);
							  coreItem.stackTagCompound.setString("tooltype", "NULL");
						      coreItem.stackTagCompound.setString("toolmaterial", "NULL");
						  }
						  break;
					  case 3:
						  if(tablePEU-1000>=0&&materialItem==null){
							  tablePEU=tablePEU-1000;
							  setInventorySlotContents(2, new ItemStack(ItemCustomManager.materialdia_part));
							  coreItem.getItem().setDamage(coreItem, 0);
							  coreItem.stackTagCompound.setString("tooltype", "NULL");
						      coreItem.stackTagCompound.setString("toolmaterial", "NULL");
						  }
						  break;
					  case 4:
						  if(tablePEU-1000>=0&&materialItem==null){
							  tablePEU=tablePEU-1000;
							  setInventorySlotContents(2, new ItemStack(ItemCustomManager.materialextdia_part));
							  coreItem.getItem().setDamage(coreItem, 0);
							  coreItem.stackTagCompound.setString("tooltype", "NULL");
						      coreItem.stackTagCompound.setString("toolmaterial", "NULL");
						  }
						  break;
					  case 5:
						  if(tablePEU-1000>=0&&materialItem==null){
							  tablePEU=tablePEU-1000;
							  setInventorySlotContents(2, new ItemStack(ItemCustomManager.maextdia_part));
							  coreItem.getItem().setDamage(coreItem, 0);
							  coreItem.stackTagCompound.setString("tooltype", "NULL");
						      coreItem.stackTagCompound.setString("toolmaterial", "NULL");
						  }
						  break;
					  case 6:
						  if(tablePEU-1000>=0&&materialItem==null){
							  tablePEU=tablePEU-1000;
							  setInventorySlotContents(2, new ItemStack(ItemCustomManager.madia_part));
							  coreItem.getItem().setDamage(coreItem, 0);
							  coreItem.stackTagCompound.setString("tooltype", "NULL");
						      coreItem.stackTagCompound.setString("toolmaterial", "NULL");
						  }
						  break;
					  case 7:
						  if(tablePEU-1000>=0&&materialItem==null){
							  tablePEU=tablePEU-1000;
							  setInventorySlotContents(2, new ItemStack(ItemCustomManager.madv_part));
							  coreItem.getItem().setDamage(coreItem, 0);
							  coreItem.stackTagCompound.setString("tooltype", "NULL");
						      coreItem.stackTagCompound.setString("toolmaterial", "NULL");
						  }
						  break;
					  case 8:
						  if(tablePEU-1000>=0&&materialItem==null){
							  tablePEU=tablePEU-1000;
							  setInventorySlotContents(2, new ItemStack(ItemCustomManager.miron_part));
							  coreItem.getItem().setDamage(coreItem, 0);
							  coreItem.stackTagCompound.setString("tooltype", "NULL");
						      coreItem.stackTagCompound.setString("toolmaterial", "NULL");
						  }
						  break;
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
		    }

		    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
		    {
		        super.writeToNBT(par1NBTTagCompound);
		        par1NBTTagCompound.setShort("tablePEU", (short)this.tablePEU);
		        par1NBTTagCompound.setShort("maxPEU", (short)this.maxPEU);
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
