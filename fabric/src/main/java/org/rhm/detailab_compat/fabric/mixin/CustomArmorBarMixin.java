package org.rhm.detailab_compat.fabric.mixin;

import com.redlimerl.detailab.api.render.CustomArmorBar;
import org.spongepowered.asm.mixin.Mixin;

//? if >=1.21
/*import net.minecraft.client.gui.GuiGraphics;*/
import com.mojang.blaze3d.vertex.PoseStack;
import com.redlimerl.detailab.api.render.BarRenderManager;
import com.redlimerl.detailab.render.InGameDrawer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;

import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Function;



// dev didn't fix this until very recently, so I just fixed it myself
// this is not an optimal solution
@Mixin(value = CustomArmorBar.class, priority = 1)
public class CustomArmorBarMixin {
    //? if >=1.21 {
    /*@Shadow @Final private Function<ItemStack, ? extends BarRenderManager> predicate;

    @Inject(
            method = "draw",
            at = @At("HEAD"),
            cancellable = true
    )
    private void modifyDraw(ItemStack itemStack, GuiGraphics context, int xPos, int yPos, boolean isHalf, boolean isMirror, CallbackInfo ci) {
        BarRenderManager renderInfo = this.predicate.apply(itemStack);

        if (!renderInfo.isShown()) {
            ResourceLocation texture = renderInfo.getTexture();
            if (isHalf) {
                InGameDrawer.drawTexture(
                        texture, context, xPos, yPos,
                        renderInfo.getTextureOffsetHalf().x, renderInfo.getTextureOffsetHalf().y,
                        renderInfo.getTextureWidth(), renderInfo.getTextureHeight(),
                        renderInfo.getColor(), isMirror
                );
            } else {
                InGameDrawer.drawTexture(
                        texture, context, xPos, yPos,
                        renderInfo.getTextureOffsetFull().x, renderInfo.getTextureOffsetFull().y,
                        renderInfo.getTextureWidth(), renderInfo.getTextureHeight(),
                        renderInfo.getColor(), false
                );
            }
            ci.cancel();
        }
    }

    *///?}
}
