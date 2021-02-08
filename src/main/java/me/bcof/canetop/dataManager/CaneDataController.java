package me.bcof.canetop.dataManager;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

public class CaneDataController {
    private FileConfiguration file;
    private ConfigHandler configHandler;



    public void createData(UUID uuid, long cane) {
        file = configHandler.getCaneConfig();
        if (file.getConfigurationSection(uuid.toString()) == null) {
            file.createSection(uuid.toString());
            ConfigurationSection section = file.getConfigurationSection(uuid.toString());
            section.set("cane-number", cane);
            configHandler.saveCaneConfig();
        }
    }

    public long getCaneAmount(UUID uuid) {
        file = configHandler.getCaneConfig();
        if (file.getConfigurationSection(uuid.toString()) != null) {
            ConfigurationSection section = file.getConfigurationSection(uuid.toString());
            return section.getLong("cane-number");
        }
        return 0;
    }


    public void setCaneAmount(UUID uuid, long number) {
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
            long amount = section.getLong("cane-number");

            configHandler.saveCaneConfig();
        }else{
            createData(uuid, 0);
        }
    }

    public boolean doesUserExist(UUID uuid){
        file = configHandler.getCaneConfig();
        if(file.getConfigurationSection(uuid.toString()) == null){
            return false;
        }else{
            return true;
        }
    }

    public HashMap<String, Long> sortLeaderboard(){
        file = configHandler.getCaneConfig();
        HashMap<String, Long> values = new HashMap<>();

        for (String player : file.getKeys(false)){
            ConfigurationSection section = file.getConfigurationSection(player);
            long amount = section.getLong("cane-number");
            values.put(player, amount);
        }

        HashMap<String, Long> sortedHashMap = new LinkedHashMap<>();

        values.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> sortedHashMap.put(k.getKey(), k.getValue()));


        return sortedHashMap;
    }
}

