package net.funkpla.waila_smallships;

import com.talhanation.smallships.world.entity.ship.Ship;
import mcp.mobius.waila.api.IClientRegistrar;
import mcp.mobius.waila.api.IWailaClientPlugin;

public class SmallshipsWailaClient implements IWailaClientPlugin {
    @Override
    public void register(IClientRegistrar registrar) {
        registrar.body(ShipProvider.INSTANCE, Ship.class);
    }
}