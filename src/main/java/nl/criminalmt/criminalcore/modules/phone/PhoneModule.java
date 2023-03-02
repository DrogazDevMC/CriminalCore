package nl.criminalmt.criminalcore.modules.phone;

import nl.criminalmt.criminalcore.CriminalCore;
import nl.criminalmt.criminalcore.framework.file.File;
import nl.criminalmt.criminalcore.framework.modules.AbstractModule;
import nl.criminalmt.criminalcore.modules.phone.listeners.OpenPhoneListener;

public class PhoneModule extends AbstractModule {
    @Override
    public String getName() {
        return "phone";
    }

    @Override
    public void onEnable() {
        super.onEnable();

        plugin.getServer().getPluginManager().registerEvents(new OpenPhoneListener(), plugin);


    }
}
