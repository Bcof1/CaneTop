package me.bcof.canetop.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import me.bcof.canetop.dataManager.CaneDataController;

public class BlockBrokeEvent implements Listener {
    CaneDataController caneDataController;

    // adds up all of the mined sugarcane, even if only the bottom block is physically mined.
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        long sugarcane = 0;

        for (int y = event.getBlock().getY(); y != 255 ; y++) {
            Location sugarCaneAttached = new Location(event.getBlock().getWorld(), event.getBlock().getX(), y, event.getBlock().getZ());
            Material block = sugarCaneAttached.getBlock().getType();
            if(block == Material.SUGAR_CANE_BLOCK){
                sugarcane = sugarcane + 1;
            }else{
                break;
            }
        }
        caneDataController = new CaneDataController();
        caneDataController.setCaneAmount(event.getPlayer().getUniqueId(), caneDataController.getCaneAmount(event.getPlayer().getUniqueId()) + sugarcane);
    }
}
