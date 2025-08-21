package io.arona74.mendingrepaircost.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemStack.class)
public class ItemStackMixin {

    @ModifyVariable(
        method = "setRepairCost",
        at = @At("HEAD"),
        argsOnly = true
    )
    private int forceZeroRepairCostForMending(int repairCost) {
        ItemStack stack = (ItemStack) (Object) this;

        if (EnchantmentHelper.getLevel(Enchantments.MENDING, stack) > 0) {
            return 0;
        }
        return repairCost;
    }
}
