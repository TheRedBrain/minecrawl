package com.github.theredbrain.minecrawl;

import com.github.theredbrain.minecrawl.compat.RunesCompat;
import com.github.theredbrain.minecrawl.compat.SpellEngineCompat;
import com.github.theredbrain.minecrawl.compat.SpellEngineExtensionCompat;
import com.github.theredbrain.minecrawl.component.type.InfiniteSpellAmmoContainerComponent;
import com.github.theredbrain.minecrawl.registry.BlockRegistry;
import com.github.theredbrain.minecrawl.registry.ItemComponentRegistry;
import com.github.theredbrain.minecrawl.registry.ItemGroupRegistry;
import com.github.theredbrain.minecrawl.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.component.ComponentType;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class Minecrawl implements ModInitializer {
	public static final String MOD_ID = "minecrawl";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
//	public static ServerConfig SERVER_CONFIG;

	public static final boolean isRunesLoaded = FabricLoader.getInstance().isModLoaded("runes");
	public static final boolean isSpellEngineLoaded = FabricLoader.getInstance().isModLoaded("spell_engine");
	public static final boolean isSpellEngineExtensionLoaded = FabricLoader.getInstance().isModLoaded("spellengineextension");
	public static final boolean isMergedItemsLoaded = FabricLoader.getInstance().isModLoaded("mergeditems");

//	public static RegistryEntry<StatusEffect> POWER_SHOT_SPELL;
//	public static RegistryEntry<StatusEffect> FROZEN_SHOT_SPELL;
//	public static RegistryEntry<StatusEffect> REMOVE_RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS;

//	public static RegistryEntry<StatusEffect> FIRE_BLAST_MODIFIER_1;
//	public static RegistryEntry<StatusEffect> FIRE_BLAST_MODIFIER_2;

//	public static TagKey<StatusEffect> RANGED_ATTACKS_MODIFIER_SPELL_EFFECTS = TagKey.of(RegistryKeys.STATUS_EFFECT, identifier("ranged_attacks_modifier_spell_effects"));

	public static ComponentType<InfiniteSpellAmmoContainerComponent> INFINITE_SPELL_AMMO_CONTAINER_COMPONENT;

	public static ItemStack getArcaneRuneStack() {
		if (isRunesLoaded) {
			return RunesCompat.getArcaneRuneStack();
		}
		return ItemStack.EMPTY;
	}

	public static ItemStack getFireRuneStack() {
		if (isRunesLoaded) {
			return RunesCompat.getFireRuneStack();
		}
		return ItemStack.EMPTY;
	}

	public static ItemStack getFrostRuneStack() {
		if (isRunesLoaded) {
			return RunesCompat.getFrostRuneStack();
		}
		return ItemStack.EMPTY;
	}

	public static ItemStack getHealingRuneStack() {
		if (isRunesLoaded) {
			return RunesCompat.getHealingRuneStack();
		}
		return ItemStack.EMPTY;
	}

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
//		SERVER_CONFIG = ConfigApiJava.registerAndLoadConfig(ServerConfig::new);

		BlockRegistry.init();
		ItemComponentRegistry.init();
		ItemGroupRegistry.init();
		ItemRegistry.init();

		if (isSpellEngineLoaded) {
			SpellEngineCompat.initContainerCompat();
			SpellEngineCompat.registerCustomImpacts();
		}

		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(MOD_ID);
		if (modContainer.isPresent()) {
			ResourceManagerHelper.registerBuiltinResourcePack(identifier("minecrawl_core"), modContainer.get(), Text.translatable("resourcepack.minecrawl.minecrawl_core.name"), ResourcePackActivationType.ALWAYS_ENABLED);
			if (isMergedItemsLoaded) {
				ResourceManagerHelper.registerBuiltinResourcePack(identifier("minecrawl_item_merging"), modContainer.get(), Text.translatable("resourcepack.minecrawl.minecrawl_item_merging.name"), ResourcePackActivationType.DEFAULT_ENABLED);
			}
//			ResourceManagerHelper.registerBuiltinResourcePack(identifier("minecrawl_item_modifications"), modContainer.get(), Text.translatable("resourcepack.minecrawl.minecrawl_item_modifications.name"), ResourcePackActivationType.DEFAULT_ENABLED);
			// TODO integrate into minecrawl_item_modifications?
			ResourceManagerHelper.registerBuiltinResourcePack(identifier("minecrawl_rpg_inventory_integration"), modContainer.get(), Text.translatable("resourcepack.minecrawl.minecrawl_rpg_inventory_integration.name"), ResourcePackActivationType.DEFAULT_ENABLED);
//			ResourceManagerHelper.registerBuiltinResourcePack(identifier("minecrawl_spells"), modContainer.get(), Text.translatable("resourcepack.minecrawl.minecrawl_spells.name"), ResourcePackActivationType.DEFAULT_ENABLED);
			ResourceManagerHelper.registerBuiltinResourcePack(identifier("minecrawl_resource_pack"), modContainer.get(), Text.translatable("resourcepack.minecrawl.minecrawl_resource_pack.name"), ResourcePackActivationType.DEFAULT_ENABLED);
		}
	}

	public static Identifier identifier(String path) {
		return Identifier.of(MOD_ID, path);
	}
}