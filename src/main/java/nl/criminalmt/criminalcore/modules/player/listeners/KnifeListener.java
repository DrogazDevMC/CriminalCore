package nl.criminalmt.criminalcore.modules.player.listeners;

import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KnifeListener implements Listener {

    private final Map<UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof LivingEntity)) return;
        if (!(event.getEntity() instanceof Player)) return;

        LivingEntity attacker = (LivingEntity) event.getDamager();

        if (attacker.getEquipment().getItemInMainHand() == null) return;
        if (attacker.getEquipment().getItemInMainHand().getType() != Material.WOOD_SWORD) return;

        if (attacker instanceof Player) {
            Player player = (Player) attacker;

            if (cooldown.getOrDefault(player.getUniqueId(), -1L) > System.currentTimeMillis()) {
                event.setCancelled(true);
                player.sendMessage(ChatUtils.format("&cJe moet nog &4" + (((cooldown.getOrDefault(player.getUniqueId(), -1L) - System.currentTimeMillis()) / 1000) + 1) + " &cseconde wachten!"));
                return;
            }

            cooldown.put(player.getUniqueId(), System.currentTimeMillis() + 2000);
        }

        event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        cooldown.remove(event.getPlayer().getUniqueId());
    }
}
