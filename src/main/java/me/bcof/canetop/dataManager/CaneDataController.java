package me.bcof.canetop.dataManager;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

public class CaneDataController {
    private FileConfiguration file = ConfigHandler.getCaneConfig();
    private ConfigHandler configHandler;



    public void createData(UUID uuid, long cane) {
        if (file.getConfigurationSection(uuid.toString()) == null) {
            file.createSection(uuid.toString());
            ConfigurationSection section = file.getConfigurationSection(uuid.toString());
            section.set("cane-number", cane);
            ConfigHandler.saveCaneConfig();
        }
    }

    public long getCaneAmount(UUID uuid) {
        if (file.getConfigurationSection(uuid.toString()) != null) {
            ConfigurationSection section = file.getConfigurationSection(uuid.toString());
            return section.getLong("cane-number");
        }
        return 0;
    }


    public void setCaneAmount(UUID uuid, long number) {
        if (file.getConfigurationSection(uuid.toString()) != null) {
            ConfigurationSection section = file.getConfigurationSection(uuid.toString());
            section.set("cane-number", number);
            ConfigHandler.saveCaneConfig();
            ConfigHandler.reloadCaneConfig();
        }
    }

    public void getUser(UUID uuid){
        if(file.getConfigurationSection(uuid.toString()) == null){
            createData(uuid, 0);
        }
    }

    public boolean doesUserExist(UUID uuid){
        return file.getConfigurationSection(uuid.toString()) == null;
    }

    public HashMap<String, Long> sortLeaderboard(){
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

