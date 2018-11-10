package net.lrsoft.phantomcraft2.blocks;

import java.util.Random;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.guis.rtTEPEUStorage;
import net.lrsoft.phantomcraft2.guis.rtTESPEU;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class blocksolarPEU extends BlockContainer{
	private final Random raaaadom = new Random();

	  @SideOnly(Side.CLIENT)
	  private IIcon iconFront;
	  @SideOnly(Side.CLIENT)
	  private IIcon iconTop;
	
	protected blocksolarPEU(Material material) {
		super(material);
	}
	  public void breakBlock(World world, int x, int y, int z, Block block, int meta)
	  {
	    TileEntity te = world.getTileEntity(x, y, z);
	    if ((te != null) && ((te instanceof rtTESPEU)))
	    {
	    	rtTESPEU solar = (rtTESPEU)te;
	      for (int i = 0; i < solar.getSizeInventory(); i++)
	      {
	        ItemStack stack = solar.getStackInSlot(i);
	        if (stack != null)
	        {
	          float a = (float) (Math.random() * 0.8F + 0.1F);
	          float b = (float) (Math.random() * 0.8F + 0.1F);
	          float c = (float) (Math.random() * 0.8F + 0.1F);
	          while (stack.stackSize > 0)
	          {
	            int d = this.raaaadom.nextInt(21) + 10;
	            if (d > stack.stackSize) {
	              d = stack.stackSize;
	            }
	            stack.stackSize -= d;
	            EntityItem e = new EntityItem(world, x + a, y + b, z + c, new ItemStack(stack.getItem(), d, stack.getItemDamage()));
	            if (stack.hasTagCompound()) {
	              e.getEntityItem().setTagCompound((NBTTagCompound)stack.getTagCompound().copy());
	            }
	            float var15 = 0.05F;
	            e.motionX = ((float)this.raaaadom.nextGaussian() * var15);
	            e.motionY = ((float)this.raaaadom.nextGaussian() * var15 + 0.2F);
	            e.motionZ = ((float)this.raaaadom.nextGaussian() * var15);
	            world.spawnEntityInWorld(e);
	          }
	        }
	      }
	    }
	    super.breakBlock(world, x, y, z, block, meta);
	  }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new rtTESPEU();
	}
@Override
public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int i1, float f1, float f2, float f3)
{
    player.openGui(phantomcraft2.instance, 2018220003, world, i, j, k);
   return true;
}
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister iconRegister)
{
   this.blockIcon = iconRegister.registerIcon("phtc2:SPEU_p1");
   this.iconFront = iconRegister.registerIcon("phtc2:SPEU_p1");
   this.iconTop = iconRegister.registerIcon("phtc2:SPEU_p2");
}
//////public void breakBlock
@SideOnly(Side.CLIENT)
public IIcon getIcon(int side, int metadata)
{
   return side == metadata ? this.iconFront : side == 0 ? this.iconTop : side == 1 ? this.iconTop : (metadata == 0) && (side == 3) ? this.iconFront : this.blockIcon;
}
}