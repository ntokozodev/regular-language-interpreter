package za.ac.ukzn.cs.regexfa.regular_expression;


/**
 * 
 * @author Ntokozo
 * @date 15/09/2014
 * 
 */
public class RegExp2AST 
{
	private String regex = "";
	
	public static void main(String[] args)
	{
		
	}
	
	public RegExp2AST(String re)
	{
		this.setRegex(re);
	}
	
	/**
	 * Convert the regular expression to an expression tree
	 */
	public Regex convert() 
	{
		return null;
	}

	public String getRegex() 
	{
		return regex;
	}

	public void setRegex(String regex) 
	{
		this.regex = regex;
	}
}
