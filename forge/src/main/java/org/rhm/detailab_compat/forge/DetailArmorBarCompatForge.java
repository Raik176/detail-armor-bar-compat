package org.rhm.detailab_compat.forge;

import com.redlimerl.detailab.api.DetailArmorBarAPI;
import com.redlimerl.detailab.api.render.ArmorBarRenderManager;
import com.redlimerl.detailab.api.render.ItemBarRenderManager;
import com.redlimerl.detailab.api.render.TextureOffset;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.rhm.detailab_compat.DetailArmorBarCompatCommon;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod(DetailArmorBarCompatCommon.MOD_ID)
public class DetailArmorBarCompatForge {
	public DetailArmorBarCompatForge() {
		MinecraftForge.EVENT_BUS.addListener(this::onClientSetup);
	}

	public void onClientSetup(FMLClientSetupEvent event) {
		DetailArmorBarCompatCommon.MOD_COMPATS.forEach((itemId, info) -> {
			if (ForgeRegistries.ITEMS.containsKey(itemId)) {
				Item item = ForgeRegistries.ITEMS.getValue(itemId);
				if (item instanceof ArmorItem armorItem) {
					DetailArmorBarAPI.customArmorBarBuilder().armor(armorItem).render((stack) -> new ArmorBarRenderManager(
							info.getLocation(),
							info.getSize(),
							info.getSize(),
							new TextureOffset(info.getFullOffset().getKey(),info.getFullOffset().getValue()),
							new TextureOffset(info.getHalfOffset().getKey(),info.getHalfOffset().getValue()),
							new TextureOffset(info.getFullOutlineOffset().getKey(),info.getFullOutlineOffset().getValue()),
							new TextureOffset(info.getHalfOutlineOffset().getKey(),info.getHalfOutlineOffset().getValue())
					)).register();
				} else {
					DetailArmorBarAPI.customItemBarBuilder().item(item).render((stack) -> new ItemBarRenderManager(
							info.getLocation(),
							info.getSize(),
							info.getSize()/2,
							new TextureOffset(info.getFullOffset().getKey(),info.getFullOffset().getValue()),
							new TextureOffset(info.getFullOutlineOffset().getKey(),info.getFullOutlineOffset().getValue()),
							true,
							Color.WHITE
					)).register();
				}
			}
		});
	}
}
