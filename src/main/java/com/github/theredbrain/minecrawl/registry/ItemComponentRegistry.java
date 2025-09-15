package com.github.theredbrain.minecrawl.registry;

import com.github.theredbrain.minecrawl.Minecrawl;
import com.github.theredbrain.minecrawl.component.type.InfiniteSpellAmmoContainerComponent;
import com.github.theredbrain.scriptblocks.ScriptBlocks;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemComponentRegistry {
	public static void init() {
		Minecrawl.INFINITE_SPELL_AMMO_CONTAINER_COMPONENT = Registry.register(
				Registries.DATA_COMPONENT_TYPE,
				ScriptBlocks.identifier("infinite_spell_ammo_container_component"),
				ComponentType.<InfiniteSpellAmmoContainerComponent>builder().codec(InfiniteSpellAmmoContainerComponent.CODEC).packetCodec(InfiniteSpellAmmoContainerComponent.PACKET_CODEC).cache().build()
		);
	}
}
