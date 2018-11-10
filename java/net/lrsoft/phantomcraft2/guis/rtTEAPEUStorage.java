package net.lrsoft.phantomcraft2.guis;

import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU.ItemPEUManager;
import net.lrsoft.phantomcraft2.items.custom.ItemCustomManager;
import net.lrsoft.phantomcraft2.items.finalserise.ItemFinalManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class rtTEAPEUStorage extends TileEntity implements IInventory {
    public long tablePEU = 0;
    public long maxPEU = 500000;
    public int transportSPEED=500;
	private ItemStack stack[] = new ItemStack[2];
		@Override
		public void updateEntity() {
			super.updateEntity();
			maxPEU = 500000;
			if (tablePEU<0) tablePEU=-tablePEU;
			 if(!this.worldObj.isRemote){
				ItemStack provideItem = getStackInSlot(0);
				ItemStack PEUItem = getStackInSlot(1);		   
					if(provideItem!=null){
						int a=0;
						try{
						  a=provideItem.stackTagCompound.getInteger("storedPEU");
						}catch(Exception b){
							a=0;
						}
						if(a>0&&tablePEU<maxPEU){
							if(tablePEU+transportSPEED<maxPEU&&a-transportSPEED>=0){
								tablePEU=tablePEU+transportSPEED;
								provideItem.stackTagCompound.setInteger("storedPEU",a-transportSPEED);
							}else if(tablePEU+transportSPEED<maxPEU&&a-transportSPEED<0){
								tablePEU=tablePEU+a;
								provideItem.stackTagCompound.setInteger("storedPEU",0);
							}else if(tablePEU+transportSPEED>=maxPEU&&a-transportSPEED>=0){
								provideItem.stackTagCompound.setInteger("storedPEU",a-transportSPEED);
								tablePEU=maxPEU;
							}else if(tablePEU+transportSPEED>=maxPEU&&a-transportSPEED<0){
								tablePEU=maxPEU;
								provideItem.stackTagCompound.setInteger("storedPEU",0);
							}
						}
					}
				
					if(PEUItem!=null){
					//	PEUItem.setTagCompound(tag);
						int a=0;
						try{
						a=PEUItem.stackTagCompound.getInteger("storedPEU");
						}catch(Exception e){
							 NBTTagCompound tag = new NBTTagCompound();
							 PEUItem.setTagCompound(tag);
							 tag.setInteger("storedPEU", 0);
						}
						if(PEUItem.getItem()==ItemsRegister.ph_basicbattery && a<itemPEUList.basicPEUbattery||
						   PEUItem.getItem()==ItemPEUManager.PEUaxe && a<itemPEUList.PEUaxe||
						   PEUItem.getItem()==ItemPEUManager.PEUpickaxe && a<itemPEUList.PEUpickaxe||
						   PEUItem.getItem()==ItemPEUManager.PEUspade && a<itemPEUList.PEUspade||
						   PEUItem.getItem()==ItemPEUManager.PEUsword && a<itemPEUList.PEUsword||
						   PEUItem.getItem()==ItemsRegister.ph_PEUgun && a<itemPEUList.PEUgun||
						   PEUItem.getItem()==ItemPEUManager.PEUchestplate && a<itemPEUList.PEUarmor||
						   PEUItem.getItem()==ItemPEUManager.PEUhelmet && a<itemPEUList.PEUarmor||
						   PEUItem.getItem()==ItemPEUManager.PEUleggings && a<itemPEUList.PEUarmor||
						   PEUItem.getItem()==ItemPEUManager.PEUboots && a<itemPEUList.PEUarmor||
						   PEUItem.getItem()==ItemFinalManager.PEUfinalsword && a<itemPEUList.PEUfsword||
						   PEUItem.getItem()==ItemFinalManager.PEUfinalpickaxe && a<itemPEUList.PEUfpickaxe||
						   PEUItem.getItem()==ItemFinalManager.PEUfinalchestplate && a<itemPEUList.PEUfarmor||
						   PEUItem.getItem()==ItemFinalManager.PEUfinalhelmet && a<itemPEUList.PEUfarmor||
						   PEUItem.getItem()==ItemFinalManager.PEUfinalleggings && a<itemPEUList.PEUfarmor||
						   PEUItem.getItem()==ItemFinalManager.PEUfinalboots && a<itemPEUList.PEUfarmor||
						   PEUItem.getItem()==ItemsRegister.ph_advbattery && a<itemPEUList.advPEUbattery||
						   PEUItem.getItem()==ItemCustomManager.customitem && a<itemPEUList.PEUcustom||
						   PEUItem.getItem()==ItemsRegister.ph_PEUshield && a<itemPEUList.PEUshieid){
								if(tablePEU-transportSPEED>0){
									PEUItem.stackTagCompound.setInteger("storedPEU", a+transportSPEED);
									tablePEU=tablePEU-transportSPEED;
								}else{
									PEUItem.stackTagCompound.setInteger("storedPEU", (int) (a+tablePEU));
									tablePEU=0;
								}
								//PEUItem.setTagCompound(tag);
							//	System.out.println(a);	
						}
					}
				if (tablePEU<0) tablePEU=-tablePEU;
				
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
}
