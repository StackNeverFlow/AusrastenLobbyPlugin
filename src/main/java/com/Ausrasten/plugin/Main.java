/*
 * @author ExceptionAPI (admin@shzmu.xyz)
 *
 * Copyright by ExceptionAPI (admin@shzmu.xyz)
 */
package com.Ausrasten.plugin;

import com.Ausrasten.plugin.Commands.DupCMD;
import com.Ausrasten.plugin.Commands.FlyCMD;
import com.Ausrasten.plugin.Commands.GameModeCMD;
import com.Ausrasten.plugin.Commands.VanishCMD;
import com.Ausrasten.plugin.Events.FirstPlayEvent;
import com.Ausrasten.plugin.Listener.JumpPadListener;
import com.Ausrasten.plugin.Listener.PlayerChatListener;
import com.Ausrasten.plugin.Listener.PlayerListener;
import de.dytanic.cloudnet.bridge.CloudServer;
import me.lucko.luckperms.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    //Yaml config not use yet
    public File file = new File("plugins//Ausrasten//config.yml");
    public YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

    @Override
    public void onEnable() {

        //Listener & Event register
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerListener(), this);
        pluginManager.registerEvents(new PlayerChatListener(), this);
        pluginManager.registerEvents(new JumpPadListener(), this);
        pluginManager.registerEvents(new FirstPlayEvent(), this);


        // Command register
        getCommand("gm").setExecutor(new GameModeCMD());
        getCommand("fly").setExecutor(new FlyCMD());
        getCommand("vanish").setExecutor(new VanishCMD());
        getCommand("dup").setExecutor(new DupCMD());


        // For update the nametags, scoreboard and the world
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (Player all : Bukkit.getOnlinePlayers()) {
                new PlayerListener().updateScoreboard(all);
                CloudServer.getInstance().updateNameTags(all);
            }

            Bukkit.getWorld("Lobby").setDifficulty(Difficulty.PEACEFUL);
            Bukkit.getWorld("Lobby").setTime(1200);
            Bukkit.getWorld("Lobby").setStorm(false);
            Bukkit.getWorld("Lobby").setPVP(false);
        }, 0, 20);

        System.out.println("Loaded");

    }

    @Override
    public void onDisable() {
        System.out.println("Unloaded");
    }
}
