package com.ghostcode.combat_ding;

import com.ghostcode.combat_ding.mixin.click;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.Sound;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class main implements ModInitializer {
	//Sound ding = new Sound("entity.experience_orb.pickup", 100.0f, 50.0f, 1, Sound.RegistrationType.SOUND_EVENT, false, true, 100);
	public static final ExampleBlock EXAMPLE_BLOCK = new ExampleBlock(FabricBlockSettings.of(Material.METAL).hardness(4.0f));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		
		System.out.println("This is the Combat Ding onInitialize method!");

		Registry.register(Registry.BLOCK, new Identifier("tutorial", "example_block"), EXAMPLE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "example_block"), new BlockItem(EXAMPLE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));



		/*if (!world.isClient) {
			world.playSound(
					null, // Player - if non-null, will play sound for every nearby player *except* the specified player
					blockPos, // The position of where the sound will come from
					SoundEvents.BLOCK_ANVIL_LAND, // The sound that will play, in this case, the sound the anvil plays when it lands.
					SoundCategory.BLOCKS, // This determines which of the volume sliders affect this sound
					1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
					1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
			);
		}*/
	}
}
