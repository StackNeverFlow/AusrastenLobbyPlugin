/*
 * @author ExceptionAPI (admin@shzmu.xyz)
 *
 * Copyright by ExceptionAPI (admin@shzmu.xyz)
 */
package com.Ausrasten.plugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static com.Ausrasten.plugin.Utils.Config.NoPerms;
import static com.Ausrasten.plugin.Utils.Config.PREFIX;

public class FlyCMD implements CommandExecutor {
    ArrayList<Player>list = new ArrayList<Player>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (command.getName().equalsIgnoreCase("fly")) {
            Player player = (Player) commandSender;

            if (player.hasPermission("ausrasten.fly")) {
                if (list.contains(player)) {
                    list.remove(player);
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.sendMessage(PREFIX + "Du kannst nun nicht mehr fliegen");
                } else {
                    list.add(player);
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.sendMessage(PREFIX + "Du kannst nun fliegen");
                }
            } else { player.sendMessage(NoPerms); }
        }


        return false;
    }
}
