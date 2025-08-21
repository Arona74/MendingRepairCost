package io.arona74.mendingrepaircost;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.TypedActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MendingRepairCostMod implements ModInitializer {
    public static final String MOD_ID = "mendingrepaircost";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("MendingRepairCost mod initialized!");
        
        // Register event to reset repair cost when items with mending are used
        UseItemCallback.EVENT.register((player, world, hand) -> {
            ItemStack stack = player.getStackInHand(hand);
            
            // Check if item has mending and was just repaired (durability changed)
            if (!stack.isEmpty() && EnchantmentHelper.getLevel(Enchantments.MENDING, stack) > 0) {
                // Reset repair cost for mending items
                stack.setRepairCost(0);
            }
            
            return TypedActionResult.pass(stack);
        });
    }
    
    /**
     * Reset repair cost for mending items when they are modified
     */
    public static void resetMendingRepairCost(ItemStack stack) {
        if (!stack.isEmpty() && EnchantmentHelper.getLevel(Enchantments.MENDING, stack) > 0) {
            stack.setRepairCost(0);
        }
    }
}