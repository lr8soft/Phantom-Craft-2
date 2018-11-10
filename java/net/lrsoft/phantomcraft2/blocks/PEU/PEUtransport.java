package net.lrsoft.phantomcraft2.blocks.PEU;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.blocks.blockstateexchange;
import net.lrsoft.phantomcraft2.guis.rtTEPEUSE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.common.util.ForgeDirection;
import static net.minecraftforge.common.util.ForgeDirection.*;

public class PEUtransport extends BlockContainer{
	protected PEUtransport(Material material) {
		super(material);
	}
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new rtTEtransport();
	}
/*	 public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	  {
		 int temp = world.getBlockMetadata(x, y, z);
		 TileEntity te = world.getTileEntity(x, y, z);
		 if(te!=null){
			 setBlockBounds(0.5F, 0.5F, 0.5F, 0.75F, 0.75F, 0.75F);
		 }
	  }*/
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        int l = p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_);
        this.func_150043_b(l);
    }
    private void func_150043_b(int p_150043_1_)
    {
        int j = p_150043_1_ & 7;
        boolean flag = (p_150043_1_ & 8) > 0;
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.1875F;
        float f3 = 0.125F;

        if (flag)
        {
            f3 = 0.0625F;
        }

        if (j == 1)
        {
            this.setBlockBounds(0.0F, f, 0.75F - f2, f3, f1, 0.75F + f2);
        }
        else if (j == 2)
        {
            this.setBlockBounds(1.0F - f3, f, 0.75F - f2, 1.0F, f1, 0.75F + f2);
        }
        else if (j == 3)
        {
            this.setBlockBounds(0.75F - f2, f, 0.0F, 0.75F + f2, f1, f3);
        }
        else if (j == 4)
        {
            this.setBlockBounds(0.75F - f2, f, 1.0F - f3, 0.75F + f2, f1, 1.0F);
        }
    }

	    public boolean isOpaqueCube()
	    {
	        return false;
	    }
	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
	    public void setBlockBoundsForItemRender()
	    {
	        float f = 0.1875F;
	        float f1 = 0.125F;
	        float f2 = 0.125F;
	        this.setBlockBounds(0.5F - f, 0.5F - f1, 0.5F - f2, 0.75F, 0.75F, 0.75F);
	    }
	    
	    public boolean canPlaceBlockOnSide(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_)
	    {
	        ForgeDirection dir = ForgeDirection.getOrientation(p_149707_5_);
	        return (dir == NORTH && p_149707_1_.isSideSolid(p_149707_2_, p_149707_3_, p_149707_4_ + 1, NORTH)) ||
	               (dir == SOUTH && p_149707_1_.isSideSolid(p_149707_2_, p_149707_3_, p_149707_4_ - 1, SOUTH)) ||
	               (dir == WEST  && p_149707_1_.isSideSolid(p_149707_2_ + 1, p_149707_3_, p_149707_4_, WEST)) ||
	               (dir == EAST  && p_149707_1_.isSideSolid(p_149707_2_ - 1, p_149707_3_, p_149707_4_, EAST));
	    }
	    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
	    {
	        return (p_149742_1_.isSideSolid(p_149742_2_ - 1, p_149742_3_, p_149742_4_, EAST)) ||
	               (p_149742_1_.isSideSolid(p_149742_2_ + 1, p_149742_3_, p_149742_4_, WEST)) ||
	               (p_149742_1_.isSideSolid(p_149742_2_, p_149742_3_, p_149742_4_ - 1, SOUTH)) ||
	               (p_149742_1_.isSideSolid(p_149742_2_, p_149742_3_, p_149742_4_ + 1, NORTH));
	    }
	    public int onBlockPlaced(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_)
	    {
	        int j1 = p_149660_1_.getBlockMetadata(p_149660_2_, p_149660_3_, p_149660_4_);
	        int k1 = j1 & 8;
	        j1 &= 7;

	        ForgeDirection dir = ForgeDirection.getOrientation(p_149660_5_);

	        if (dir == NORTH && p_149660_1_.isSideSolid(p_149660_2_, p_149660_3_, p_149660_4_ + 1, NORTH))
	        {
	            j1 = 4;
	        }
	        else if (dir == SOUTH && p_149660_1_.isSideSolid(p_149660_2_, p_149660_3_, p_149660_4_ - 1, SOUTH))
	        {
	            j1 = 3;
	        }
	        else if (dir == WEST && p_149660_1_.isSideSolid(p_149660_2_ + 1, p_149660_3_, p_149660_4_, WEST))
	        {
	            j1 = 2;
	        }
	        else if (dir == EAST && p_149660_1_.isSideSolid(p_149660_2_ - 1, p_149660_3_, p_149660_4_, EAST))
	        {
	            j1 = 1;
	        }
	        else
	        {
	            j1 = this.getBedDirection(p_149660_1_, p_149660_2_, p_149660_3_, p_149660_4_);
	        }

	        return j1 + k1;
	    }
	    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
	    {
	        if (this.canBlockStay(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_));
	        {
	            int l = p_149695_1_.getBlockMetadata(p_149695_2_, p_149695_3_, p_149695_4_) & 7;
	            boolean flag = false;

	            if (!p_149695_1_.isSideSolid(p_149695_2_ - 1, p_149695_3_, p_149695_4_, EAST) && l == 1)
	            {
	                flag = true;
	            }

	            if (!p_149695_1_.isSideSolid(p_149695_2_ + 1, p_149695_3_, p_149695_4_, WEST) && l == 2)
	            {
	                flag = true;
	            }

	            if (!p_149695_1_.isSideSolid(p_149695_2_, p_149695_3_, p_149695_4_ - 1, SOUTH) && l == 3)
	            {
	                flag = true;
	            }

	            if (!p_149695_1_.isSideSolid(p_149695_2_, p_149695_3_, p_149695_4_ + 1, NORTH) && l == 4)
	            {
	                flag = true;
	            }

	            if (flag)
	            {
	                this.dropBlockAsItem(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.getBlockMetadata(p_149695_2_, p_149695_3_, p_149695_4_), 0);
	                p_149695_1_.setBlockToAir(p_149695_2_, p_149695_3_, p_149695_4_);
	            }
	        }
	    }



}
