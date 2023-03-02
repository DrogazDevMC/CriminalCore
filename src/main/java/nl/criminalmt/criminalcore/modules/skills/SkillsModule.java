package nl.criminalmt.criminalcore.modules.skills;

import lombok.Getter;
import lombok.Setter;
import nl.criminalmt.criminalcore.CriminalCore;
import nl.criminalmt.criminalcore.framework.configs.SkillsYML;
import nl.criminalmt.criminalcore.framework.file.File;
import nl.criminalmt.criminalcore.framework.modules.AbstractModule;
import nl.criminalmt.criminalcore.modules.skills.listener.FirstJoinEvent;
import nl.criminalmt.criminalcore.modules.skills.listener.NPCClickListener;

public class SkillsModule extends AbstractModule {
    @Override
    public String getName() {
        return "skills";
    }


    @Override
    public void onEnable() {
        super.onEnable();

        plugin.getServer().getPluginManager().registerEvents(new NPCClickListener(this), plugin);
        plugin.getServer().getPluginManager().registerEvents(new FirstJoinEvent(this), plugin);
        SkillsYML.setup();


    }
}
