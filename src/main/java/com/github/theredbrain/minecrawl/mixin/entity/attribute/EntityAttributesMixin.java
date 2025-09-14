package com.github.theredbrain.minecrawl.mixin.entity.attribute;

import com.github.theredbrain.minecrawl.Minecrawl;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityAttributes.class)
public class EntityAttributesMixin {
	static {
		Minecrawl.ATTACK_RANGE = Registry.registerReference(Registries.ATTRIBUTE, Minecrawl.identifier("generic.active_range"), new ClampedEntityAttribute("attribute.name.generic.attack_range", 0.0, 0.0, 1024.0).setTracked(true));
	}
}
