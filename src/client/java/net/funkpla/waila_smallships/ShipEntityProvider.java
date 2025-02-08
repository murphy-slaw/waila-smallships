package net.funkpla.waila_smallships;

import mcp.mobius.waila.api.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;

import java.util.Optional;

public enum ShipEntityProvider implements IEntityComponentProvider {
    INSTANCE;

    @Override
    public void appendBody(ITooltip tooltip, IEntityAccessor accessor, IPluginConfig config) {
        CompoundTag data = accessor.getData().raw();
        Optional<Tag> customName = Optional.ofNullable(data.get("customName"));
        if (customName.isPresent()) {
            var name = customName.get().getAsString();
            var formatter = IWailaConfig.get().getFormatter();
            tooltip.setLine(WailaConstants.OBJECT_NAME_TAG, formatter.entityName(name));
        }
        if (config.getBoolean(SmallshipsWaila.CONFIG_SHOW_TEXT)) {
            var text = Component.translatable(
                    "smallships.ship.attributes.max_speed.label",
                    data.get("maxSpeed")
            );
            tooltip.addLine(text);
        }
        if (config.getBoolean(SmallshipsWaila.CONFIG_SHOW_ICONS))
            tooltip.addLine().with(new SpeedComponent(data.getFloat("maxSpeed"), 150, 15));

        if (config.getBoolean(SmallshipsWaila.CONFIG_SHOW_TEXT)) {
            var text = Component.translatable(
                    "smallships.ship.container_size.label",
                    data.get("containerSize")
            );
            tooltip.addLine(text);
        }

        if (config.getBoolean(SmallshipsWaila.CONFIG_SHOW_ICONS))
            tooltip.addLine().with(new CargoComponent(data.getFloat("containerSize"), 10));

        IEntityComponentProvider.super.appendBody(tooltip, accessor, config);
    }

}
