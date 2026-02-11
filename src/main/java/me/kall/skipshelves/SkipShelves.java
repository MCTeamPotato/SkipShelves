package me.kall.skipshelves;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(SkipShelves.MOD_ID)
public final class SkipShelves {
    public static final String MOD_ID = "skipshelves";

    public SkipShelves() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CONFIG);
    }

    public static final ForgeConfigSpec CONFIG;
    public static final ForgeConfigSpec.IntValue POWER;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("SkipShelves");
        POWER = builder.defineInRange("EnchantmentTablePower", 15, 0, Integer.MAX_VALUE);
        builder.pop();
        CONFIG = builder.build();
    }
}
