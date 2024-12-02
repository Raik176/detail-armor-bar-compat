package org.rhm.detailab_compat;

import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class DetailArmorBarCompatCommon {
	public static final String MOD_ID = "detailab_compat";
	public static final Map<ResourceLocation, ResourceLocation> MOD_COMPATS = Map.ofEntries(
			basicCompat("friendsandfoes", "wildfire_crown")
	);
	public static final int ARMOR_SIZE = 18;
	public static final int ITEM_SIZE = 18;

	private static Map.Entry<ResourceLocation, ResourceLocation> basicCompat(String ns, String name) {
		return Map.entry(id(ns,name), textureId(ns, name));
	}
	private static ResourceLocation textureId(String ns, String name) {
		return id("textures/gui/sprites/hud/" + ns + "/" + name + ".png");
	}
	private static ResourceLocation id(String path) {
		return id(MOD_ID,path);
	}
	private static ResourceLocation id(String ns, String path) {
		//? if >=1.21 {
		return ResourceLocation.tryBuild(ns,path);
		//?} else
		/*return new ResourceLocation(ns,path);*/
	}
}
