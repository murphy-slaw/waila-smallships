package net.funkpla.waila_smallships;

import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.Ship;
import mcp.mobius.waila.api.*;
import net.minecraft.util.Mth;

public enum ShipDataProvider implements IDataProvider<Ship> {
    INSTANCE;

    @Override
    public void appendData(IDataWriter data, IServerAccessor<Ship> accessor, IPluginConfig config) {
        Ship ship = accessor.getTarget();
        data.raw().putString("customName", ship.getCustomName().getString());
        data.raw().putInt("maxSpeed", Mth.floor(ship.getAttributes().maxSpeed));
        if (ship instanceof ContainerShip containerShip) {
            data.raw().putInt("containerSize", Mth.floor(containerShip.getContainerSize()));
        }
    }

}
