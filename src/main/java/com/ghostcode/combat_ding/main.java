package com.ghostcode.combat_ding;

import com.ghostcode.combat_ding.mixin.SheepShearCallback;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.*;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class main implements ModInitializer {
	//Sound ding = new Sound("entity.experience_orb.pickup", 100.0f, 50.0f, 1, Sound.RegistrationType.SOUND_EVENT, false, true, 100);
	public static final ExampleBlock EXAMPLE_BLOCK = new ExampleBlock(FabricBlockSettings.of(Material.METAL).hardness(4.0f));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Registering event!");
		SheepShearCallback.EVENT.register((player, sheep) -> {
			System.out.println("Shear (main)");
			player.sendMessage(new LiteralText("Shear"), false);

			sheep.setSheared(true);

			// create diamond item entity at sheep position
			ItemStack stack = new ItemStack(Items.DIAMOND);
			ItemEntity itemEntity = new ItemEntity(player.world, sheep.getX(), sheep.getY(), sheep.getZ(), stack);
			player.world.spawnEntity(itemEntity);

			return ActionResult.FAIL;
		});
		
		System.out.println("This is the Combat Ding onInitialize method!");

		Registry.register(Registry.BLOCK, new Identifier("tutorial", "example_block"), EXAMPLE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "example_block"), new BlockItem(EXAMPLE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
	}
}
