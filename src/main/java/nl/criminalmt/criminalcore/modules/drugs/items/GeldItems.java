package nl.criminalmt.criminalcore.modules.drugs.items;

import net.citizensnpcs.npc.ai.speech.Chat;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.items.ItemBuilder;
import nl.criminalmt.criminalcore.framework.items.NBTEditor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GeldItems {

    public static ItemStack zwartGeld100(Integer amount) {
        ItemStack zwartGeld100 = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&8€100,-"))
                .setAmount(amount)
                .setLore(ChatUtils.format("&8➠ &7Officieel &8&lCriminal&7&lMT &7Zwartgeld!"))
                .toItemStack();
        zwartGeld100 = NBTEditor.set(zwartGeld100, "zwartgeld", "criminalmt");
        return zwartGeld100;
    }
    public static ItemStack zwartGeld100i() {
        ItemStack zwartGeld100i = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&8€100,-"))
                .setLore(ChatUtils.format("&8➠ &7Officieel &8&lCriminal&7&lMT &7Zwartgeld!"))
                .toItemStack();
        zwartGeld100i = NBTEditor.set(zwartGeld100i, "zwartgeld", "criminalmt");
        return zwartGeld100i;
    }

    public static ItemStack Geld100(Integer amount) {
        ItemStack Geld100 = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&f€100,-"))
                .setLore(ChatUtils.format("&cOfficieel Minetopia bank biljet!"))
                .setAmount(amount)
                .toItemStack();
        Geld100 = NBTEditor.set(Geld100, "witgeld", "criminalmt");
        return Geld100;
    }

}
