package nl.criminalmt.criminalcore.modules.phone.menus;

import nl.criminalmt.criminalcore.CriminalCore;
import nl.criminalmt.criminalcore.framework.chat.ChatResponse;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.gui.GUI;
import nl.criminalmt.criminalcore.framework.items.ItemBuilder;
import nl.criminalmt.criminalcore.framework.items.NBTEditor;
import nl.minetopiasdb.api.API;
import nl.minetopiasdb.api.objects.Phone;
import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class BankierenMenu extends GUI {
    private final Player player;

    public BankierenMenu(Player player) {
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
                .toItemStack();
        contacten = NBTEditor.set(contacten, "phone_icon1", "mtwcustom");

        ItemStack bankieren = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&5&lGeldzaken"))
                .setLore(Arrays.asList(ChatUtils.format("&7Maak geld over naar andere mensen &"), ChatUtils.format("&7en koop crypto!")))
                .setGlow(true)
                .toItemStack();
        bankieren = NBTEditor.set(bankieren, "phone_icon32", "mtwcustom");

        ItemStack voedsel = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&9&lVoedsel Winkel"))
                .setLore(Arrays.asList(ChatUtils.format("&7Koop lekker eten bij de voedselwinkel &"), ChatUtils.format("&7blijf gezond!")))
                .toItemStack();
        voedsel = NBTEditor.set(voedsel, "phone_icon34", "mtwcustom");

        ItemStack blackmarket = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&c&lBlackmarket"))
                .setLore(Arrays.asList(ChatUtils.format("&7Koop Ilegale items en maak je klaar voor overvallen!")))
                .toItemStack();
        blackmarket = NBTEditor.set(blackmarket, "phone_icon4", "mtwcustom");

        ItemStack settings = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&7&lInformatie"))
                .setLore(Arrays.asList(ChatUtils.format("&7Rekening:"), ChatUtils.format(""), ChatUtils.format("&7Gemaakt door: &c83J")))
                .toItemStack();
        settings = NBTEditor.set(settings, "phone_icon40", "mtwcustom");

        ItemStack overschrijven = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&5Overschrijven"))
                .setLore(Arrays.asList(ChatUtils.format("&7Maak geld over naar online spelers!")))
                .toItemStack();
        overschrijven = NBTEditor.set(overschrijven, "phone_icon32", "mtwcustom");

        ItemStack crypto = new ItemBuilder(Material.CLAY_BRICK)
                .setName(ChatUtils.format("&6Crypto"))
                .setLore(Arrays.asList(ChatUtils.format("&7Komt later...")))
                .setGlow(true)
                .toItemStack();
        crypto = NBTEditor.set(crypto, "crypto_bitcoin", "mtcustom");


        ItemStack close = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&cSluit"))
                .toItemStack();
        close = NBTEditor.set(close, "phone_icon20", "mtwcustom");

        inventory.setItem(2, contacten);
        inventory.setItem(3, bankieren);
        inventory.setItem(4, voedsel); //21
//        inventory.setItem(5, twitter); //23
//        inventory.setItem(30, crypto);
        inventory.setItem(5, blackmarket);
        inventory.setItem(6, settings);
        inventory.setItem(49, close);

        inventory.setItem(22, overschrijven);
        inventory.setItem(31, crypto);

        inventory.setItem(11, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(12, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 5).setName(" ").toItemStack());
        inventory.setItem(13, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(20, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(21, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
        inventory.setItem(23, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());


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
        if (event.getSlot() == 2) {
            new PhoneMenu(player).open(player);
        }

        if(event.getSlot() == 4) {
            new FoodMenu(player).open(player);
        }
        if(event.getSlot() == 5) {
            new BlackmarketMenu(player).open(player);
        }

//        if(event.getSlot() == 31) {
//            new CryptoMenu(player).open(player);
//        }

        if(event.getSlot() == 49) {
            player.closeInventory();
        }

        if (event.getSlot() == 22) {
            player.closeInventory();
            new ChatResponse(player, ChatUtils.format("&5&lBankieren &7Gebruik: &f(speler) om te kiezen naar wie je een geld wil overmaken"), (reply) -> {
                if (!(reply.isEmpty())) {
                    Player target = Bukkit.getPlayer(reply);
                    if (target != null) {
                        new ChatResponse(player, ChatUtils.format("&5&lBankieren &7Gebruik: &f(bedrag) stuur een bedrag"), (amount) -> {
                            if (!(amount.isEmpty())) {
                                if (NumberUtils.isCreatable(amount)) {
                                    if (API.getEcon().getBalance(player) >= Integer.parseInt(amount)) {
                                        API.getEcon().withdrawPlayer(player, Double.parseDouble(amount));
                                        API.getEcon().depositPlayer(target, Double.parseDouble(amount));
                                        player.sendMessage(ChatUtils.format("&aSuccessvul &2&l€" + amount + " &aovergemaakt naar  &2&l" + reply));
                                        target.sendMessage(ChatUtils.format("&aJe hebt &2&l€" + amount + " &aontvangen van &2&l" + player.getName()));
                                        return;
                                    }
                                }
                                player.sendMessage(ChatUtils.format("&7Ongeldig bedrag!"));
                            }
                        });
                    } else {
                        player.sendMessage(ChatUtils.format("&7Deze speler is niet online!"));
                    }
                }
            });
        }

    }

    @Override
    protected void handleCloseAction(InventoryCloseEvent event) {

    }
}
