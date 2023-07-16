package org.ghalbeyou.titleplus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class TitlePlus extends JavaPlugin {

    private Map<UUID, BukkitTask> activeTitles;

    @Override
    public void onEnable() {
        activeTitles = new HashMap<>();
    }

    @Override
    public void onDisable() {
        // Stop all active titles when the plugin is disabled
        for (BukkitTask task : activeTitles.values()) {
            task.cancel();
        }
        activeTitles.clear();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("titleplus")) {
            if (args.length >= 3) {
                if (!sender.hasPermission("titleplus.use")) {
                    sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                    return true;
                }
                String title = args[0];
                int duration = Integer.parseInt(args[1]);
                String targetPlayer = args[2];

                Player[] players;
                if (targetPlayer.equals("*")) {
                    players = Bukkit.getOnlinePlayers().toArray(new Player[0]);
                } else {
                    Player player = Bukkit.getPlayer(targetPlayer);
                    if (player == null) {
                        sender.sendMessage(ChatColor.RED + "Player not found!");
                        return true;
                    }
                    players = new Player[]{player};
                }

                // Generate a unique ID for the title
                UUID titleId = UUID.randomUUID();

                for (Player player : players) {
                    player.sendTitle(ChatColor.translateAlternateColorCodes('&', title).replace("-", " "), "", 10, duration * 20, 10);
                }

                sender.sendMessage(ChatColor.GREEN + "Title sent with ID: " + titleId);
            } else {
                sender.sendMessage(ChatColor.RED + "Usage: /titleplus <title> <duration> <player(* for all)>");
            }
            return true;
        } else if (command.getName().equalsIgnoreCase("stoptitle")) {
            if (args.length >= 1) {
                if (!sender.hasPermission("titleplus.stoptitle")) {
                    sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                    return true;
                }
                String titleId = args[0];

                if (titleId.equals("*")) {
                    // Stop all active titles
                    for (BukkitTask task : activeTitles.values()) {
                        task.cancel();
                    }
                    activeTitles.clear();
                } else {
                    UUID id;
                    try {
                        id = UUID.fromString(titleId);
                    } catch (IllegalArgumentException e) {
                        sender.sendMessage(ChatColor.RED + "Invalid title ID!");
                        return true;
                    }

                    BukkitTask task = activeTitles.get(id);
                    if (task != null) {
                        task.cancel();
                        activeTitles.remove(id);
                    } else {
                        sender.sendMessage(ChatColor.RED + "Title ID not found!");
                        return true;
                    }
                }

                sender.sendMessage(ChatColor.GREEN + "Title(s) stopped successfully!");
            } else {
                sender.sendMessage(ChatColor.RED + "Usage: /stoptitle <title_id or * for all>");
            }
            return true;
        } else if (command.getName().equalsIgnoreCase("titlereload")) {
            if (!sender.hasPermission("titleplus.reload")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                return true;
            }
            // Add your reload logic here
            sender.sendMessage(ChatColor.GREEN + "Plugin reloaded!");
            return true;
        }
        return false;
    }
}