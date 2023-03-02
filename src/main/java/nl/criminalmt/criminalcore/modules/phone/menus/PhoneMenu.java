package nl.criminalmt.criminalcore.modules.phone.menus;

import nl.criminalmt.criminalcore.framework.chat.ChatResponse;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.file.File;
import nl.criminalmt.criminalcore.framework.gui.GUI;
import nl.criminalmt.criminalcore.framework.items.ItemBuilder;
import nl.criminalmt.criminalcore.framework.items.NBTEditor;
import nl.minetopiasdb.api.API;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

public class PhoneMenu extends GUI {

    private final Player player;




    public PhoneMenu(Player player) {
        super(ChatUtils.format("&8Telefoon - CriminalMT"), 6);
        this.player = player;
    }

    @Override
    protected void setContents() {

        for (int i = 0; i < 54; i++) {
            ItemStack leeg = new ItemBuilder(Material.IRON_INGOT).setName(" ").toItemStack();
            leeg = NBTEditor.set(leeg, "telefoon_leeg", "mdev");
            inventory.setItem(i, leeg);
        }

        ItemStack contacten = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&7&lContacten"))
                .setLore(Arrays.asList(ChatUtils.format("&7Bekijk je contacten, voeg nieuwe toe &"), ChatUtils.format("&7stuur ze een bericht!")))
                .setGlow(true)
                .toItemStack();
        contacten = NBTEditor.set(contacten,"phone_icon1", "mtwcustom");

        ItemStack bankieren = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&5&lGeldzaken"))
                .setLore(Arrays.asList(ChatUtils.format("&7Maak geld over naar andere mensen &"), ChatUtils.format("&7en koop crypto!")))
                .toItemStack();
        bankieren = NBTEditor.set(bankieren,"phone_icon32", "mtwcustom");

        ItemStack voedsel = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&9&lVoedsel Winkel"))
                .setLore(Arrays.asList(ChatUtils.format("&7Koop lekker eten bij de voedselwinkel &"), ChatUtils.format("&7blijf gezond!")))
                .toItemStack();
        voedsel = NBTEditor.set(voedsel,"phone_icon34", "mtwcustom");

        ItemStack blackmarket = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&c&lBlackmarket"))
                .setLore(Arrays.asList(ChatUtils.format("&7Koop Ilegale items en maak je klaar voor overvallen!")))
                .toItemStack();
        blackmarket = NBTEditor.set(blackmarket,"phone_icon4", "mtwcustom");

        ItemStack settings = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&7&lInformatie"))
                .setLore(Arrays.asList(ChatUtils.format("&7Rekening: &c€" + API.getEcon().getBalance(player)), ChatUtils.format(""), ChatUtils.format("&7Gemaakt door: &c83J")))
                .toItemStack();
        settings = NBTEditor.set(settings,"phone_icon40", "mtwcustom");

        ItemStack twitter = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&bTwitter"))
                .setLore(Arrays.asList(ChatUtils.format("&7Stuur een bericht in twitter")))
                .toItemStack();
        twitter = NBTEditor.set(twitter,"phone_icon16", "mtwcustom");

        ItemStack whatsapp = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&aWhatsApp"))
                .setLore(Arrays.asList(ChatUtils.format("&7Stuur een bericht naar een online speler")))
                .toItemStack();
        whatsapp = NBTEditor.set(whatsapp,"phone_icon2", "mtwcustom");

        ItemStack nieuws = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&7&lNieuws"))
                .setLore(Arrays.asList(ChatUtils.format("&7Al het laatste nieuws!")))
                .toItemStack();
        nieuws = NBTEditor.set(nieuws,"phone_icon5", "mtwcustom");

        ItemStack close = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&cSluit"))
                .toItemStack();
        close = NBTEditor.set(close,"phone_icon20", "mtwcustom");

        inventory.setItem(2, contacten);
        inventory.setItem(3, bankieren);
        inventory.setItem(4, voedsel); //21
//        inventory.setItem(5, twitter); //23
//        inventory.setItem(30, crypto);
        inventory.setItem(5, blackmarket);
        inventory.setItem(6, settings);
        inventory.setItem(49, close);

        inventory.setItem(21, twitter);
        inventory.setItem(22, whatsapp);
        inventory.setItem(23, nieuws);

        inventory.setItem(11, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 5).setName(" ").toItemStack());
        inventory.setItem(12, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(13, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(20, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());



        inventory.setItem(24, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(29, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(30, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(31, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
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

        if(event.getSlot() == 3) {
            new BankierenMenu(player).open(player);
        }

        if(event.getSlot() == 4) {
            new FoodMenu(player).open(player);
        }

        if(event.getSlot() == 5) {
            new BlackmarketMenu(player).open(player);
        }

        if(event.getSlot() == 49) {
            player.closeInventory();
        }

        if(event.getSlot() == 21) {
            player.closeInventory();
            new ChatResponse(player, ChatUtils.format("&b&lTwitter &7Gebruik: &f(bericht) stuur een bericht"), (reply) -> {
                if (!(reply.isEmpty())) {
                    player.sendMessage("gestuurd");
                    Bukkit.broadcastMessage(ChatUtils.format("&f[&b&lTwitter&f] &7@" + player.getName() + "&f: " + reply));
                    return;
                }
            });
        }

        if(event.getSlot() == 22) {
            player.closeInventory();
            new ChatResponse(player, ChatUtils.format("&a&lWhatsApp &7Gebruik: &f(speler) om te kiezen naar wie je een bericht wil sturen."), (reply) -> {
                if (!(reply.isEmpty())) {
                    Player target = Bukkit.getPlayer(reply);
                    if(target != null) {
                        new ChatResponse(player, ChatUtils.format("&a&lWhatsApp &7Gebruik: &f(bericht) stuur een bericht"), (message) -> {
                            if (!(message.isEmpty())) {
                                target.sendMessage(ChatUtils.format("&a&lWhatsApp &7" + player.getName() + "&f: " + message));
                                player.sendMessage(ChatUtils.format("&aBericht succesvol gestuurd naar &2&l" + reply));
                                return;
                            }
                        });
                    } else {
                        player.sendMessage(ChatUtils.format("&7Deze speler is niet online!"));
                        return;
                    }
                }
            });
        }
    }

    @Override
    protected void handleCloseAction(InventoryCloseEvent event) {

    }
}

