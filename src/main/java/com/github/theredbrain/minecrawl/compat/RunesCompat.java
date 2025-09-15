package com.github.theredbrain.minecrawl.compat;

import net.minecraft.item.ItemStack;
import net.runes.api.RuneItems;

public class RunesCompat {
	public static ItemStack getArcaneRuneStack() {
		return RuneItems.get(RuneItems.RuneType.ARCANE).getDefaultStack();
	}

	public static ItemStack getFireRuneStack() {
		return RuneItems.get(RuneItems.RuneType.FIRE).getDefaultStack();
	}

	public static ItemStack getFrostRuneStack() {
		return RuneItems.get(RuneItems.RuneType.FROST).getDefaultStack();
	}

	public static ItemStack getHealingRuneStack() {
		return RuneItems.get(RuneItems.RuneType.HEALING).getDefaultStack();
	}
}
