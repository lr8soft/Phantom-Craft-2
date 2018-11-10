package net.lrsoft.phantomcraft2.guis;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.lrsoft.phantomcraft2.guis.rtCountainerStateExchange;
public class GuiStateExchange extends GuiContainer {
		private rtTEStateExchange tile;
		public GuiStateExchange(InventoryPlayer inventory, rtTEStateExchange tileEntity) {
			super(new rtCountainerStateExchange(inventory, tileEntity));
			// TODO Auto-generated constructor stub
			this.tile = tileEntity;
			this.doesGuiPauseGame();
		}
		@Override
	    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
	                // TODO Auto-generated method stub
	                super.drawGuiContainerForegroundLayer(par1, par2);
	     this.fontRendererObj.drawString(StatCollector.translateToLocal("Poly Energy Converter"), 65, 6, 4210752);//
	     this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	   //  drawString(FontRenderer,str,x,y,c)
		}
		@Override
		protected void drawGuiContainerBackgroundLayer(float var1, int var2,
				int var3) {
			// TODO Auto-generated method stub
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.renderEngine.bindTexture(new ResourceLocation("phtc2","textures/gui/StateExchange.png"));
	        int var5 = (this.width - this.xSize) / 2;
	        int var6 = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);//(x,y,u,v,w,h)
	        int b = tile.tableExchangeTime; // 取得Tile内的燃料燃烧时间
	        float maxBurnTime = tile.maxExchangeTime*1.0F;// 取得最大燃料燃烧时间，用float，不用的话得不出百分比
	        if (b > 0 && maxBurnTime > 0) // 确定描绘的时机
	        {
	                // 描绘火焰图像
	            this.drawTexturedModalRect(this.guiLeft + 81, this.guiTop + 37 + (int)(14 - 14 * ((float)b / maxBurnTime)), 176, (int)(14 - 14 * ((float)b / maxBurnTime)), 14, (int)(14 * ((float)b / maxBurnTime)));
	        }
		}
}
