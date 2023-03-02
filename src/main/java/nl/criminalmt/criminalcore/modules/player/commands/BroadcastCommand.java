package nl.criminalmt.criminalcore.modules.player.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("broadcast|bc")
@CommandPermission("criminalcore.commands.broadcast")
public class BroadcastCommand extends BaseCommand {

    @Default
    public void onCommand(Player player, String message) {
        Bukkit.getOnlinePlayers().forEach(target -> target.sendMessage(ChatUtils.format("&8&lCriminal&7&lMT &7» &f" + message)));
    }

}
