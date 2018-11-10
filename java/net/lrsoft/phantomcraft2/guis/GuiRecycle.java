package net.lrsoft.phantomcraft2.guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiRecycle extends GuiContainer {
	private rtTERecycle tile;
	public GuiRecycle(InventoryPlayer inventory, rtTERecycle tileEntity) {
		super(new rtCountainerRecycle(inventory, tileEntity));
		// TODO Auto-generated constructor stub
		this.tile = tileEntity;
		this.doesGuiPauseGame();
	}
	@Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
                // TODO Auto-generated method stub
                super.drawGuiContainerForegroundLayer(par1, par2);
     this.fontRendererObj.drawString(StatCollector.translateToLocal("PEU Recycling Machine"), 60, 6, 4210752);//
     this.fontRendererObj.drawString(StatCollector.translateToLocal("PEU:"+tile.tablePEU+"/"+tile.maxPEU), 105, 45, 4210752);//
     this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
   //  drawString(FontRenderer,str,x,y,c)
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		// TODO Auto-generated method stub
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(new ResourceLocation("phtc2","textures/gui/RecycleM.png"));
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);//(x,y,u,v,w,h)
        int b = (int) tile.tablePEU; // 取得Tile内的燃料燃烧时间
        float maxBurnTime = tile.maxPEU*1.0F;// 取得最大燃料燃烧时间，用float，不用的话得不出百分比
	}
}