package nl.criminalmt.criminalcore.modules.tankstation_overval.listeners;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import nl.criminalmt.criminalcore.CriminalCore;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.modules.drugs.items.GeldItems;
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
    private final TankstationModule module;

    public NPCClickListener(TankstationModule module) {
        this.module = module;
    }

    @EventHandler
    public void clickNPCJobs(NPCRightClickEvent event) {
        Player player = event.getClicker();
//        String jobs = module.jobs.getConfiguration().getString("Players." + player.getUniqueId() + ".Job");
        if (event.getNPC().getFullName().contains("Winkelier")) {
//            check if player holds an item called "Knuppel","Pistool","Mes"
            if (player.getInventory().getItemInMainHand() == null) return;
            if (player.getInventory().getItemInMainHand().getItemMeta() == null) return;
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() == null) return;
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Knuppel")) {

                if (module.isOverval()) {
                    player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &f&l>> &7Er is recentelijk al een overval geweest!"));
                    return;
                }

                module.setOverval(true);
                OvervalTimer overvalTimer = new OvervalTimer(module);
                overvalTimer.runTaskTimer(CriminalCore.getInstance(), 0, 20L);

                int Level = PlayerManager.getPlayer(player.getUniqueId()).getLevel();
                String job = PlayerManager.getPlayer(player.getUniqueId()).getPrefix();

                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &f&l>> &7Je hebt een overval gestart!"));

                Bukkit.getScheduler().scheduleSyncDelayedTask(CriminalCore.getInstance(), () -> {
                    player.sendMessage(ChatUtils.format("&3[&bLevel " + Level + "&3] &8[&7" + job + "&8] &7" + player.getName() + ": Dit is een overval! Geef me al het geld in de kassa en snel!"));
                    Bukkit.getScheduler().scheduleSyncDelayedTask(CriminalCore.getInstance(), () -> {
                        player.sendMessage(ChatUtils.format("&3[&bLevel 5&3] &8[&7Eig. Tankstation&8] &7Winkelier: Oh nee! Wat doe je? Waarom overval je mijn winkel?"));
                        player.playSound(player.getLocation(), "entity.villager.no", 1, 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(CriminalCore.getInstance(), () -> {
                            player.sendMessage(ChatUtils.format("&3[&bLevel " + Level + "&3] &8[&7" + job + "&8] &7" + player.getName() + ": Ik heb geld nodig, begrijp je dat niet? Geef me gewoon het geld en er zal niets gebeuren."));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(CriminalCore.getInstance(), () -> {
                                player.sendMessage(ChatUtils.format("&3[&bLevel 5&3] &8[&7Eig. Tankstation&8] &7Winkelier: Oké, oké, ik begrijp het.Ik zal je het geld geven. Laat me gewoon even de kassa openen."));
                                player.playSound(player.getLocation(), "entity.villager.yes", 1, 1);
                                Bukkit.getScheduler().scheduleSyncDelayedTask(CriminalCore.getInstance(), () -> {
                                    player.sendMessage(ChatUtils.format("&3[&bLevel 5&3] &8[&7Eig. Tankstation&8] &7Winkelier: Hier is het geld, ik hoop dat je het niet gebruikt voor iets slechts."));
                                    player.playSound(player.getLocation(), "entity.villager.yes", 1, 2);
                                    player.getInventory().addItem(LootTable.Dufflebag(new Random().nextInt(10) + 25));

                                    if (new Random().nextInt(2) == 0) {
                                        player.sendMessage(ChatUtils.format("&3[&bLevel " + Level + "&3] &8[&7" + job + "&8] &7" + player.getName() + ": Hey, probeer je me voor de gek te houden? Ik weet dat je nog een kluis hebt!"));
                                        Bukkit.getScheduler().scheduleSyncDelayedTask(CriminalCore.getInstance(), () -> {
                                            player.sendMessage(ChatUtils.format("&3[&bLevel 5&3] &8[&7Eig. Tankstation&8] &7Winkelier: Klopt.... Ik zal de kluis leeg gaan halen."));
                                            player.playSound(player.getLocation(), "entity.villager.yes", 1, 2);

                                            NPC npc = event.getNPC();
                                            Location loc = npc.getStoredLocation();

                                            event.getNPC().despawn();

                                            Bukkit.getScheduler().scheduleSyncDelayedTask(CriminalCore.getInstance(), () -> {
                                                npc.spawn(loc);
                                                player.sendMessage(ChatUtils.format("&3[&bLevel 5&3] &8[&7Eig. Tankstation&8] &7Winkelier: Hier is de kluis, ik hoop dat je het niet gebruikt voor iets slechts."));
                                                player.playSound(player.getLocation(), "entity.villager.yes", 1, 2);
                                                player.getInventory().addItem(LootTable.Dufflebag(new Random().nextInt(30) + 25));
                                            }, 500L);
                                        }, 60L);
                                    }


                                }, 300L);
                            }, 60L);
                        }, 60L);
                    }, 60L);
                }, 10L);

                return;
            }

//            "&cWinkelier:Oké, oké, ik begrijp het.Ik zal je het geld geven.Laat me gewoon even de kassa openen."

            player.sendMessage(ChatUtils.format("&cJe hebt geen wapen in je hand!"));
        }
    }
}