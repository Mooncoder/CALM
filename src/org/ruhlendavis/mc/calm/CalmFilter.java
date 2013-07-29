package org.ruhlendavis.mc.calm;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * This is our filter definition.
 * 
 * @author Feaelin (Iain E. Davis) <iain@ruhlendavis.org>
 */
public class CalmFilter
{
	private String				name;
	private MatchMethod		method;
	private String				patternString;
	private Pattern				pattern;
	private boolean				toConsole;
	private boolean				toStandardLog;
	private String				logPath;
	private String				replaceString;
	private List<String>	replaceTokens;

	CalmFilter()
	{
	}
	
	CalmFilter(String name, MatchMethod method, String patternString, boolean toConsole, boolean toStandardLog, String logPath, String replaceString, List<String> replaceTokens) throws PatternSyntaxException
	{
		this.name = name;
		setMatching(patternString, method);
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
	 * @return the pattern
	 */
	public String getPatternString()
	{
		return patternString;
	}

	/**
	 * @return the pattern
	 */
	public Pattern getPattern()
	{
		return pattern;
	}

	/**
	 * @param method the method to set
	 */
	public final void setMatching(String patternString, MatchMethod method) throws PatternSyntaxException
	{
		this.method = method;
		this.patternString = patternString;
		if (this.method == MatchMethod.REGEX)
		{
			this.pattern = Pattern.compile(patternString);
		}
		else
		{
			this.pattern = null;
		}
	}

	/**
	 * @param pattern the pattern to set
	 */
	public void setPattern(String pattern)
	{
		this.patternString = pattern;
		
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
