package vishsiri.megmergepack;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class MEGMergeCommand implements CommandExecutor {

    private final MEGMergePack main;

    public MEGMergeCommand(MEGMergePack main) {
        this.main = main;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String pluginPrefix = main.getConfig().getString("pluginPrefix");
        if (args.length == 0) {
            sender.sendMessage("§b§lMEGMergePack §7§l> §a/megmergepack reload §7- §fReload the config");
            sender.sendMessage("§b§lMEGMergePack §7§l> §a/megmergepack help §7- §fDisplay this help");
            sender.sendMessage("§b§lMEGMergePack §7§l> §a/megmergepack merge §7- §fMerge folder to ItemAdders");
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            main.reloadConfig();
            sender.sendMessage( pluginPrefix + "§aConfig reloaded! [ VisherRyz ]");
            return true;
        }
        if (args[0].equalsIgnoreCase("merge")) {
            main.reloadConfig();
            File from = new File(Objects.requireNonNull(main.getConfig().getString("ModelEngineAssets")));
            File to = new File(Objects.requireNonNull(main.getConfig().getString("ItemAdderAssets")));
            try {
                copyDir(from.toPath(), to.toPath());
                sender.sendMessage( pluginPrefix + "Complete merging to ItemAdder :) dev VisherRyz");
            } catch (IOException ex) {
                // ex.printStackTrace();
            }
            return true;
        }
        if (args[0].equalsIgnoreCase("help")) {
            sender.sendMessage("§b§lMEGMergePack §7§l> §a/megmergepack reload §7- §fReload the config");
            sender.sendMessage("§b§lMEGMergePack §7§l> §a/megmergepack help §7- §fDisplay this help");
            sender.sendMessage("§b§lMEGMergePack §7§l> §a/megmergepack merge §7- §fMerge folder to ItemAdders");
            return true;
        }
        return false;
    }
    public static void copyDir(Path src, Path dest) throws IOException {
        Files.walk(src)
                .forEach(source -> {
                    try {
                        Files.copy(source, dest.resolve(src.relativize(source)),
                                StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        // e.printStackTrace();
                    }
                });
    }
}
