package be.ghost606.trademc.handler;

import be.ghost606.trademc.client.settings.KeyBindings;
import be.ghost606.trademc.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import org.lwjgl.input.Keyboard;

import java.io.File;

/**
 * Created by Kevin on 12/07/2014.
 */
public class ConfigurationHandler {


    public static Configuration configuration;

    public static void init(File configFile) {
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
            //Resync configs
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {

        configuration.addCustomCategoryComment(Reference.Configuration.CATEGORY_KEYBINDING_NAME, Reference.Configuration.CATEGORY_KEYBINDING_COMMENT);

        KeyBindings.tradeKey = new net.minecraft.client.settings.KeyBinding(Reference.KeyBinding.TRADE, configuration.get(Reference.Configuration.CATEGORY_KEYBINDING_NAME, Reference.KeyBinding.TRADE, Keyboard.KEY_Y).getInt(Keyboard.KEY_Y), Reference.KeyBinding.CATEGORY);
        //acceptKey = new KeyBinding("key.accept", Keyboard.KEY_RSHIFT + Keyboard.KEY_)

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
