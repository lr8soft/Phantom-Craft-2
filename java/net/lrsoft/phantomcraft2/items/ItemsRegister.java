package net.lrsoft.phantomcraft2.items;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.lrsoft.phantomcraft2.phantomcraft2;
import net.lrsoft.phantomcraft2.items.PEU.itemPEUList;
import net.lrsoft.phantomcraft2.items.PEU.itemadvPEUbattery;
import net.lrsoft.phantomcraft2.items.PEU.itembasicPEUbattery;
import net.lrsoft.phantomcraft2.items.basicserise.ItemBasicManager;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicarmor;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU.ItemPEUFlySupport;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU.ItemPEUManager;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU.ItemPEUShield;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU.ItemarmorPEU;
import net.lrsoft.phantomcraft2.items.basicserise.itembasicPEU.ItemgunPEU;
import net.lrsoft.phantomcraft2.items.custom.ItemCustomManager;
import net.lrsoft.phantomcraft2.items.eport.itemeport;
import net.lrsoft.phantomcraft2.items.finalserise.ItemFinalManager;
import net.lrsoft.phantomcraft2.items.finalserise.Itemfinalarmor;
public class ItemsRegister {
	 public static Item normalingot;
	 public static Item energydust;
	 
	 public static Item ph_advingot;
	 public static Item ph_advdust;
	 public static Item ph_basicbattery;
	 public static Item ph_PEUgun;
	 public static Item ph_PEUFlySupport;
	 
	 public static Item ph_hyperdust;
	 public static Item ph_hyperdiamond;
	 public static Item ph_hyperingot;
	 
	 public static Item ph_advbattery;
	 public static Item ph_PEUshield;
	 public static ArmorMaterial basicarmor = EnumHelper.addArmorMaterial("basicarmor", 14, new int[]{2, 5, 4, 2}, 16);
	 public static ArmorMaterial PEUarmor = EnumHelper.addArmorMaterial("PEUarmor", 25, new int[]{2, 7, 5, 2}, 20);
	 public static ArmorMaterial PEUfarmor = EnumHelper.addArmorMaterial("PEUfarmor", 40, new int[]{4, 9, 6, 4}, 28);
	 public static void itemsregister(){
		 normalingot=new items();
		 normalingot.setUnlocalizedName("normalingot");
		 normalingot.setTextureName("phtc2:normalingot");
		 normalingot.setMaxStackSize(64);
		 normalingot.setCreativeTab(phantomcraft2.tabPHTC2);
		 GameRegistry.registerItem(normalingot, "normalingot");
		 
		 energydust=new items();
		 energydust.setUnlocalizedName("energydust");
		 energydust.setTextureName("phtc2:energydust");
		 energydust.setMaxStackSize(64);
		 energydust.setCreativeTab(phantomcraft2.tabPHTC2);
		 GameRegistry.registerItem(energydust, "energydust");
		 
		 ph_advdust=new items();
		 ph_advdust.setUnlocalizedName("ph_advdust");
		 ph_advdust.setTextureName("phtc2:ph_advdust");
		 ph_advdust.setMaxStackSize(64);
		 ph_advdust.setCreativeTab(phantomcraft2.tabPHTC2);
		 GameRegistry.registerItem(ph_advdust, "ph_advdust");
		 
		 ph_advingot=new items();
		 ph_advingot.setUnlocalizedName("ph_advingot");
		 ph_advingot.setTextureName("phtc2:ph_advingot");
		 ph_advingot.setMaxStackSize(64);
		 ph_advingot.setCreativeTab(phantomcraft2.tabPHTC2);
		 GameRegistry.registerItem(ph_advingot, "ph_advingot");
		 
		 ph_basicbattery=new itembasicPEUbattery();
		 ph_basicbattery.setUnlocalizedName("ph_basicbattery");
		 ph_basicbattery.setTextureName("phtc2:ph_basicbattery");
		 ph_basicbattery.setMaxStackSize(1);
		 ph_basicbattery.setCreativeTab(phantomcraft2.tabPHTC2);
		 GameRegistry.registerItem(ph_basicbattery, "ph_basicbattery");
		 
		 ph_PEUgun=new ItemgunPEU();
		 ph_PEUgun.setUnlocalizedName("ph_PEUgun");
		 ph_PEUgun.setTextureName("phtc2:ph_PEUgun");
		 ph_PEUgun.setMaxStackSize(1);
		 ph_PEUgun.setMaxDamage(200);
		 ph_PEUgun.setCreativeTab(phantomcraft2.tabPHTC2);
		 GameRegistry.registerItem(ph_PEUgun, "ph_PEUgun");
		 
		 ph_PEUFlySupport=new ItemPEUFlySupport();
		 ph_PEUFlySupport.setUnlocalizedName("ph_PEUFlySupport");
		 ph_PEUFlySupport.setTextureName("phtc2:ph_PEUFlySupport");
		 ph_PEUFlySupport.setMaxStackSize(1);
		 ph_PEUFlySupport.setCreativeTab(phantomcraft2.tabPHTC2);
		 GameRegistry.registerItem(ph_PEUFlySupport, "ph_PEUFlySupport");
		 
		 ph_hyperdiamond=new items();
		 ph_hyperdiamond.setUnlocalizedName("ph_hyperdiamond");
		 ph_hyperdiamond.setTextureName("phtc2:ph_hyperdiamond");
		 ph_hyperdiamond.setMaxStackSize(64);
		 ph_hyperdiamond.setCreativeTab(phantomcraft2.tabPHTC2);
		 GameRegistry.registerItem(ph_hyperdiamond, "ph_hyperdiamond");
		 
		 ph_advbattery=new itemadvPEUbattery();
		 ph_advbattery.setUnlocalizedName("ph_advbattery");
		 ph_advbattery.setTextureName("phtc2:ph_advbattery");
		 ph_advbattery.setMaxStackSize(64);
		 ph_advbattery.setCreativeTab(phantomcraft2.tabPHTC2);
		 GameRegistry.registerItem(ph_advbattery, "ph_advbattery");
		 
		 ph_PEUshield=new ItemPEUShield();
		 ph_PEUshield.setUnlocalizedName("ph_PEUshield");
		 ph_PEUshield.setTextureName("phtc2:ph_PEUshield");
		 ph_PEUshield.setMaxStackSize(1);
		 ph_PEUshield.setCreativeTab(phantomcraft2.tabPHTC2);
		 GameRegistry.registerItem(ph_PEUshield, "ph_PEUshield");

		 
		 itembasicarmor.onReg();
		 ItemBasicManager.onReg();
		 ItemPEUManager.onReg();
		 itemeport.onReg();
		 ItemarmorPEU.onReg();
		 ItemFinalManager.onReg();
		 Itemfinalarmor.onReg();
		 ItemCustomManager.onReg();
	 }
	 public static void itemsrecipe(){
		 itembasicarmor.onRecipeReg();
		 ItemBasicManager.onRecipeReg();
         itemeport.onRecipeReg();
         itemPEUList.onRecipeReg();
         ItemarmorPEU.onRecipeReg();
         ItemPEUManager.onRecipeReg();
         ItemFinalManager.onRecipeReg();
         Itemfinalarmor.onRecipeReg();
         ItemCustomManager.onRecipeReg();
	 }
}
