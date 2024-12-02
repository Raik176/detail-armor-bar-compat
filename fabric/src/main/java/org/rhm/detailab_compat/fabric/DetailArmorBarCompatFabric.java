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
			DetailArmorBarCompatCommon.MOD_COMPATS.forEach((itemId, texture) -> {
				if (itemRegistry().containsKey(itemId)) {
					Item item = itemRegistry().get(itemId);
					if (item instanceof ArmorItem armorItem) {
						System.out.println(itemId);
						System.out.println(texture);
						DetailArmorBarAPI.customArmorBarBuilder().armor(armorItem).render((stack) -> new ArmorBarRenderManager(
                                texture,
                                DetailArmorBarCompatCommon.ARMOR_SIZE,
								DetailArmorBarCompatCommon.ARMOR_SIZE,
                                new TextureOffset(0,0),
                                new TextureOffset(0,0),
                                new TextureOffset(0,0),
                                new TextureOffset(0,0)
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
		});
	}

	private DefaultedRegistry<Item> itemRegistry() {
		//? if >=1.19.3 {
		return BuiltInRegistries.ITEM;
		//?} else
		/*return Registry.ITEM;*/
	}
}
