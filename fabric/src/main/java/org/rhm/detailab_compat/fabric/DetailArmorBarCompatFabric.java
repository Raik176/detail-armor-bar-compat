package org.rhm.detailab_compat.fabric;

import com.redlimerl.detailab.api.DetailArmorBarAPI;
import com.redlimerl.detailab.api.render.ArmorBarRenderManager;
import com.redlimerl.detailab.api.render.ItemBarRenderManager;
import com.redlimerl.detailab.api.render.TextureOffset;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.core.DefaultedRegistry;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import org.rhm.detailab_compat.DetailArmorBarCompatCommon;

import java.awt.*;

//? if >=1.19.3 {
import net.minecraft.core.registries.BuiltInRegistries;
//?} else
/*import net.minecraft.core.Registry;*/

public class DetailArmorBarCompatFabric implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientLifecycleEvents.CLIENT_STARTED.register((client) -> {
			DetailArmorBarCompatCommon.MOD_COMPATS.forEach((itemId, info) -> {
				if (itemRegistry().containsKey(itemId)) {
					Item item = itemRegistry().get(itemId);
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
		});
	}

	private DefaultedRegistry<Item> itemRegistry() {
		//? if >=1.19.3 {
		return BuiltInRegistries.ITEM;
		//?} else
		/*return Registry.ITEM;*/
	}
}
