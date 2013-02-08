package com.casualbananas.src.commands;

import org.bukkit.entity.Player;

public class Sudo extends CommandBase {
	public Sudo(Player player, String[] args) {
		super(player, args);

		if (player.hasPermission("cbc.sudo")) {
			if (args.length > 1) {
				Player sender = server.getPlayer(args[0]);
				if (sender != null) {
					String command = "";

					for (int i = 1; i < args.length; i++) {
						if (args.equals("")) {
							command = args[i];
						} else {
							command = command + " " + args[i];
						}
					}
					
					server.dispatchCommand(sender, command);
				} else {
					player.sendMessage(usage("sudo <player> <command> [args]"));
				}
			} else {
				player.sendMessage(usage("sudo <player> <command> [args]"));
			}
		} else {
			player.sendMessage(access);
		}
	}
}
