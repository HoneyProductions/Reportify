package me.goodbee.reportify;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.w3c.dom.Text;

/**
 * Class handling the /report command
 */
public class ReportCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /report <player>");
            return false;
        }

        Player reportedPlayer = Bukkit.getPlayer(args[0]);

        if(reportedPlayer == null) {
            sender.sendMessage(ChatColor.RED + "Could not find a player by the name of \"" + args[0] + "\".");
            return false;
        }

        TextComponent staffMsg1 = new TextComponent(
                "§8-----------------------------------------------------"
        );

        TextComponent staffMsg2 = new TextComponent(
                "§c§lStaff §r§7>>> §fNew report by player §c" + sender.getName() + "§f."
        );

        TextComponent staffMsg3 = new TextComponent(
                "§c§lStaff §r§7>>> §fUser: §c" + reportedPlayer.getName() + "§f."
        );

        TextComponent staffMsg4 = new TextComponent(
                "§c§lStaff §r§7>>> §fReason: §cDev Build - WIP"
        );

        TextComponent staffMsg5 = new TextComponent(
                "§c§lStaff §r§7>>> §c§l[Click to respond.]"
        );

        staffMsg5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/z-respondreport " + reportedPlayer.getName()));

        TextComponent staffMsg6 = new TextComponent(
                "§8-----------------------------------------------------"
        );


        for(Player player : Bukkit.getOnlinePlayers()) {
            if(player.hasPermission("reportify.reports")) {
                Player.Spigot spigotPlayer = player.spigot();

                Bukkit.getLogger().info(staffMsg5.getClickEvent().toString());

                spigotPlayer.sendMessage(staffMsg1);
                spigotPlayer.sendMessage(staffMsg2);
                spigotPlayer.sendMessage(staffMsg3);
                spigotPlayer.sendMessage(staffMsg4);
                spigotPlayer.sendMessage(staffMsg5);
                spigotPlayer.sendMessage(staffMsg6);

            }
        }

        sender.sendMessage("§aYour report has been recorded. Thank you for your report.");

        return false;
    }
}
