package com.casualbananas.src.commands;

import org.bukkit.entity.Player;

public class CBC extends CommandBase {

	public CBC(Player player, String[] args) {
		super(player, args);

		player.sendMessage(Y + "CasualBananas Server Info");
		player.sendMessage("CasualBananas Minecraft Server is a Minecraft server worked on by " + G + "TheOnly1ne, CruelFish, and 404Kitten");
		player.sendMessage("You can find our forums at " + Y + "casualbananas.com");
		player.sendMessage("The CasualBananas Minecraft Plugin is modeled after " + G + "ExclServer, which is the software that the Garry's Mod servers run");
		player.sendMessage("Plugin Made by " + G + "TheOnly1ne");
	}
}
