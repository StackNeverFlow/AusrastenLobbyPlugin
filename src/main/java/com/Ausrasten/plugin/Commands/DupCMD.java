package com.Ausrasten.plugin.Commands;

import com.google.gson.internal.$Gson$Preconditions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static com.Ausrasten.plugin.Utils.Config.NoPerms;
import static com.Ausrasten.plugin.Utils.Config.PREFIX;

public class DupCMD implements CommandExecutor {

    ArrayList<String> duplist = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (command.getName().equalsIgnoreCase("dup")) {
            Player player = (Player) commandSender;

            if (player.hasPermission("ausrasten.dup.use")) {

                if (player.hasPermission("ausrasten.dup.add")) {
                    if (strings[0].equalsIgnoreCase("add")) {
                        if (!duplist.contains(strings[1])) {
                            duplist.add(strings[1]);
                            player.sendMessage(PREFIX + "Der Spieler " + strings[1] + " ist nun im Array");
                        } else {
                            player.sendMessage(PREFIX + "Der Spieler " + strings[1] + " ist bereits im Array");
                        }
                    }
                }

                if (player.hasPermission("ausrasten.dup.remove")) {
                    if (strings[0].equalsIgnoreCase("remove")) {
                        if (duplist.contains(strings[1])) {
                            duplist.remove(strings[1]);
                            player.sendMessage(PREFIX + "Der Spieler " + strings[1] + " ist nun nicht mehr im Array");
                        } else {
                            player.sendMessage(PREFIX + "Der Spieler " + strings[1] + " ist nicht im Array");
                        }
                    }
                }
                if (strings[0].equalsIgnoreCase("list")) {
                    String allDups = duplist.toString();

                    player.sendMessage(PREFIX + allDups);
                }

                if (strings[0].equalsIgnoreCase("clear")) {
                    if (player.hasPermission("ausrasten.dup.clear")) {
                        duplist.clear();
                        player.sendMessage(PREFIX + "§c§lDer Array wurde geleert");
                    }
                }

                if (strings[0].equalsIgnoreCase("save")) {
                    if (player.hasPermission("ausrasten.dup.savetofile")) {
                        
                    }
                }

            } else {
                player.sendMessage(NoPerms);
            }

        }

        return false;
    }
}
