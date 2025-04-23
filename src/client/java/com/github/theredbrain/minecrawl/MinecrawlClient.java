package com.github.theredbrain.minecrawl;

import com.github.theredbrain.minecrawl.registry.EntityRegistry;
import com.github.theredbrain.minecrawl.render.renderer.FakeVillagerEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MinecrawlClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		registerEntityRenderer();
	}

	private void registerEntityRenderer() {
		EntityRendererRegistry.register(EntityRegistry.FAKE_VILLAGER_ENTITY, FakeVillagerEntityRenderer::new);
	}
}