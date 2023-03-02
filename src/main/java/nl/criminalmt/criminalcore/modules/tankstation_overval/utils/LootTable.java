package nl.criminalmt.criminalcore.modules.tankstation_overval.utils;

import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.items.ItemBuilder;
import nl.criminalmt.criminalcore.framework.items.NBTEditor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class LootTable {
    public static ItemStack Geld100(Integer amount) {
        ItemStack Geld100 = new ItemBuilder(Material.IRON_INGOT)
                .setName(ChatUtils.format("&f€100,-"))
                .setLore(ChatUtils.format("&cOfficieel Minetopia bank biljet!"))
                .setAmount(amount)
                .toItemStack();
        Geld100 = NBTEditor.set(Geld100, "witgeld", "criminalmt");
        return Geld100;
    }

    public static ItemStack Dufflebag(Integer amount) {
        ItemStack Dufflebag = new ItemBuilder(Material.INK_SACK)
                .setData((short) 4)
                .setName(ChatUtils.format("&fDufflebag"))
                .setLore(new ArrayList<>() {{
                    add(ChatUtils.format("&cInhoud: &7" + amount + "x €100,-"));
                    add(ChatUtils.format(""));
                    add(ChatUtils.format("&cDit is een officieel CriminalMT item!"));
                }})
                .toItemStack();
        Dufflebag = NBTEditor.set(Dufflebag, "duffelbag", "criminalmt");
        return Dufflebag;
    }
}
