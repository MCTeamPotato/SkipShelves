package me.kall.skipshelves;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;

@Mod(SkipShelves.MOD_ID)
public final class SkipShelves {
    public static final String MOD_ID = "skipshelves";

    public SkipShelves(@NotNull FMLJavaModLoadingContext context) {
        context.registerConfig(ModConfig.Type.COMMON, CONFIG);
    }

    public static final ForgeConfigSpec CONFIG;
    public static final ForgeConfigSpec.DoubleValue POWER;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("SkipShelves");
        POWER = builder.defineInRange("EnchantmentTablePower", 15.0D, 0.0D, Double.MAX_VALUE);
        builder.pop();
        CONFIG = builder.build();
    }
}
