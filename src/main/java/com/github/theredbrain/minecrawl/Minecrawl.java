package com.github.theredbrain.minecrawl;

import com.github.theredbrain.minecrawl.compat.SpellEngineCompat;
import com.github.theredbrain.minecrawl.compat.SpellEngineExtensionCompat;
import com.github.theredbrain.minecrawl.registry.ItemRegistry;
import com.github.theredbrain.minecrawl.registry.StatusEffectsRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Minecrawl implements ModInitializer {
	public static final String MOD_ID = "minecrawl";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final boolean isSpellEngineLoaded = FabricLoader.getInstance().isModLoaded("spell_engine");
	public static final boolean isSpellEngineExtensionLoaded = FabricLoader.getInstance().isModLoaded("spellengineextension");

	public static RegistryEntry<StatusEffect> POWER_SHOT_SPELL;
	public static RegistryEntry<StatusEffect> FROZEN_SHOT_SPELL;
	public static RegistryEntry<StatusEffect> REMOVE_RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS;

	public static TagKey<StatusEffect> RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS = TagKey.of(RegistryKeys.STATUS_EFFECT, identifier("ranged_attacks_modifier_spell_effects"));

	public static void configureEffects() {
		if (isSpellEngineLoaded) {
			SpellEngineCompat.configureEffects();
		}
		if (isSpellEngineExtensionLoaded) {
			SpellEngineExtensionCompat.configureEffects();
		}
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Welcome to the Minecrawl dungeons!");

		ItemRegistry.init();
		StatusEffectsRegistry.registerEffects();

	}

	public static Identifier identifier(String path) {
		return Identifier.of(MOD_ID, path);
	}
}