package za.ac.ukzn.cs.regex2fa.re;

import za.ac.ukzn.cs.regex2fa.fa.NFA;

/*
 *  Class representing a character class tree in a RegExp expression tree.
 */
public class RegClassExp extends Regex 
{	
	protected char lower,  // lower limit of class
	               upper;  // upper limit of class
	
	/*
	 * Construct a new character node with specified lower
	 * and upper limits for the class
	 */
	public RegClassExp(char lower, char upper) 
	{	
		this.setLower(lower);
		this.setUpper(upper);				
	}
	
	private void setUpper(char upper) 
	{	this.upper = upper;	}

	private void setLower(char lower) 
	{	this.lower = lower;	}

	/*
	 * Make and return a Nfa for this character class expression tree
	 */
	public NFA makeNFA() 
	{	
		return null;
	}
	
	/*
	 *  Decompile this character class expression tree back to its original
	 *  form as a string
	 */
	public String decompile() 
	{	
		return "[" + lower + "-" + upper + "]";
	}
}
