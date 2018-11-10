package net.lrsoft.phantomcraft2.guis;

import cpw.mods.fml.common.registry.GameRegistry;
import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class rtTEStateExchange extends TileEntity implements IInventory {
    public int tableExchangeTime = 0;
    public int maxExchangeTime = 0;
	private ItemStack stack[] = new ItemStack[3];
		@Override
		public void updateEntity() {
			super.updateEntity();
			if(!this.worldObj.isRemote)
			    // 判断燃烧时间
				if (tableExchangeTime > 0) {
					// 取得更换的物品
					ItemStack repairItem = getStackInSlot(0);
					// 取得更换后的物品
					ItemStack outputItem = getStackInSlot(1);
					// 确定开始修复的条件之一：更换物品槽不为空
					if (repairItem != null) {
						// 判断物品
						   if (repairItem.getItem() == ItemsRegister.normalingot){
							if(outputItem == null){
								setInventorySlotContents(1, new ItemStack(ItemsRegister.ph_advingot));
								if(repairItem.stackSize-1>0){
									repairItem.stackSize--;
								}else{
									setInventorySlotContents(0, null);
								}								
								tableExchangeTime= tableExchangeTime-100;
							}else if(outputItem.getItem()==ItemsRegister.ph_advingot && outputItem.stackSize+1<=64){  
								outputItem.stackSize++;
								if(repairItem.stackSize-1>0){
									repairItem.stackSize--;
								}else{
									setInventorySlotContents(0, null);
								}								
								tableExchangeTime= tableExchangeTime-100;
								
						   }
					}else if(repairItem.getItem() == ItemsRegister.energydust){
							if(outputItem == null){
								setInventorySlotContents(1, new ItemStack(ItemsRegister.ph_advdust));
								if(repairItem.stackSize-1>0){
									repairItem.stackSize--;
								}else{
									setInventorySlotContents(0, null);
								}								
								tableExchangeTime= tableExchangeTime-100;
							}else if(outputItem.getItem()==ItemsRegister.ph_advdust && outputItem.stackSize+1<=64){  
								outputItem.stackSize++;
								if(repairItem.stackSize-1>0){
									repairItem.stackSize--;
								}else{
									setInventorySlotContents(0, null);
								}								
								tableExchangeTime= tableExchangeTime-100;
						   }
					}
			      }
					// 减少燃烧时间
					
				} else // 没有燃料的情况下
				{
					// 如果有被修复的物品
					if (getStackInSlot(0) != null) {
						// 取得燃料槽的物品
						ItemStack burnItem = getStackInSlot(2);
						// 取得物品的燃烧值
						int getExchangeTime = getItemExchangeTime(burnItem);
						// 判断物品是否能燃烧
						if (getExchangeTime > 0) {
							maxExchangeTime = getExchangeTime;
							tableExchangeTime = getExchangeTime+tableExchangeTime;		
								// 其他物品就减少
								if (burnItem.stackSize - 1 > 0) {
									burnItem.stackSize--;
									setInventorySlotContents(2, burnItem);
								} else {
									setInventorySlotContents(2, null);
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
		        this.tableExchangeTime = par1NBTTagCompound.getShort("tableExchangeTime");
		        this.maxExchangeTime = par1NBTTagCompound.getShort("maxExchangeTime");
		    }

		    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
		    {
		        super.writeToNBT(par1NBTTagCompound);
		        par1NBTTagCompound.setShort("tableExchangeTime", (short)this.tableExchangeTime);
		        par1NBTTagCompound.setShort("maxExchangeTime", (short)this.maxExchangeTime);
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
		    
		    public static int getItemExchangeTime(ItemStack p_145952_0_)
		    {
		        if (p_145952_0_ == null)
		        {
		            return 0;
		        }
		        else
		        {
		            Item item = p_145952_0_.getItem();
		            if (item == ItemsRegister.energydust) return 40;
		            if (item == ItemsRegister.ph_advdust) return 80;
		            if (item == ItemsRegister.normalingot) return 5;
		            if (item == ItemsRegister.ph_advingot) return 20;
		            if (item == Items.redstone) return 5;
		            return GameRegistry.getFuelValue(p_145952_0_);
		        }
		    }
		}

