package nl.criminalmt.criminalcore.modules.drugs.items;

import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.items.ItemBuilder;
import nl.criminalmt.criminalcore.framework.items.NBTEditor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DrugsItems {
    public static ItemStack wiet() {
        ItemStack wietItem = new ItemBuilder(Material.POTATO_ITEM)
                .setName(ChatUtils.format("&f&lWiet"))
                .setLore(ChatUtils.format("&8➠ &7Officieel &8&lCriminal&7&lMT &7Item!"))
                .setAmount(2)
                .toItemStack();
        wietItem = NBTEditor.set(wietItem, "wiet", "mtcustom");
        return wietItem;
    }
    public static ItemStack hasj() {
        ItemStack hasjItem = new ItemBuilder(Material.POTATO_ITEM)
                .setName(ChatUtils.format("&f&lBlok Hasj"))
                .setLore(ChatUtils.format("&8➠ &7Officieel &8&lCriminal&7&lMT &7Item!"))
                .toItemStack();
        hasjItem = NBTEditor.set(hasjItem, "wiet_verpakt", "mtcustom");
        return hasjItem;
    }
    public static ItemStack opium() {
        ItemStack opiumItem = new ItemBuilder(Material.SPIDER_EYE)
                .setName(ChatUtils.format("&f&lOpium"))
                .setLore(ChatUtils.format("&8➠ &7Officieel &8&lCriminal&7&lMT &7Item!"))
                .toItemStack();
        opiumItem = NBTEditor.set(opiumItem, "opium", "mtcustom");
        return opiumItem;
    }

    public static ItemStack opiumVerpakt() {
        ItemStack opiumVerpakt = new ItemBuilder(Material.SPIDER_EYE)
                .setName(ChatUtils.format("&f&lZakje Opium"))
                .setLore(ChatUtils.format("&8➠ &7Officieel &8&lCriminal&7&lMT &7Item!"))
                .toItemStack();
        opiumVerpakt = NBTEditor.set(opiumVerpakt, "opium_verpakt", "mtcustom");
        return opiumVerpakt;
    }

    public static ItemStack coke() {
        ItemStack cokeItem = new ItemBuilder(Material.SUGAR)
                .setName(ChatUtils.format("&f&lCoke"))
                .setLore(ChatUtils.format("&8➠ &7Officieel &8&lCriminal&7&lMT &7Item!"))
                .toItemStack();
        cokeItem = NBTEditor.set(cokeItem, "coke", "mtcustom");
        return cokeItem;
    }

    public static ItemStack cokeVerpakt() {
        ItemStack cokeVerpakt = new ItemBuilder(Material.SUGAR)
                .setName(ChatUtils.format("&f&lZakje Coke"))
                .setLore(ChatUtils.format("&8➠ &7Officieel &8&lCriminal&7&lMT &7Item!"))
                .toItemStack();
        cokeVerpakt = NBTEditor.set(cokeVerpakt, "coke_verpakt", "mtcustom");
        return cokeVerpakt;
    }

    public static ItemStack meth() {
        ItemStack methItem = new ItemBuilder(Material.SUGAR)
                .setName(ChatUtils.format("&f&lMeth"))
                .setLore(ChatUtils.format("&8➠ &7Officieel &8&lCriminal&7&lMT &7Item!"))
                .toItemStack();
        methItem = NBTEditor.set(methItem, "meth_onv", "bdev");
        return methItem;
    }
    public static ItemStack methVerpakt() {
        ItemStack methVerpakt = new ItemBuilder(Material.SUGAR)
                .setName(ChatUtils.format("&f&lZakje Meth"))
                .setLore(ChatUtils.format("&8➠ &7Officieel &8&lCriminal&7&lMT &7Item!"))
                .toItemStack();
        methVerpakt = NBTEditor.set(methVerpakt, "meth", "mtcustom");
        return methVerpakt;
    }

    public static ItemStack methMenu() {
        ItemStack methItem = new ItemBuilder(Material.SUGAR)
                .setName(ChatUtils.format("&f&lMeth Verwerken"))
                .setLore(ChatUtils.format("&7Benodigd: 5x Meth"))
                .toItemStack();
        return methItem;
    }
    public static ItemStack wietMenu() {
        ItemStack wietmItem = new ItemBuilder(Material.POTATO_ITEM)
                .setName(ChatUtils.format("&f&lWiet Verwerken"))
                .setLore(ChatUtils.format("&7Benodigd: 3x Wiet"))
                .toItemStack();
        wietmItem = NBTEditor.set(wietmItem, "wiet_verpakt", "mtcustom");
        return wietmItem;
    }
    public static ItemStack cokeMenu() {
        ItemStack cokemItem = new ItemBuilder(Material.SUGAR)
                .setName(ChatUtils.format("&f&lCocaïne Verwerken"))
                .setLore(ChatUtils.format("&7Benodigd: 3x Coke"))
                .toItemStack();
        cokemItem = NBTEditor.set(cokemItem, "coke_verpakt", "mtcustom");
        return cokemItem;
    }
    public static ItemStack opiumMenu() {
        ItemStack opmMenu = new ItemBuilder(Material.SPIDER_EYE)
                .setName(ChatUtils.format("&f&lOpium Verwerken"))
                .setLore(ChatUtils.format("&7Benodigd: 5x Opium"))
                .toItemStack();
        opmMenu = NBTEditor.set(opmMenu, "opium_verpakt","mtcustom");
        return opmMenu;
    }



}
