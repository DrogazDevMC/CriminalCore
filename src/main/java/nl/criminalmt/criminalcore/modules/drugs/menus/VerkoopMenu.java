package nl.criminalmt.criminalcore.modules.drugs.menus;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.gui.GUI;
import nl.criminalmt.criminalcore.framework.items.ItemRemover;
import nl.criminalmt.criminalcore.modules.drugs.items.DrugsItems;
import nl.criminalmt.criminalcore.modules.drugs.items.GeldItems;
import nl.criminalmt.criminalcore.modules.drugs.items.VerkoopItems;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class VerkoopMenu extends GUI {
    public VerkoopMenu(Player player) {
        super(ChatUtils.format("&8Dealer"), 3);
        this.player = player;
    }

    private final Player player;

    @Override
    protected void setContents() {
        inventory.setItem(10, VerkoopItems.WiVerM());
        inventory.setItem(12, VerkoopItems.CoVerM());
        inventory.setItem(14, VerkoopItems.OpVerM());
        inventory.setItem(16, VerkoopItems.MeVerM());
    }

    @Override
    protected void handleClickAction(InventoryClickEvent event) {
        if(event.getCurrentItem().equals(VerkoopItems.WiVerM())) {
            if(player.getInventory().containsAtLeast(DrugsItems.hasj(), 1)) {
                ItemRemover.removeNamedItems(player.getInventory(), DrugsItems.hasj().getType(), 1, "mtcustom", "wiet_verpakt");
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &a+ €250 Zwartgeld"));
                player.getInventory().addItem(GeldItems.zwartGeld100(2));
                return;
            } else {
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &cJe hebt niet genoeg verpakte wiet!"));
                return;
            }
        }

        if(event.getCurrentItem().equals(VerkoopItems.CoVerM())) {
            if(player.getInventory().containsAtLeast(DrugsItems.cokeVerpakt(), 1)) {
                ItemRemover.removeNamedItems(player.getInventory(), DrugsItems.cokeVerpakt().getType(), 1,  "mtcustom","coke_verpakt");
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &a+ €360 Zwartgeld"));
                player.getInventory().addItem(GeldItems.zwartGeld100(4));
                return;
            } else {
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &cJe hebt niet genoeg verpakte coke!"));
                return;
            }
        }

        if(event.getCurrentItem().equals(VerkoopItems.OpVerM())) {
            if(player.getInventory().containsAtLeast(DrugsItems.opiumVerpakt(), 1)) {
                ItemRemover.removeNamedItems(player.getInventory(), DrugsItems.opiumVerpakt().getType(), 1, "mtcustom","opium_verpakt");
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &a+ €610 Zwartgeld"));
                player.getInventory().addItem(GeldItems.zwartGeld100(7));
                return;
            } else {
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &cJe hebt niet genoeg verpakte opium!"));
                return;
            }
        }

        if(event.getCurrentItem().equals(VerkoopItems.MeVerM())) {
            if(player.getInventory().containsAtLeast(DrugsItems.methVerpakt(), 1)) {
                ItemRemover.removeNamedItems(player.getInventory(), DrugsItems.methVerpakt().getType(), 1, "mtcustom","meth");
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &a+ €530 Zwartgeld"));
                player.getInventory().addItem(GeldItems.zwartGeld100(6));
                return;
            } else {
                player.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &8➠ &cJe hebt niet genoeg verpakte meth!"));
                return;
            }
        }
    }

    @Override
    protected void handleCloseAction(InventoryCloseEvent event) {

    }
}
