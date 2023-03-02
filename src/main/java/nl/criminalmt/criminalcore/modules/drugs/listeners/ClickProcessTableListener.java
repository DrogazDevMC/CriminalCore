package nl.criminalmt.criminalcore.modules.drugs.listeners;

import nl.criminalmt.criminalcore.modules.drugs.DrugsModule;
import nl.criminalmt.criminalcore.modules.drugs.menus.ProcessMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class ClickProcessTableListener implements Listener {

    private final DrugsModule module;

    public ClickProcessTableListener(DrugsModule module) {
        this.module = module;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!(event.getAction()).equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (event.getHand().equals(EquipmentSlot.HAND)) return;
        if (event.getClickedBlock().getType() == Material.LIGHT_BLUE_GLAZED_TERRACOTTA) {
            double verwerkLoc = event.getPlayer().getLocation().distance(module.getVerwerk());
            if (verwerkLoc > 3) return;
            new ProcessMenu(player).open(player);
        }
    }
}
