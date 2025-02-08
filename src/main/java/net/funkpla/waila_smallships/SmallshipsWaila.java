package net.funkpla.waila_smallships;

import com.talhanation.smallships.world.entity.ship.Ship;
import mcp.mobius.waila.api.ICommonRegistrar;
import mcp.mobius.waila.api.IWailaCommonPlugin;

public class SmallshipsWaila implements IWailaCommonPlugin {
    @Override
    public void register(ICommonRegistrar registrar) {
        registrar.entityData(ShipProvider.INSTANCE, Ship.class);
    }
}