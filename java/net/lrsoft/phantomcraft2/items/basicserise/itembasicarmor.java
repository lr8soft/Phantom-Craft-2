package net.lrsoft.phantomcraft2.items.basicserise;
import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.items.*;
import net.lrsoft.phantomcraft2.items.basicserise.ItemBasicManager;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
public class itembasicarmor extends ItemArmor {
	public String textureName;
    public itembasicarmor(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
        super(material, 0, type);
        this.textureName = textureName;
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName("phtc2:" + unlocalizedName);
        this.setCreativeTab(phantomcraft2.tabPHTC2);
    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
        return "phtc2:textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {

    }
    public static void onReg(){
  	  GameRegistry.registerItem(ItemBasicManager.basichelmet = new itembasicarmor("basichelmet", ItemsRegister.basicarmor, "basicarmor", 0), "basichelmet");//0 for helmet
  	  GameRegistry.registerItem(ItemBasicManager.basicchestplate = new itembasicarmor("basicchestplate", ItemsRegister.basicarmor, "basicarmor", 1), "basicchestplate"); // 1 for chestplate
  	  GameRegistry.registerItem(ItemBasicManager.basicleggings = new itembasicarmor("basicleggings", ItemsRegister.basicarmor, "basicarmor", 2), "basicleggings"); // 2 for leggings
  	  GameRegistry.registerItem(ItemBasicManager.basicboots = new itembasicarmor("basicboots", ItemsRegister.basicarmor, "basicarmor", 3), "basicboots"); //3 for boot
  }
    public static void onRecipeReg(){
    	GameRegistry.addRecipe(new ItemStack(ItemBasicManager.basichelmet, 1), new Object[] {"###", "# #", "   ", '#', ItemsRegister.normalingot});
    	GameRegistry.addRecipe(new ItemStack(ItemBasicManager.basicchestplate, 1), new Object[] {"# #", "###", "###", '#', ItemsRegister.normalingot});
    	GameRegistry.addRecipe(new ItemStack(ItemBasicManager.basicleggings, 1), new Object[] {"###", "# #", "# #", '#', ItemsRegister.normalingot});
    	GameRegistry.addRecipe(new ItemStack(ItemBasicManager.basicboots, 1), new Object[] {"   ", "X X", "X X", 'X',ItemsRegister.normalingot});

    }
}

