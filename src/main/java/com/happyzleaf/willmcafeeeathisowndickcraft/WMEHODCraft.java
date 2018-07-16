package com.happyzleaf.willmcafeeeathisowndickcraft;

import com.happyzleaf.willmcafeeeathisowndickcraft.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = WMEHODCraft.MOD_ID, name = WMEHODCraft.MOD_NAME, version = WMEHODCraft.VERSION, acceptableRemoteVersions = "*")
public class WMEHODCraft {
	public static final String MOD_ID = "wmehodcraft";
	public static final String MOD_NAME = "WMEHODCraft";
	public static final String VERSION = "1.0-SNAPSHOT";
	
	@Mod.Instance(MOD_ID)
	public static WMEHODCraft instance;
	
	@SidedProxy(clientSide = "com.happyzleaf.willmcafeeeathisowndickcraft.proxy.ClientProxy", serverSide = "com.happyzleaf.willmcafeeeathisowndickcraft.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	public static Logger LOGGER = LogManager.getLogger(MOD_NAME);
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
