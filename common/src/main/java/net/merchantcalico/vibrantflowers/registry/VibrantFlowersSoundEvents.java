package net.merchantcalico.vibrantflowers.registry;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class VibrantFlowersSoundEvents {

	public static final SoundEvent CHRYSANTHEMUM_BLOCK_MELODY = register("block.chrysanthemum.melody");
	public static final SoundEvent HALTER_BLOCK_MELODY = register("block.halter.melody");

	public static SoundEvent register(String name){
		ResourceLocation location = ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, name);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, name, SoundEvent.createVariableRangeEvent(location));
	}

	public static void init(){}
}
