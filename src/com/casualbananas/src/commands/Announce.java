package com.casualbananas.src.commands;

import org.bukkit.entity.Player;

public class Announce extends CommandBase {

	public Announce(Player player, String[] args) {
		super(player, args);
		if (player.hasPermission(permissions.announce)) {
			if (args.length > 0) {
				String msg = null;
				for (int i = 0; i < args.length; i++) {
					if (msg == null) {
						msg = args[i];
					} else {
						msg = msg + " " + args[i];
					}
				}

				if (msg.equals(null) || msg.equalsIgnoreCase("null")) {

				} else {
					server.broadcastMessage("(ANNOUNCEMENT) " + format + ": " + msg);
				}
			}
		} else {
			player.sendMessage(access);
		}
	}
}
