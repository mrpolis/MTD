package main.java.net.teepee.MTD.Commands;

import main.java.net.teepee.MTD.Automation.Game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class End implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		Game g = Game.getGame((Player) sender);
		if (g == null) {
			Msg.send(sender, "error.not_in_game");
			return true;
		}
		if (g.hasStarted())
			g.stop(true);
		return true;
	}

}
