package nl.criminalmt.criminalcore.modules.illegal_jobs.listeners;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.modules.illegal_jobs.JobsModule;
import nl.criminalmt.criminalcore.modules.illegal_jobs.menus.RecruiterMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class JobNPCClickListener implements Listener {
    private final JobsModule module;

    public JobNPCClickListener(JobsModule module) {
        this.module = module;
    }

    @EventHandler
    public void clickNPCJobs(NPCRightClickEvent event) {
        Player player = event.getClicker();
        String jobs = module.jobs.getConfiguration().getString("Players." + player.getUniqueId() + ".Job");
        if(event.getNPC().getName().contains("Recruiter")) {
            if(jobs == null) {
                new RecruiterMenu(player).open(player);
            } else {
                player.sendMessage(ChatUtils.format("&cJe hebt al een job gekozen!"));
            }
        }
    }
}
