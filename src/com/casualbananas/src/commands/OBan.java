package com.casualbananas.src.commands;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class OBan extends CommandBase {

	int tpower = 0;

	public OBan(Player player, String[] args) {
		super(player, args);

		if (player.hasPermission(permissions.ban)) {
			if (args.length >= 2) {
				OfflinePlayer ban = server.getOfflinePlayer(args[0]);
				if (ban != null) {
					String reason = "";

					for (int i = 1; i < args.length; i++) {
						if (reason.equals("")) {
							reason = args[i];
						} else {
							reason = reason + " " + args[i];
						}
					}

					ban.setBanned(true);
					server.broadcastMessage(format + " has banned " + G + ban.getName() + W + " permanently with reason: " + reason);
				} else {
					player.sendMessage(R + "User is not online!");
				}
			} else {
				player.sendMessage(usage("ban <user> [reason]"));
			}
		}
	}
}
