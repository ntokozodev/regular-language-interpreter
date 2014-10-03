package za.ac.ukzn.cs.regex2fa.fa;

import java.util.ArrayList;
import java.util.TreeSet;

public class DFA_State 
{
	
	boolean is_final = false;
	ArrayList<DFA_State> dfa_list = new ArrayList<>();
	TreeSet<Integer> state_set;
	int state_count;
	ArrayList<Integer> transitions = new ArrayList<Integer>();
	ArrayList<Character> symbols = new ArrayList<Character>();

	@SuppressWarnings("unchecked")
	public DFA_State(@SuppressWarnings("rawtypes") TreeSet StateSet, int statenum)
	{
		state_set = new TreeSet<Integer>(StateSet); 
		this. state_count = statenum;
	
	
	}

	@SuppressWarnings("rawtypes")
	public TreeSet getState()
	{ return state_set; }

	public void setTransition(int trans, char sym, DFA_State d)
	{
		transitions.add(trans);
		symbols.add(sym);
		dfa_list.add(d);
	}

	public int getstate()
	{ return state_count; }

	public boolean equals(DFA_State obj)
	{ return(this.state_set == obj.state_set); }

	public void setFinal() 
	{ is_final = true; }

		
	public boolean getFinal()
	{ return is_final; }

	
	public DFA_State Next1(char sym)
	{
		for(int i = 0; i < symbols.size(); i++)
		{
			if (symbols.get(i)==sym)
				return dfa_list.get(i);
		}
		return this;
	}
	
	/**
	 * Prints out the states of the DFA and also displays which one 
	 * is the start state and the accept state
	 */
	public String toString()
	{
		String temp = state_count + "\t: [";
		for (int i = 0; i < symbols.size(); i++)
			temp += "("+symbols.get(i)+"->"+transitions.get(i)+") ";
	
		temp += "]";
		if (is_final)
			temp += "Accept/Final State";
	
		if(state_count == 0)
			temp+= "Start State";	
		return temp;
	}
}