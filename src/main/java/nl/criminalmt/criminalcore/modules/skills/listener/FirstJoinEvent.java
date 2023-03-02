package nl.criminalmt.criminalcore.modules.skills.listener;

import nl.criminalmt.criminalcore.framework.configs.SkillsYML;
import nl.criminalmt.criminalcore.modules.skills.SkillsModule;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstJoinEvent implements Listener {

    private final SkillsModule module;

    public FirstJoinEvent(SkillsModule module) {
        this.module = module;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        boolean hasPlayedBefore = player.hasPlayedBefore();

        if (!hasPlayedBefore) {
            SkillsYML.get().set("Skills." + player.getUniqueId() + ".CarCrafting.LEVEL", 0);
            SkillsYML.get().set("Skills." + player.getUniqueId() + ".CarCrafting.EXP", 0);

            SkillsYML.get().set("Skills." + player.getUniqueId() + ".Criminal.LEVEL", 0);
            SkillsYML.get().set("Skills." + player.getUniqueId() + ".Criminal.EXP", 0);

            SkillsYML.get().set("Skills." + player.getUniqueId() + ".Jobs.LEVEL", 0);
            SkillsYML.get().set("Skills." + player.getUniqueId() + ".Jobs.EXP", 0);
            SkillsYML.save();
        }
    }
}
