package org.ruhlendavis.mc.calm;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CalmCommandExecutor implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments)
	{
		int argumentStart = 0;
		String commandName = command.getName().toLowerCase();

		// If user types 'calm somecommand arg1 arg2' set commandName, and note
		// where the arguments start.
		if (commandName.equals("calm"))
		{
			if (arguments.length == 0)
			{
				// spit out generic stuff here
				return true;
			}
			commandName = arguments[argumentStart];
			argumentStart++;
		}

		// If user types 'calmsomecommand arg1 arg2' then calmsomecommand --> somecommand.
		if (commandName.startsWith("calm"))
		{
			commandName = commandName.substring(4, commandName.length());
		}

		// Amusing side effect of above. calm calmreload will work. :)

		if (commandName.equals("reload"))
		{
			onReloadConfig(sender);
		}

		return true;
	}

	private void onReloadConfig(CommandSender sender)
	{
		Calm.config.filters.clear();
		Calm.config.load();
		// TODO: make a real message.
		sender.sendMessage("reloaded.");
	}
}
