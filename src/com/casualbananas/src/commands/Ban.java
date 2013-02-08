package com.casualbananas.src.commands;

import org.bukkit.entity.Player;

public class Ban extends CommandBase {

	public Ban(Player player, String[] args) {
		super(player, args);

		if (player.hasPermission(permissions.ban)) {
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
						ban.setBanned(true);
						ban.kickPlayer(reason);
						server.broadcastMessage(format + " has banned " + G + ban.getName() + W + " permanently with reason: " + reason);
					} else {
						server.broadcastMessage(format + " tried to ban " + G + ban.getName());
					}
				} else {
					player.sendMessage(R + "User is not online!");
				}
			} else {
				player.sendMessage(usage("ban <user> [reason]"));
			}
		}
	}
}
