package net.lrsoft.phantomcraft2.guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiPEUStorage extends GuiContainer {
	private rtTEPEUStorage tile;
	public GuiPEUStorage(InventoryPlayer inventory, rtTEPEUStorage tileEntity) {
		super(new rtCountainerPEUStorage(inventory, tileEntity));
		// TODO Auto-generated constructor stub
		this.tile = tileEntity;
		this.doesGuiPauseGame();
	}
	@Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
                // TODO Auto-generated method stub
                super.drawGuiContainerForegroundLayer(par1, par2);
     this.fontRendererObj.drawString(StatCollector.translateToLocal("PEUStorage"), 65, 6, 4210752);//
     this.fontRendererObj.drawString(StatCollector.translateToLocal("PEU:"+tile.tablePEU+"/"+tile.maxPEU), 67, 26, 4210752);//
     this.fontRendererObj.drawString(StatCollector.translateToLocal(tile.transportSPEED+"PEU/tick"), 67, 33, 4210752);
     this.fontRendererObj.drawString(StatCollector.translateToLocal("UpSlot is Input,DownSlot is Output"), 67, 42, 4210752);
     this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
   //  drawString(FontRenderer,str,x,y,c)
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		// TODO Auto-generated method stub
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(new ResourceLocation("phtc2","textures/gui/PEUStorage.png"));
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);//(x,y,u,v,w,h)
        int b = (int) tile.tablePEU; // 取得Tile内的PEU能量数值
  //      float maxPEU = tile.maxPEU*1.0F;// 取得最大PEU，用float，不用的话得不出百分比
  //      if (b > 0 && maxBurnTime > 0) // 确定描绘的时机
  //      {
                // 描绘火焰图像
   //         this.drawTexturedModalRect(this.guiLeft + 81, this.guiTop + 37 + (int)(14 - 14 * ((float)b / maxBurnTime)), 176, (int)(14 - 14 * ((float)b / maxBurnTime)), 14, (int)(14 * ((float)b / maxBurnTime)));
   //     }
	}
}
