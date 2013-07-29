package org.ruhlendavis.mc.calm;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * This is the key class for log filtering.
 * 
 * @author Feaelin (Iain E. Davis) <iain@ruhlendavis.org>
 */
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

		for (CalmFilter filter : Calm.filters)
		{
			String pattern = filter.getPattern();
			switch (filter.getMethod())
			{
				case EXACT:
					if (message.equals(pattern))
					{
						if (filter.isToConsole())
						{
							continue;
						}
						return false;
					}
					break;
				case SIMPLE:
					if (message.contains(pattern))
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
					break;
			}
		}
		return true;
	}
}
