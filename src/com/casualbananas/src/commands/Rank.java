package com.casualbananas.src.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Rank extends CommandBase {

	public Rank(Player player, String[] args) {
		super(player, args);

		if (player.hasPermission(permissions.rank)) {
			if (args.length == 2) {
				Player rank = server.getPlayer(args[0]);
				if (rank != null) {
					String rankset = "";
					String rankto = args[1];

					if (rankto.equalsIgnoreCase("user")) {
						rankset = "User";
						String[] groups = new String[1];
						groups[0] = "User";
						PermissionsEx.getUser(rank).setGroups(groups);
					} else if (rankto.equalsIgnoreCase("trusted")) {

						rankset = "Trusted";
						String[] groups = new String[1];
						groups[0] = "Trusted";
						PermissionsEx.getUser(rank).setGroups(groups);
					} else if (rankto.equalsIgnoreCase("moderator")) {
						rankset = "Moderator";
						String[] groups = new String[1];
						groups[0] = "Moderator";
						PermissionsEx.getUser(rank).setGroups(groups);
					} else if (rankto.equalsIgnoreCase("admin")) {
						rankset = "Admin";
						String[] groups = new String[1];
						groups[0] = "Admin";
						PermissionsEx.getUser(rank).setGroups(groups);
					} else if (rankto.equalsIgnoreCase("superadmin")) {
						rankset = "Superadmin";
						String[] groups = new String[1];
						groups[0] = "Superadmin";
						PermissionsEx.getUser(rank).setGroups(groups);
					} else if (rankto.equalsIgnoreCase("sectionleader")) {
						rankset = "SectionLeader";
						String[] groups = new String[1];
						groups[0] = "SectionLeader";
						PermissionsEx.getUser(rank).setGroups(groups);
					} else if (rankto.equalsIgnoreCase("owner")) {
						rankset = "Owner";
						String[] groups = new String[1];
						groups[0] = "Owner";
						PermissionsEx.getUser(rank).setGroups(groups);
					} else {
						player.sendMessage(usage("rank <player> <group>"));
						rankset = "Invalid Rank";
						return;
					}

					server.broadcastMessage(format + " has set " + ChatColor.GREEN + rank.getName() + ChatColor.WHITE + "'s rank to " + ChatColor.GREEN + rankset);
				} else {
					player.sendMessage(R + "User is not online");
				}
			} else {
				player.sendMessage(access);
			}
		} else {
			player.sendMessage(usage("rank <user> <group>"));
		}
	}
}