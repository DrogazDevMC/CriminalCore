package nl.criminalmt.criminalcore;

import co.aikar.commands.CommandManager;
import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import nl.criminalmt.criminalcore.framework.gui.InventoryListener;
import nl.criminalmt.criminalcore.framework.modules.AbstractModule;
import nl.criminalmt.criminalcore.modules.drugs.DrugsModule;
import nl.criminalmt.criminalcore.modules.phone.PhoneModule;
import nl.criminalmt.criminalcore.modules.player.PlayerModule;
import nl.criminalmt.criminalcore.modules.plugin.PluginModule;
import nl.criminalmt.criminalcore.modules.skills.SkillsModule;
import nl.criminalmt.criminalcore.modules.tankstation_overval.TankstationModule;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class CriminalCore extends JavaPlugin {

    @Getter private static CriminalCore instance;
    @Getter private PaperCommandManager commandManager;

    private final List<AbstractModule> modules = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        this.commandManager = new PaperCommandManager(this);
        this.getServer().getPluginManager().registerEvents(new InventoryListener(), this);

        this.initiateModules(
                new PluginModule(),
                new PlayerModule(),
                new PhoneModule(),
//		        new TurfWarsModule(),
//		        new DrugsModule(),
		        new SkillsModule(),
                new TankstationModule());

        this.modules.forEach(AbstractModule::onEnable);
    }

    @Override
    public void onDisable() {
        this.modules.forEach(AbstractModule::onEnable);
    }

    private Optional<AbstractModule> findModule(String name) {
        return this.modules.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findAny();
    }

    private void initiateModules(AbstractModule... modules) {
        this.modules.addAll(Arrays.asList(modules));
    }
}
