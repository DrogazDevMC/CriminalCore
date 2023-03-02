package nl.criminalmt.criminalcore.modules.player.tasks;

import com.cryptomorin.xseries.messages.ActionBar;
import com.google.common.base.Strings;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.modules.player.PlayerModule;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class HealingTimer extends BukkitRunnable {


    public HealingTimer(PlayerModule module, Player player, String name, int seconds) {
        this.module = module;
        this.player = player;
        this.name = name;
        this.maxSeconds = seconds;
    }

    private Player player;
    private final String name;
    private final PlayerModule module;
    private int seconds = 0;

    private int maxSeconds;


    @Override
    public void run() {
        seconds++;

        ActionBar.sendActionBar(player, ChatUtils.format("&7" + name + " Innemen &8&l[" + getProgressBar(seconds, maxSeconds, 10, '╏', ChatColor.GREEN, ChatColor.RED) + "&8&l]"));

        if (seconds == maxSeconds) {
            if (name.equals("Medkit")) {
                player.setHealth(20);
                player.sendMessage(ChatUtils.format("&aJe hebt een medkit gebruikt"));
            }
            if (name.equals("Bandage")) {
                player.setHealth(player.getHealth() + 6);
                player.sendMessage(ChatUtils.format("&aJe hebt een bandage gebruikt"));
            }
            this.cancel();
        }
    }

    public String getProgressBar(int current, int max, int totalBars, char symbol, ChatColor completedColor,
                                 ChatColor notCompletedColor) {
        float percent = (float) current / max;
        int progressBars = (int) (totalBars * percent);

        return Strings.repeat("" + completedColor + symbol, progressBars)
                + Strings.repeat("" + notCompletedColor + symbol, totalBars - progressBars);
    }
}
