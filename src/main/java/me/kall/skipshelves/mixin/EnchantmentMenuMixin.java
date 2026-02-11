package me.kall.skipshelves.mixin;

import me.kall.skipshelves.SkipShelves;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(EnchantmentMenu.class)
public abstract class EnchantmentMenuMixin {
    @Dynamic
    @ModifyConstant(method = {"method_17411", "lambda$slotsChanged$0", "func_217002_a"}, constant = @Constant(intValue = 0, ordinal = 0))
    private int modifyPower(int origin) {
        return SkipShelves.POWER.get();
    }

    @Dynamic
    @Redirect(method = {"method_17411", "lambda$slotsChanged$0", "func_217002_a"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;isEmptyBlock(Lnet/minecraft/core/BlockPos;)Z", ordinal = 0))
    private boolean skip(Level instance, BlockPos pos) {
        return false;
    }
}
