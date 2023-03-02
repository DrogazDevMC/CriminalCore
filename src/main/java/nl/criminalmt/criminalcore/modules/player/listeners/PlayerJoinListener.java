package nl.criminalmt.criminalcore.modules.player.listeners;

import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.items.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionType;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.hasPlayedBefore()) return;
        Bukkit.getOnlinePlayers().forEach(target -> target.sendMessage(ChatUtils.format("&7Welkom op &8&lCriminal&7&lMT&7, &c" + player.getName() + "&7. Je bent de &c" + Bukkit.getOfflinePlayers().length + "e &7die onze server joined!")));

        PlayerInventory inventory = player.getInventory();
        inventory.addItem(new ItemBuilder(Material.IRON_HELMET).setName("Camo helmet").setLore("&8➟ &7Officieel &8&lCriminal&7&lMT &4&nkit&r &7item!").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DURABILITY, 1).toItemStack());
        inventory.addItem(new ItemBuilder(Material.IRON_CHESTPLATE).setName("Camo chestplate").setLore("&8➟ &7Officieel &8&lCriminal&7&lMT &4&nkit&r &7item!").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DURABILITY, 1).toItemStack());
        inventory.addItem(new ItemBuilder(Material.IRON_LEGGINGS).setName("Camo leggings").setLore("&8➟ &7Officieel &8&lCriminal&7&lMT &4&nkit&r &7item!").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DURABILITY, 1).toItemStack());
        inventory.addItem(new ItemBuilder(Material.IRON_BOOTS).setName("Camo boots").setLore("&8➟ &7Officieel &8&lCriminal&7&lMT &4&nkit&r &7item!").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DURABILITY, 1).toItemStack());

//        Weapon weapon = new Weapon("ump");
//        WeaponFactory factory = new WeaponFactory(player);
//        factory.buildWeapon(weapon, 15);
//        factory.addToInventory();
//
//        weapon = new Weapon("glocknormal");
//        factory = new WeaponFactory(player);
//        factory.buildWeapon(weapon, 10);
//        factory.addToInventory();

        inventory.addItem(new ItemBuilder(Material.WOOD_SWORD).setName("&b&lMes").setLore("&8➟ &7Officieel &8&lCriminal&7&lMT &4&nkit&r &7item!").setDurability((short) 50).addEnchantment(Enchantment.DAMAGE_ALL, 1).toItemStack());
        inventory.addItem(new ItemBuilder(Material.CARROT_STICK).setName("&f&lRugzak").setDurability((short) 22).setLore("&8➟ &7Officieel &8&lCriminal&7&lMT &4&nkit&r &7item!").setUnbreakable(true).toItemStack());
        inventory.addItem(new ItemBuilder(Material.BLAZE_POWDER).setName("&f&lTelefoon").setLore("&8➟ &7Officieel &8&lCriminal&7&lMT &4&nkit&r &7item!").toItemStack());
        inventory.addItem(new ItemBuilder(Material.COOKED_BEEF).setAmount(64).setName("&f&lHamburger").setLore("&8➟ &7Officieel &8&lCriminal&7&lMT &4&nkit&r &7item!").toItemStack());
        inventory.addItem(new ItemBuilder(Material.POTION).setAmount(16).setName("&f&lWater Bottle").setLore("&8➟ &7Officieel &8&lCriminal&7&lMT &4&nkit&r &7item!").asPotion().setType(PotionType.WATER).toItemStack());
    }

}
