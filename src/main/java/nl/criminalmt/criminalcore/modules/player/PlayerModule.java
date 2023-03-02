package nl.criminalmt.criminalcore.modules.player;

import nl.criminalmt.criminalcore.framework.modules.AbstractModule;
import nl.criminalmt.criminalcore.modules.player.listeners.BlockModificationListener;
import nl.criminalmt.criminalcore.modules.player.listeners.HealingListener;
import nl.criminalmt.criminalcore.modules.player.listeners.KnifeListener;
import nl.criminalmt.criminalcore.modules.player.commands.BroadcastCommand;
import nl.criminalmt.criminalcore.modules.player.listeners.PlayerJoinListener;

public class PlayerModule extends AbstractModule {

    @Override
    public String getName() {
        return "player";
    }

    @Override
    public void onEnable() {
        super.onEnable();

        plugin.getCommandManager().registerCommand(new BroadcastCommand());

        plugin.getServer().getPluginManager().registerEvents(new KnifeListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new BlockModificationListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new HealingListener(this), plugin);
    }

}
