package za.ac.ukzn.cs.regexfa.test;

import java.util.Scanner;

import za.ac.ukzn.cs.regexfa.finite_automaton.DeterministicFA;
import za.ac.ukzn.cs.regexfa.finite_automaton.NondeterministicFA;
import za.ac.ukzn.cs.regexfa.regular_expression.RegExp2AST;
import za.ac.ukzn.cs.regexfa.regular_expression.Regex;

public class Application 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter regular expression: ");
		String re = in.next(); // the regular expression to be converted
		
		System.out.println("\nWelcome! RegexFA program processing... "+re);
		
		Regex r = (new RegExp2AST(re)).convert(); // convert re to an expression tree
		
		// use Thompson's construction to build an nfa from expression tree
		NondeterministicFA nfa = new NondeterministicFA(r); 
		
		// use subset construction to convert nfa to an equivalent dfa
		DeterministicFA dfa = new DeterministicFA(nfa);
		// test strings to see if they're members of the language denoted by the regex using DFA
		String str = "";
		dfa.testString(str ); 
		
		in.close();
	}
}
