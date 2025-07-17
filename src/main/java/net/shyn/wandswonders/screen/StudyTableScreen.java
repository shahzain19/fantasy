package net.shyn.wandswonders.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.shyn.wandswonders.WandsWonders;

import java.util.Random;

public class StudyTableScreen extends HandledScreen<StudyTableScreenHandler> {

    private static final Identifier GUI_TEXTURE =
            Identifier.of(WandsWonders.MOD_ID, "textures/gui/study_table.png");

    private static final Identifier GLYPH_OVERLAY =
            Identifier.of(WandsWonders.MOD_ID, "textures/gui/glyph_overlay.png");

    private static final Identifier RUNE_EFFECT =
            Identifier.of(WandsWonders.MOD_ID, "textures/gui/rune_effect.png");

    private static final Identifier SLOT_HIGHLIGHT =
            Identifier.of(WandsWonders.MOD_ID, "textures/gui/slot_highlight.png");

    private final Random random = new Random();

    public StudyTableScreen(StudyTableScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        // Draw main GUI
        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        // ✨ If crafting possible, draw glowing glyph
        if (handler.canCraft()) {
            context.drawTexture(GLYPH_OVERLAY, x + 119, y + 34, 0, 0, 24, 24);
        }

        // 🌀 Floating magical effect (random flicker)
        if (random.nextFloat() < 0.05f) {
            int flickerX = x + 30 + random.nextInt(100);
            int flickerY = y + 20 + random.nextInt(60);
            context.drawTexture(RUNE_EFFECT, flickerX, flickerY, 0, 0, 8, 8);
        }

        // 🔲 Highlight slots (subtle) if hovered
        drawSlotHighlight(context, mouseX, mouseY, x, y, 29, 35); // Fragment
        drawSlotHighlight(context, mouseX, mouseY, x, y, 51, 35); // Ink
        drawSlotHighlight(context, mouseX, mouseY, x, y, 73, 35); // Blank
        drawSlotHighlight(context, mouseX, mouseY, x, y, 119, 35); // Output
    }

    private void drawSlotHighlight(DrawContext context, int mouseX, int mouseY, int x, int y, int slotX, int slotY) {
        if (isPointWithinBounds(slotX, slotY, 18, 18, mouseX, mouseY)) {
            context.drawTexture(SLOT_HIGHLIGHT, x + slotX, y + slotY, 0, 0, 18, 18);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        // 🧠 Styled tooltips
        if (isPointWithinBounds(29, 35, 18, 18, mouseX, mouseY)) {
            context.drawTooltip(textRenderer, Text.literal("Insert Knowledge Fragment").setStyle(Style.EMPTY.withColor(0xFFCC66)), mouseX, mouseY);
        }
        if (isPointWithinBounds(51, 35, 18, 18, mouseX, mouseY)) {
            context.drawTooltip(textRenderer, Text.literal("Insert Natural Ink").setStyle(Style.EMPTY.withColor(0x99CCFF)), mouseX, mouseY);
        }
        if (isPointWithinBounds(73, 35, 18, 18, mouseX, mouseY)) {
            context.drawTooltip(textRenderer, Text.literal("Insert Blank Scroll").setStyle(Style.EMPTY.withColor(0xEEEEEE)), mouseX, mouseY);
        }
        if (isPointWithinBounds(119, 35, 18, 18, mouseX, mouseY)) {
            context.drawTooltip(textRenderer, Text.literal("Result: §dMagic Wand"), mouseX, mouseY);
        }
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}
