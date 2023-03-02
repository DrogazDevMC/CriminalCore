package nl.criminalmt.criminalcore.modules.drugs.listeners;

import nl.criminalmt.criminalcore.CriminalCore;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.modules.drugs.DrugsModule;
import nl.criminalmt.criminalcore.modules.drugs.tasks.HarvestDrugsTimer;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;


public class HarvestDrugsListener implements Listener {
    private final DrugsModule module;

    public HarvestDrugsListener(DrugsModule module) {
        this.module = module;
    }

    //Event if player clicked Weed, Meth, Coke or Opium

    @EventHandler
    public void clickDrugsPlant(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!(event.getAction()).equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (event.getHand().equals(EquipmentSlot.HAND)) return;
        if (event.getClickedBlock().getType() == Material.LONG_GRASS && event.getClickedBlock().getData() == 2) {
            double distanceW = event.getPlayer().getLocation().distance(module.getWietPluk());
            if (distanceW > 6) return;
            if (module.getIsHarvesting().get(player.getUniqueId()) == Boolean.TRUE) {
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT ➠ &7Je bent al aan het plukken!"));
                return;
            }
            module.getIsHarvesting().put(player.getUniqueId(), Boolean.TRUE);
            HarvestDrugsTimer harvest = new HarvestDrugsTimer(module, event.getPlayer());
            harvest.runTaskTimer(CriminalCore.getInstance(), 0L, 20L);
            module.getHarvestingType().put(player.getUniqueId(), "weed");
            return;
        }

        if (event.getClickedBlock().getType() == Material.RED_ROSE && event.getClickedBlock().getData() == 2) {
            double distanceO = event.getPlayer().getLocation().distance(module.getOpiumPluk());
            if (distanceO > 6) return;
            if (module.getIsHarvesting().get(player.getUniqueId()) == Boolean.TRUE) {
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT ➠ &7Je bent al aan het plukken!"));
                return;
            }
            module.getIsHarvesting().put(player.getUniqueId(), Boolean.TRUE);
            HarvestDrugsTimer harvest = new HarvestDrugsTimer(module, event.getPlayer());
            harvest.runTaskTimer(CriminalCore.getInstance(), 0L, 20L);
            module.getHarvestingType().put(player.getUniqueId(), "opium");
            return;
        }

        if (event.getClickedBlock().getType() == Material.RED_ROSE && event.getClickedBlock().getData() == 3) {
            double distanceC = event.getPlayer().getLocation().distance(module.getCokePluk());
            if (distanceC > 6) return;
            if (module.getIsHarvesting().get(player.getUniqueId()) == Boolean.TRUE) {
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT ➠ &7Je bent al aan het plukken!"));
                return;
            }
            module.getIsHarvesting().put(player.getUniqueId(), Boolean.TRUE);
            HarvestDrugsTimer harvest = new HarvestDrugsTimer(module, event.getPlayer());
            harvest.runTaskTimer(CriminalCore.getInstance(), 0L, 20L);
            module.getHarvestingType().put(player.getUniqueId(), "coke");
            return;
        }
        if (event.getClickedBlock().getType() == Material.SPONGE && event.getClickedBlock().getData() == 1) {
            double distanceM = event.getPlayer().getLocation().distance(module.getMethPluk());
            if (distanceM > 6) return;
            if (module.getIsHarvesting().get(player.getUniqueId()) == Boolean.TRUE) {
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT ➠ &7Je bent al aan het plukken!"));
                return;
            }
            module.getIsHarvesting().put(player.getUniqueId(), Boolean.TRUE);
            HarvestDrugsTimer harvest = new HarvestDrugsTimer(module, event.getPlayer());
            harvest.runTaskTimer(CriminalCore.getInstance(), 0L, 20L);
            module.getHarvestingType().put(player.getUniqueId(), "meth");
            return;
        }
    }


//    public void clickWiet(PlayerInteractEvent event) {
//        Player player = event.getPlayer();
//        double distanceP = event.getPlayer().getLocation().distance(module.getWietPluk());
////        double distanceB = event.getClickedBlock().getLocation().distance(module.getWietPluk());
//        if (!(event.getAction()).equals(Action.RIGHT_CLICK_BLOCK)) return;
//        if (distanceP > 6) return;
////        if(distanceB > 6) return;
//        if (event.getHand().equals(EquipmentSlot.HAND)) return;
//        if (!(event.getClickedBlock().getType() == Material.LONG_GRASS && event.getClickedBlock().getData() == 2))
//            return;
//        if (module.getIsHarvesting().get(player.getUniqueId()) == Boolean.TRUE) {
//            player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT ➠ &7Je bent al aan het plukken!"));
//            return;
//        }
//        module.getIsHarvesting().put(player.getUniqueId(), Boolean.TRUE);
//        HarvestDrugsTimer harvest = new HarvestDrugsTimer(module, event.getPlayer());
//        harvest.runTaskTimer(CriminalCore.getInstance(), 0L, 20L);
//        module.getHarvestingType().put(player.getUniqueId(), "weed");
//        return;
//    }
//
//    public void clickOpium(PlayerInteractEvent event) {
//        Player player = event.getPlayer();
//        double distanceO = event.getPlayer().getLocation().distance(module.getOpiumPluk());
//        if (!(event.getAction()).equals(Action.RIGHT_CLICK_BLOCK)) return;
//        player.sendMessage("1");
//        if (distanceO > 6) return;
//        player.sendMessage("2");
//        if (event.getHand().equals(EquipmentSlot.HAND)) return;
//        player.sendMessage("3");
//        if (!(event.getClickedBlock().getType() == Material.RED_ROSE && event.getClickedBlock().getData() == 2)) return;
//        player.sendMessage("4");
//        if (module.getIsHarvesting().get(player.getUniqueId()) == Boolean.TRUE) {
//            player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT ➠ &7Je bent al aan het plukken!"));
//            return;
//        }
//        player.sendMessage("5");
//        module.getIsHarvesting().put(player.getUniqueId(), Boolean.TRUE);
//        HarvestDrugsTimer harvest = new HarvestDrugsTimer(module, event.getPlayer());
//        harvest.runTaskTimer(CriminalCore.getInstance(), 0L, 20L);
//        module.getHarvestingType().put(player.getUniqueId(), "opium");
//        return;
//    }
}
