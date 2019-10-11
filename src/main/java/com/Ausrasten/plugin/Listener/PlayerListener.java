/*
 * @author ExceptionAPI (admin@shzmu.xyz)
 *
 * Copyright by ExceptionAPI (admin@shzmu.xyz)
 */
package com.Ausrasten.plugin.Listener;

import com.Ausrasten.plugin.Utils.Config;
import de.dytanic.cloudnet.api.CloudAPI;
import de.dytanic.cloudnet.bridge.CloudServer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        final Player player = (Player) event.getPlayer();

        event.setJoinMessage(null);
        player.sendMessage(Config.PREFIX + "Du bist nun auf §e" + CloudAPI.getInstance().getOnlinePlayer(player.getUniqueId()).getServer().replace("l", "L"));

        setScoreboard(player.getPlayer());

        CloudServer.getInstance().updateNameTags(player.getPlayer());

        player.setGameMode(GameMode.ADVENTURE);
        player.setFoodLevel(20);
        player.setHealth(20);

        player.setCanPickupItems(false);
        player.setMaxHealth(6);

        Inventory inv = player.getInventory();

        ItemStack itemStack = new ItemStack(Material.COMPASS);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.setDisplayName("§a§lNavigator");
        itemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

        inv.addItem(itemStack);
    }


    @EventHandler
    public void onQuit(final PlayerQuitEvent event) {
        final Player player = (Player) event.getPlayer();

        event.setQuitMessage(null);

    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

    }

    private void setScoreboard(final Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

        final Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective o = scoreboard.registerNewObjective("aaa", "bbb");

        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName("§6§lAUSRASTEN");

        o.getScore("§8").setScore(8);
        o.getScore("§7● §6Server").setScore(7);
        o.getScore("§f" + CloudAPI.getInstance().getOnlinePlayer(player.getUniqueId()).getServer().replace("l", "L")).setScore(6);
        o.getScore("§5").setScore(5);
        o.getScore("§7● §6Spieler").setScore(4);
        o.getScore("§f" + CloudAPI.getInstance().getOnlineCount()).setScore(3);


        player.setScoreboard(scoreboard);
    }


    /*
    *
    * Hey you need to fix this bug!!!!!!!!!!!!!!!!!!!!!!
    * :C
    * */


    public void updateScoreboard(final Player player) {
        if(player.getScoreboard() == null || player.getScoreboard().getObjective(DisplaySlot.SIDEBAR) == null)
            return;

        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

        final Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective o = scoreboard.registerNewObjective("aaa", "bbb");

        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName("§6§lAUSRASTEN");

        o.getScore("§8").setScore(8);
        o.getScore("§7● §6Server").setScore(7);
        o.getScore("§f" + CloudAPI.getInstance().getOnlinePlayer(player.getUniqueId()).getServer().replace("l", "L")).setScore(6);
        o.getScore("§5").setScore(5);
        o.getScore("§7● §6Spieler").setScore(4);
        o.getScore("§f" + CloudAPI.getInstance().getOnlineCount()).setScore(3);


        player.setScoreboard(scoreboard);
    }

}