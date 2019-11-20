package com.Ausrasten.plugin.Commands;

import com.Ausrasten.plugin.Utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static com.Ausrasten.plugin.Utils.Config.NoPerms;
import static com.Ausrasten.plugin.Utils.Config.PREFIX;

public class DupCMD implements CommandExecutor {

    //The Array to storage the player for save him in the config
    ArrayList<String> duplist = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (command.getName().equalsIgnoreCase("dup")) {
            Player player = (Player) commandSender;

            //Basic permission check
            if (player.hasPermission("ausrasten.dup.use")) {

                //the code for the '/dup add <Playername>'
                if (player.hasPermission("ausrasten.dup.add")) {
                    if (strings[0].equalsIgnoreCase("add")) {
                        if (!duplist.contains(strings[1])) {
                            duplist.add(strings[1]);
                            player.sendMessage(PREFIX + "Der Spieler " + strings[1] + " ist nun im Array");
                        } else {
                            player.sendMessage(PREFIX + "Der Spieler " + strings[1] + " ist bereits im Array");
                        }
                    }
                } else { player.sendMessage(NoPerms); }

                //the code for the '/dup remove <Playername>'
                if (player.hasPermission("ausrasten.dup.remove")) {
                    if (strings[0].equalsIgnoreCase("remove")) {
                        if (duplist.contains(strings[1])) {
                            duplist.remove(strings[1]);
                            player.sendMessage(PREFIX + "Der Spieler " + strings[1] + " ist nun nicht mehr im Array");
                        } else {
                            player.sendMessage(PREFIX + "Der Spieler " + strings[1] + " ist nicht im Array");
                        }
                    }
                } else { player.sendMessage(NoPerms); }

                //the code for the '/dup list'
                if (player.hasPermission("ausrasten.dup.list")) {
                    if (strings[0].equalsIgnoreCase("list")) {
                        String allDups = duplist.toString();

                        player.sendMessage(PREFIX + allDups);
                    }
                } else { player.sendMessage(NoPerms); }

                //the code for the '/dup clear' clearing only the temp array
                if (strings[0].equalsIgnoreCase("clear")) {
                    if (player.hasPermission("ausrasten.dup.clear")) {
                        duplist.clear();
                        player.sendMessage(PREFIX + "§c§lDer Array wurde geleert");
                    }
                } else { player.sendMessage(NoPerms); }

                //the code for the '/dup save' to save the array in a file ( ==!not ready yet!== )
                if (strings[0].equalsIgnoreCase("save")) {
                    if (player.hasPermission("ausrasten.dup.savetofile")) {
                        String SaveFileMe = duplist.toString();
                        player.sendMessage(PREFIX + "Der Array wurde in einer Datei gesichert!" + SaveFileMe);
                    }
                }

            } else {
                player.sendMessage(NoPerms);
            }

        }

        return false;
    }
}
