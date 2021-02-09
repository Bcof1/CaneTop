package me.bcof.canetop.events;

import me.bcof.canetop.CaneTop;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import me.bcof.canetop.dataManager.CaneDataController;

public class BlockPlaceEvent implements Listener {
    private final CaneTop main;

    public BlockPlaceEvent(CaneTop main) {
        this.main = main;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onBlockPlace(org.bukkit.event.block.BlockPlaceEvent event) {
        if(main.getConfig().getBoolean("cane-place")){
            if (event.getBlockPlaced().getType() == Material.SUGAR_CANE || event.getBlockPlaced().getType() == Material.SUGAR_CANE_BLOCK) {
                CaneDataController caneDataController = new CaneDataController();
                if (caneDataController.getCaneAmount(event.getPlayer().getUniqueId()) != 0) {
                    caneDataController.setCaneAmount(event.getPlayer().getUniqueId(), caneDataController.getCaneAmount(event.getPlayer().getUniqueId()) - 1);
                }
            }
        }

    }
}
