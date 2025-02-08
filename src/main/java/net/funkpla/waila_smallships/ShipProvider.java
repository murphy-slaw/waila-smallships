package net.funkpla.waila_smallships;

import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.Ship;
import mcp.mobius.waila.api.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.Mth;

public enum ShipProvider implements IDataProvider<Ship>, IEntityComponentProvider {
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

    @Override
    public void appendBody(ITooltip tooltip, IEntityAccessor accessor, IPluginConfig config) {
        CompoundTag data = accessor.getData().raw();
        MutableComponent text = Component.literal(data.get("customName").getAsString());
        tooltip.addLine(text);

        text = Component.translatable(
                "smallships.ship.attributes.max_speed.label",
                data.get("maxSpeed")
        );
        tooltip.addLine(text);

        text = Component.translatable(
                "smallships.ship.container_size.label",
                data.get("containerSize")
        );
        tooltip.addLine(text);

        IEntityComponentProvider.super.appendBody(tooltip, accessor, config);
    }

}
