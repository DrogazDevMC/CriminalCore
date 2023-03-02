package nl.criminalmt.criminalcore.modules.phone;

import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.items.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemGiver {
    public static void giveFood(Material material, int amount, String name, Player player) {
        ItemStack food = new ItemBuilder(material)
                .setName(name)
                .setLore(ChatUtils.format("&8➠ &7Officieel &8&lCriminal&7&lMT &7Item!"))
                .setAmount(amount)
                .toItemStack();

        player.getInventory().addItem(food);
        return;
    }
}
