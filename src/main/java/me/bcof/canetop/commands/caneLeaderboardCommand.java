package me.bcof.canetop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.bcof.canetop.utils.stringUtil;
import me.bcof.canetop.dataManager.caneDataController;

public class caneLeaderboardCommand implements CommandExecutor {
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
            caneDataController caneDataController = new caneDataController();
            caneDataController.sortLeaderboard();
            player.sendMessage("sent debug to console");
        }
        return false;
    }
}
