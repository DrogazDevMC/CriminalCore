package nl.criminalmt.criminalcore.modules.drugs.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.npc.ai.speech.Chat;
import nl.criminalmt.criminalcore.framework.chat.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class VerkoopCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only player can preform this command");
            return true;
        }

        if(!(player.hasPermission("criminalcore.commands.drugs"))) { player.sendMessage(ChatUtils.format("&cJe hebt kunt dit commando niet uitvoeren!")); return false;}

        if(args.length == 0) {
            player.sendMessage(ChatUtils.format("&7&lCRIMINAL&8&lMT &cDrugs Commands"));
            player.sendMessage(ChatUtils.format("&7/drugs &cplaatspluk (&4wiet, coke, meth, opium&c) &4Later..."));
            player.sendMessage(ChatUtils.format("&7/drugs &cplaatsverkoop"));
            player.sendMessage(ChatUtils.format("&7/drugs &cplaatswitwas"));
            return false;
        }

        if(args[0].equalsIgnoreCase("plaatsverkoop")) {

            if (args.length != 2) {
                player.sendMessage(ChatUtils.format("&cSyntax: /drugs &4plaatsverkoop skin"));
                return false;
            }

            NPC verkoopnpc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, ChatUtils.format("&8&l➠ &fDealer"));
            verkoopnpc.data().setPersistent("player-skin-name", args[1]);
            verkoopnpc.spawn(player.getLocation());
            player.sendMessage(ChatUtils.format("&aVerkoop npc geplaatst"));
            return false;
        }

        if(args[0].equalsIgnoreCase("plaatswitwas")) {

            if (args.length != 2) {
                player.sendMessage(ChatUtils.format("&cSyntax: /drugs &4plaatswitwas skin"));
                return false;
            }

            NPC verkoopnpc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, ChatUtils.format("&8&l➠ &fWitwas"));
            verkoopnpc.data().setPersistent("player-skin-name", args[1]);
            verkoopnpc.spawn(player.getLocation());
            player.sendMessage(ChatUtils.format("&aWitwas npc geplaatst"));
            return false;
        }


        return false;
    }
}