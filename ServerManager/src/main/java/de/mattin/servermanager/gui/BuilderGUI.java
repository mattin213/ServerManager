package de.mattin.servermanager.gui;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.service.ServiceInfoSnapshot;
import de.dytanic.cloudnet.driver.service.ServiceLifeCycle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class BuilderGUI {

    Inventory inv;

    public BuilderGUI(Player player) {
        this.inv = Bukkit.createInventory(player, 9, ChatColor.BLUE+"BauServer managen");
        Integer i = 2;
        Integer j = 1;
        for (ServiceInfoSnapshot server : CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServices("BauServer")) {
            ItemStack item = null;
            // Check if Server is running
            if (server.isConnected()&&server.getLifeCycle()==ServiceLifeCycle.RUNNING) {
                item.setType(Material.GOLD_BLOCK);
                item.getItemMeta().setDisplayName("Server #"+j+" Online");
            }
            else {item.setType(Material.REDSTONE_BLOCK); item.getItemMeta().setDisplayName("Server #"+j+" Online");}
            //Set Lore
            String onlineTime = "Läuft seit: " + server.getConnectedTime();
            String serverName = "Name: " + server.getName();
            String[] lore = {onlineTime, serverName};
            item.getItemMeta().setLore(Arrays.asList(lore));

            this.inv.setItem(i, item);
            j++;
            i = i+2;
        }
    }

    public Inventory getInventory() {
        return this.inv;
    }
}
