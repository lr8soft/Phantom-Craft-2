package net.lrsoft.phantomcraft2.guis;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class rtTEPEUFurnace extends TileEntity implements IInventory {
	
    public int tablePEU = 0;
    public int maxPEU = 1000;
    public int transportSPEED=50;
	private ItemStack stack[] = new ItemStack[3];
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		//System.out.println("Hello GUI");
		if(!this.worldObj.isRemote){
	    // 判断燃烧时间
			ItemStack inputItem = getStackInSlot(0);
			ItemStack outputItem = getStackInSlot(1);
			ItemStack PEUItem = getStackInSlot(2);
			if(tablePEU-10>0){
              if(inputItem!=null && FurnaceRecipes.smelting().getSmeltingResult(inputItem)!=null){
            	  if(inputItem.stackSize-1>0){
           		     if(outputItem==null){
           		        setInventorySlotContents(1, FurnaceRecipes.smelting().getSmeltingResult(inputItem));
           		        inputItem.stackSize--;
           		     }else if(outputItem.getItem()==FurnaceRecipes.smelting().getSmeltingResult(inputItem).getItem()){
           		    	outputItem.stackSize++;
           		    	inputItem.stackSize--;
           		     }
           		     tablePEU=tablePEU-10;
            	  }else if(inputItem.stackSize-1==0){
            		  setInventorySlotContents(0, null);
            		  if(outputItem==null){
                		 setInventorySlotContents(1, FurnaceRecipes.smelting().getSmeltingResult(inputItem));
                		 
                	  }else if(outputItem.getItem()==FurnaceRecipes.smelting().getSmeltingResult(inputItem).getItem()){
                		 outputItem.stackSize++;
                	  }
            		  tablePEU=tablePEU-10;
            	  }
            //	  System.out.println(FurnaceRecipes.smelting().getSmeltingResult(inputItem).getDisplayName());
              }
			}else if(PEUItem!=null)	{
				try{
				PEUItem.stackTagCompound.getInteger("storedPEU");
				}catch (Exception e){
					 NBTTagCompound tag = new NBTTagCompound();
					 PEUItem.setTagCompound(tag);
					 tag.setInteger("storedPEU", 0);
			    }
                if(PEUItem.stackTagCompound.getInteger("storedPEU")>0){
                	if(PEUItem.stackTagCompound.getInteger("storedPEU")-50>0){
                		tablePEU=tablePEU+50;
                		PEUItem.stackTagCompound.setInteger("storedPEU",PEUItem.stackTagCompound.getInteger("storedPEU")-50);
                	}else{
                		tablePEU=tablePEU+PEUItem.stackTagCompound.getInteger("storedPEU");
                		PEUItem.stackTagCompound.setInteger("storedPEU",0);
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

