package me.kall.skipshelves;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.jetbrains.annotations.NotNull;

@Mod(SkipShelves.MOD_ID)
public final class SkipShelves {
    public static final String MOD_ID = "skipshelves";

    public SkipShelves(IEventBus modBus, Dist dist, @NotNull ModContainer container) {
        container.registerConfig(ModConfig.Type.COMMON, CONFIG);
    }

    public static final ModConfigSpec CONFIG;
    public static final ModConfigSpec.DoubleValue POWER;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.push("SkipShelves");
        POWER = builder.defineInRange("EnchantmentTablePower", 15.0D, 0.0D, Double.MAX_VALUE);
        builder.pop();
        CONFIG = builder.build();
    }
}
