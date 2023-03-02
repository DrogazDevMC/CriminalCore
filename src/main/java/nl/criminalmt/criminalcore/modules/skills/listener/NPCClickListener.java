package nl.criminalmt.criminalcore.modules.skills.listener;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import nl.criminalmt.criminalcore.CriminalCore;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.modules.skills.SkillsModule;
import nl.criminalmt.criminalcore.modules.skills.menus.SkillsMenu;
import nl.criminalmt.criminalcore.modules.tankstation_overval.TankstationModule;
import nl.criminalmt.criminalcore.modules.tankstation_overval.tasks.OvervalTimer;
import nl.criminalmt.criminalcore.modules.tankstation_overval.utils.LootTable;
import nl.minetopiasdb.api.playerdata.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Random;

public class NPCClickListener implements Listener {
    private final SkillsModule module;

    public NPCClickListener(SkillsModule module) {
        this.module = module;
    }

    @EventHandler
    public void clickNPCJobs(NPCRightClickEvent event) {
        Player player = event.getClicker();
        if (event.getNPC().getFullName().contains("Skills")) {
            new SkillsMenu(player).open(player);
        }
    }
}