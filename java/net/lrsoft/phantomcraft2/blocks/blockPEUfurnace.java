package net.lrsoft.phantomcraft2.blocks;

import java.util.Random;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.guis.rtTEAPEUStorage;
import net.lrsoft.phantomcraft2.guis.rtTEEnergyProduce;
import net.lrsoft.phantomcraft2.guis.rtTEPEUFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class blockPEUfurnace extends BlockContainer{
	  @SideOnly(Side.CLIENT)
	  private IIcon iconFront;
	  @SideOnly(Side.CLIENT)
	  private IIcon iconTop;
	protected blockPEUfurnace(Material material) {
		super(material);
		this.setLightLevel(1.0f);
	}
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new rtTEPEUFurnace();
	}
	private final Random raaaadom = new Random();
	  public void breakBlock(World world, int x, int y, int z, Block block, int meta)
	  {
	    TileEntity te = world.getTileEntity(x, y, z);
	    if ((te != null) && ((te instanceof rtTEPEUFurnace)))
	    {
	    	rtTEPEUFurnace storage = (rtTEPEUFurnace)te;
	      for (int i = 0; i < storage.getSizeInventory(); i++)
	      {
	        ItemStack stack = storage.getStackInSlot(i);
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
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int i1, float f1, float f2, float f3)
    {
        player.openGui(phantomcraft2.instance, 2018218001, world, i, j, k);
       return true;
    }
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
       this.blockIcon = iconRegister.registerIcon("phtc2:PEUf_p1");
       this.iconFront = iconRegister.registerIcon("phtc2:PEUf_p1");
       this.iconTop = iconRegister.registerIcon("phtc2:PEUf_p2");
    }
//////public void breakBlock
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
       return side == metadata ? this.iconFront : side == 0 ? this.iconTop : side == 1 ? this.iconTop : (metadata == 0) && (side == 3) ? this.iconFront : this.blockIcon;
    }
    @Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity){
    	((EntityLivingBase) entity).setFire(3);
    }


}