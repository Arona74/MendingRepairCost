package io.arona74.mendingrepaircost.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(ExperienceOrbEntity.class)
public class ExperienceOrbEntityMixin {
    
    /**
     * Prevents the vanilla mending repair logic from running
     */
    @Inject(method = "repairPlayerGears", at = @At("HEAD"), cancellable = true)
    private void preventMendingRepair(PlayerEntity player, int amount, CallbackInfoReturnable<Integer> cir) {
        // Get the equipment slot and item that would normally be repaired by mending
        Map.Entry<EquipmentSlot, ItemStack> entry = EnchantmentHelper.chooseEquipmentWith(
            Enchantments.MENDING, player, ItemStack::isDamaged
        );
        
        // If there is a mending item, we still want XP to be given to player
        // but we don't want the repair to happen
        if (entry != null) {
            // Cancel the vanilla repair logic
            cir.setReturnValue(0);
            
            // The XP will still be given to the player through the normal XP pickup logic
            // which happens elsewhere in the code
        }
    }
}