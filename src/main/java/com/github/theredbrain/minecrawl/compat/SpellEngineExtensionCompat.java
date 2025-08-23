package com.github.theredbrain.minecrawl.compat;

import com.github.theredbrain.minecrawl.registry.StatusEffectsRegistry;
import com.github.theredbrain.spellengineextension.entity.effect.ProvidesSpell;

import java.util.List;

public class SpellEngineExtensionCompat {
	public static void configureEffects() {
		ProvidesSpell.configure(StatusEffectsRegistry.FROZEN_SHOT_SPELL, List.of("minecrawl:frozen_shot_modifier"));
		ProvidesSpell.configure(StatusEffectsRegistry.POWER_SHOT_SPELL, List.of("minecrawl:power_shot_modifier"));
	}
}
