package io.arona74.mendingrepaircost.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ExperienceOrbEntity.class)
public class ExperienceOrbEntityMixin {
    
    /**
     * Completely skip mending repair by returning early if any mending items are present
     * The XP will still be awarded through the normal pickup process
     */
    @Inject(method = "repairPlayerGears", at = @At("HEAD"), cancellable = true)
    private void skipMendingRepair(PlayerEntity player, int amount, CallbackInfoReturnable<Integer> cir) {
        // Check if player has any mending items
        boolean hasMendingItems = false;
        
        // Check all equipment slots
        for (ItemStack stack : player.getInventory().main) {
            if (!stack.isEmpty() && stack.isDamaged() && 
                EnchantmentHelper.getLevel(Enchantments.MENDING, stack) > 0) {
                hasMendingItems = true;
                break;
            }
        }
        
        // Check armor slots
        if (!hasMendingItems) {
            for (ItemStack stack : player.getInventory().armor) {
                if (!stack.isEmpty() && stack.isDamaged() && 
                    EnchantmentHelper.getLevel(Enchantments.MENDING, stack) > 0) {
                    hasMendingItems = true;
                    break;
                }
            }
        }
        
        // Check offhand
        if (!hasMendingItems) {
            ItemStack offhand = player.getOffHandStack();
            if (!offhand.isEmpty() && offhand.isDamaged() && 
                EnchantmentHelper.getLevel(Enchantments.MENDING, offhand) > 0) {
                hasMendingItems = true;
            }
        }
        
        // If mending items are present, return the full amount without doing any repair
        // This allows the XP to be awarded normally in the calling method
        if (hasMendingItems) {
            cir.setReturnValue(amount);
        }
    }
}