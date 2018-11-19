package net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.lrsoft.phantomcraft2.items.basicserise.ItemBasicManager;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicarmor;
import net.lrsoft.phantomcraft2.items.eport.itemeport;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemarmorPEU extends ItemArmor {
	public String textureName;
    public ItemarmorPEU(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
        super(material, 0, type);
        this.textureName = textureName;
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName("phtc2:" + unlocalizedName);
        this.setCreativeTab(phantomcraft2.tabPHTC2);
    }
	  @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List information, boolean advancedTooltip)
	{
		//  NBTTagCompound tag = new NBTTagCompound();
        	try{
		  int a=itemStack.stackTagCompound.getInteger("storedPEU");
		  information.add("Stored PEU "+a+"/"+itemPEUList.PEUarmor);
		  if(a>itemPEUList.PEUarmor) itemStack.stackTagCompound.setInteger("storedPEU",itemPEUList.PEUarmor);
        	}catch(Exception e){}
	}
    	@Override
    	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
       	 return "phtc2:textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
    	}
    	@Override
    	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        	if (itemStack.getItem().equals(ItemPEUManager.PEUboots)||
            		itemStack.getItem().equals(ItemPEUManager.PEUchestplate)||
            		itemStack.getItem().equals(ItemPEUManager.PEUhelmet)||
            		itemStack.getItem().equals(ItemPEUManager.PEUleggings)){
               	 try{
          		  int a=itemStack.stackTagCompound.getInteger("storedPEU");
          		  if(a-5>=0 && itemStack.getItemDamage()>0){
          			itemStack.setItemDamage(itemStack.getItemDamage()-1);
          			itemStack.stackTagCompound.setInteger("storedPEU",a-5);
          		  }else{
          		  }
          		  
                }catch(Exception e){
                }

          }
    	}
    
    public static void onReg(){
    	  GameRegistry.registerItem(ItemPEUManager.PEUhelmet = new ItemarmorPEU("PEUhelmet", ItemsRegister.PEUarmor, "PEUarmor", 0), "PEUhelmet");//0 for helmet
      	  GameRegistry.registerItem(ItemPEUManager.PEUchestplate = new ItemarmorPEU("PEUchestplate", ItemsRegister.PEUarmor, "PEUarmor", 1), "PEUchestplate"); // 1 for chestplate
      	  GameRegistry.registerItem(ItemPEUManager.PEUleggings = new ItemarmorPEU("PEUleggings", ItemsRegister.PEUarmor, "PEUarmor", 2), "PEUleggings"); // 2 for leggings
      	  GameRegistry.registerItem(ItemPEUManager.PEUboots = new ItemarmorPEU("PEUboots", ItemsRegister.PEUarmor, "PEUarmor", 3), "PEUboots"); //3 for boot
    }
    public static void onRecipeReg(){
    	GameRegistry.addRecipe(new ItemStack(ItemPEUManager.PEUhelmet, 1),
    			new Object[] {"#X#", "#A#", "   ", '#', ItemsRegister.ph_advingot,'X',itemeport.eport_save,'A',itemeport.eport_output});
    	GameRegistry.addRecipe(new ItemStack(ItemPEUManager.PEUchestplate, 1), 
    			new Object[] {"# #", "#X#", "###", '#', ItemsRegister.ph_advingot,'X',itemeport.eport_save});
    	GameRegistry.addRecipe(new ItemStack(ItemPEUManager.PEUleggings, 1), 
    			new Object[] {"#X#", "# #", "A A", '#', ItemsRegister.ph_advingot,'X',itemeport.eport_save,'A',itemeport.eport_output});
    	GameRegistry.addRecipe(new ItemStack(ItemPEUManager.PEUboots, 1), 
    			new Object[] {"   ", "X X", "X#X", 'X',ItemsRegister.ph_advingot,'#',itemeport.eport_impact});

    }
    
}
