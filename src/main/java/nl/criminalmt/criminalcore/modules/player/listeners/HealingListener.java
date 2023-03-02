package nl.criminalmt.criminalcore.modules.player.listeners;

import lombok.RequiredArgsConstructor;
import nl.criminalmt.criminalcore.CriminalCore;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.items.NBTEditor;
import nl.criminalmt.criminalcore.modules.player.PlayerModule;
import nl.criminalmt.criminalcore.modules.player.tasks.HealingTimer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
public class HealingListener implements Listener {

    private final PlayerModule module;

    private final Map<UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onClickHealing(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (event.getAction() != Action.RIGHT_CLICK_AIR) return;
        if (event.getItem() == null) return;
        if (!(NBTEditor.contains(event.getItem(), "mtcustom"))) return;

        if (NBTEditor.getString(event.getItem(), "mtcustom").equals("medkit_fullmodel")) {
            if (event.getPlayer().getHealth() == 20) {
                player.sendMessage(ChatUtils.format("&cJe kunt geen medkit gebruiken"));
                return;
            }

            if (cooldown.getOrDefault(player.getUniqueId(), -1L) > System.currentTimeMillis()) {
                event.setCancelled(true);
                player.sendMessage(ChatUtils.format("&cJe moet nog &4" + (((cooldown.getOrDefault(player.getUniqueId(), -1L) - System.currentTimeMillis()) / 1000) + 1) + " &cseconde wachten!"));
                return;
            }

            cooldown.put(player.getUniqueId(), System.currentTimeMillis() + 5000);

            event.getItem().setAmount(event.getItem().getAmount() - 1);
            HealingTimer heal = new HealingTimer(module, event.getPlayer(), "Medkit", 5 * 20);
            heal.runTaskTimer(CriminalCore.getInstance(), 0L, 1L);
            return;
        }
        if (NBTEditor.getString(event.getItem(), "mtcustom").equals("bandage_fullmodel")) {
            if (event.getPlayer().getHealth() >= 10) {
                player.sendMessage(ChatUtils.format("&cJe kunt geen bandage gebruiken"));
                return;
            }

            if (cooldown.getOrDefault(player.getUniqueId(), -1L) > System.currentTimeMillis()) {
                event.setCancelled(true);
                player.sendMessage(ChatUtils.format("&cJe moet nog &4" + (((cooldown.getOrDefault(player.getUniqueId(), -1L) - System.currentTimeMillis()) / 1000) + 1) + " &cseconde wachten!"));
                return;
            }

            cooldown.put(player.getUniqueId(), System.currentTimeMillis() + 1000);

            event.getItem().setAmount(event.getItem().getAmount() - 1);
            HealingTimer heal = new HealingTimer(module, event.getPlayer(), "Bandage", 3 * 20);
            heal.runTaskTimer(CriminalCore.getInstance(), 0L, 1L);
            return;
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        cooldown.remove(event.getPlayer().getUniqueId());
    }
}
