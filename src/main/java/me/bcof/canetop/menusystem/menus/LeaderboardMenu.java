package me.bcof.canetop.menusystem.menus;

import me.bcof.canetop.menusystem.Menu;
import me.bcof.canetop.menusystem.PlayerMenuUtility;
import org.bukkit.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import me.bcof.canetop.utils.StringUtil;
import me.bcof.canetop.dataManager.CaneDataController;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;


public class LeaderboardMenu extends Menu {

    public LeaderboardMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Cane Top";
    }

    @Override
    public int getSlots() {
        return 36;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {

    }

    @Override
    public void setMenuItems() {
        CaneDataController caneDataController = new CaneDataController();
        HashMap<String, Integer> playerData = caneDataController.sortLeaderboard();
        setFillerGlass();

        int count = 1;

        for (String key : playerData.keySet()){
            if(count != 11){
                OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(key));
                ItemStack playerItem = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                if(playerItem.hasItemMeta()){
                    setItemPositions(playerData, key, player, playerItem, count);
                }else{
                    setItemPositions(playerData, key, player, playerItem, count);
                }
                count++;
            }else{
                break;
            }
        }
    }

    private void setItemData(HashMap<String, Integer> playerData, String key, OfflinePlayer player, ItemStack playerItem, String position) {
        SkullMeta itemMeta = (SkullMeta) playerItem.getItemMeta();
        if(itemMeta.getLore() == null){
            List<String> lores = new ArrayList<>();
            lores.add(StringUtil.translateMessage("&2Sugarcane broken: " + "&a&l" + playerData.get(key)));
            itemMeta.setLore(lores);
            itemMeta.setOwner(player.getName());
            itemMeta.setDisplayName(StringUtil.translateMessage("&b&l" + position + "&7 - &c" + player.getName()));
            playerItem.setItemMeta(itemMeta);
        }else{
            List<String> lores = itemMeta.getLore();
            lores.add(StringUtil.translateMessage("&2Sugarcane broken: " + "&a&l" + playerData.get(key)));
            itemMeta.setLore(lores);
            itemMeta.setOwner(player.getName());
            itemMeta.setDisplayName(StringUtil.translateMessage("&b&l" + position + "&7 - &c" + player.getName()));
            playerItem.setItemMeta(itemMeta);
        }
    }

    private void setItemPositions(HashMap<String, Integer> playerData, String key, OfflinePlayer player, ItemStack playerItem, int count){
        if(count == 1){
            setItemData(playerData, key, player, playerItem, "1st");
            inventory.setItem(4, playerItem);
        }

        if(count == 2){
            setItemData(playerData, key, player, playerItem, "2nd");
            inventory.setItem(12, playerItem);
        }

        if(count == 3){
            setItemData(playerData, key, player, playerItem, "3rd");
            inventory.setItem(14, playerItem);
        }

        if(count == 4){
            setItemData(playerData, key, player, playerItem, "4th");
            inventory.setItem(20, playerItem);
        }

        if(count == 5){
            setItemData(playerData, key, player, playerItem, "5th");
            inventory.setItem(22, playerItem);
        }

        if(count == 6){
            setItemData(playerData, key, player, playerItem, "6th");
            inventory.setItem(24, playerItem);
        }

        if(count == 7){
            setItemData(playerData, key, player, playerItem, "7th");
            inventory.setItem(28, playerItem);
        }

        if(count == 8){
            setItemData(playerData, key, player, playerItem, "8th");
            inventory.setItem(30, playerItem);
        }

        if(count == 9){
            setItemData(playerData, key, player, playerItem, "9th");
            inventory.setItem(32, playerItem);
        }

        if(count == 10){
            setItemData(playerData, key, player, playerItem, "10th");
            inventory.setItem(34, playerItem);
        }

    }

}
