package nl.criminalmt.criminalcore.modules.illegal_jobs.menus;

import lombok.Getter;
import lombok.Setter;
import nl.criminalmt.criminalcore.CriminalCore;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.file.File;
import nl.criminalmt.criminalcore.framework.gui.GUI;
import nl.criminalmt.criminalcore.framework.items.ItemBuilder;
import nl.criminalmt.criminalcore.framework.items.NBTEditor;
import nl.criminalmt.criminalcore.modules.illegal_jobs.JobsModule;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class RecruiterMenu extends GUI {

    private final JobsModule module;
    public RecruiterMenu(Player player) {
        super(ChatUtils.format("Kies je job."), 3);
        module = null;
    }

    @Override
    protected void setContents() {
        for (int i = 0; i < 27; i++) {
            ItemStack leeg = new ItemBuilder(Material.STAINED_GLASS_PANE).setName(" ").toItemStack();
            inventory.setItem(i, leeg);
        }


        ItemStack hacker = new ItemBuilder(NBTEditor.getHead("http://textures.minecraft.net/texture/4409f441c3142e0a2c1b8b35e6678cf436d1e0dbf6b5cdea7b5aa77cf9d537c0")).setName(ChatUtils.format("&7Job: &fHacker")).toItemStack();
        ItemStack dealer = new ItemBuilder(NBTEditor.getHead("http://textures.minecraft.net/texture/fa89817916d296f6319cfd035ffed3977d6646904bbcb340a0e552977311b93a")).setName(ChatUtils.format("&7Job: &fDrugsdealer")).toItemStack();
        ItemStack hitman = new ItemBuilder(NBTEditor.getHead("http://textures.minecraft.net/texture/74bb84e56c83a8cda8a1609298f086de6e73cb7517c5a3414ee7c7d507b83571")).setName(ChatUtils.format("&7Job: &fHitman")).toItemStack();

        inventory.setItem(11, hacker);
        inventory.setItem(13, dealer);
        inventory.setItem(15, hitman);
    }

    @Override
    protected void handleClickAction(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(event.getSlot() == 11) {
            module.jobs.getConfiguration().set("Players." + player.getUniqueId() + ".Job", "Hacker");
        }
    }

    @Override
    protected void handleCloseAction(InventoryCloseEvent event) {

    }
}
