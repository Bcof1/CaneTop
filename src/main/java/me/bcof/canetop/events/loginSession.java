package me.bcof.canetop.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import me.bcof.canetop.dataManager.caneDataController;
import org.bukkit.event.player.PlayerQuitEvent;

public class loginSession implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        caneDataController caneDataController = new caneDataController();
        caneDataController.getData(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        // no clue if we need this yet

    }
}
