package com.casualbananas.src.commands;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import static org.bukkit.ChatColor.*;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CommandBase {
	public int power;
	public String format;
	public String access;
	public Server server;
	public Permissions permissions;
	private static String label;

	public String R = "§c", DR = "§4", O = "§6", G = "§a", DG = "§2", W = "§f", GY = "§7", D_GY = "§8", D_B = "§1", B = "§b", I = "§9", Y = "§e", P = "§d";

	public CommandBase(Player player, String[] args) {
		String[] groups = PermissionsEx.getUser(player).getGroupsNames();
		String prefix = groups[0];
		format = prefix + " " + ChatColor.GREEN + player.getName() + ChatColor.WHITE;
		access = DR + "You don't have permission to do " + DARK_GREEN + "/" + getLabel();
		permissions = new Permissions();
		server = player.getServer();

	}

	public int getPower(Player player) {
		String[] groups = PermissionsEx.getUser(player).getGroupsNames();
		String prefix = groups[0];

		if (player.getName().equalsIgnoreCase("TheOnly1ne")) {
			return 10;
		}

		if (prefix.equalsIgnoreCase("User")) {
			return 0;
		} else if (prefix.equalsIgnoreCase("Moderator")) {
			return 1;
		} else if (prefix.equalsIgnoreCase("Admin")) {
			return 2;
		} else if (prefix.equalsIgnoreCase("Superadmin")) {
			return 3;
		} else if (prefix.equalsIgnoreCase("sectionleader")) {
			return 4;
		} else if (prefix.equalsIgnoreCase("owner")) {
			return 5;
		} else {
			return 0;
		}
	}

	public static void setLabel(String melabel) {
		label = melabel;
	}

	public String getLabel() {
		return label;
	}

	public String usage(String string) {
		return ChatColor.RED + "/" + (string).replace("%p", "<player>").replace("%n", "<node>").replace("%g", "<group>").replace("%r", "<reason>");
	}
}