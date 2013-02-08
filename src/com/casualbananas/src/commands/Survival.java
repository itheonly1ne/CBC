package com.casualbananas.src.commands;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Survival extends CommandBase {

	public Survival(Player player, String[] args) {
		super(player, args);
		
		server.dispatchCommand(server.getConsoleSender(), "mvtp " + player.getName() + " survival");
		
		player.sendMessage("Teleported to " +G +"survival");
		player.setGameMode(GameMode.SURVIVAL);
	}
}
