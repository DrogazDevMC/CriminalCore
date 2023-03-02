package nl.criminalmt.criminalcore.modules.drugs.listeners;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.items.ItemRemover;
import nl.criminalmt.criminalcore.modules.drugs.items.DrugsItems;
import nl.criminalmt.criminalcore.modules.drugs.items.GeldItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class ClickLaundryNPC implements Listener {

    private PlayerInventory inventory;

    @EventHandler
    public void clickNPC(NPCRightClickEvent event) {
        Player player = event.getClicker();

        if(event.getNPC().getName().contains("Witwas")) {
            if(player.getInventory().containsAtLeast(GeldItems.zwartGeld100i(), 4)) {
                player.sendMessage("test" + player.getInventory());
//                ItemRemover.removeNamedItems(event.getClicker().getInventory(), GeldItems.zwartGeld100i().getType(), 4, "criminalmt","zwartgeld");
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &c- 4x €100 Zwartgeld"));
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &a+ 2x €100 Witgeld"));
                player.getInventory().addItem(GeldItems.Geld100(2));
                return;
            } else {
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &cJe kunt geen geld meer witwassen!"));
            }
        }
    }
}
