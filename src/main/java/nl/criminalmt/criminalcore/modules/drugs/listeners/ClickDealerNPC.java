package nl.criminalmt.criminalcore.modules.drugs.listeners;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import nl.criminalmt.criminalcore.modules.drugs.menus.VerkoopMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ClickDealerNPC implements Listener {


    @EventHandler
    public void clickNPC(NPCRightClickEvent event) {
        Player player = event.getClicker();

        if(event.getNPC().getName().contains("Dealer")) {
            new VerkoopMenu(player).open(player);
        }
    }

}
