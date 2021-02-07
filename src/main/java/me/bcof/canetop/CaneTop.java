package me.bcof.canetop;

import me.bcof.canetop.commands.caneAdminCommand;
import me.bcof.canetop.commands.caneLeaderboardCommand;
import me.bcof.canetop.events.loginSession;
import org.bukkit.plugin.java.JavaPlugin;
import me.bcof.canetop.dataManager.configHandler;

public final class CaneTop extends JavaPlugin {
    private configHandler configManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("canetop").setExecutor(new caneLeaderboardCommand());
        getCommand("cane").setExecutor(new caneAdminCommand());

        getServer().getPluginManager().registerEvents(new loginSession(), this);
        loadConfigHandler();
        System.out.println(" ");
        System.out.println("Loaded commands, events and config");
        System.out.println(" ");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadConfigHandler(){
        configManager = new configHandler();
        configManager.setup();
        configManager.saveCaneConfig();
        configManager.reloadCaneConfig();

    }
}
