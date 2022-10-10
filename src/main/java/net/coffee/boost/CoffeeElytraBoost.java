package net.coffee.boost;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.math.MathHelper;



public class CoffeeElytraBoost implements ModInitializer {
	private static KeyBinding keyBinding;

	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override public void onInitialize() {


		keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
		"key.coffeeelytraboost.boost", // The translation key of the keybinding's name
		InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
		GLFW.GLFW_KEY_G, // The keycode of the key
		"category.coffeeelytraboost.boost" // The translation key of the keybinding's category.
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (keyBinding.wasPressed()) {
			float yaw = (float) Math.toRadians(client.player.getYaw()); 
				if (client.player.isFallFlying()) {
                     client.player.addVelocity(MathHelper.sin(yaw) * -0.05F, 0, MathHelper.cos(yaw) * 0.05F);
				}
			}
		});
	}
}

	
	




