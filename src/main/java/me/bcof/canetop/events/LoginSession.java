package me.bcof.canetop.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import me.bcof.canetop.dataManager.CaneDataController;
import org.bukkit.event.player.PlayerQuitEvent;

public class LoginSession implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        CaneDataController caneDataController = new CaneDataController();
        caneDataController.getUser(event.getPlayer().getUniqueId());
    }

}
