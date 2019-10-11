/*
 * @author ExceptionAPI (admin@shzmu.xyz)
 *
 * Copyright by ExceptionAPI (admin@shzmu.xyz)
 */
package com.Ausrasten.plugin.Listener;

import com.Ausrasten.plugin.Utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInventoryClickEvent implements Listener {

    public void onClick(PlayerInteractEvent event, InventoryClickEvent invclick) {
        final Player player = event.getPlayer();

        if (player.getItemInHand().getType() == Material.COMPASS) {
            Inventory inventory = Bukkit.createInventory(null, 9 * 3);

            ItemStack itemStack = new ItemStack(Material.MAGMA_CREAM);
            ItemMeta itemMeta = itemStack.getItemMeta();

            itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.setDisplayName("§8● §a§lSpawn");

            if (invclick.getClickedInventory().contains(Material.MAGMA_CREAM)) {
                player.sendMessage(Config.PREFIX + "Du wurdest zum Spawn teleportiert");
            }
        }
    }

    public void onItemMove(InventoryDragEvent event) { event.setCancelled(true); }

}
