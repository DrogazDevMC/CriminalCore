package nl.criminalmt.criminalcore.modules.drugs;

import lombok.Getter;
import lombok.Setter;
import nl.criminalmt.criminalcore.framework.modules.AbstractModule;
import nl.criminalmt.criminalcore.modules.drugs.commands.VerkoopCMD;
import nl.criminalmt.criminalcore.modules.drugs.listeners.ClickDealerNPC;
import nl.criminalmt.criminalcore.modules.drugs.listeners.ClickLaundryNPC;
import nl.criminalmt.criminalcore.modules.drugs.listeners.ClickProcessTableListener;
import nl.criminalmt.criminalcore.modules.drugs.listeners.HarvestDrugsListener;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.UUID;

public class DrugsModule extends AbstractModule {
    @Override
    public String getName() {
        return "drugs";
    }

    @Getter @Setter private Location opiumPluk = new Location(Bukkit.getWorld("devworld"), -301, 4, -202);
    @Getter @Setter private Location wietPluk = new Location(Bukkit.getWorld("devworld"), 1290, 4, 652);
    @Getter @Setter private Location cokePluk = new Location(Bukkit.getWorld("devworld"), -301, 4, -216);
    @Getter @Setter private Location methPluk = new Location(Bukkit.getWorld("devworld"), -301, 4, -230);
    @Getter private Location verwerk = new Location(Bukkit.getWorld("devworld"), -318, 4, -216);
    @Getter @Setter private HashMap<UUID, Boolean> isHarvesting = new HashMap<UUID, Boolean>();
    @Getter @Setter private HashMap<UUID, String> harvestingType = new HashMap<UUID, String>();

    @Override
    public void onEnable() {
        super.onEnable();

        plugin.getServer().getPluginManager().registerEvents(new ClickProcessTableListener(this), plugin);
        plugin.getServer().getPluginManager().registerEvents(new HarvestDrugsListener(this), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ClickDealerNPC(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ClickLaundryNPC(), plugin);

        plugin.getCommand("drugs").setExecutor(new VerkoopCMD());

    }
}
