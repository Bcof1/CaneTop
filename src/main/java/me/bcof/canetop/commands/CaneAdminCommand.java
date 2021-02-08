package me.bcof.canetop.commands;

import me.bcof.canetop.utils.StringUtil;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.bcof.canetop.dataManager.CaneDataController;

public class CaneAdminCommand implements CommandExecutor {
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

            if(args.length == 0){
                CaneDataController caneDataController = new CaneDataController();
                player.sendMessage(StringUtil.translateMessage("&c&l" + "You" + "&7 have mined &a&l" + caneDataController.getCaneAmount(player.getUniqueId()) + " &7sugarcane"));

            }
            if(player.hasPermission("canetop.admin")){
                if(args.length == 2) {
                    String option = args[0];
                    String playerIGN = args[1];
                    CaneDataController caneDataController = new CaneDataController();

                    if (option.equalsIgnoreCase("reset")) {
                        OfflinePlayer target = Bukkit.getOfflinePlayer(playerIGN);
                        if (!caneDataController.doesUserExist(target.getUniqueId())) {
                            player.sendMessage(StringUtil.translateMessage("&c&lPlayer is not found"));
                        } else {
                            caneDataController.setCaneAmount(target.getUniqueId(), 0);
                            player.sendMessage(StringUtil.translateMessage("&a&l" + target.getName() + "&7's cane amount has been reset"));
                        }
                    }

                }

                if(args.length == 3){
                    String option = args[0];
                    String playerIGN = args[1];
                    int amount = Integer.parseInt(args[2]);
                    CaneDataController caneDataController = new CaneDataController();

                    if(option.equalsIgnoreCase("set")){
                        OfflinePlayer target = Bukkit.getOfflinePlayer(playerIGN);
                        if (!caneDataController.doesUserExist(target.getUniqueId())) {
                            player.sendMessage(StringUtil.translateMessage("&c&lPlayer is not found"));
                        } else {
                            caneDataController.setCaneAmount(target.getUniqueId(), amount);
                            player.sendMessage(StringUtil.translateMessage("&a" + target.getName() + "&7's sugarcane has been set to &2&l" + amount));
                        }
                    }
                }

                if(args.length == 1){
                    String option = args[0];
                    if(option.equalsIgnoreCase("help")){
                        player.sendMessage(StringUtil.translateMessage("&c&l/canetop &7 - Opens up the canetop gui"));
                        player.sendMessage(StringUtil.translateMessage("&c&l/cane reset <player> &7 - Resets a player's cane counter"));
                        player.sendMessage(StringUtil.translateMessage("&c&l/cane set <player> <number> &7 - Sets a player's counter to the specified number"));
                        player.sendMessage(StringUtil.translateMessage("&c&l/cane <player> &7 - Shows the player's counter in chat"));
                    }else{
                        OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
                        CaneDataController caneDataController = new CaneDataController();
                        if (!caneDataController.doesUserExist(target.getUniqueId())) {
                            player.sendMessage(StringUtil.translateMessage("&c&lPlayer does not exist"));
                        } else {
                            player.sendMessage(StringUtil.translateMessage("&c&l" + target.getName() + "&7 has mined &a&l" + caneDataController.getCaneAmount(target.getUniqueId()) + " &7sugarcane"));
                        }

                    }

                }
            }
        }
        return false;
    }
}
