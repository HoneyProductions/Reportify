package me.goodbee.reportify;

import org.bukkit.plugin.java.JavaPlugin;

public final class Reportify extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("report").setExecutor(new ReportCommand());
        getCommand("z-respondreport").setExecutor(new RespondCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
