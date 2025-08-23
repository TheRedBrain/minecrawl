package com.github.theredbrain.minecrawl.item;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

import java.util.Optional;

public class SpellCastingCrossbowItem extends Item {
	private static final LoadingSounds DEFAULT_LOADING_SOUNDS = new LoadingSounds(
			Optional.of(SoundEvents.ITEM_CROSSBOW_LOADING_START),
			Optional.of(SoundEvents.ITEM_CROSSBOW_LOADING_MIDDLE),
			Optional.of(SoundEvents.ITEM_CROSSBOW_LOADING_END)
	);
	private boolean charged = false;
	private boolean loaded = false;
	private boolean ready = false;

	public SpellCastingCrossbowItem(Settings settings) {
		super(settings);
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient && entity instanceof PlayerEntity playerEntity) {
			if (playerEntity.getOffHandStack().isEmpty()) {
				float f = playerEntity.getItemCooldownManager().getCooldownProgress(stack.getItem(), 0.0F);
				if (f > 0.8F) {
					this.charged = false;
					this.loaded = false;
					this.ready = false;
				}

				if (f <= 0.8F && !this.charged) {
					this.charged = true;
					DEFAULT_LOADING_SOUNDS.start()
							.ifPresent(sound -> world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), (SoundEvent) sound.value(), SoundCategory.PLAYERS, 0.5F, 1.0F));
				}

				if (f <= 0.5F && !this.loaded) {
					this.loaded = true;
					DEFAULT_LOADING_SOUNDS.mid()
							.ifPresent(sound -> world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), (SoundEvent) sound.value(), SoundCategory.PLAYERS, 0.5F, 1.0F));
				}

				if (f <= 0.0F && !this.ready) {
					this.ready = true;
					DEFAULT_LOADING_SOUNDS.end()
							.ifPresent(sound -> world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), (SoundEvent) sound.value(), SoundCategory.PLAYERS, 0.5F, 1.0F));
				}
			}
		}
	}

	public static boolean isCharged(PlayerEntity user, ItemStack stack) {
		return !user.getItemCooldownManager().isCoolingDown(stack.getItem());
	}

	public static record LoadingSounds(Optional<RegistryEntry<SoundEvent>> start,
									   Optional<RegistryEntry<SoundEvent>> mid,
									   Optional<RegistryEntry<SoundEvent>> end) {
		public static final Codec<CrossbowItem.LoadingSounds> CODEC = RecordCodecBuilder.create(
				instance -> instance.group(
								SoundEvent.ENTRY_CODEC.optionalFieldOf("start").forGetter(CrossbowItem.LoadingSounds::start),
								SoundEvent.ENTRY_CODEC.optionalFieldOf("mid").forGetter(CrossbowItem.LoadingSounds::mid),
								SoundEvent.ENTRY_CODEC.optionalFieldOf("end").forGetter(CrossbowItem.LoadingSounds::end)
						)
						.apply(instance, CrossbowItem.LoadingSounds::new)
		);
	}
}
