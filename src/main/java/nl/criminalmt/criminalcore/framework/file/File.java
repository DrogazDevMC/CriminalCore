package nl.criminalmt.criminalcore.framework.file;

import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.IOException;

public class File {

	@Getter private FileConfiguration configuration = null;
	private final java.io.File file;

	public File(Plugin plugin, String fileName) {
		if (!plugin.getDataFolder().exists()) plugin.getDataFolder().mkdir();
		file = new java.io.File(plugin.getDataFolder(), fileName);

		try {
			if (!file.exists())
				plugin.saveResource(fileName, false);

			configuration = new YamlConfiguration();
			configuration.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void saveFile() throws IOException, InvalidConfigurationException {
		configuration.save(file);
		configuration.load(file);
	}

}
