package me.kall.skipshelves.mixin;

import me.kall.skipshelves.SkipShelves;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantmentMenu.class)
public abstract class EnchantmentMenuMixin {
    @Dynamic
    @Redirect(method = {"method_17411", "lambda$slotsChanged$0", "m_39483_"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/EnchantmentTableBlock;isValidBookShelf(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/BlockPos;)Z"), require = 0)
    private boolean onEnchant(Level level, BlockPos tablePos, BlockPos offsetPos) {
        return false;
    }

    @Dynamic
    @ModifyConstant(method = {"method_17411", "lambda$slotsChanged$0", "m_39483_"}, constant = @Constant(floatValue = 0.0F))
    private float modifyPower(float origin) {
        return SkipShelves.POWER.get().floatValue();
    }
}
