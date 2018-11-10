package net.lrsoft.phantomcraft2.items.custom;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.util.ResourceLocation;

public class ItemCustom extends Item{
	  @SideOnly(Side.CLIENT)
	  private IIcon iconzero,iconironsword,iconadvsword,icondiasword,iconphextdiasword;
	  @SideOnly(Side.CLIENT)
	  private IIcon iconironpa,iconadvpa,icondiapa,iconphextpa;
	public ItemCustom(){
        this.setCreativeTab(phantomcraft2.tabPHTC2);
        this.setUnlocalizedName("customtools");
        this.setMaxStackSize(1);
        this.setFull3D();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
	}

	 @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iicon)
    {
    	iconzero=iicon.registerIcon("phtc2:customtool/customtoolszero");
    	iconironsword=iicon.registerIcon("phtc2:customtool/ironsword");
    	iconadvsword=iicon.registerIcon("phtc2:customtool/iconadvsword");
    	icondiasword=iicon.registerIcon("phtc2:customtool/icondiasword");
    	iconphextdiasword = iicon.registerIcon("phtc2:customtool/customtools");
    	//////////////////
    	iconironpa=iicon.registerIcon("phtc2:customtool/iconironpa");
    	iconadvpa=iicon.registerIcon("phtc2:customtool/iconadvpa");
    	icondiapa=iicon.registerIcon("phtc2:customtool/icondiapa");
    	iconphextpa = iicon.registerIcon("phtc2:customtool/iconphextpa");
    }
	 @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int a)
    {
    	if(a==8){
            return this.iconironpa;
        }else if(a==7){
            return this.iconadvpa;
        }else if(a==6){
            return this.icondiapa;
        }else if(a==5){
            return this.iconphextpa;
        }else if(a==4){
          return this.iconphextdiasword;
        }else if(a==3){
          return this.icondiasword;
        }else if(a==2){
          return this.iconadvsword;
        }else if(a==1){
          return this.iconironsword;
        }else{
        	return this.iconzero;
        }
    }
	  @SideOnly(Side.CLIENT)
	  public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List information, boolean advancedTooltip)
	  {
		  int strtime=0;
		  float truedamage;
        try{
		  int a=itemStack.stackTagCompound.getInteger("storedPEU");
		  information.add("Stored PEU "+a+"/"+itemPEUList.PEUcustom);
		  if(a>itemPEUList.PEUcustom) itemStack.stackTagCompound.setInteger("storedPEU",itemPEUList.PEUcustom);
        }catch(Exception e){
			try{
				 NBTTagCompound retag = new NBTTagCompound();
				 itemStack.setTagCompound(retag);
				 retag.setInteger("storedPEU", 0);
			}catch(Exception k){}
        }
		try{
			strtime=itemStack.stackTagCompound.getInteger("strtime");
			information.add("Strengthen time: "+ strtime);
		}catch(Exception d){}
		try{
			int toolaction=itemStack.stackTagCompound.getInteger("toolaction");
			switch(toolaction){
			case 1:
			   information.add("Tool's action: Explosion");
			   break;
			case 2:   
			   information.add("Tool's action: Lightning");
			   break;
			case 3:
			   information.add("Tool's action: Rapidly moving");
			   break;
			}
		}catch(Exception d){}
		  try{
			  float damage=itemStack.stackTagCompound.getFloat("damage");
			  String tooltype=itemStack.stackTagCompound.getString("tooltype");
			  truedamage=damage+strtime;
			  information.add("ToolType: "+tooltype);
			  information.add("+"+truedamage+" attack damage");
		  }catch(Exception b){}
		
	  }

	  public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean par5){
		  String material=null;
		  String tooltype=null;
		  float damage=0; 
		  try{
			  material=itemStack.stackTagCompound.getString("toolmaterial");
		  }catch(Exception b){}
		  try{
			  tooltype=itemStack.stackTagCompound.getString("tooltype");
		  }catch(Exception c){}
		  if(tooltype=="sword"){
		     if(material=="iron"){
			    damage=10.0f;
			    itemStack.setItemDamage(1);
			    itemStack.setStackDisplayName("PEU core Iron sword");
		     }else if(material=="phadv"){
			    damage=15.0f;
			    itemStack.setItemDamage(2);
			    itemStack.setStackDisplayName("PEU core Advanced-Material sword");
		     }else if(material=="phdia"){
			    damage=20.0f;
			    itemStack.setItemDamage(3);
			    itemStack.setStackDisplayName("PEU core Advanced-Diamond sword");
		     }else if(material=="phextdia"){
			    damage=30.0f;		
			    itemStack.setItemDamage(4);
			    itemStack.setStackDisplayName("PEU core Hyper-Excited diamond sword");
		     }else{
		    	damage=4.0f; 
		     }
		     itemStack.stackTagCompound.setFloat("damage", damage);
		  }
		  if(tooltype=="pickaxe"){
			  int harverstlevel=0;
			     if(material=="iron"){
					    itemStack.setItemDamage(8);
					    itemStack.setStackDisplayName("PEU core Iron pickaxe");
				     }else if(material=="phadv"){
					    itemStack.setItemDamage(7);
					    itemStack.setStackDisplayName("PEU core Advanced-Material pickaxe");
				     }else if(material=="phdia"){
					    itemStack.setItemDamage(6);
					    itemStack.setStackDisplayName("PEU core Advanced-Diamond pickaxe");
				     }else if(material=="phextdia"){	
					    itemStack.setItemDamage(5);
					    itemStack.setStackDisplayName("PEU core Hyper-Excited diamond pickaxe");
				     }else{
				    	 harverstlevel=1;
				     }
			     itemStack.stackTagCompound.setFloat("damage", 4.0f);
			     
		  }
	  }
	  public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase player){
		  int storedPEU=0;
		  try{
				 storedPEU=stack.stackTagCompound.getInteger("storedPEU");
		  }catch(Exception e){}
		  if(5<=stack.getItemDamage()&&stack.getItemDamage()<=8){ 
		   if(storedPEU-2>=0){
			 stack.stackTagCompound.setInteger("storedPEU",storedPEU-2);
		   }else{
			player.addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(),100,2));		
		   } 
		  }
		 return true;
		
	  }
	  public float getDigSpeed(ItemStack itemstack, Block block,int metadata){
		  float digspeed=0.0f;
		  int harverstlevel=0;
		  if(5<=itemstack.getItemDamage()&&itemstack.getItemDamage()<=8){
			  switch(itemstack.getItemDamage()){
			  case 5:
				  harverstlevel=4;
				  digspeed=30.0f;
				  break;
			  case 6:
				  harverstlevel=4;
				  digspeed=20.0f;
				  break;
			  case 7:
				  harverstlevel=3;
				  digspeed=14.0f;
				  break;
			  case 8:
				  harverstlevel=2;
				  digspeed=10.0f;
				  break;
			  }
			  itemstack.getItem().setHarvestLevel("pickaxe", harverstlevel);
		  } 
		return digspeed;
	  }
	  
	  public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase source)
	  {
		float damage=1.0f;
		float truedamage;
		int storedPEU=0;
		int strtime=0;
		try{
			damage=stack.stackTagCompound.getFloat("damage");
		}catch(Exception e){}
		try{
			strtime=stack.stackTagCompound.getInteger("strtime");
		}catch(Exception d){}
		try{
			 storedPEU=stack.stackTagCompound.getInteger("storedPEU");
	    }catch(Exception e){}
		truedamage=damage+strtime;
		if(storedPEU-2>=0){
			try{
		      target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)source),damage+(float)strtime);
			}catch(Exception k){
			  target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)source),damage+(float)strtime);	
			}
		  stack.stackTagCompound.setInteger("storedPEU",storedPEU-2);
	    }
	    return true;
	  }
	  
	  
	  @Override
	  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		  String material=null;
		  String tooltype=null;
		  int toolaction=0;
		  int storedPEU=0;
		  try{
			  storedPEU=itemStack.stackTagCompound.getInteger("storedPEU");
		    }catch(Exception e){}
		  try{
			  material=itemStack.stackTagCompound.getString("toolmaterial");
		  }catch(Exception a){}
		  try{
			  tooltype=itemStack.stackTagCompound.getString("tooltype");
		  }catch(Exception b){}
		  try{
			  toolaction=itemStack.stackTagCompound.getInteger("toolaction");
		  }catch(Exception b){}
		//  System.out.println("it work,TYPE:"+toolaction);
		  switch(toolaction){
		  case 1:
			  for(int dist = 2; dist < 16; dist=dist+2){
		            AxisAlignedBB a = player.boundingBox.copy();
		            Vec3 v = player.getLookVec();
		            v = v.normalize();
		            a = a.expand(2.0f, 0.25f, 2.0f);
		            a = a.offset(v.xCoord*(float)dist,v.yCoord*(float)dist,v.zCoord*(float)dist);

		            List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(player,a, null);
		            float distance = 16.0f;
		            for(Entity target : list){
		                float targetdistance = target.getDistanceToEntity(player);
		                if(targetdistance < distance&&storedPEU-10>=0)
		                {
		                	world.createExplosion(player, target.posX, target.posY, target.posZ, 3.0f, false);
		                	itemStack.stackTagCompound.setInteger("storedPEU",storedPEU-10);
		                }
		            }
		        }
			  break;
		   case 2:
				  for(int dist = 2; dist < 16; dist=dist+2){
			            AxisAlignedBB a = player.boundingBox.copy();
			            Vec3 v = player.getLookVec();
			            v = v.normalize();
			            a = a.expand(2.0f, 0.25f, 2.0f);
			            a = a.offset(v.xCoord*(float)dist,v.yCoord*(float)dist,v.zCoord*(float)dist);

			            List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(player,a, null);
			            float distance = 16.0f;
			            for(Entity target : list){
			                float targetdistance = target.getDistanceToEntity(player);
			                if(targetdistance < distance&&storedPEU-10>=0)
			                {
			                	world.addWeatherEffect(new EntityLightningBolt(world,target.posX,target.posY,target.posZ));
			                	itemStack.stackTagCompound.setInteger("storedPEU",storedPEU-10);
			                }
			            }
			        }
				  break;
		   case 3:
		            if(storedPEU-1>=0){
		            	Vec3 v2=player.getLookVec();
		            	v2=v2.normalize();
	                	player.setVelocity(v2.xCoord*2, 0, v2.zCoord*2);
	                	itemStack.stackTagCompound.setInteger("storedPEU",storedPEU-1);
	                }
			   break;
		  }
		  return itemStack;
	  }
}
