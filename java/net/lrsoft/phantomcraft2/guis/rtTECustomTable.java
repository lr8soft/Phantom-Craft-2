package net.lrsoft.phantomcraft2.guis;

import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU.ItemPEUManager;
import net.lrsoft.phantomcraft2.items.custom.ItemCustomManager;
import net.lrsoft.phantomcraft2.items.finalserise.ItemFinalManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class rtTECustomTable extends TileEntity implements IInventory {
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
				if(coreItem!=null){
				 if(coreItem.getItem()==ItemCustomManager.customitem&&materialItem!=null){
					 if(materialItem.getItem()==ItemCustomManager.materialextdia_part&&tablePEU-2000>=0){
					    try{	 
					     	coreItem.stackTagCompound.setString("tooltype", "sword");
						    coreItem.stackTagCompound.setString("toolmaterial", "phextdia");
						    setInventorySlotContents(2, null);
						    tablePEU=tablePEU-2000;
						}catch(Exception e){
							  NBTTagCompound emg=new NBTTagCompound();
							  coreItem.setTagCompound(emg);
							  emg.setString("tooltype", "sword");
							  emg.setString("toolmaterial", "phextdia");
							  coreItem.setTagCompound(emg);
							  setInventorySlotContents(2, null);
							    tablePEU=tablePEU-2000;
						 } 
					 }else if(materialItem.getItem()==ItemCustomManager.materialadv_part&&tablePEU-1000>=0){
						 try{
							coreItem.stackTagCompound.setString("tooltype", "sword");
							coreItem.stackTagCompound.setString("toolmaterial", "phadv");
							setInventorySlotContents(2, null);
							tablePEU=tablePEU-1000;
						}catch(Exception e){
							NBTTagCompound emg=new NBTTagCompound();
						    coreItem.setTagCompound(emg);
							emg.setString("tooltype", "sword");
							emg.setString("toolmaterial", "phadv");
							coreItem.setTagCompound(emg);
							setInventorySlotContents(2, null);
							tablePEU=tablePEU-1000;
						} 
				     }else if(materialItem.getItem()==ItemCustomManager.materialdia_part&&tablePEU-1500>=0){
				    	 try{
							coreItem.stackTagCompound.setString("tooltype", "sword");
							coreItem.stackTagCompound.setString("toolmaterial", "phdia");
							setInventorySlotContents(2, null);
							tablePEU=tablePEU-1500;
						 }catch(Exception e){
								NBTTagCompound emg=new NBTTagCompound();
							    coreItem.setTagCompound(emg);
								emg.setString("tooltype", "sword");
								emg.setString("toolmaterial", "phdia");
								coreItem.setTagCompound(emg);
								setInventorySlotContents(2, null);
								tablePEU=tablePEU-1500;
						} 
				     }else if(materialItem.getItem()==ItemCustomManager.materialiron_part&&tablePEU-1000>=0){
				    	 try{
							coreItem.stackTagCompound.setString("tooltype", "sword");
							coreItem.stackTagCompound.setString("toolmaterial", "iron");
							setInventorySlotContents(2, null);
							tablePEU=tablePEU-1000;
						 }catch(Exception e){
								NBTTagCompound emg=new NBTTagCompound();
							    coreItem.setTagCompound(emg);
								emg.setString("tooltype", "sword");
								emg.setString("toolmaterial", "iron");
								coreItem.setTagCompound(emg);
								setInventorySlotContents(2, null);
								tablePEU=tablePEU-1000;
						 } 
				     }else if(materialItem.getItem()==ItemCustomManager.maextdia_part&&tablePEU-2000>=0){
					  try{
						coreItem.stackTagCompound.setString("tooltype", "pickaxe");
						coreItem.stackTagCompound.setString("toolmaterial", "phextdia");
						setInventorySlotContents(2, null);
						tablePEU=tablePEU-2000;
					  }catch(Exception e){
						  NBTTagCompound emg=new NBTTagCompound();
						  coreItem.setTagCompound(emg);
						  emg.setString("tooltype", "pickaxe");
						  emg.setString("toolmaterial", "phextdia");
						  coreItem.setTagCompound(emg);
						  setInventorySlotContents(2, null);
							tablePEU=tablePEU-2000;
					  } 
					 }else if(materialItem.getItem()==ItemCustomManager.madv_part&&tablePEU-1000>=0){
						 try{
							coreItem.stackTagCompound.setString("tooltype", "pickaxe");
							coreItem.stackTagCompound.setString("toolmaterial", "phadv");
							setInventorySlotContents(2, null);
							tablePEU=tablePEU-1000;
						}catch(Exception e){
								  NBTTagCompound emg=new NBTTagCompound();
								  coreItem.setTagCompound(emg);
								  emg.setString("tooltype", "pickaxe");
								  emg.setString("toolmaterial", "phadv");
								  coreItem.setTagCompound(emg);
								  setInventorySlotContents(2, null);
								  tablePEU=tablePEU-1000;
					    } 
				     }else if(materialItem.getItem()==ItemCustomManager.madia_part&&tablePEU-1500>=0){
				    	 try{
							coreItem.stackTagCompound.setString("tooltype", "pickaxe");
							coreItem.stackTagCompound.setString("toolmaterial", "phdia");
							setInventorySlotContents(2, null);
							tablePEU=tablePEU-1500;
						 }catch(Exception e){
								  NBTTagCompound emg=new NBTTagCompound();
								  coreItem.setTagCompound(emg);
								  emg.setString("tooltype", "pickaxe");
								  emg.setString("toolmaterial", "phdia");
								  coreItem.setTagCompound(emg);
								  setInventorySlotContents(2, null);
								  tablePEU=tablePEU-1500;
					     } 
				     }else if(materialItem.getItem()==ItemCustomManager.miron_part&&tablePEU-1000>=0){
				    	 try{
							coreItem.stackTagCompound.setString("tooltype", "pickaxe");
							coreItem.stackTagCompound.setString("toolmaterial", "iron");
							setInventorySlotContents(2, null);
							tablePEU=tablePEU-1000;
						 }catch(Exception e){
								  NBTTagCompound emg=new NBTTagCompound();
								  coreItem.setTagCompound(emg);
								  emg.setString("tooltype", "pickaxe");
								  emg.setString("toolmaterial", "iron");
								  coreItem.setTagCompound(emg);
								  setInventorySlotContents(2, null);
								  tablePEU=tablePEU-1000;
					     } 
				     }
				 }
				 if(coreItem.getItem()==ItemCustomManager.customitem&&strengthenItem!=null){
					 if(strengthenItem.getItem()==ItemCustomManager.strengthenitem&&tablePEU-500>=0){
					  int strtime=0;	 
						 try{
							 strtime=coreItem.stackTagCompound.getInteger("strtime");
						 }catch(Exception k){}
						 coreItem.stackTagCompound.setInteger("strtime",strtime+1); 
						 setInventorySlotContents(3, null);
						 tablePEU=tablePEU-500;
					 }else if(strengthenItem.getItem()==ItemCustomManager.explodeitem&&tablePEU-1000>=0){
						 coreItem.stackTagCompound.setInteger("toolaction",1);
						 setInventorySlotContents(3, null);
						 tablePEU=tablePEU-1000;
					 }else if(strengthenItem.getItem()==ItemCustomManager.lightningitem&&tablePEU-800>=0){
						 coreItem.stackTagCompound.setInteger("toolaction",2);
						 setInventorySlotContents(3, null);
						 tablePEU=tablePEU-800;
					 }else if(strengthenItem.getItem()==ItemCustomManager.teloportitem&&tablePEU-500>=0){
						 coreItem.stackTagCompound.setInteger("toolaction",3);
						 setInventorySlotContents(3, null);
						 tablePEU=tablePEU-500;
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
