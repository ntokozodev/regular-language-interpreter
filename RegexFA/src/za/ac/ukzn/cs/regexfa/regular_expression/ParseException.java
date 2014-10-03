package za.ac.ukzn.cs.regexfa.regular_expression;

/**
 * @author Ntokozo
 *
 */
public class ParseException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @return a message describing the error
	 * 
	 */
	public String getMessage()
	{
		return "under construction";
	}
	
	/**
	 * @return  the location in the expression at which it was detected
	 */
	public String getErrorOffet()
	{
		return "under construction!";
	}

}
