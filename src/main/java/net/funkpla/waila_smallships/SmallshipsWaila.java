package net.funkpla.waila_smallships;

import com.talhanation.smallships.world.entity.ship.Ship;
import mcp.mobius.waila.api.ICommonRegistrar;
import mcp.mobius.waila.api.IWailaCommonPlugin;
import net.minecraft.resources.ResourceLocation;

public class SmallshipsWaila implements IWailaCommonPlugin {
    public static final String MOD_ID = "waila_smallships";
    public static final ResourceLocation CONFIG_SHOW_ICONS = new ResourceLocation(MOD_ID,"show_icons");
    public static final ResourceLocation CONFIG_SHOW_TEXT = new ResourceLocation(MOD_ID,"show_text");

    @Override
    public void register(ICommonRegistrar registrar) {
        registrar.entityData(ShipDataProvider.INSTANCE, Ship.class);
        registrar.localConfig(CONFIG_SHOW_ICONS, true);
        registrar.localConfig(CONFIG_SHOW_TEXT, true);
    }
}