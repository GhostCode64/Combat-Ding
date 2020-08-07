package com.ghostcode.combat_ding;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.Sound;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class main implements ModInitializer {
	SoundInstance ding = new SoundInstance() {
	}

			//new SoundIns("entity.experience_orb.pickup", 100.0f, 50.0f, 1, Sound.RegistrationType.SOUND_EVENT, false, true, 100);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Ding volume level: " + ding.getVolume());

		PositionedSoundInstance sound = PositionedSoundInstance.master(soundEvent, Pling.getConfig().pitch);

		MinecraftClient.getInstance().getSoundManager().play(ding);

		System.out.println("Hello Fabric world!");
	}
}
