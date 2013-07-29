package org.ruhlendavis.mc.calm;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Primary class.
 * 
 * @author Feaelin (Iain E. Davis) <iain@ruhlendavis.org>
 */
public final class Calm extends JavaPlugin
{
	@SuppressWarnings("PMD.UnusedPrivateField")
	private static Calm instance;
	
	public static List<CalmFilter> filters = new ArrayList<>();
	
	/**
	 * onEnable triggered by Bukkit to handle any setup the plugin needs.
	 *
	 */
	@Override
  public void onEnable()
	{
		getCommand("calm").setExecutor(new CalmCommandExecutor());
		getCommand("calmreload").setExecutor(new CalmCommandExecutor());

		Logger.getLogger("Minecraft").setFilter(new LoggingFilter());
		// For use in onDisable();
		instance = this;
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
