package com.casualbananas.src.commands;

import org.bukkit.entity.Player;

public class Kick extends CommandBase {

	public Kick(Player player, String[] args) {
		super(player, args);

		if (player.hasPermission(permissions.kick)) {
			if (args.length >= 2) {
				Player ban = server.getPlayer(args[0]);
				if (ban != null) {
					String reason = "";

					for (int i = 1; i < args.length; i++) {
						if (reason.equals("")) {
							reason = args[i];
						} else {
							reason = reason + " " + args[i];
						}
					}

					if (getPower(player) > getPower(ban)) {
						ban.kickPlayer(reason);
						server.broadcastMessage(format + " has kicked " + G + ban.getName() + W + " with reason: " + reason);
					} else {
						server.broadcastMessage(format + " tried to kick " + G + ban.getName());
					}
				} else {
					player.sendMessage(R + "User is not online!");
				}
			} else {
				player.sendMessage(usage("kick <user> <reason>"));
			}
		}
	}
}
