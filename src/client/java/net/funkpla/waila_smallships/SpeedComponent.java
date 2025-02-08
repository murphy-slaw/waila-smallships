package net.funkpla.waila_smallships;

import mcp.mobius.waila.api.__internal__.ApiSide;
import net.minecraft.util.Mth;

/**
 * Component that renders a speed bar.
 */
@ApiSide.ClientOnly
public class SpeedComponent extends IconComponent {

    /**
     * @param speed      the speed point, 1 full icon represent 2 hp
     * @param maxSpeed   the max speed point
     * @param maxPerLine the max icon per line until it get wrapped into multiple
     */
    public SpeedComponent(float speed, float maxSpeed, int maxPerLine) {
        this.ratio =10;
        this.value = Mth.ceil(speed);
        this.iconCount = Mth.positiveCeilDiv(Mth.ceil(Math.max(speed, maxSpeed)), ratio);
        this.lineLength = Math.min(iconCount, maxPerLine);
        this.vOffset = 0;
    }
}
