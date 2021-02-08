package me.bcof.canetop.commands;

import me.bcof.canetop.CaneTop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.bcof.canetop.menusystem.menus.LeaderboardMenu;

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
        }
        return false;
    }
}
