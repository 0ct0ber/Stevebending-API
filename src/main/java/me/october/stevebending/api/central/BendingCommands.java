package me.october.stevebending.api.central;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.october.stevebending.api.central.Bending.BendingType;

class BendingCommands implements CommandExecutor {

	private Bending bending;
	private boolean allowSwitching;
	
	BendingCommands(Bending bending, boolean allowSwitching) {
		this.bending = bending;
		this.allowSwitching = allowSwitching;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		BendingType type = null;
		String message = null;
		switch (command.getName().toLowerCase()) {
		case "fire" : {
			type = BendingType.FIRE;
			message = "§cYou are now a firebender...";
			break;
		}
		case "water" : {
			type = BendingType.WATER;
			message = "§cYou are now a waterbender...";
			break;
		}
		case "earth" : {
			type = BendingType.EARTH;
			message = "§cYou are now an earthbender...";
			break;
		}
		case "air" : {
			type = BendingType.AIR;
			message = "§cYou are now an airbender...";
			break;
		}
		}
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command is only usable by players");
			return true;
		}
		
		Player player = (Player)sender;
		
		BendingType current = StevebendingAPI.getBending().getBendingType(player);
		if (!allowSwitching && current != BendingType.NONE) {
			player.sendMessage("§cYou have already chosen an element");
			return true;
		}
		if (type == current) {
			player.sendMessage("§cYou have chosen this element already");
			return true;
		}
		
		bending.setBendingType(player, type);
		player.sendMessage(message);
		
		return true;
	}

}
