package com.github.theredbrain.minecrawl.registry;

import com.github.theredbrain.minecrawl.Minecrawl;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public class StatusEffectsRegistry {

//	public static final StatusEffect FROZEN_SHOT_SPELL = new MinecrawlStatusEffect(StatusEffectCategory.BENEFICIAL);
//	public static final StatusEffect POWER_SHOT_SPELL = new MinecrawlStatusEffect(StatusEffectCategory.BENEFICIAL);

	// not needed, can use status effect spell impact with apply_mode REMOVE, if the pattern matcher supports tags
//	public static final StatusEffect REMOVE_RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS = new RemoveEffectsStatusEffect(Minecrawl.RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS, StatusEffectCategory.HARMFUL, 3381504);

//	public static final StatusEffect FIRE_BLAST_MODIFIER_1 = new MinecrawlStatusEffect(StatusEffectCategory.BENEFICIAL);
//	public static final StatusEffect FIRE_BLAST_MODIFIER_2 = new MinecrawlStatusEffect(StatusEffectCategory.BENEFICIAL);

	public static void registerEffects() {
		// --- Attribute Modifiers ---

		// --- Configuration ---
		Minecrawl.configureEffects();

		// --- Registration ---
//		Minecrawl.FROZEN_SHOT_SPELL = register("frozen_shot_spell", FROZEN_SHOT_SPELL);
//		Minecrawl.POWER_SHOT_SPELL = register("power_shot_spell", POWER_SHOT_SPELL);
//		Minecrawl.REMOVE_RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS = register("remove_ranged_attacks_modifier_spell_effects", REMOVE_RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS);
//		Minecrawl.FIRE_BLAST_MODIFIER_1 = register("fire_blast_modifier_1", FIRE_BLAST_MODIFIER_1);
//		Minecrawl.FIRE_BLAST_MODIFIER_2 = register("fire_blast_modifier_2", FIRE_BLAST_MODIFIER_2);
	}

	private static RegistryEntry<StatusEffect> register(String identifierString, StatusEffect statusEffect) {
		return Registry.registerReference(Registries.STATUS_EFFECT, Minecrawl.identifier(identifierString), statusEffect);
	}
}
