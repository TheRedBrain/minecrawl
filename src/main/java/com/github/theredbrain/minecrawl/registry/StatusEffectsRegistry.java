package com.github.theredbrain.minecrawl.registry;

import com.github.theredbrain.minecrawl.Minecrawl;
import com.github.theredbrain.variousstatuseffects.effect.BeneficialStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.RemoveEffectsStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public class StatusEffectsRegistry {

	public static final StatusEffect FROZEN_SHOT_SPELL = new BeneficialStatusEffect();
	public static final StatusEffect POWER_SHOT_SPELL = new BeneficialStatusEffect();
	public static final StatusEffect REMOVE_RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS = new RemoveEffectsStatusEffect(Minecrawl.RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS, StatusEffectCategory.HARMFUL, 3381504);

	public static void registerEffects() {
//		ServerConfig serverConfig = VariousStatusEffects.SERVER_CONFIG;
		// --- Attribute Modifiers ---

		// --- Configuration ---
		Minecrawl.configureEffects();

		// --- Registration ---
		Minecrawl.FROZEN_SHOT_SPELL = register("frozen_shot_spell", FROZEN_SHOT_SPELL);
		Minecrawl.POWER_SHOT_SPELL = register("power_shot_spell", POWER_SHOT_SPELL);
		Minecrawl.REMOVE_RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS = register("remove_ranged_attacks_modifier_spell_effects", REMOVE_RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS);
	}

	private static RegistryEntry<StatusEffect> register(String identifierString, StatusEffect statusEffect) {
		return Registry.registerReference(Registries.STATUS_EFFECT, Minecrawl.identifier(identifierString), statusEffect);
	}
}
