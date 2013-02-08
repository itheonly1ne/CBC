package com.casualbananas.src.commands;

import org.bukkit.entity.Player;

public class Suffix extends CommandBase {

	public Suffix(Player player, String[] args) {
		super(player, args);

		if (player.hasPermission(permissions.suffix)) {
			Player suffix = server.getPlayer(args[0]);
			server.dispatchCommand(server.getConsoleSender(), "pex user " + suffix.getName() + " suffix " + "(" + G + args[1] + W + ")");
			server.broadcastMessage(format + " has set " + G + suffix.getName() + W + "'s suffix to " + G + args[1]);
		} else {
			player.sendMessage(access);
		}
	}
}
