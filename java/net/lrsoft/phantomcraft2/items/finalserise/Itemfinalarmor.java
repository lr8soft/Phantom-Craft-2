package net.lrsoft.phantomcraft2.items.finalserise;

import java.util.List;

import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.items.ItemsRegister;
import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.lrsoft.phantomcraft2.items.basicserise.ItemBasicManager;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicarmor;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU.ItemPEUManager;
import net.lrsoft.phantomcraft2.items.eport.itemeport;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings.GameType;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Itemfinalarmor  extends ItemArmor {
	public String textureName;
    public Itemfinalarmor(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
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
		  information.add("Stored PEU "+a+"/"+itemPEUList.PEUfarmor);
		  if(a>itemPEUList.PEUfarmor) itemStack.stackTagCompound.setInteger("storedPEU",itemPEUList.PEUfarmor);
  }catch(Exception e){}

	}
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
        return "phtc2:textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
   // 	 try{	 
        if (itemStack.getItem().equals(ItemFinalManager.PEUfinalboots)||
            	itemStack.getItem().equals(ItemFinalManager.PEUfinalchestplate)||
            	itemStack.getItem().equals(ItemFinalManager.PEUfinalhelmet)||
            	itemStack.getItem().equals(ItemFinalManager.PEUfinalleggings)){
                try{
          		  int a=itemStack.stackTagCompound.getInteger("storedPEU");
          		  if(a-5>=0 && itemStack.getItemDamage()>0){
          			itemStack.setItemDamage(itemStack.getItemDamage()-1);
          			itemStack.stackTagCompound.setInteger("storedPEU",a-5);
          		  }else{
          		  }
          		  
                }catch(Exception e){
                }
//////////////Repair itself
          if(itemStack.getItem().equals(ItemFinalManager.PEUfinalchestplate)) {
			if(Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed()&&player.posY<250){
				player.motionY=player.motionY+0.122;
				player.motionX=player.motionX*1.102;
				player.motionZ=player.motionZ*1.102;
			}					
            player.fallDistance=0;  
          }
          try{//////////////////Enchantment
     	      itemStack.stackTagCompound.getBoolean("isfirstuse");
       }catch(Exception e){
        try{	  
     	      itemStack.addEnchantment(Enchantment.protection, 3+(int)(Math.random()*6));
     	      itemStack.addEnchantment(Enchantment.unbreaking, 3+(int)(Math.random()*3));
     	      itemStack.stackTagCompound.setBoolean("isfirstuse",false);
     	}catch(Exception p){}
       }
        }
        // }
          
  //   }catch(Exception s){}    
    }
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean par5){

    }
 
    public static void onReg(){
  	  GameRegistry.registerItem(ItemFinalManager.PEUfinalhelmet = new Itemfinalarmor("PEUfinalhelmet", ItemsRegister.PEUfarmor, "PEUfinalarmor", 0), "PEUfinalhelmet");//0 for helmet
  	  GameRegistry.registerItem(ItemFinalManager.PEUfinalchestplate = new Itemfinalarmor("PEUfinalchestplate", ItemsRegister.PEUfarmor, "PEUfinalarmor", 1), "PEUfinalchestplate"); // 1 for chestplate
  	  GameRegistry.registerItem(ItemFinalManager.PEUfinalleggings = new Itemfinalarmor("PEUfinalleggings", ItemsRegister.PEUfarmor, "PEUfinalarmor", 2), "PEUfinalleggings"); // 2 for leggings
  	  GameRegistry.registerItem(ItemFinalManager.PEUfinalboots = new Itemfinalarmor("PEUfinalboots", ItemsRegister.PEUfarmor, "PEUfinalarmor", 3), "PEUfinalboots"); //3 for boot
 
  }
    public static void onRecipeReg(){
    	
        GameRegistry.addRecipe(new ItemStack(ItemFinalManager.PEUfinalhelmet, 1), 
        new Object[] {"A#A", "ABA", "   ", 'A', ItemsRegister.ph_hyperdiamond,'#',itemeport.eport_storage,'B',ItemPEUManager.PEUhelmet});
        
        GameRegistry.addRecipe(new ItemStack(ItemFinalManager.PEUfinalchestplate, 1),
        new Object[] {"#A#", "#B#", "#C#", '#', ItemsRegister.ph_hyperdiamond,'A',itemeport.eport_enrich,'B',ItemPEUManager.PEUchestplate,'C',itemeport.eport_impact});
       
        GameRegistry.addRecipe(new ItemStack(ItemFinalManager.PEUfinalleggings, 1), 
        new Object[] {"#A#", "#B#", "# #", '#', ItemsRegister.ph_hyperdiamond,'A',itemeport.eport_storage,'B',ItemPEUManager.PEUleggings});
       
        GameRegistry.addRecipe(new ItemStack(ItemFinalManager.PEUfinalboots, 1), 
        new Object[] {"   ", "XAX", "XBX", 'X',ItemsRegister.ph_hyperdiamond,'A',itemeport.eport_storage,'B',itemeport.eport_impact});

       }

}
