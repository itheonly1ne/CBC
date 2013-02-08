package com.casualbananas.src.commands;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Flatlands extends CommandBase {
	public Flatlands(Player player, String[] args) {
		super(player, args);

		if (player.hasPermission(permissions.creative)) {
			server.dispatchCommand(server.getConsoleSender(), "mvtp " + player.getName() + " flatlands");
			player.setGameMode(GameMode.CREATIVE);
			player.sendMessage("Teleported to" + G + " flatlands");
		}
	}
}
