package nl.criminalmt.criminalcore.modules.illegal_jobs;

import lombok.Getter;
import lombok.Setter;
import nl.criminalmt.criminalcore.CriminalCore;
import nl.criminalmt.criminalcore.framework.file.File;
import nl.criminalmt.criminalcore.framework.modules.AbstractModule;
import nl.criminalmt.criminalcore.modules.illegal_jobs.listeners.JobNPCClickListener;


public class JobsModule extends AbstractModule {

    public File jobs = new File(CriminalCore.getInstance(), "players-jobs.yml");

    @Override
    public String getName() {
        return "jobs";
    }

    @Override
    public void onEnable() {
        super.onEnable();

        plugin.getServer().getPluginManager().registerEvents(new JobNPCClickListener(this), plugin);
    }
}
