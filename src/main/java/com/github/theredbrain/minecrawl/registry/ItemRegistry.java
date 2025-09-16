package com.github.theredbrain.minecrawl.registry;

import com.github.theredbrain.minecrawl.Minecrawl;
import com.github.theredbrain.minecrawl.component.type.InfiniteSpellAmmoContainerComponent;
import com.github.theredbrain.minecrawl.item.SpellCastingCrossbowItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemRegistry {

	public static final Item SPELL_CASTING_CROSSBOW_1 = registerItem("spell_casting_crossbow_1", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_2 = registerItem("spell_casting_crossbow_2", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_3 = registerItem("spell_casting_crossbow_3", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_4 = registerItem("spell_casting_crossbow_4", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_5 = registerItem("spell_casting_crossbow_5", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_6 = registerItem("spell_casting_crossbow_6", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_7 = registerItem("spell_casting_crossbow_7", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_8 = registerItem("spell_casting_crossbow_8", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_9 = registerItem("spell_casting_crossbow_9", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_10 = registerItem("spell_casting_crossbow_10", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_11 = registerItem("spell_casting_crossbow_11", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_12 = registerItem("spell_casting_crossbow_12", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);

	public static final Item INFINITE_ARROW_QUIVER = registerItem("infinite_arrow_quiver", new Item(new Item.Settings()
			.maxCount(1)
			.component(Minecrawl.INFINITE_SPELL_AMMO_CONTAINER_COMPONENT, new InfiniteSpellAmmoContainerComponent.Builder(List.of(Items.ARROW.getDefaultStack().copyWithCount(64))).build())
	), null);
	public static final Item INFINITE_ARCANE_RUNE_POUCH = registerItem("infinite_arcane_rune_pouch", new Item(new Item.Settings()
			.maxCount(1)
			.component(Minecrawl.INFINITE_SPELL_AMMO_CONTAINER_COMPONENT, new InfiniteSpellAmmoContainerComponent.Builder(List.of(Minecrawl.getArcaneRuneStack().copyWithCount(64))).build())
	), null);
	public static final Item INFINITE_FIRE_RUNE_POUCH = registerItem("infinite_fire_rune_pouch", new Item(new Item.Settings()
			.maxCount(1)
			.component(Minecrawl.INFINITE_SPELL_AMMO_CONTAINER_COMPONENT, new InfiniteSpellAmmoContainerComponent.Builder(List.of(Minecrawl.getFireRuneStack().copyWithCount(64))).build())
	), null);
	public static final Item INFINITE_FROST_RUNE_POUCH = registerItem("infinite_frost_rune_pouch", new Item(new Item.Settings()
			.maxCount(1)
			.component(Minecrawl.INFINITE_SPELL_AMMO_CONTAINER_COMPONENT, new InfiniteSpellAmmoContainerComponent.Builder(List.of(Minecrawl.getFrostRuneStack().copyWithCount(64))).build())
	), null);
	public static final Item INFINITE_HEALING_RUNE_POUCH = registerItem("infinite_healing_rune_pouch", new Item(new Item.Settings()
			.maxCount(1)
			.component(Minecrawl.INFINITE_SPELL_AMMO_CONTAINER_COMPONENT, new InfiniteSpellAmmoContainerComponent.Builder(List.of(Minecrawl.getHealingRuneStack().copyWithCount(64))).build())
	), null);

	private static Item registerItem(String name, Item item, @Nullable RegistryKey<ItemGroup> itemGroup) {

		if (itemGroup != null) {
			ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> {
				content.add(item);
			});
		}
		return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Minecrawl.identifier(name)), item);
	}

	public static void init() {
	}
}
