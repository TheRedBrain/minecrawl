package com.github.theredbrain.minecrawl.compat;

import com.github.theredbrain.minecrawl.registry.StatusEffectsRegistry;
import net.spell_engine.api.effect.Synchronized;

public class SpellEngineCompat {
	public static void configureEffects() {
		Synchronized.configure(StatusEffectsRegistry.FROZEN_SHOT_SPELL, true);
		Synchronized.configure(StatusEffectsRegistry.POWER_SHOT_SPELL, true);
	}
}
