package me.bcof.canetop.menusystem.menus;

import me.bcof.canetop.menusystem.Menu;
import me.bcof.canetop.menusystem.PlayerMenuUtility;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class leaderboardMenu extends Menu {

    public leaderboardMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Cane Top";
    }

    @Override
    public int getSlots() {
        return 27;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {

    }

    @Override
    public void setMenuItems() {

        

    }

}
