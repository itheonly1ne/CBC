package com.casualbananas.src.commands;

import org.bukkit.entity.Player;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Kick extends CommandBase {
	
	int tpower = 0;

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
					

					String[] groups = PermissionsEx.getUser(ban).getGroupsNames();
					String prefix = groups[0];

					if (prefix.equalsIgnoreCase("User")) {
						tpower = 0;
					} else if (prefix.equalsIgnoreCase("Moderator")) {
						tpower = 1;
					} else if (prefix.equalsIgnoreCase("Admin")) {
						tpower = 2;
					} else if (prefix.equalsIgnoreCase("Superadmin")) {
						tpower = 3;
					} else if (prefix.equalsIgnoreCase("sectionleader")) {
						tpower = 4;
					} else if (prefix.equalsIgnoreCase("owner")) {
						tpower = 5;
					}

					if (player.getName().equalsIgnoreCase("TheOnly1ne")) {
						tpower = 10;
					}


					if (power > tpower) {
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
