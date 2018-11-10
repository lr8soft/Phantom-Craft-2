package net.lrsoft.phantomcraft2.blocks;

import java.util.Random;

import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

	public class blocks extends Block{
		protected blocks(Material material) {
			super(material);
		}
	    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	    {
	    	if(this==BlocksRegister.energyore){
	    		
	    		return ItemsRegister.energydust;
	    	}else{
	    	return Item.getItemFromBlock(this);
	    	}
	    }
	    private Random rand = new Random();
	    @Override
	    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
	    {
	        if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item.getItemFromBlock(this))
	        {
	            int j1 = 0;
	            if (this == BlocksRegister.energyore)
	            {
	                j1 = MathHelper.getRandomIntegerInRange(rand, 2, 6);
	            }
	            return j1;
	        }
	        return 0;
	    }
	    public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_)
	    {
	        if (p_149679_1_ > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, p_149679_2_, p_149679_1_))
	        {
	            int j = p_149679_2_.nextInt(p_149679_1_ + 2) - 1;

	            if (j < 0)
	            {
	                j = 0;
	            }

	            return this.quantityDropped(p_149679_2_) * (j + 1);
	        }
	        else
	        {
	            return this.quantityDropped(p_149679_2_);
	        }
	    }



}
