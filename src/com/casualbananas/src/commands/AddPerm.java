package com.casualbananas.src.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AddPerm extends CommandBase {

	public AddPerm(Player player, String[] args) {
		super(player, args);

		if (player.hasPermission(permissions.addPerm)) {
			if (args.length == 2) {
				server.dispatchCommand(server.getConsoleSender(), "pex group " + args[0] + " add " + args[1]);

				player.sendMessage(ChatColor.GREEN + "Permission added");
			} else {
				player.sendMessage(usage("addperm <group> <node>"));
			}
		}
	}
}
