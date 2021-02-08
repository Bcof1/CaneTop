package me.bcof.canetop.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import me.bcof.canetop.dataManager.CaneDataController;

public class BlockPlaceEvent implements Listener {

    @EventHandler
    public void onBlockPlace(org.bukkit.event.block.BlockPlaceEvent event){
        if(event.getBlockPlaced().getType() == Material.SUGAR_CANE || event.getBlockPlaced().getType() == Material.SUGAR_CANE_BLOCK){
            CaneDataController caneDataController = new CaneDataController();
            caneDataController.setCaneAmount(event.getPlayer().getUniqueId(), caneDataController.getCaneAmount(event.getPlayer().getUniqueId()) -1);
        }
    }
}
