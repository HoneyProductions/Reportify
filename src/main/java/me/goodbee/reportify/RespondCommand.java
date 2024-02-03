package me.goodbee.reportify;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * The class handling the internal response command.
 */
public class RespondCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("reportify.reports")) return false;
        if(args.length != 1) ((Player) sender).kickPlayer("§cDo not attempt to use this command manually.");


        Player playerSender = (Player) sender;
        Player repondToPlayer = Bukkit.getPlayer(args[0]);

        playerSender.setGameMode(GameMode.SPECTATOR);playerSender.teleport(repondToPlayer);

        return false;
    }
}
