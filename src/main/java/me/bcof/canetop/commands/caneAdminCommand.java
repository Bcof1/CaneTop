package me.bcof.canetop.commands;

import me.bcof.canetop.utils.stringUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.bcof.canetop.dataManager.caneDataController;

public class caneAdminCommand implements CommandExecutor {
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
                player.sendMessage(stringUtil.translateMessage("&c&l/canetop &7 - Opens up the canetop gui"));
                player.sendMessage(stringUtil.translateMessage("&c&l/cane reset <player> &7 - Resets a player's cane counter"));
                player.sendMessage(stringUtil.translateMessage("&c&l/cane set <player> <number> &7 - Sets a player's counter to the specified number"));
                player.sendMessage(stringUtil.translateMessage("&c&l/cane <player> &7 - Shows the player's counter in chat"));
            }
            if(player.hasPermission("canetop.admin")){
                if(args.length == 2) {
                    String option = args[0];
                    String playerIGN = args[1];

                    if (option.equalsIgnoreCase("reset")) {
                        Player target = Bukkit.getPlayer(playerIGN);
                        if (target == null) {
                            player.sendMessage(stringUtil.translateMessage("&c&lPlayer is not found"));
                        } else {
                            caneDataController caneDataController = new caneDataController();
                            caneDataController.setCaneAmount(target.getUniqueId(), 0);
                            player.sendMessage(stringUtil.translateMessage("&a" + target.getDisplayName() + "'s cane amount has been reset"));
                        }
                    }

                }

                if(args.length == 3){
                    String option = args[0];
                    String playerIGN = args[1];
                    int amount = Integer.parseInt(args[2]);
                    caneDataController caneDataController = new caneDataController();

                    if(option.equalsIgnoreCase("set")){
                        Player target = Bukkit.getPlayer(playerIGN);
                        if (target == null) {
                            player.sendMessage(stringUtil.translateMessage("&c&lPlayer is not found"));
                        } else {
                            caneDataController.setCaneAmount(target.getUniqueId(), amount);
                            player.sendMessage(stringUtil.translateMessage("&a" + target.getDisplayName() + "&7's has been set to &2&l" + args[2]));
                        }

                    }

                }

                if(args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    caneDataController caneDataController = new caneDataController();
                    if (target == null) {
                        player.sendMessage(stringUtil.translateMessage("&c&lPlayer is not found"));
                    } else {
                        player.sendMessage(stringUtil.translateMessage("&c&l" + target.getDisplayName() + "&7 has mined &a&l" + caneDataController.getCaneAmount(target.getUniqueId())) + "&7sugarcane");
                    }

                }
            }



        }
        return false;
    }
}
