package de.mattin.servermanager.commands;

import de.mattin.servermanager.gui.BuilderGUI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class BauServerCommand implements CommandExecutor {

    // /bauserver Command (perm: "builder")
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("builder")) {
            Bukkit.getPlayer(sender.getName()).openInventory(new BuilderGUI(Bukkit.getPlayer(sender.getName())).getInventory());
            Bukkit.getPlayer(sender.getName()).playSound(Bukkit.getPlayer(sender.getName()).getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 30, 1);
        }
        else {
            sender.sendMessage("Dafür benötigst du den Builder Rang ;)");
        }
        return false;
    }
}
