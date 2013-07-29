package org.ruhlendavis.mc.calm;

import java.util.List;

/**
 * This is our filter definition.
 * 
 * @author Feaelin
 */
public class CalmFilter
{
	private String      name;
	private MatchMethod method;
	private String      pattern;
	private boolean     toConsole;
	private boolean     toStandardLog;
	private String      logPath;
	private String      replaceString;
	private List<String> replaceTokens;

	CalmFilter(String name, MatchMethod method, String pattern, boolean toConsole, boolean toStandardLog, String logPath, String replaceString, List<String> replaceTokens)
	{
		this.name = name;
		this.method = method;
		this.pattern = pattern;
		this.toConsole = toConsole;
		this.toStandardLog = toStandardLog;
		this.logPath = logPath;
		this.replaceString = replaceString;
		this.replaceTokens = replaceTokens;
	}
}
