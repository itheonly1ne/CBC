package com.casualbananas.src.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CreateGroup extends CommandBase {

	public CreateGroup(Player player, String[] args) {
		super(player, args);

		if (player.hasPermission(permissions.createGroup)) {
			if (args.length == 2) {
				String newGroup = args[0];
				String parent = args[1];
				server.dispatchCommand(server.getConsoleSender(), "pex group " + newGroup + " create " + parent);
				server.broadcastMessage(format + " has created group " + ChatColor.GREEN + newGroup);
			} else {
				player.sendMessage(usage("creategroup <group> <parent>"));
			}
		} else {
			player.sendMessage(access);
		}
	}
}
