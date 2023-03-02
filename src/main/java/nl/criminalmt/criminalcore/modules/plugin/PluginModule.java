package nl.criminalmt.criminalcore.modules.plugin;

import nl.criminalmt.criminalcore.framework.modules.AbstractModule;
import nl.criminalmt.criminalcore.modules.plugin.commands.PluginInfoCommand;

public class PluginModule extends AbstractModule {

    @Override
    public String getName() {
        return "plugin";
    }

    @Override
    public void onEnable() {
        super.onEnable();

        plugin.getCommandManager().registerCommand(new PluginInfoCommand(this));
    }
}
