/*
 * @author ExceptionAPI (admin@shzmu.xyz)
 *
 * Copyright by ExceptionAPI (admin@shzmu.xyz)
 */

package com.Ausrasten.plugin.Listener;

import com.Ausrasten.plugin.Utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static com.Ausrasten.plugin.Utils.Config.TeamChat;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (event.getMessage().contains("#tc")) {
            if (player.hasPermission("ausrasten.teamchat.send")) {
                String msg = event.getMessage();
                for (Player team : Bukkit.getOnlinePlayers()) {
                    if (team.hasPermission("ausrasten.teamchat.see")) {
                        event.setCancelled(true);
                        team.sendMessage(TeamChat + player.getName() + " §8●" + msg.replaceAll("#tc", "§8"));
                        return;
                    }
                }
            } else {
                event.setCancelled(true);
            }
        }

        if(event.getPlayer().hasPermission("ausrasten.chat.bypass")) {
            event.setFormat("§4Leitung §8| §4" + event.getPlayer().getName() + " §8● §7" + event.getMessage().replace("%", "%%"));
            return;
        }

        event.setCancelled(true);
        event.getPlayer().sendMessage(Config.PREFIX + "Du brauchst einen Rang um in der Lobby zu schreiben!");

    }

}
