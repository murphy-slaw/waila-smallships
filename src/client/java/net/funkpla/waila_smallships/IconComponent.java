package net.funkpla.waila_smallships;

import mcp.mobius.waila.api.ITooltipComponent;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;

public abstract class IconComponent implements ITooltipComponent {
    protected static final int iconSize = SmallshipsWailaClient.ICON_SIZE;
    protected int iconCount;
    protected int lineLength;
    protected int ratio;
    protected int value;
    protected int vOffset;


    public int getWidth() {
        return (lineLength * iconSize) + 1;
    }

    public int getHeight() {
        return (Mth.positiveCeilDiv(iconCount, lineLength) * iconSize) + 2;
    }

    @Override
    public void render(GuiGraphics ctx, int x, int y, float delta) {
        var filled = value / ratio - 1;
        var half = filled + value % 2;

        for (var i = iconCount - 1; i >= 0; i--) {
            var ix = x + ((i % lineLength) * iconSize);
            var iy = y + ((i / lineLength) * iconSize);

            drawIcon(ctx, ix, iy, 0, vOffset);
            if (i <= filled) {
                drawIcon(ctx, ix, iy, iconSize, vOffset);
            } else if (i == half) {
                drawIcon(ctx, ix, iy, iconSize * 2, vOffset);
            }
        }
    }

    private void drawIcon(GuiGraphics ctx, int x, int y, int uOffset, int vOffset) {
        ctx.blit(SmallshipsWailaClient.ICON_TEXTURE,
                x, y,
                uOffset, vOffset,
                SmallshipsWailaClient.ICON_SIZE, SmallshipsWailaClient.ICON_SIZE,
                SmallshipsWailaClient.ATLAS_WIDTH, SmallshipsWailaClient.ATLAS_HEIGHT
        );
    }
}
