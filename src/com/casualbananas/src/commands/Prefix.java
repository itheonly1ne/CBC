package com.casualbananas.src.commands;

import org.bukkit.entity.Player;

public class Prefix extends CommandBase {
	// prefix <group> <color> <prefix>
	public Prefix(Player player, String[] args) {
		super(player, args);

		if (player.hasPermission(permissions.prefix)) {
			if (args.length == 3) {
				String group = args[0];
				String ca = args[1];
				String fix = args[2];
				server.dispatchCommand(server.getConsoleSender(), ("pex group " + group + " prefix " + ca + "[" + fix + "]" + W).replace('&', '§'));

				player.sendMessage(G + "Prefix Added");
			} else {
				player.sendMessage(usage("prefix <group> <color> <prefix>"));
			}
		}
	}
}
