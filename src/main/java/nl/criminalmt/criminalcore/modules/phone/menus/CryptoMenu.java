package nl.criminalmt.criminalcore.modules.phone.menus;

import nl.criminalmt.criminalcore.CriminalCore;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.file.File;
import nl.criminalmt.criminalcore.framework.gui.GUI;
import nl.criminalmt.criminalcore.framework.items.ItemBuilder;
import nl.criminalmt.criminalcore.framework.items.NBTEditor;
import nl.criminalmt.criminalcore.modules.phone.PhoneModule;
import nl.minetopiasdb.api.API;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.io.IOException;
import java.util.Arrays;

public class CryptoMenu extends GUI {

    File crypto = new File(CriminalCore.getInstance(), "crypto.yml");
    File pcrypto = new File(CriminalCore.getInstance(), "playersinfo_crypto.yml");

    private final Player player;

    public CryptoMenu(Player player) {
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

        ItemStack info = new ItemBuilder(Material.PAPER)
                .setName(ChatUtils.format("&7Informatie"))
                .setLore(Arrays.asList(ChatUtils.format("&7Maak geld over naar online spelers!")))
                .toItemStack();

        ItemStack crypto = new ItemBuilder(Material.CLAY_BRICK)
                .setName(ChatUtils.format("&6Crypto"))
                .setLore(Arrays.asList(ChatUtils.format("&7Verdien geld met het verhandelen van Crypto's")))
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

        inventory.setItem(22, info);
        inventory.setItem(30, crypto);
        inventory.setItem(32, crypto);

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
        inventory.setItem(31, new ItemBuilder(Material.STAINED_GLASS_PANE).setData((short) 11).setName(" ").toItemStack());
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
        if (event.getSlot() == 3) {
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

        int Koers = crypto.getConfiguration().getInt("Crypto.Bitcoin.Koers");
        int BitcoinAmount = pcrypto.getConfiguration().getInt("Crypto.Playerdata." + player.getUniqueId() + ".Bitcoins");
        int Som = BitcoinAmount + 1;

        //30 & 32
//        if (event.getSlot() == 30) {
//            player.sendMessage("1");
//            if(API.getEcon().getBalance(player) >= Koers) {
//                player.sendMessage("2");
//                if(pcrypto.getConfiguration().get("Crypto.Playerdata." + player.getUniqueId()) == null) {
//                    player.sendMessage("3");
//                    pcrypto.getConfiguration().set("Crypto.Playerdata." + player.getUniqueId() + ".Bitcoins", 1);
//                    if (Koers < 8025) {
//                        crypto.getConfiguration().set("Crypto.Bitcoin.Koers", Koers + 75);
//                        try {
//                            pcrypto.saveFile();
//                            crypto.saveFile();
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        } catch (InvalidConfigurationException e) {
//                            throw new RuntimeException(e);
//                        }
//                        return;
//                    }
//                    try {
//                        pcrypto.saveFile();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    } catch (InvalidConfigurationException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return;
//                }
//                player.sendMessage("4");
//                player.sendMessage("Amount = " + Som);
//                pcrypto.getConfiguration().set("Crypto.Playerdata." + player.getUniqueId() + ".Bitcoins", BitcoinAmount + 1);
//                if (Koers < 8025) {
//                    crypto.getConfiguration().set("Crypto.Bitcoin.Koers", Koers + 75);
//                    try {
//                        pcrypto.saveFile();
//                        crypto.saveFile();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    } catch (InvalidConfigurationException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return;
//                }
//                try {
//                    pcrypto.saveFile();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                } catch (InvalidConfigurationException e) {
//                    throw new RuntimeException(e);
//                }
//                return;
//            }
//            player.sendMessage("error");
//        }
        if (event.getSlot() == 32) {
            player.sendMessage("1");
            if(BitcoinAmount >= 0) {

            }
            player.sendMessage(ChatUtils.format("&7Je hebt geen bitcoins meer!"));
        }
    }

    @Override
    protected void handleCloseAction(InventoryCloseEvent event) {

    }
}
