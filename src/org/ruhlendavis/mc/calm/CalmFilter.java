package org.ruhlendavis.mc.calm;

import java.util.List;

/**
 * This is our filter definition.
 * 
 * @author Feaelin (Iain E. Davis) <iain@ruhlendavis.org>
 */
public class CalmFilter
{
	private String				name;
	private MatchMethod		method;
	private String				pattern;
	private boolean				toConsole;
	private boolean				toStandardLog;
	private String				logPath;
	private String				replaceString;
	private List<String>	replaceTokens;

	CalmFilter()
	{
	}
	
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

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the method
	 */
	public MatchMethod getMethod()
	{
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(MatchMethod method)
	{
		this.method = method;
	}

	/**
	 * @return the pattern
	 */
	public String getPattern()
	{
		return pattern;
	}

	/**
	 * @param pattern the pattern to set
	 */
	public void setPattern(String pattern)
	{
		this.pattern = pattern;
	}

	/**
	 * @return the toConsole
	 */
	public boolean isToConsole()
	{
		return toConsole;
	}

	/**
	 * @param toConsole the toConsole to set
	 */
	public void setToConsole(boolean toConsole)
	{
		this.toConsole = toConsole;
	}

	/**
	 * @return the toStandardLog
	 */
	public boolean isToStandardLog()
	{
		return toStandardLog;
	}

	/**
	 * @param toStandardLog the toStandardLog to set
	 */
	public void setToStandardLog(boolean toStandardLog)
	{
		this.toStandardLog = toStandardLog;
	}

	/**
	 * @return the logPath
	 */
	public String getLogPath()
	{
		return logPath;
	}

	/**
	 * @param logPath the logPath to set
	 */
	public void setLogPath(String logPath)
	{
		this.logPath = logPath;
	}

	/**
	 * @return the replaceString
	 */
	public String getReplaceString()
	{
		return replaceString;
	}

	/**
	 * @param replaceString the replaceString to set
	 */
	public void setReplaceString(String replaceString)
	{
		this.replaceString = replaceString;
	}

	/**
	 * @return the replaceTokens
	 */
	public List<String> getReplaceTokens()
	{
		return replaceTokens;
	}

	/**
	 * @param replaceTokens the replaceTokens to set
	 */
	public void setReplaceTokens(List<String> replaceTokens)
	{
		this.replaceTokens = replaceTokens;
	}
}
