package org.ruhlendavis.mc.calm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.PatternSyntaxException;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

/**
 *
 * @author Iain E. Davis <iain@ruhlendavis.org>
 */
public final class Configuration
{
	public List<CalmFilter> filters = new ArrayList<>();

	private Calm plugin;
	
	public Configuration(Calm plugin)
	{
		this.plugin = plugin;
		plugin.saveDefaultConfig();
		load();
	}
	
	/**
	 * Read the configuration options from config.yml.
	 */
	public void load()
	{
		FileConfiguration config = plugin.getConfig();

		ConfigurationSection filterSection = config.getConfigurationSection("filters");
		
		if (filterSection == null)
		{
			return;
		}
		
		Set<String> filterNames = filterSection.getKeys(false);

		for (String filterName : filterNames)
		{
			String path = "filters." + filterName + ".";
			String methodString = config.getString(path + "method").toUpperCase();

			// Defaults to exact
			MatchMethod method = MatchMethod.valueOf(methodString);

			if (method == null)
			{
				method = MatchMethod.EXACT;
			}
			
			List<String> replaceTokens = config.getStringList(path + "replace-tokens");

			try
			{
				CalmFilter filter = new CalmFilter(
								filterName,
								method,
								config.getString(path + "pattern", ""),
								config.getBoolean(path + "to-console", true),
								config.getBoolean(path + "to-standard-log", true),
								config.getString(path + "log-path", ""),
								config.getString(path + "replace-string", ""),
								replaceTokens
								);
				filters.add(filter);
			}
			catch (PatternSyntaxException exception)
			{
				// TODO: notify user of bad regexp.
			}
		}
	}
}
