package nl.criminalmt.criminalcore.framework.items;

import com.google.common.collect.Multimap;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.util.*;

public class ItemBuilder {

	private final ItemStack item;
	private ItemMeta meta;
	private List<String> lore;
	private boolean colorize = true;

	/**
	 * Creates a new ItemBuilder Object for the given {@link Material}
	 *
	 * @param material The material used for creating the new Object
	 */
	public ItemBuilder(@Nonnull Material material) {
		Validate.notNull(material, "Material must not be null");

		this.item = new ItemStack(material);
		this.meta = item.getItemMeta();
	}

	/**
	 * Creates a new ItemBuilder Object for the given {@link ItemStack}
	 *
	 * @param item The item used for creating the new Object
	 */
	public ItemBuilder(@Nonnull ItemStack item) {
		Validate.notNull(item, "Item must not be null");

		this.item = item;
		this.meta = item.getItemMeta();
	}

	/**
	 * Creates a new ItemBuilder Object for the given {@link ItemStack} and {@link ItemMeta}
	 *
	 * @param item The item used for creating the new Object
	 * @param meta The ItemMeta used for creating the new Object
	 */
	public ItemBuilder(@Nonnull ItemStack item, @Nonnull ItemMeta meta) {
		Validate.notNull(item, "Item must not be null");
		Validate.notNull(meta, "Meta must not be null");

		this.item = item;
		this.meta = meta;
	}

	/**
	 * Sets the amount of the item
	 *
	 * @param amount Amount
	 */
	public ItemBuilder setAmount(int amount) {
		item.setAmount(amount);
		return this;
	}

	/**
	 * Sets the name of the item
	 *
	 * @param name Name
	 */
	public ItemBuilder setName(@Nonnull String name) {
		Validate.notNull(name, "Name must not be null");

		meta.setDisplayName(colorize(name));
		return this;
	}

	/**
	 * Adds an enchantment
	 *
	 * @param enchantment Enchantment to add
	 * @param level Enchantment Level
	 */
	public ItemBuilder addEnchantment(@Nonnull Enchantment enchantment, int level) {
		Validate.notNull(enchantment, "Enchantment must not be null");

		meta.addEnchant(enchantment, level, false);
		return this;
	}

	/**
	 * Adds multiple enchantments at once
	 *
	 * @param enchantments The enchantments to add
	 */
	public ItemBuilder addEnchantments(@Nonnull Map<Enchantment, Integer> enchantments) {
		Validate.notNull(enchantments, "Enchantments must not be null");

		enchantments.forEach(
				(e, l) -> meta.addEnchant(e, l, false)
		);
		return this;
	}

	/**
	 * Adds an unsafe enchantment
	 * <p>This method is unsafe and will ignore level restrictions or item type. Use at your own discretion.</p>
	 *
	 * @param enchantment The enchantment to add
	 * @param level Enchantment Level
	 * @
	 */
	public ItemBuilder addUnsafeEnchantment(@Nonnull Enchantment enchantment, int level) {
		Validate.notNull(enchantment, "Enchantment must not be null");

		meta.addEnchant(enchantment, level, true);
		return this;
	}

	/**
	 * Adds multiple unsafe enchantments at once
	 * <p>This method is unsafe and will ignore level restrictions or item type. Use at your own discretion.</p>
	 *
	 * @param enchantments The enchantments to add
	 */
	public ItemBuilder addUnsafeEnchantments(@Nonnull Map<Enchantment, Integer> enchantments) {
		Validate.notNull(enchantments, "Enchantments must not be null");

		enchantments.forEach(
				(e, l) -> meta.addEnchant(e, l, true)
		);
		return this;
	}

	/**
	 * Removes an enchantment
	 *
	 * @param enchantment The enchantment to remove
	 */
	public ItemBuilder removeEnchantment(@Nonnull Enchantment enchantment) {
		Validate.notNull(enchantment, "Enchantment must not be null");

		meta.removeEnchant(enchantment);
		return this;
	}

	/**
	 * Adds the given string as a lore
	 *
	 * @param lore The string to add
	 */
	public ItemBuilder addLore(@Nonnull String lore) {
		Validate.notNull(lore, "Lore must not be null");

		this.lore.add(colorize(lore));
		meta.setLore(this.lore);
		return this;
	}

	/**
	 * Adds the given strings as a lore
	 *
	 * @param lore The strings to add
	 */
	public ItemBuilder setLore(@Nonnull String... lore) {
		Validate.notNull(lore, "Lore must not be null");

		this.lore = Arrays.asList(colorize(lore));
		return this;
	}

	/**
	 * Adds the given list as a lore
	 *
	 * @param lore The list to add
	 */
	public ItemBuilder setLore(@Nonnull List<String> lore) {
		Validate.notNull(lore, "Lore must not be null");

		this.lore = colorize(lore);
		return this;
	}

	/**
	 * Removes a line from the lore based on the index
	 *
	 * @param index The line to remove
	 */
	public ItemBuilder removeLoreLine(int index) {
		if (index < 0 || lore.size() < 0) return this;
		lore.remove(index);
		meta.setLore(lore);
		return this;
	}

	/**
	 * Removes a line from the lore based on the line string
	 *
	 * @param line The line to remove
	 */
	public ItemBuilder removeLoreLine(@Nonnull String line) {
		Validate.notNull(line, "line must not be null");

		if (!lore.contains(line)) return this;
		lore.remove(line);
		meta.setLore(lore);
		return this;
	}

	/**
	 * Adds an {@link ItemFlag}
	 *
	 * @param itemFlags The ItemFlag to add
	 */
	public ItemBuilder addItemFlags(@Nonnull ItemFlag... itemFlags) {
		Validate.notNull(item, "ItemFlag must not be null");

		meta.addItemFlags(itemFlags);
		return this;
	}

	/**
	 * Removes an ItemFlag
	 *
	 * @param itemFlags The ItemFlag to remove
	 */
	public ItemBuilder removeItemFlags(@Nonnull ItemFlag... itemFlags) {
		Validate.notNull(itemFlags, "ItemFlag must not be null");

		meta.removeItemFlags(itemFlags);
		return this;
	}

	/**
	 * Sets the material data
	 *
	 * @param materialData The material data to set
	 */
	@Deprecated
	public ItemBuilder setMaterialData(@Nonnull MaterialData materialData) {
		Validate.notNull(materialData, "MaterialData must not be null");

		item.setData(materialData);
		return this;
	}

	/**
	 * Set as unbreakable
	 *
	 * @param unbreakable Whether the item should be unbreakable
	 */
	public ItemBuilder setUnbreakable(boolean unbreakable) {
		meta.setUnbreakable(unbreakable);
		return this;
	}

	/**
	 * Set glowing
	 *
	 * @param b Whether the item should glow
	 */
	public ItemBuilder setGlow(boolean b) {
		addUnsafeEnchantment(item.getType() != Material.BOW ? Enchantment.ARROW_INFINITE : Enchantment.LUCK, 1);
		addItemFlags(ItemFlag.HIDE_ENCHANTS);
		return this;
	}

	/**
	 * Set the owner as an {@link OfflinePlayer}
	 *
	 * @param owner The owner
	 */
	public ItemBuilder setOwner(@Nonnull OfflinePlayer owner) {
		Validate.notNull(owner, "Owner must not be null");

		if (meta instanceof SkullMeta) {
			((SkullMeta) meta).setOwningPlayer(owner);
		}
		return this;
	}

	/**
	 * Set the owner as an {@link String}
	 *
	 * @param owner The owner
	 */
	public ItemBuilder setOwner(@Nonnull String owner) {
		Validate.notNull(owner, "Owner must not be null");

		if (meta instanceof SkullMeta) {
			((SkullMeta) meta).setOwner(owner);
		}
		return this;
	}

	/**
	 * Set item meta
	 *
	 * @param meta The item meta
	 */
	public ItemBuilder setItemMeta(@Nonnull ItemMeta meta) {
		Validate.notNull(meta, "Meta must not be null");

		this.meta = meta;
		return this;
	}

	/**
	 * Set if strings should be colorized by the builder
	 *
	 * @param b Whether to colorize strings
	 */
	public ItemBuilder setColorize(boolean b) {
		colorize = b;
		return this;
	}

	/**
	 * Build the item
	 *
	 * @return The finished item
	 */
	public ItemStack toItemStack() {
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	/**
	 * Check if server is paper
	 *
	 * @return Whether the server is running paper
	 */
	private boolean isPaper() {
		try {
			Class.forName("com.destroystokyo.paper.profile");
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	/**
	 * Colorize a list of strings
	 *
	 * @param string The list to colorize
	 * @return Colorized list of strings
	 */
	private List<String> colorize(List<String> string) {
		if (!colorize) return string;

		List<String> result = new ArrayList<>();
		string.forEach(
				(str) -> result.add(colorize(str))
		);
		return result;
	}

	/**
	 * Colorize an array of strings
	 *
	 * @param string The array to colorize
	 * @return Colorized array of strings
	 */
	private String[] colorize(String... string) {
		if (!colorize) return string;

		List<String> result = new ArrayList<>();
		Arrays.asList(string).forEach(
				(str) -> result.add(colorize(str))
		);
		return result.toArray(new String[0]);
	}

	/**
	 * Colorize a string
	 *
	 * @param string The string to colorize
	 * @return Colorized string
	 */
	private String colorize(String string) {
		if (!colorize) return string;
		return ChatUtils.format(string);
	}

	public PotionBuilder asPotion() {
		return new PotionBuilder(this.toItemStack());
	}

	public ItemBuilder setNoName() {
		meta.setDisplayName(" ");
		return this;
	}

	public ItemBuilder hideNBT() {
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		return this;
	}

	public ItemBuilder setProfile(String string) {
		GameProfile profile = new GameProfile(UUID.randomUUID(), null);
		profile.getProperties().put("textures", new Property("textures", string));

		Field field;
		SkullMeta meta2 = (SkullMeta) meta;

		try {
			field = meta2.getClass().getDeclaredField("profile");
			field.setAccessible(true);
			field.set(meta2, profile);
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return this;
	}

	public ItemBuilder setDurability(short durability) {
		item.setDurability(durability);
		return this;
	}

	public ItemBuilder setColor(Color c) {
		((LeatherArmorMeta) meta).setColor(c);
		return this;
	}

	public ItemBuilder addLeatherColor(Color color) {
		((LeatherArmorMeta) meta).setColor( color );
		return this;
	}

	public ItemBuilder setData(short data) {
		item.setDurability(data);
		return this;
	}

}
