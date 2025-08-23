package com.github.theredbrain.minecrawl;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Minecrawl implements ModInitializer {
	public static final String MOD_ID = "minecrawl";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Welcome to the Minecrawl dungeons!");


	}

	public static Identifier identifier(String path) {
		return Identifier.of(MOD_ID, path);
	}
}