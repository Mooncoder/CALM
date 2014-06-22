package org.ruhlendavis.mc.calm;

import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoggingFilter implements Filter
{
	public LoggingFilter()
	{
		super();
	}

	@Override
	public boolean isLoggable(LogRecord record)
	{
		String message = record.getMessage();

		for (CalmFilter filter : Calm.config.filters)
		{
			String patternString = filter.getPatternString();
			switch (filter.getMethod())
			{
				case EXACT:
					if (message.equals(patternString))
					{
						if (filter.isToConsole())
						{
							continue;
						}
						return false;
					}
					break;
				case SIMPLE:
					if (message.contains(patternString))
					{
						if (filter.isToConsole())
						{
							continue;
						}
						return false;
					}
					break;
				case WILDCARD:
					break;
				case REGEX:
					Pattern pattern = filter.getPattern();
					if (pattern != null)
					{
						Matcher matcher = pattern.matcher(message);
						if (matcher.find())
						{
							if (filter.isToConsole())
							{
								continue;
							}
							return false;
						}
					}
					break;
			}
		}
		return true;
	}
}
