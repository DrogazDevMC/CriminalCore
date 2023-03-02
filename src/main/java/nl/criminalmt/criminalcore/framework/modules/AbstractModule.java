package nl.criminalmt.criminalcore.framework.modules;

import nl.criminalmt.criminalcore.CriminalCore;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public abstract class AbstractModule implements Listener {

    protected final CriminalCore plugin = CriminalCore.getInstance();
    public abstract String getName();

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    public CriminalCore getPlugin() {
        return this.plugin;
    }

}
