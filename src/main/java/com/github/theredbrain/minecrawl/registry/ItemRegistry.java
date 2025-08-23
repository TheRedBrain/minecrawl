package com.github.theredbrain.minecrawl.registry;

import com.github.theredbrain.minecrawl.Minecrawl;
import com.github.theredbrain.minecrawl.item.SpellCastingCrossbowItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import org.jetbrains.annotations.Nullable;

public class ItemRegistry {

	public static final Item SPELL_CASTING_CROSSBOW_1 = registerItem("spell_casting_crossbow_1", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_2 = registerItem("spell_casting_crossbow_2", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_3 = registerItem("spell_casting_crossbow_3", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_4 = registerItem("spell_casting_crossbow_4", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_5 = registerItem("spell_casting_crossbow_5", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_6 = registerItem("spell_casting_crossbow_6", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_7 = registerItem("spell_casting_crossbow_7", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);
	public static final Item SPELL_CASTING_CROSSBOW_8 = registerItem("spell_casting_crossbow_8", new SpellCastingCrossbowItem(new Item.Settings().maxCount(1)), null);

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
