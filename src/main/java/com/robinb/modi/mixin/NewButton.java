package com.robinb.modi.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class NewButton extends Screen {
    protected NewButton(Text title) {
        super(title);
    }
    @Inject(at = @At("RETURN"), method = "initWidgetsNormal")
    private void addButton(int y, int spacingY, CallbackInfo info){
        this.addButton(new ButtonWidget(this.width / 2 - 100 + 205, y, 50, 20, "Hello!", (buttonWidget) -> {
            MinecraftClient.getInstance().openScreen(new SelectWorldScreen(this));
        }));
    }

}
