package net.shyn.wandswonders.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;
import net.shyn.wandswonders.component.PlayerManaProvider;

public class ManaHudOverlay implements HudRenderCallback {


    public static void register() {
        HudRenderCallback.EVENT.register(new ManaHudOverlay());
    }

    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        var mana = PlayerManaProvider.get(client.player);
        int currentMana = mana.getMana();
        int maxMana = mana.getMaxMana();

        // Bar position and size
        int barWidth = 102;
        int barHeight = 12;
        int x = 10;
        int y = client.getWindow().getScaledHeight() - 55;

        // Background with rounded look
        drawContext.fill(x, y, x + barWidth, y + barHeight, 0x88003366); // soft dark purple

        // Blue glowing mana fill
        float manaPercent = currentMana / (float) maxMana;
        int manaFillWidth = (int) (barWidth * manaPercent);

        drawContext.fillGradient(x + 1, y + 1, x + manaFillWidth - 1, y + barHeight - 1,
                0xFF66CCFF, 0xFF3399FF); // glowing gradient blue

        // Border (white outline)
        drawContext.drawBorder(x, y, barWidth, barHeight, 0xFFFFFFFF);

        // Mana Text
        String text = currentMana + " / " + maxMana + " Mana";
        int textX = x + (barWidth / 2) - (client.textRenderer.getWidth(text) / 2);
        drawContext.drawText(client.textRenderer, Text.of(text), textX, y - 12, 0x77CCFF, true);
    }
}
