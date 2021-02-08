package me.bcof.canetop.dataManager;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

public class CaneDataController {
    FileConfiguration file;
    ConfigHandler configHandler;
    private HashMap<UUID, Integer> playerDataCache = new HashMap<>();


    public void createData(UUID uuid, int cane) {
        file = configHandler.getCaneConfig();
        if (file.getConfigurationSection(uuid.toString()) == null) {
            file.createSection(uuid.toString());
            ConfigurationSection section = file.getConfigurationSection(uuid.toString());
            section.set("cane-number", cane);
            configHandler.saveCaneConfig();
        }
    }

    public int getCaneAmount(UUID uuid) {
        file = configHandler.getCaneConfig();
        if (file.getConfigurationSection(uuid.toString()) != null) {
            ConfigurationSection section = file.getConfigurationSection(uuid.toString());
            return section.getInt("cane-number");
        }
        return 0;
    }


    public void setCaneAmount(UUID uuid, int number) {
        file = configHandler.getCaneConfig();
        if (file.getConfigurationSection(uuid.toString()) != null) {
            ConfigurationSection section = file.getConfigurationSection(uuid.toString());
            section.set("cane-number", number);
            configHandler.saveCaneConfig();
            configHandler.reloadCaneConfig();
        }
    }

    public void getData(UUID uuid){
        file = configHandler.getCaneConfig();
        if (file.getConfigurationSection(uuid.toString()) != null) {
            ConfigurationSection section = file.getConfigurationSection(uuid.toString());
            int amount = section.getInt("cane-number");
            playerDataCache.put(uuid, amount);
            configHandler.saveCaneConfig();
        }else{
            createData(uuid, 0);
        }

    }

    public HashMap<String, Integer> sortLeaderboard(){
        file = configHandler.getCaneConfig();
        HashMap<String, Integer> values = new HashMap<>();

        for (String player : file.getKeys(false)){
            ConfigurationSection section = file.getConfigurationSection(player);
            int amount = section.getInt("cane-number");
            values.put(player, amount);
        }

        HashMap<String, Integer> sortedHashMap = new LinkedHashMap<>();


        values.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> sortedHashMap.put(k.getKey(), k.getValue()));


        System.out.println(sortedHashMap);
        
        return sortedHashMap;
    }
}

