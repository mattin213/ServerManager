package de.mattin.servermanager;

import de.mattin.servermanager.commands.BauServerCommand;
import de.mattin.servermanager.listener.GUIListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerManager extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("bauserver").setExecutor(new BauServerCommand());

        Bukkit.getPluginManager().registerEvents(new GUIListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
