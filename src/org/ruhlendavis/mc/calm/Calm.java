package org.ruhlendavis.mc.calm;

import java.util.ArrayList;
import java.util.List;
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
		// This should be the last thing we do.
		instance = null;
	}
}
