package com.happyzleaf.willmcafeeeathisowndickcraft.gui;

import com.google.gson.Gson;
import com.happyzleaf.willmcafeeeathisowndickcraft.WMEHODCraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author happyzleaf
 * @since 16/07/2018
 */
public class GuiAwaitingResponse extends GuiScreen {
	private static Gson gson = new Gson();
	private static URL url;
	static {
		try {
			url = new URL("https://will-mcafee-eat-his-own-dick.herokuapp.com/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public ResourceLocation answer = null;
	
	@Override
	public void initGui() {
		super.initGui();
		
		try {
			Response response = gson.fromJson(new InputStreamReader(url.openStream()), Response.class);
			switch (response.isdickonthemenu) {
				case "Yes!":
					answer = new ResourceLocation(WMEHODCraft.MOD_ID, "textures/yes.png");
					break;
				case "No!":
					answer = new ResourceLocation(WMEHODCraft.MOD_ID, "textures/no.png");
					break;
				case "Maybe?":
					answer = new ResourceLocation(WMEHODCraft.MOD_ID, "textures/maybe.png");
					break;
				default:
					answer = new ResourceLocation(WMEHODCraft.MOD_ID, "textures/error.png");
			}
		} catch (IOException e) {
			answer = new ResourceLocation(WMEHODCraft.MOD_ID, "textures/error.png");
		}
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		if (answer == null) {
			mc.player.closeScreen();
			return;
		}
		
		mc.renderEngine.bindTexture(answer);
		GL11.glColor4f(1, 1, 1, 1);
		drawTexturedModalRect(width / 2 - 91, height / 2 - 52, 0, 0, 183, 104);
		fontRenderer.drawString("Will John McAfee Eat His Own Dick?", width / 2 - 85, height / 2 - 46, 16777215, true);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	public static class Response {
		public String isdickonthemenu;
	}
}
