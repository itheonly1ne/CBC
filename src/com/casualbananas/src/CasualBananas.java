package com.casualbananas.src;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.casualbananas.src.commands.AddPerm;
import com.casualbananas.src.commands.Announce;
import com.casualbananas.src.commands.Ban;
import com.casualbananas.src.commands.CBC;
import com.casualbananas.src.commands.CommandBase;
import com.casualbananas.src.commands.CreateGroup;
import com.casualbananas.src.commands.Creative;
import com.casualbananas.src.commands.Flatlands;
import com.casualbananas.src.commands.Kick;
import com.casualbananas.src.commands.OBan;
import com.casualbananas.src.commands.Rank;
import com.casualbananas.src.commands.Sudo;
import com.casualbananas.src.commands.Suffix;
import com.casualbananas.src.commands.Survival;

public class CasualBananas extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft");
	public PluginDescriptionFile pdf = this.getDescription();
	public static CasualBananas cbc = new CasualBananas();

	@Override
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	public void onDisable() {
		logger.info(pdf.getName() + " has been disabled!");
		saveConfig();
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;

		new CommandBase(player, args);

		if (label.equalsIgnoreCase("announce")) {
			new Announce(player, args);
		} else if (label.equalsIgnoreCase("rank")) {
			new Rank(player, args);
		} else if (label.equalsIgnoreCase("creategroup")) {
			new CreateGroup(player, args);
		} else if (label.equalsIgnoreCase("addperm")) {
			new AddPerm(player, args);
		} else if (label.equalsIgnoreCase("suffix")) {
			new Suffix(player, args);
		} else if (label.equalsIgnoreCase("ban")) {
			new Ban(player, args);
		} else if (label.equalsIgnoreCase("oban")) {
			new OBan(player, args);
		} else if (label.equalsIgnoreCase("kick")) {
			new Kick(player, args);
		} else if (label.equalsIgnoreCase("cbc")) {
			new CBC(player, args);
		} else if (label.equalsIgnoreCase("creative")) {
			new Creative(player, args);
		} else if (label.equalsIgnoreCase("flatlands")) {
			new Flatlands(player, args);
		} else if (label.equalsIgnoreCase("survival")) {
			new Survival(player, args);
		} else if (label.equalsIgnoreCase("sudo")) {
			new Sudo(player, args);
		}
		return false;
	}
}
