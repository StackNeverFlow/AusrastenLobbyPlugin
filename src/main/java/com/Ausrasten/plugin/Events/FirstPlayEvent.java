package com.Ausrasten.plugin.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.Ausrasten.plugin.Utils.Config.PREFIX;

public class FirstPlayEvent implements Listener {

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent joinEvent) {
        Player player = joinEvent.getPlayer();

        if (!player.hasPlayedBefore()) {
            player.sendMessage("");
            player.sendMessage("");
            player.sendMessage(PREFIX + "Willkommen aus §a§lAusrasten.org§7!");
            player.sendMessage("");
            player.sendMessage("");
        }
    }

}