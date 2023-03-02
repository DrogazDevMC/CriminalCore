package nl.criminalmt.criminalcore.modules.drugs.tasks;

import com.cryptomorin.xseries.messages.ActionBar;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.modules.drugs.DrugsModule;
import nl.criminalmt.criminalcore.modules.drugs.items.DrugsItems;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class HarvestDrugsTimer extends BukkitRunnable {


    public HarvestDrugsTimer(DrugsModule module, Player player) {
        this.module = module;
        this.player = player;
    }

    private Player player;
    private final DrugsModule module;


    private int seconds = 6;

    @Override
    public void run() {
        seconds--;

        if (seconds == 5) {
            ActionBar.sendActionBar(player, ChatUtils.format("&7Aan het plukken &8&l[&c╏╏╏╏╏╏╏╏╏╏&8&l]"));

        }

        if (seconds == 4) {
            ActionBar.sendActionBar(player, ChatUtils.format("&7Aan het plukken &8&l[&a╏╏&c╏╏╏╏╏╏╏╏&8&l]"));
        }

        if (seconds == 3) {
            ActionBar.sendActionBar(player, ChatUtils.format("&7Aan het plukken &8&l[&a╏╏╏╏&c╏╏╏╏╏╏&8&l]"));
        }

        if (seconds == 2) {
            ActionBar.sendActionBar(player, ChatUtils.format("&7Aan het plukken &8&l[&a╏╏╏╏╏╏&c╏╏╏╏&8&l]"));
        }
        if (seconds == 1) {
            ActionBar.sendActionBar(player, ChatUtils.format("&7Aan het plukken &8&l[&a╏╏╏╏╏╏╏╏&c╏╏&8&l]"));
        }

        if (seconds == 0) {
            ActionBar.sendActionBar(player, ChatUtils.format("&7Aan het plukken &8&l[&a╏╏╏╏╏╏╏╏╏╏&8&l]"));
            module.getIsHarvesting().put(player.getUniqueId(), Boolean.FALSE);
            if (module.getHarvestingType().get(player.getUniqueId()).equals("weed")) {
                ActionBar.sendActionBar(player, ChatUtils.format("&7Plukken geslaagd - &a+2 Wiet"));
                player.getInventory().addItem(DrugsItems.wiet());
            }
            if (module.getHarvestingType().get(player.getUniqueId()).equals("opium")) {
                ActionBar.sendActionBar(player, ChatUtils.format("&7Plukken geslaagd - &a+1 Opium"));
                player.getInventory().addItem(DrugsItems.opium());
            }
            if (module.getHarvestingType().get(player.getUniqueId()).equals("coke")) {
                ActionBar.sendActionBar(player, ChatUtils.format("&7Plukken geslaagd - &a+1 Cocaïne"));
                player.getInventory().addItem(DrugsItems.coke());
            }
            if (module.getHarvestingType().get(player.getUniqueId()).equals("meth")) {
                ActionBar.sendActionBar(player, ChatUtils.format("&7Plukken geslaagd - &a+1 Meth"));
                player.getInventory().addItem(DrugsItems.meth());
            }
            this.cancel();
        }
    }
}
