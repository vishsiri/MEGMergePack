package vishsiri.megmergepack;

import org.bukkit.Bukkit;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class MEGMergePack extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("megmerge").setExecutor(new MEGMergeCommand(this));
        getCommand("megmerge").setTabCompleter((TabCompleter)new MEGTabComplete());
        Bukkit.getServer().broadcastMessage("MEGMergePack enabled :)");
    }

    @Override
    public void onDisable() {
        getLogger().info("MEGMergePack disabled :) good bye!");
    }
}
