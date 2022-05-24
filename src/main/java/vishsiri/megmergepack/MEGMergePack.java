package vishsiri.megmergepack;

import org.bukkit.plugin.java.JavaPlugin;

public final class MEGMergePack extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("megmerge").setExecutor(new MEGMergeCommand(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("MEGMergePack disabled :) good bye!");
    }
}
