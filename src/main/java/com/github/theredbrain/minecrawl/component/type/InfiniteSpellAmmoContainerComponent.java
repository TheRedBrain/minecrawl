package com.github.theredbrain.minecrawl.component.type;

import com.mojang.serialization.Codec;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipAppender;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.text.Text;

import java.util.List;
import java.util.function.Consumer;

public record InfiniteSpellAmmoContainerComponent(
		List<ItemStack> stacks
) implements TooltipAppender {
	public static final InfiniteSpellAmmoContainerComponent DEFAULT = new InfiniteSpellAmmoContainerComponent(List.of(ItemStack.EMPTY));
	public static final Codec<InfiniteSpellAmmoContainerComponent> CODEC = ItemStack.CODEC.listOf().xmap(InfiniteSpellAmmoContainerComponent::new, component -> component.stacks);
	public static final PacketCodec<RegistryByteBuf, InfiniteSpellAmmoContainerComponent> PACKET_CODEC = ItemStack.PACKET_CODEC
			.collect(PacketCodecs.toList())
			.xmap(InfiniteSpellAmmoContainerComponent::new, infiniteSpellAmmoContainerComponent -> infiniteSpellAmmoContainerComponent.stacks);

	public ItemStack get(int index) {
		return (ItemStack) this.stacks.get(index);
	}

	public int size() {
		return this.stacks.size();
	}

	public static Builder builder() {
		return new Builder(DEFAULT);
	}

	public static class Builder {
		List<ItemStack> stacks;

		public Builder(List<ItemStack> stacks) {
			this.stacks = stacks;
		}

		public Builder(InfiniteSpellAmmoContainerComponent base) {
			this(List.copyOf(base.stacks));
		}

		public InfiniteSpellAmmoContainerComponent build() {
			return new InfiniteSpellAmmoContainerComponent(List.copyOf(this.stacks));
		}
	}

	@Override
	public void appendTooltip(Item.TooltipContext context, Consumer<Text> tooltip, TooltipType type) {
		if (!this.stacks.isEmpty()) {
			tooltip.accept(Text.translatable("item.minecrawl.infinite_spell_ammo_container_component.tooltip", this.stacks.getFirst().getName()));
		}
	}
}
