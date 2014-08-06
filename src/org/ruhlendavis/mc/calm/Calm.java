package org.ruhlendavis.mc.calm;

import java.util.logging.Filter;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Calm extends JavaPlugin
{
	public static Configuration config;

	private static Calm instance;

	@Override
         public void onEnable()
	{
		Bukkit.getLogger().setFilter(new LoggingFilter());
		// For use in onDisable();
		instance = this;
		config = new Configuration(instance);

		getCommand("calm").setExecutor(new CalmCommandExecutor());
		getCommand("calmreload").setExecutor(new CalmCommandExecutor());

	}

	@Override
	public void onDisable()
	{
		Filter filter = Logger.getLogger("Minecraft").getFilter();

		if (filter != null && filter instanceof CalmFilter)
		{
			Logger.getLogger("Minecraft").setFilter(null);
		}
		// This should be the last thing we do.
		instance = null;
	}
}
