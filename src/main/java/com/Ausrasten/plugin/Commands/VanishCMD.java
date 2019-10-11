/*
 * @author ExceptionAPI (admin@shzmu.xyz)
 *
 * Copyright by ExceptionAPI (admin@shzmu.xyz)
 */
package com.Ausrasten.plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static com.Ausrasten.plugin.Utils.Config.NoPerms;
import static com.Ausrasten.plugin.Utils.Config.PREFIX;

public class VanishCMD implements CommandExecutor {

    ArrayList<String> vanish = new ArrayList<String>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (command.getName().equalsIgnoreCase("vanish")) {
            Player player = (Player) commandSender;

            if (player.hasPermission("ausrasten.vanish")) {
                if (strings.length == 0) {
                    if (vanish.contains(player.getName())) {
                        vanish.remove(player.getName());
                        player.sendMessage(PREFIX + "Du bist nun sichtbar");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.showPlayer(player);
                        }
                    } else {
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.hidePlayer(player);
                        }
                        vanish.add(player.getName());
                        player.sendMessage(PREFIX + "Du nun unsichtbar");
                    }
                }
            } else { player.sendMessage(NoPerms); }
        }
        return false;
    }
}
