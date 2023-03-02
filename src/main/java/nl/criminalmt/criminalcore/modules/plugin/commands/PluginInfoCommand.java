package nl.criminalmt.criminalcore.modules.plugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import lombok.RequiredArgsConstructor;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import nl.criminalmt.criminalcore.modules.plugin.PluginModule;
import org.bukkit.entity.Player;

@CommandAlias("criminalcore|criminal|criminalmt|ver|version|pl|plugins")
@RequiredArgsConstructor
public class PluginInfoCommand extends BaseCommand {

    private final PluginModule module;

    @Default
    public void onCommand(Player player) {
        player.sendMessage(ChatUtils.format("&8&m                                &r"));
        player.sendMessage(ChatUtils.format("&7CriminalCore &cV" + module.getPlugin().getDescription().getVersion()));
        player.sendMessage("");
        player.sendMessage(ChatUtils.format("&7Gemaakt door: &c" + String.join("&7, &c", module.getPlugin().getDescription().getAuthors())));
        player.sendMessage(ChatUtils.format("&8&m                                &r"));
    }

}
