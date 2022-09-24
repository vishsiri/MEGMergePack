package vishsiri.megmergepack;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class MEGTabComplete implements TabCompleter {

    List<String> arguments;
    public MEGTabComplete() {
        this.arguments = List.of("reload", "help", "merge");
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        final List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase())) {
                    completions.add(a);
                }
            }
            return completions;
        }
        return null;
    }
}
