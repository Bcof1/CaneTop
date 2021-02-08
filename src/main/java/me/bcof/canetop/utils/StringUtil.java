package me.bcof.canetop.utils;

import org.bukkit.ChatColor;

public class StringUtil {
    private String message;

    public static String translateMessage(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
