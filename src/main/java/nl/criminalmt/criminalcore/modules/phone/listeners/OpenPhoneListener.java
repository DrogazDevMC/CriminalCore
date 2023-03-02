package nl.criminalmt.criminalcore.modules.phone.listeners;

import nl.criminalmt.criminalcore.framework.items.NBTEditor;
import nl.criminalmt.criminalcore.modules.phone.menus.PhoneMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class OpenPhoneListener implements Listener {

    @EventHandler
    public void phoneClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() != Action.RIGHT_CLICK_AIR) return;
        if (event.getItem() == null) return;
        if (!(event.getItem().getType() == Material.BLAZE_POWDER)) return;
        if (!(event.getItem().getItemMeta().getDisplayName().contains("Telefoon"))) return;

        new PhoneMenu(player).open(player);
    }
}
