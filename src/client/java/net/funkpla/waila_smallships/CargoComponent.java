package net.funkpla.waila_smallships;

import mcp.mobius.waila.api.__internal__.ApiSide;
import net.minecraft.util.Mth;

/**
 * Component that renders a slots bar.
 */
@ApiSide.ClientOnly
public class CargoComponent extends IconComponent {
    /**
     * @param slots      number of inventory slots
     * @param maxPerLine the max icon per line until it get wrapped into multiple
     */

    public CargoComponent(float slots, int maxPerLine) {
        this.ratio = 54;
        this.value = Mth.ceil(slots);
        this.iconCount = Mth.positiveCeilDiv(Math.max(this.value, 1), ratio);
        this.lineLength = Math.min(iconCount, maxPerLine);
        this.vOffset = SmallshipsWailaClient.ICON_SIZE;
    }
}
