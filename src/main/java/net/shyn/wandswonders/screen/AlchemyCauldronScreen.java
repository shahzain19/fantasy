package net.shyn.wandswonders.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.shyn.wandswonders.WandsWonders;

public class AlchemyCauldronScreen extends HandledScreen<AlchemyCauldronScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(WandsWonders.MOD_ID, "textures/gui/study_table.png");
    private static final Identifier SLOT_OVERLAY = Identifier.of(WandsWonders.MOD_ID, "textures/gui/slot_overlay.png");
    private static final Identifier GLYPH_GLOW = Identifier.of(WandsWonders.MOD_ID, "textures/gui/glyph_glow.png");

    public AlchemyCauldronScreen(AlchemyCauldronScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        // Draw base GUI background
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        // ✨ Highlight output if recipe is ready
        if (handler.hasRecipeIngredients() && handler.getOutputSlot().getStack().isEmpty()) {
            context.setShaderColor(1.0f, 1.0f, 1.0f, 0.7f); // soft glow
            context.drawTexture(GLYPH_GLOW, x + 122, y + 33, 0, 0, 24, 24);
            context.setShaderColor(1f, 1f, 1f, 1f); // reset
        }

        // Draw subtle slot overlays
        drawSubtleSlot(context, mouseX, mouseY, x + 38, y + 35);  // Ingredient 1
        drawSubtleSlot(context, mouseX, mouseY, x + 56, y + 35);  // Ingredient 2
        drawSubtleSlot(context, mouseX, mouseY, x + 74, y + 35);  // Ingredient 3
        drawSubtleSlot(context, mouseX, mouseY, x + 122, y + 35); // Output
    }

    private void drawSubtleSlot(DrawContext context, int mouseX, int mouseY, int slotX, int slotY) {
        int guiX = (width - backgroundWidth) / 2;
        int guiY = (height - backgroundHeight) / 2;
        if (isPointWithinBounds(slotX - guiX, slotY - guiY, 18, 18, mouseX, mouseY)) {
            context.setShaderColor(1f, 1f, 1f, 0.2f); // soft overlay
            context.drawTexture(SLOT_OVERLAY, slotX, slotY, 0, 0, 18, 18);
            context.setShaderColor(1f, 1f, 1f, 1f); // reset
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}
