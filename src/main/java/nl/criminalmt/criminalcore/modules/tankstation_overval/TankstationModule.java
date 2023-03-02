package nl.criminalmt.criminalcore.modules.tankstation_overval;

import lombok.Getter;
import lombok.Setter;
import nl.criminalmt.criminalcore.CriminalCore;
import nl.criminalmt.criminalcore.framework.file.File;
import nl.criminalmt.criminalcore.framework.modules.AbstractModule;
import nl.criminalmt.criminalcore.modules.phone.listeners.OpenPhoneListener;
import nl.criminalmt.criminalcore.modules.tankstation_overval.listeners.NPCClickListener;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.UUID;

public class TankstationModule extends AbstractModule {
    @Override
    public String getName() {
        return "tankstation";
    }

    @Getter @Setter private boolean isOverval = false;


    @Override
    public void onEnable() {
        super.onEnable();

        plugin.getServer().getPluginManager().registerEvents(new NPCClickListener(this), plugin);


    }
}
