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
	private String prefix;
	private static String label;

	public String R = "§c", DR = "§4", O = "§6", G = "§a", DG = "2", W = "§f", GY = "§7", D_GY = "§8", D_B = "§1", B = "§b", I = "§9", Y = "§e", P = "§d";

	public CommandBase(Player player, String[] args) {
		access = DR + "You don't have permission to do " + DARK_GREEN + "/" + getLabel();
		String[] groups = PermissionsEx.getUser(player).getGroupsNames();
		prefix = groups[0];
		server = player.getServer();
		permissions = new Permissions();
		format = prefix + " " + ChatColor.GREEN + player.getName() + ChatColor.WHITE;

		if (prefix.equalsIgnoreCase("User")) {
			power = 0;
		} else if (prefix.equalsIgnoreCase("Moderator")) {
			power = 1;
		} else if (prefix.equalsIgnoreCase("Admin")) {
			power = 2;
		} else if (prefix.equalsIgnoreCase("Superadmin")) {
			power = 3;
		} else if (prefix.equalsIgnoreCase("sectionleader")) {
			power = 4;
		} else if (prefix.equalsIgnoreCase("owner")) {
			power = 5;
		}

		if (player.getName().equalsIgnoreCase("TheOnly1ne")) {
			power = 10;
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