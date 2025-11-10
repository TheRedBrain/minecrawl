package com.github.theredbrain.minecrawl.compat;

import com.github.theredbrain.minecrawl.Minecrawl;
import com.github.theredbrain.minecrawl.component.type.InfiniteSpellAmmoContainerComponent;
import net.minecraft.item.ItemStack;
import net.spell_engine.compat.container.ContainerCompat;

import java.util.List;

public class SpellEngineCompat {

	public static void initContainerCompat() {
		ContainerCompat.resolvers.add((itemStack) -> {
			InfiniteSpellAmmoContainerComponent infiniteSpellAmmoContainerComponent = itemStack.get(Minecrawl.INFINITE_SPELL_AMMO_CONTAINER_COMPONENT);
			return infiniteSpellAmmoContainerComponent != null ? new InfiniteAmmoItemAdapter(infiniteSpellAmmoContainerComponent) : null;
		});
	}

	public record InfiniteAmmoItemAdapter(
			InfiniteSpellAmmoContainerComponent component
	) implements ContainerCompat.Adapter {

		@Override
		public int size() {
			return this.component.size();
		}

		@Override
		public ItemStack get(int index) {
			return this.component.get(index).copy();
		}

		@Override
		public InfiniteAmmoItemAdapter createNewWithContents(List<ItemStack> contents) {
			InfiniteSpellAmmoContainerComponent.Builder newBundle = new InfiniteSpellAmmoContainerComponent.Builder(this.component);
			return new InfiniteAmmoItemAdapter(newBundle.build());
		}

		@Override
		public void attachTo(ItemStack itemStack) {
			itemStack.set(Minecrawl.INFINITE_SPELL_AMMO_CONTAINER_COMPONENT, this.component);
		}
	}
}
