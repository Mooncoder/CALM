package org.ruhlendavis.mc.calm;

import java.util.logging.Filter;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Primary class.
 * 
 * @author Feaelin (Iain E. Davis) <iain@ruhlendavis.org>
 */
public final class Calm extends JavaPlugin
{
	public static Configuration config;

	private static Calm instance;

  /**
	 * onEnable triggered by Bukkit to handle any setup the plugin needs.
	 *
	 */
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
	
	/**
	 * onDisable triggered by Bukkit to handle any cleanup the plugin needs when
	 * disabling.
	 */
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
