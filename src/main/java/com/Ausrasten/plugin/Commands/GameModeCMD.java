/*
 * @author ExceptionAPI (admin@shzmu.xyz)
 *
 * Copyright by ExceptionAPI (admin@shzmu.xyz)
 */
package com.Ausrasten.plugin.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.Ausrasten.plugin.Utils.Config.NoPerms;
import static com.Ausrasten.plugin.Utils.Config.PREFIX;

public class GameModeCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        final Player player = (Player) commandSender;
        if (command.getName().equalsIgnoreCase("gm")) {
            if (player.hasPermission("ausrasten.gm.use")) {

                if (strings[0].length() == 1) {

                    if (strings[0].equalsIgnoreCase("0")) {
                        if (player.hasPermission("ausrasten.gm.0")) {
                            player.sendMessage(PREFIX + "Du bist nun in §e§lGameMode Survival");
                            player.setGameMode(GameMode.SURVIVAL);
                        } else {
                            player.sendMessage(NoPerms);
                        }
                    }

                    if (strings[0].equalsIgnoreCase("1")) {
                        if (player.hasPermission("ausrasten.gm.1")) {
                            player.sendMessage(PREFIX + "Du bist nun in §e§lGameMode Creative");
                            player.setGameMode(GameMode.CREATIVE);
                        } else {
                            player.sendMessage(NoPerms);
                        }
                    }

                    if (strings[0].equalsIgnoreCase("2")) {
                        if (player.hasPermission("ausrasten.gm.2")) {
                            player.sendMessage(PREFIX + "Du bist nun in §e§lGameMode Adventure");
                            player.setGameMode(GameMode.ADVENTURE);
                        } else {
                            player.sendMessage(NoPerms);
                        }
                    }

                    if (strings[0].equalsIgnoreCase("3")) {
                        if (player.hasPermission("ausrasten.gm.3")) {
                            player.sendMessage(PREFIX + "Du bist nun in §e§lGameMode Spectator");
                            player.setGameMode(GameMode.SPECTATOR);
                        } else {
                            player.sendMessage(NoPerms);
                        }
                    }
                } else {
                    player.sendMessage(PREFIX + "Falsche Syntax");
                }


            } else {
                player.sendMessage(NoPerms);
            }
        }
        return false;
    }
}
