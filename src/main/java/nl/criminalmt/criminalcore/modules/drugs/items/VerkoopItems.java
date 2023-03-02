package nl.criminalmt.criminalcore.modules.drugs.items;

import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.items.ItemBuilder;
import nl.criminalmt.criminalcore.framework.items.NBTEditor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class VerkoopItems {

    public static ItemStack OpVerM() {
        ItemStack OpVerM = new ItemBuilder(Material.SPIDER_EYE)
                .setName(ChatUtils.format("&f&lOpium Verkopen"))
                .setLore(ChatUtils.format("&7Prijs: €610"))
                .toItemStack();
        OpVerM = NBTEditor.set(OpVerM, "opium_verpakt", "mtcustom");
        return OpVerM;
    }

    public static ItemStack MeVerM() {
        ItemStack MeVerM = new ItemBuilder(Material.SUGAR)
                .setName(ChatUtils.format("&f&lMeth Verkopen"))
                .setLore(ChatUtils.format("&7Prijs: €530"))
                .toItemStack();
        MeVerM = NBTEditor.set(MeVerM, "meth", "mtcustom");
        return MeVerM;
    }

    public static ItemStack WiVerM() {
        ItemStack WiVerM = new ItemBuilder(Material.POTATO_ITEM)
                .setName(ChatUtils.format("&f&lWiet Verkopen"))
                .setLore(ChatUtils.format("&7Prijs: €250"))
                .toItemStack();
        WiVerM = NBTEditor.set(WiVerM, "wiet_verpakt", "mtcustom");
        return WiVerM;
    }

    public static ItemStack CoVerM() {
        ItemStack CoVerM = new ItemBuilder(Material.SUGAR)
                .setName(ChatUtils.format("&f&lCocaïne Verkopen"))
                .setLore(ChatUtils.format("&7Prijs: €360"))
                .toItemStack();
        CoVerM = NBTEditor.set(CoVerM, "coke_verpakt", "mtcustom");
        return CoVerM;
    }
}
