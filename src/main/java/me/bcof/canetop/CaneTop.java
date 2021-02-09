package me.bcof.canetop;

import me.bcof.canetop.commands.CaneAdminCommand;
import me.bcof.canetop.commands.CaneLeaderboardCommand;
import me.bcof.canetop.events.BlockPlaceEvent;
import me.bcof.canetop.events.MenuListener;
import me.bcof.canetop.events.BlockBrokeEvent;
import me.bcof.canetop.events.LoginSession;
import me.bcof.canetop.menusystem.PlayerMenuUtility;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import me.bcof.canetop.dataManager.ConfigHandler;

import java.io.File;
import java.util.HashMap;

public final class CaneTop extends JavaPlugin {
    private ConfigHandler configManager;

    private static final HashMap<Player, PlayerMenuUtility> playerMenuMap = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("canetop").setExecutor(new CaneLeaderboardCommand());
        getCommand("cane").setExecutor(new CaneAdminCommand());

        getServer().getPluginManager().registerEvents(new LoginSession(), this);
        getServer().getPluginManager().registerEvents(new BlockBrokeEvent(), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceEvent(this), this);
        loadConfigHandler();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadConfigHandler() {
        configManager = new ConfigHandler();
        configManager.setup();
        configManager.saveCaneConfig();
        configManager.reloadCaneConfig();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player player) {
        PlayerMenuUtility playerMenuUtility;
        if (!(playerMenuMap.containsKey(player))) {

            playerMenuUtility = new PlayerMenuUtility(player);
            playerMenuMap.put(player, playerMenuUtility);

            return playerMenuUtility;
        } else {
            return playerMenuMap.get(player);
        }
    }


}
