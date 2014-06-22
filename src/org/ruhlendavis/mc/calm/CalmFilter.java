package org.ruhlendavis.mc.calm;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public MatchMethod getMethod()
	{
		return method;
	}

	public String getPatternString()
	{
		return patternString;
	}

	public Pattern getPattern()
	{
		return pattern;
	}

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

	public void setPattern(String pattern)
	{
		this.patternString = pattern;

	}

	public boolean isToConsole()
	{
		return toConsole;
	}

	public void setToConsole(boolean toConsole)
	{
		this.toConsole = toConsole;
	}

	public boolean isToStandardLog()
	{
		return toStandardLog;
	}

	public void setToStandardLog(boolean toStandardLog)
	{
		this.toStandardLog = toStandardLog;
	}

	public String getLogPath()
	{
		return logPath;
	}

	public void setLogPath(String logPath)
	{
		this.logPath = logPath;
	}

	public String getReplaceString()
	{
		return replaceString;
	}

	public void setReplaceString(String replaceString)
	{
		this.replaceString = replaceString;
	}

	public List<String> getReplaceTokens()
	{
		return replaceTokens;
	}

	public void setReplaceTokens(List<String> replaceTokens)
	{
		this.replaceTokens = replaceTokens;
	}
}
