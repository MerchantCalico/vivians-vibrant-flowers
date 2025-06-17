package net.merchantcalico.vibrantflowers.registry;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class VibrantFlowersSoundEvents {

	public static final SoundEvent HALTER_MELODY = register("halter_melody");
	public static final SoundEvent CHRYSANTH_MELODY = register("chrysanth_melody");

	public static SoundEvent register(String name){
		ResourceLocation location = ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, name);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, name, SoundEvent.createVariableRangeEvent(location));
	}

	public static void init(){}
}
