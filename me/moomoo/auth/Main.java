package me.moomoo.auth;

import javafx.application.Application;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getScheduler().runTaskTimer(this, () -> Bukkit.getWorlds().forEach(b -> b.getPlayers().forEach(e -> {
            e.teleport(new Location(Bukkit.getServer().getWorld("world_the_end"),0,120,0));
            e.setGameMode(GameMode.SPECTATOR);
        })), 0L, 20L);
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent evt){
        evt.setCancelled(true);
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent evt){
        evt.setJoinMessage("");
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent evt){
        evt.setQuitMessage("");
        evt.getPlayer().teleport(new Location(Bukkit.getServer().getWorld("world_the_end"),0,120,0));
    }
}
