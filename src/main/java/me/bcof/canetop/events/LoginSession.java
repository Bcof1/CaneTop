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
        caneDataController.getData(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        // no clue if we need this yet

    }
}
