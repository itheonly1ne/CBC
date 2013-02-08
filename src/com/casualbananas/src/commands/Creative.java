package com.casualbananas.src.commands;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Creative extends CommandBase {
	public Creative(Player player, String[] args) {
		super(player, args);

		if (player.hasPermission(permissions.creative)) {
			server.dispatchCommand(server.getConsoleSender(), "mvtp " + player.getName() + " creative");
			player.setGameMode(GameMode.CREATIVE);
			player.sendMessage("Teleported to" + G + " creative");
		}
	}
}
