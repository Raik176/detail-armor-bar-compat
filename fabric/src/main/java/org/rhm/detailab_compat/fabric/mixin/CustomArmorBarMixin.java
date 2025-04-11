package org.rhm.detailab_compat.fabric.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.redlimerl.detailab.api.render.BarRenderManager;
import com.redlimerl.detailab.api.render.CustomArmorBar;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

// dev didn't fix this until very recently, so I just fixed it myself
// this is not an optimal solution
@Mixin(value = CustomArmorBar.class)
public class CustomArmorBarMixin {
    @ModifyArg(method = "draw", at = @At(
            value = "INVOKE",
            target = "Lcom/redlimerl/detailab/render/InGameDrawer;drawTexture(Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/client/gui/GuiGraphics;IIIIIILjava/awt/Color;Z)V"
    ))
    private ResourceLocation changeTexture(ResourceLocation par1, @Local BarRenderManager renderInfo) {
        return renderInfo.getTexture();
    }

    @ModifyArg(method = "drawOutLine", at = @At(
            value = "INVOKE",
            target = "Lcom/redlimerl/detailab/render/InGameDrawer;drawTexture(Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/client/gui/GuiGraphics;IIIIIILjava/awt/Color;Z)V"
    ))
    private ResourceLocation changeTextureOutline(ResourceLocation par1, @Local BarRenderManager renderInfo) {
        return renderInfo.getTexture();
    }
}
