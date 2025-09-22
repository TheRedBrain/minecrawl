package com.github.theredbrain.minecrawl.registry;

import com.github.theredbrain.minecrawl.Minecrawl;
import com.github.theredbrain.rpgcrafting.block.HorizontalFacingFullBlockCraftingTabProviderBlock;
import com.github.theredbrain.rpgcrafting.block.LecternShapedCraftingTabProviderBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;

public class BlockRegistry {

	// arms workbench
	public static final Block ALTERNATIVE_CRAFTING_TAB_1_BLOCK = registerBlock("alternative_crafting_tab_1_block", new HorizontalFacingFullBlockCraftingTabProviderBlock(1, Block.Settings.create()
			.mapColor(MapColor.OAK_TAN)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2.5F)
			.sounds(BlockSoundGroup.WOOD)
			.pistonBehavior(PistonBehavior.BLOCK)
			.nonOpaque()), ItemGroupRegistry.MINECRAWL);
	// smithing table
	public static final Block ALTERNATIVE_CRAFTING_TAB_2_BLOCK = registerBlock("alternative_crafting_tab_2_block", new HorizontalFacingFullBlockCraftingTabProviderBlock(2, Block.Settings.create()
			.mapColor(MapColor.OAK_TAN)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2.5F)
			.sounds(BlockSoundGroup.WOOD)
			.pistonBehavior(PistonBehavior.BLOCK)), ItemGroupRegistry.MINECRAWL);
	// jeweler's kit
	public static final Block ALTERNATIVE_CRAFTING_TAB_3_BLOCK = registerBlock("alternative_crafting_tab_3_block", new HorizontalFacingFullBlockCraftingTabProviderBlock(3, Block.Settings.create()
			.mapColor(MapColor.STONE_GRAY)
			.instrument(NoteBlockInstrument.BASEDRUM)
			.strength(2.5F)
			.sounds(BlockSoundGroup.WOOD)
			.pistonBehavior(PistonBehavior.BLOCK)
			.nonOpaque()), ItemGroupRegistry.MINECRAWL);
	// lectern
	public static final Block ALTERNATIVE_CRAFTING_TAB_4_BLOCK = registerBlock("alternative_crafting_tab_4_block", new LecternShapedCraftingTabProviderBlock(4, Block.Settings.create()
			.mapColor(MapColor.OAK_TAN)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2.5F)
			.sounds(BlockSoundGroup.WOOD)
			.pistonBehavior(PistonBehavior.BLOCK)
			.nonOpaque()), ItemGroupRegistry.MINECRAWL);

	private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> itemGroup) {
		Registry.register(Registries.ITEM, Minecrawl.identifier(name), new BlockItem(block, new Item.Settings()));
		ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> content.add(block));
		return Registry.register(Registries.BLOCK, Minecrawl.identifier(name), block);
	}

	public static void init() {
	}
}
