package net.funkpla.waila_smallships;

import com.talhanation.smallships.world.entity.ship.Ship;
import mcp.mobius.waila.api.IClientRegistrar;
import mcp.mobius.waila.api.IWailaClientPlugin;
import net.minecraft.resources.ResourceLocation;

import static net.funkpla.waila_smallships.SmallshipsWaila.MOD_ID;

public class SmallshipsWailaClient implements IWailaClientPlugin {

    public static final ResourceLocation ICON_TEXTURE = new ResourceLocation(MOD_ID, "textures/gui/icons.png");
    public static final int ICON_SIZE = 10;
    public static final int ATLAS_WIDTH = 30;
    public static final int ATLAS_HEIGHT = 20;

    @Override
    public void register(IClientRegistrar registrar) {
        registrar.body(ShipEntityProvider.INSTANCE, Ship.class);
    }
}