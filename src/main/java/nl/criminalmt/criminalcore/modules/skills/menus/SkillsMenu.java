package nl.criminalmt.criminalcore.modules.skills.menus;

import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.framework.configs.SkillsYML;
import nl.criminalmt.criminalcore.framework.gui.GUI;
import nl.criminalmt.criminalcore.framework.items.ItemBuilder;
import nl.criminalmt.criminalcore.framework.items.NBTEditor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class SkillsMenu extends GUI {

    private final Player player;

    public SkillsMenu(Player player) {
        super(ChatUtils.format("&8Skills - CriminalMT"), 5);
        this.player = player;
    }

    @Override
    protected void setContents() {
        for (int i = 0; i < 45; i++) {
            ItemStack leeg = new ItemBuilder(Material.STAINED_GLASS_PANE).setName(" ").setData((short) 7).toItemStack();
            inventory.setItem(i, leeg);
        }

        ItemStack hitman = new ItemBuilder(NBTEditor.getHead("http://textures.minecraft.net/texture/89a995928090d842d4afdb2296ffe24f2e944272205ceba848ee4046e01f3168"))
                .setName(ChatUtils.format("&6&l♕ SKILLS ♕"))
                .setLore(new ArrayList<>() {{
                    add(ChatUtils.format(""));
                    add(ChatUtils.format("&e&l• &fSkills zijn een manier om jezelf te verbeteren"));
                    add(ChatUtils.format("&e&l• &fJe kan skills &eunlocken &fdoor te spelen"));
                    add(ChatUtils.format(""));
                    add(ChatUtils.format("&e&l• &fDoor &6skills &fte unlocken krijg je meer kans"));
                    add(ChatUtils.format("&e&l• &fop betere beloningen bij het uitvoeren van jobs"));
                    add(ChatUtils.format(""));
                }})
                .toItemStack();

//        ItemStack head =
        inventory.setItem(4, hitman);

//        String Skills = SkillsYML.get().getString("Skills." + player.getUniqueId());

        ItemStack skills = new ItemBuilder(Material.BOOK)
                .setName("&cCar Crafting")
                .setLore(new ArrayList<>() {{
                    add(ChatUtils.format("&8Craft je eigen auto's!"));
                    add(ChatUtils.format(""));
                    add(ChatUtils.format("&fJe kan auto's craften door"));
                    add(ChatUtils.format("&fde juiste materialen te verzamelen"));
                    add(ChatUtils.format("&fbij de &escrapyard."));
                    add(ChatUtils.format(""));
                    add(ChatUtils.format("&fLevel: &c" + SkillsYML.get().getInt("Skills." + player.getUniqueId() + ".CarCrafting.LEVEL")));
                    add(ChatUtils.format("&f---------------- &c" + SkillsYML.get().getInt("Skills." + player.getUniqueId() + ".CarCrafting.EXP") + "/100 XP"));
                }})
                .toItemStack();
        inventory.setItem(20, skills);

        ItemStack jobs = new ItemBuilder(Material.BOOK).setName("&8Jobs").toItemStack();
        inventory.setItem(22, jobs);

        ItemStack overval = new ItemBuilder(Material.BOOK).setName("&8Overval").toItemStack();
        inventory.setItem(24, overval);
    }

    @Override
    protected void handleClickAction(InventoryClickEvent event) {
        if (event.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
            event.setCancelled(true);
        }
    }

    @Override
    protected void handleCloseAction(InventoryCloseEvent event) {

    }
}
