package com.happyzleaf.willmcafeeeathisowndickcraft.proxy;

import com.happyzleaf.willmcafeeeathisowndickcraft.WMEHODCraft;
import com.happyzleaf.willmcafeeeathisowndickcraft.gui.GuiAwaitingResponse;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

/**
 * Here's where all the magic happens.
 *
 * @author happyzleaf
 * @since 16/07/2018
 */
public class ClientProxy extends CommonProxy {
	private static final KeyBinding ANSWER_KEY = new KeyBinding("Will McAfee Eat His Own Dick?", Keyboard.KEY_M, "key.categories.misc");
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		ClientRegistry.registerKeyBinding(ANSWER_KEY);
		
		WMEHODCraft.LOGGER.info("Loaded!");
	}
	
	@SubscribeEvent
	public void onKey(InputEvent.KeyInputEvent event) {
		if (ANSWER_KEY.isPressed()) {
			net.minecraft.client.Minecraft.getMinecraft().displayGuiScreen(new GuiAwaitingResponse());
		}
	}
}
