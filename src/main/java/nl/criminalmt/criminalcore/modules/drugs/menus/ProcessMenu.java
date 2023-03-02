package nl.criminalmt.criminalcore.modules.drugs.menus;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.gui.GUI;
import nl.criminalmt.criminalcore.framework.items.ItemRemover;
import nl.criminalmt.criminalcore.modules.drugs.items.DrugsItems;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class ProcessMenu extends GUI {
    public ProcessMenu(Player player) {
        super(ChatUtils.format("&8Verwerk Tafel"), 3);
        this.player = player;
    }

    private final Player player;

    @Override
    protected void setContents() {
        inventory.setItem(10, DrugsItems.wietMenu());
        inventory.setItem(12, DrugsItems.cokeMenu());
        inventory.setItem(14, DrugsItems.opiumMenu());
        inventory.setItem(16, DrugsItems.methMenu());
    }

    @Override
    protected void handleClickAction(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        //Wiet
        if(event.getSlot() == 10 ) {
            if(player.getInventory().containsAtLeast(DrugsItems.wiet(), 3)) {
                ItemRemover.removeNamedItems(player.getInventory(), DrugsItems.wiet().getType(), 3, "mtcustom","wiet");
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &a+1 Blok Hasj"));
                player.getInventory().addItem(DrugsItems.hasj());
                return;
            } else {
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &cJe hebt niet genoeg wiet!"));
                return;
            }
        }

        //Coke
        else if(event.getSlot() == 12 ) {
            if(player.getInventory().containsAtLeast(DrugsItems.coke(), 3)) {
                ItemRemover.removeNamedItems(player.getInventory(), DrugsItems.coke().getType(), 3, "mtcustom", "coke");
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &a+1 Zakje Coke"));
                player.getInventory().addItem(DrugsItems.cokeVerpakt());
                return;
            } else {
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &cJe hebt niet genoeg coke!"));
                return;
            }
        }

        //Opium
        else if(event.getSlot() == 14 ) {
            if(player.getInventory().containsAtLeast(DrugsItems.opium(), 5)) {
                ItemRemover.removeNamedItems(player.getInventory(), DrugsItems.opium().getType(), 5, "mtcustom","opium");
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &a+1 Zakje Opium"));
                player.getInventory().addItem(DrugsItems.opiumVerpakt());
                return;
            } else {
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &cJe hebt niet genoeg opium!"));
                return;
            }
        }

        //Meth
        else if(event.getSlot() == 16 ) {
            if(player.getInventory().containsAtLeast(DrugsItems.meth(), 3)) {
                ItemRemover.removeNamedItems(player.getInventory(), DrugsItems.meth().getType(), 3, "bdev", "meth_onv");
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &a+1 Zakje Meth"));
                player.getInventory().addItem(DrugsItems.methVerpakt());
                return;
            } else {
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &cJe hebt niet genoeg meth!"));
                return;
            }
        }
    }

    @Override
    protected void handleCloseAction(InventoryCloseEvent event) {

    }
}
