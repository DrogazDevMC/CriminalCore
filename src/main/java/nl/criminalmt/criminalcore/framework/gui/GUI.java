package nl.criminalmt.criminalcore.framework.gui;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public abstract class GUI implements InventoryHolder {

    protected final Inventory inventory;
    @Getter private final String title;
    @Getter private int size = -1;
    @Getter private InventoryType type = null;

    public GUI(String title) {
        this(title, 3);
    }

    public GUI(String title, int rows) {
        this.title = title;
        this.size = rows * 9;
        this.inventory = Bukkit.createInventory(this, size, title);
    }

    public GUI(String title, InventoryType type) {
        this.title = title;
        this.type = type;
        this.inventory = Bukkit.createInventory(this, type, title);
    }

    protected void setItem(int x, int y, ItemStack stack) {
        inventory.setItem(y * 9 + x, stack);
    }

    public void create() {
        setContents();
    }

    public void open(Player player) {
        setContents();

        player.openInventory(this.inventory);
    }

    protected abstract void setContents();

    @Override public Inventory getInventory() {
        return inventory;
    }

    protected void drawOutline(Inventory inventory, int rows, ItemStack itemStack) {
        for (int i = 1; i < 10; i++) {
            inventory.setItem(i - 1, itemStack);
            inventory.setItem((rows * 9) - i, itemStack);
        }

        for (int i = 1; i < rows; i++) {
            inventory.setItem(i * 9, itemStack);
            inventory.setItem(i * 9 - 1, itemStack);
        }
    }

    protected abstract void handleClickAction(InventoryClickEvent event);

    protected abstract void handleCloseAction(InventoryCloseEvent event);

}
