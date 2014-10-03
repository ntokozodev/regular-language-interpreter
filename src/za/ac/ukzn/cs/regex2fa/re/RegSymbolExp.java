package za.ac.ukzn.cs.regex2fa.re;

import za.ac.ukzn.cs.regex2fa.fa.NFA;

/*
 *  Class representing a single character tree in a RegExp expression tree.
 */
public class RegSymbolExp extends Regex 
{
	protected char symbol;    // character represented
	
	public RegSymbolExp(char symbol) 
	{	
		this.setSymbol(symbol);				
	}

	private void setSymbol(char symbol) 
	{	this.symbol = symbol;	}



	/*
	 *  Decompile this character expression tree back to its original
	 *  form as a string
	 */	
	public String decompile() 
	{	return "\"" + symbol + "\"";	}
	
    /*
	 * Make and return a Nfa for this character expression tree
	 */	
	@Override
	public NFA makeNFA() 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
