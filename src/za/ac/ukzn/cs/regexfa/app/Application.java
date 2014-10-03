package za.ac.ukzn.cs.regexfa.app;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import za.ac.ukzn.cs.regex2fa.fa.DFA;
import za.ac.ukzn.cs.regex2fa.fa.NFA;
import za.ac.ukzn.cs.regex2fa.re.RegExp2AST;
import za.ac.ukzn.cs.regex2fa.re.Regex;

public class Application 
{
	public static void main(String[] args) throws IOException, ParseException
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome! RegexToFA program processing... ");
		
		System.out.print("\nPlease enter regular expression: ");
		String re = in.next(); // the regular expression to be converted
		
		Regex r = (new RegExp2AST(re)).convert(); // convert re to an expression tree
		
		// use Thompson's construction to build an nfa from expression tree
		NFA nfa = r.makeNFA(); 
		
		// use subset construction to convert nfa to an equivalent dfa
		DFA dfa = new DFA(nfa);
		System.out.println(dfa.toString());
		
		// test strings to see if they're members of the language denoted by the regex using DFA
		System.out.println();
        System.out.println("Please Enter A String To Test");
        String str = in.next();
		
        if((dfa.Accept_Language(str)) == true)
        	System.out.println("String " + str +" a accepted by the language");
        else if((dfa.Accept_Language(str) == false))
        	System.out.println("String"+ str +" is not accepted by the language");
		
		in.close();
	}
}
