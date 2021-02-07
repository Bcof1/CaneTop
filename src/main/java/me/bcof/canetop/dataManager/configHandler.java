package me.bcof.canetop.dataManager;

import me.bcof.canetop.CaneTop;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class configHandler {
    private static final CaneTop main = CaneTop.getPlugin(CaneTop.class);
    private static FileConfiguration caneConfig;
    private static File caneFile;

    public void setup() {
        if (!main.getDataFolder().exists()) {
            main.getDataFolder().mkdirs();
        }
        caneFile = new File(main.getDataFolder(), "caneData.yml");

        if (!caneFile.exists()) {
            try {
                caneFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        caneConfig = YamlConfiguration.loadConfiguration(caneFile);
    }

    public static FileConfiguration getCaneConfig() {
        return caneConfig;
    }

    public static void saveCaneConfig(){
        try{
            caneConfig.save(caneFile);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void reloadCaneConfig(){
        caneConfig = YamlConfiguration.loadConfiguration(caneFile);
    }
}
