package net.lrsoft.phantomcraft2.guis;

import java.util.Iterator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class rtCountainerASPEU extends Container {
    private rtTEASPEU tile;
	private long lastTablePEU = 0;
	private long lastMaxPEU = 1000;

    public rtCountainerASPEU(InventoryPlayer par1InventoryPlayer, rtTEASPEU par2TileEntityRepairTable)
    {
    	tile = par2TileEntityRepairTable;
    	
        this.addSlotToContainer(new Slot(par2TileEntityRepairTable, 0, 34, 19));
        int var3;
        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
        }
 }
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void addCraftingToCrafters(ICrafting par1iCrafting) {
		// TODO Auto-generated method stub
		super.addCraftingToCrafters(par1iCrafting);
		par1iCrafting.sendProgressBarUpdate(this, 0,  (int) this.tile.tablePEU);
		par1iCrafting.sendProgressBarUpdate(this, 1, (int) this.tile.maxPEU);
	}
 
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		if (par1 == 0) {
			this.tile.tablePEU = par2;
		}
		if (par1 == 1) {
			this.tile.maxPEU = par2;
		}
	}
 
	@Override
	public void detectAndSendChanges() {
		// TODO Auto-generated method stub
		super.detectAndSendChanges();
		Iterator var1 = this.crafters.iterator();
		while (var1.hasNext()) {
			ICrafting var2 = (ICrafting) var1.next();
 
			if (this.lastTablePEU != this.tile.tablePEU) {
				var2.sendProgressBarUpdate(this, 0, (int) this.tile.tablePEU);
			}
 
			if (this.lastMaxPEU != this.tile.maxPEU) {
				var2.sendProgressBarUpdate(this, 1, (int) this.tile.maxPEU);
			}
		}
		this.lastTablePEU = this.tile.tablePEU;
		this.lastMaxPEU = this.tile.maxPEU;
	}
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack var3 = null;

		return var3;
	}
}
