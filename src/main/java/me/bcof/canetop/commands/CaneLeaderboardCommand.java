package me.bcof.canetop.commands;

import me.bcof.canetop.CaneTop;
import me.bcof.canetop.dataManager.CaneDataController;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.bcof.canetop.menusystem.menus.LeaderboardMenu;

import java.util.HashMap;
import java.util.UUID;

public class CaneLeaderboardCommand implements CommandExecutor {
    /*
    /canetop opens up gui
    /cane reset <player>
    /cane set <player> <number>
    /
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            new LeaderboardMenu(CaneTop.getPlayerMenuUtility(player)).open();
        }else{
            CaneDataController caneDataController = new CaneDataController();
            HashMap<String, Long> values = caneDataController.sortLeaderboard();
            int count = 1;
            System.out.println("CANE TOP LEADERBOARD");
            for (String value : values.keySet()){
                if(count >= 10){
                    break;
                }else{
                    OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(value));

                    System.out.println(count + " - " + player.getName() + ": " + values.get(value));
                    count++;

                }

            }
        }
        return false;
    }
}
