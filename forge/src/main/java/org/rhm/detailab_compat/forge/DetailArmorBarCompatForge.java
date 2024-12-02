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
		DetailArmorBarCompatCommon.MOD_COMPATS.forEach((itemId, texture) -> {
			if (ForgeRegistries.ITEMS.containsKey(itemId)) {
				Item item = ForgeRegistries.ITEMS.getValue(itemId);
				if (item instanceof ArmorItem armorItem) {
					DetailArmorBarAPI.customArmorBarBuilder().armor(armorItem).render((stack) -> new ArmorBarRenderManager(
							texture,
							DetailArmorBarCompatCommon.ARMOR_SIZE,
							DetailArmorBarCompatCommon.ARMOR_SIZE,
							new TextureOffset(9,0),
							new TextureOffset(0,0),
							new TextureOffset(0,9),
							new TextureOffset(9,9)
					)).register();
				} else {
					DetailArmorBarAPI.customItemBarBuilder().item(item).render((stack) -> new ItemBarRenderManager(
							texture,
							DetailArmorBarCompatCommon.ITEM_SIZE,
							DetailArmorBarCompatCommon.ITEM_SIZE/2,
							new TextureOffset(9, 0),
							new TextureOffset(0, 0),
							true,
							Color.WHITE
					)).register();
				}
			}
		});
	}
}
