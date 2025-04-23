package com.github.theredbrain.minecrawl.registry;

import com.github.theredbrain.minecrawl.Minecrawl;
import com.github.theredbrain.minecrawl.entity.passive.FakeVillagerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EntityRegistry {

	public static final EntityType<FakeVillagerEntity> FAKE_VILLAGER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
			Minecrawl.identifier("fake_villager"),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, FakeVillagerEntity::new).dimensions(EntityDimensions.changing(0.6F, 1.95F)).build());

	public static void init() {
		registerEntityAttributes();
	}

	public static void registerEntityAttributes() {
		FabricDefaultAttributeRegistry.register(EntityRegistry.FAKE_VILLAGER_ENTITY, FakeVillagerEntity.createMobAttributes());
	}
}
