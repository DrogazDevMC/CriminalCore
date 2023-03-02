package nl.criminalmt.criminalcore.modules.skills.menus;

import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.gui.GUI;
import nl.criminalmt.criminalcore.framework.items.ItemBuilder;
import nl.criminalmt.criminalcore.framework.items.NBTEditor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class SkillsMenu extends GUI {

    public SkillsMenu(Player player) {
        super(ChatUtils.format("&8Skills - CriminalMT"), 5);
    }

    @Override
    protected void setContents() {
        for (int i = 0; i < 45; i++) {
            ItemStack leeg = new ItemBuilder(Material.STAINED_GLASS_PANE).setName(" ").setData((short) 7).toItemStack();
            inventory.setItem(i, leeg);
        }

//        ItemStack rewards = (new ItemBuilder(NBTEditor.getHead("https://textures.minecraft.net/texture/cba77856d80dade55699544ddcd685964b0180823fe4ff270de7e5f58aecf3a5")))
//                .addLore(.chat("&c&lBeschikbaar in latere versie"))
//                .setColoredName("&7Gang Rewards")
//                .toItemStack();

        ItemStack skills = new ItemBuilder(Material.BOOK).setName("&8Skills").toItemStack();
        inventory.setItem(20, skills);

        ItemStack jobs = new ItemBuilder(Material.BOOK).setName("&8Jobs").toItemStack();
        inventory.setItem(22, jobs);

        ItemStack overval = new ItemBuilder(Material.BOOK).setName("&8Overval").toItemStack();
        inventory.setItem(24, overval);
    }

    @Override
    protected void handleClickAction(InventoryClickEvent event) {
        if (event.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
            event.setCancelled(true);
        }
    }

    @Override
    protected void handleCloseAction(InventoryCloseEvent event) {

    }
}
