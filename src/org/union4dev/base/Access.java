package org.union4dev.base;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import org.union4dev.base.command.CommandManager;

import org.union4dev.base.gui.click.ClickGuiScreen;
import org.union4dev.base.gui.font.FontManager;
import org.union4dev.base.module.ModuleManager;

/**
 * Client Entry
 * The main class where the client is loaded up.
 * Anything related to the client will start from here and managers etc instances will be stored in this class.
 *
 * @author cubk
 */
public final class Access {

    public static String CLIENT_NAME = "Client Base";

    /**
     * Client Instance, access managers with this
     */
    private static Access INSTANCE;

    /**
     * ModuleManager Instance, access modules here
     */
    private final ModuleManager moduleManager;

    /**
     * CommandManager Instance, access commands here
     */
    private final CommandManager commandManager;

    /**
     * ClickGui Instance
     */
    private final ClickGuiScreen clickGui;

    /**
     * Font renderers
     */
    private final FontManager fontManager;

    /**
     * Entry point
     */
    public Access() {
        INSTANCE = this;

        // Initialize managers
        moduleManager = new ModuleManager();
        commandManager = new CommandManager();
        fontManager = new FontManager();
        clickGui = new ClickGuiScreen();

        // Finished Initialization
        Display.setTitle(CLIENT_NAME);
    }


    /**
     * Get client instance
     *
     * @return {@link Access}
     */
    public static Access getInstance() {
        return INSTANCE;
    }

    /**
     * Get module manager instance
     *
     * @return {@link ModuleManager}
     */
    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    /**
     * Get command manager instance
     *
     * @return {@link CommandManager}
     */
    public CommandManager getCommandManager() {
        return commandManager;
    }

    /**
     * Get ClickGui Instance
     *
     * @return {@link ClickGuiScreen}
     */
    public ClickGuiScreen getClickGui() {
        return clickGui;
    }

    /**
     * Get FontManager Instance
     *
     * @return {@link FontManager}
     */
    public FontManager getFontManager() {
        return fontManager;
    }

    /**
     * Implement this class for access instances
     *
     * @author cubk
     */
    public interface InstanceAccess {
        Minecraft mc = Minecraft.getMinecraft();
        Access access = Access.getInstance();

        default void setSuffix(String suffix, Object object) {
            access.getModuleManager().getHandle(object).setSuffix(suffix);
        }

        default void setEnable(Object object, boolean state) {
            access.getModuleManager().getHandle(object).setEnable(state);
        }

        default void setEnable(Class<?> module, boolean state) {
            access.getModuleManager().setEnable(module, state);
        }

        default boolean isEnabled(Class<?> module) {
            return access.getModuleManager().isEnabled(module);
        }
    }

}
