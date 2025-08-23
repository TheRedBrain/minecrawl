package com.github.theredbrain.minecrawl.mixin.client.render.entity;

import com.github.theredbrain.minecrawl.item.SpellCastingCrossbowItem;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {

	@WrapMethod(method = "getArmPose")
	private static BipedEntityModel.ArmPose getArmPose(AbstractClientPlayerEntity player, Hand hand, Operation<BipedEntityModel.ArmPose> original) {
		ItemStack itemStack = player.getStackInHand(hand);
		if (!itemStack.isEmpty()) {
			if (player.getActiveHand() == hand && itemStack.getItem() instanceof SpellCastingCrossbowItem) {
				if (SpellCastingCrossbowItem.isCharged(player, itemStack)) {
					return BipedEntityModel.ArmPose.CROSSBOW_HOLD;
				} else {
					return BipedEntityModel.ArmPose.CROSSBOW_CHARGE;
				}
			}
		}
		return original.call(player, hand);
	}

}
