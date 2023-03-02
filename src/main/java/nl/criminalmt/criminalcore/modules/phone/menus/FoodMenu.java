package nl.criminalmt.criminalcore.modules.phone.menus;

import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.gui.GUI;
import nl.criminalmt.criminalcore.framework.items.ItemBuilder;
import nl.criminalmt.criminalcore.framework.items.NBTEditor;
import nl.criminalmt.criminalcore.modules.phone.ItemGiver;
import nl.minetopiasdb.api.API;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class FoodMenu extends GUI {
    public FoodMenu(Player player) {
        super(ChatUtils.format("&8Telefoon - CriminalMT"), 6);
    }

    @Override
    protected void setContents() {

        // Loops all empty slots and sets background
        for (int i = 0; i < 54; i++) {
            ItemStack leeg = new ItemBuilder(Material.IRON_INGOT).setName(" ").toItemStack();
            leeg = NBTEditor.set(leeg, "telefoon_leeg", "mdev");
            inventory.setItem(i, leeg);
        }

        // All Phone Icons
        ItemStack contacten = new ItemBuilder(Material.IRON_INGOT).setName(ChatUtils.format("&7&lContacten")).setLore(Arrays.asList(ChatUtils.format("&7Bekijk je contacten, voeg nieuwe toe &"), ChatUtils.format("&7stuur ze een bericht!"))).toItemStack();
        contacten = NBTEditor.set(contacten, "phone_icon1", "mtwcustom");
        ItemStack bankieren = new ItemBuilder(Material.IRON_INGOT).setName(ChatUtils.format("&5&lGeldzaken")).setLore(Arrays.asList(ChatUtils.format("&7Maak geld over naar andere mensen &"), ChatUtils.format("&7en koop crypto!"))).setGlow(true).toItemStack();
        bankieren = NBTEditor.set(bankieren, "phone_icon32", "mtwcustom");
        ItemStack voedsel = new ItemBuilder(Material.IRON_INGOT).setName(ChatUtils.format("&9&lVoedsel Winkel")).setGlow(true).setLore(Arrays.asList(ChatUtils.format("&7Koop lekker eten bij de voedselwinkel &"), ChatUtils.format("&7blijf gezond!"))).toItemStack();
        voedsel = NBTEditor.set(voedsel, "phone_icon34", "mtwcustom");
        ItemStack blackmarket = new ItemBuilder(Material.IRON_INGOT).setName(ChatUtils.format("&c&lBlackmarket")).setLore(Arrays.asList(ChatUtils.format("&7Koop Ilegale items en maak je klaar voor overvallen!"))).toItemStack();
        blackmarket = NBTEditor.set(blackmarket, "phone_icon4", "mtwcustom");
        ItemStack settings = new ItemBuilder(Material.IRON_INGOT).setName(ChatUtils.format("&7&lInformatie")).setLore(Arrays.asList(ChatUtils.format("&7Rekening:"), ChatUtils.format(""), ChatUtils.format("&7Gemaakt door: &c83J"))).toItemStack();
        settings = NBTEditor.set(settings, "phone_icon40", "mtwcustom");
        ItemStack overschrijven = new ItemBuilder(Material.IRON_INGOT).setName(ChatUtils.format("&5Overschrijven")).setLore(Arrays.asList(ChatUtils.format("&7Maak geld over naar online spelers!"))).toItemStack();
        overschrijven = NBTEditor.set(overschrijven, "phone_icon32", "mtwcustom");
        ItemStack crypto = new ItemBuilder(Material.CLAY_BRICK).setName(ChatUtils.format("&6Crypto")).setLore(Arrays.asList(ChatUtils.format("&7Verdien geld met het verhandelen van Crypto's"))).toItemStack();
        crypto = NBTEditor.set(crypto, "crypto_bitcoin", "mtcustom");

        //Page Items
        ItemStack beacon = new ItemBuilder(Material.GRILLED_PORK).setName(ChatUtils.format("&fBeacon - &764x")).setLore(ChatUtils.format("&7Prijs: &a€7000")).toItemStack();
        ItemStack patat = new ItemBuilder(Material.BAKED_POTATO).setName(ChatUtils.format("&fFriet - &764x")).setLore(ChatUtils.format("&7Prijs: &a€6000")).toItemStack();
        ItemStack kip = new ItemBuilder(Material.COOKED_CHICKEN).setName(ChatUtils.format("&fKip - &764")).setLore(ChatUtils.format("&7Prijs: &a€7500")).toItemStack();
        ItemStack water = new ItemBuilder(Material.POTION).setName(ChatUtils.format("&fWater - &710x")).setLore(ChatUtils.format("&7Prijs: &a€5000")).toItemStack();

        // Close Button
        ItemStack close = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&cSluit"))
                .toItemStack();
        close = NBTEditor.set(close, "phone_icon20", "mtwcustom");

        //Set Inv Items
        inventory.setItem(2, contacten);
        inventory.setItem(3, bankieren);
        inventory.setItem(4, voedsel); //21
//        inventory.setItem(5, twitter); //23
//        inventory.setItem(30, crypto);
        inventory.setItem(5, blackmarket);
        inventory.setItem(6, settings);
        inventory.setItem(49, close);


        inventory.setItem(21, beacon);
        inventory.setItem(22, patat);
        inventory.setItem(23, kip);
        inventory.setItem(31, water);

        inventory.setItem(11, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(12, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(13, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 5).setName(" ").toItemStack());
        inventory.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(20, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());


        inventory.setItem(24, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(29, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(30, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(32, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(33, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(38, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(39, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(40, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(41, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(42, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(47, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 7).setName(" ").toItemStack());
        inventory.setItem(48, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 7).setName(" ").toItemStack());
        inventory.setItem(50, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 7).setName(" ").toItemStack());
        inventory.setItem(51, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 7).setName(" ").toItemStack());
        //30 & 32

    }

    @Override
    protected void handleClickAction(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getSlot() == 2) {
            new PhoneMenu(player).open(player);
        }

        if (event.getSlot() == 3) {
            new BankierenMenu(player).open(player);
        }
        if(event.getSlot() == 5) {
            new BlackmarketMenu(player).open(player);
        }
        if(event.getSlot() == 21) {
            if(!(API.getEcon().getBalance(player) >= 7000)) return;
            API.getEcon().withdrawPlayer(player, 7000);
            ItemGiver.giveFood(Material.GRILLED_PORK, 64, ChatUtils.format("&7Beacon"), player);
            return;
        }
        if(event.getSlot() == 22) {
            if(!(API.getEcon().getBalance(player) >= 6000)) return;
            API.getEcon().withdrawPlayer(player, 6000);
            ItemGiver.giveFood(Material.BAKED_POTATO, 64, ChatUtils.format("&7Friet"), player);
            return;
        }
        if(event.getSlot() == 23) {
            if(!(API.getEcon().getBalance(player) >= 7500)) return;
            API.getEcon().withdrawPlayer(player, 7500);
            ItemGiver.giveFood(Material.COOKED_CHICKEN, 64, ChatUtils.format("&7Kip"), player);
            return;
        }
        if(event.getSlot() == 31) {
            if(!(API.getEcon().getBalance(player) >= 5000)) return;
            API.getEcon().withdrawPlayer(player, 5000);
            ItemGiver.giveFood(Material.POTION, 10, ChatUtils.format("&7Water"), player);
            return;
        }
        if(event.getSlot() == 49) {
            player.closeInventory();
        }
    }

    @Override
    protected void handleCloseAction(InventoryCloseEvent event) {

    }
}
