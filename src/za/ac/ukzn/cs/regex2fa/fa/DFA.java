
package za.ac.ukzn.cs.regex2fa.fa;

/**
 * @author Ntokozo
 * Class to represent a DFA
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.TreeSet;


public class DFA 
{
	private static int state_count = 0;
	private int final_State;
	private static NFA_State nfa_arr[];
	
	ArrayList<DFA_State> dfa_st_list = new ArrayList<>();
	TreeSet<Character> set_alphabet = new TreeSet<>();
	@SuppressWarnings("rawtypes")
	TreeSet<TreeSet> new_states = new TreeSet<>();
	

	
	@SuppressWarnings("unchecked")
	public DFA(NFA nfa)
	{
		final_State = nfa.getAccept().getStateNo();
		set_alphabet = nfa.getAlphabet();
		
		Iterator<Character> alphabet_iter = set_alphabet.iterator();
		TreeSet<Integer> tree = new TreeSet<Integer>();
		
		NFA_State nfa_state = NFA.getGlobalStart();
		tree.add(nfa_state.getStateNo());
		Stack<NFA_State> state = new Stack<NFA_State>();
		
		state.push(nfa_state);
		
		nfa_arr = new NFA_State[nfa.getNumOfStates()];
		NFA_State[] temp_arr = new NFA_State[nfa.getNumOfStates()];
        
		NFA_State ns;
		while(!state.isEmpty())
        {
        	ns = state.pop();
        	int i = ns. getStateNo();
        	nfa_arr[i] = ns;
        	System.out.println(nfa_arr[i]);
        	temp_arr[i] = ns;
        	if(ns.getNext1() != null && nfa_arr[ns.getNext1().getStateNo()] == null)
        		state.push(ns.getNext1());
        	
        	if(ns.getNext2()!=null&&nfa_arr[ns.getNext2().getStateNo()]==null)
        		state.push(ns.getNext2());    	
        }
        
        
        
        tree = delta(tree, NFA_State.EPSILON);
        
        dfa_st_list.add(new DFA_State(tree, state_count++));
        
        if(tree.contains(final_State))
        	dfa_st_list.get(0).setFinal();
        
        char alphabet = 'x';
        int si = 0;
        
        while(si < dfa_st_list.size())
        {
        	DFA_State s = dfa_st_list.get(si);
        	
        	alphabet_iter = set_alphabet.iterator();
        	while(alphabet_iter.hasNext())
        	{
        		alphabet = alphabet_iter.next();
        		tree = delta(delta(s.getState(), alphabet), NFA_State.EPSILON);
        	
        		boolean contains = false;
        		for(int i=0; i<dfa_st_list.size(); i++)
        		{
        			if (tree.equals(dfa_st_list.get(i).getState()))
        			{
        				contains = true;
        				s.setTransition(dfa_st_list.get(i).getstate(), alphabet,dfa_st_list.get(i));
        			}
        		}
        	
        		if (!contains)
        		{
        			DFA_State df = new DFA_State(tree, state_count++);
        			if(df.getState().contains(final_State))
        				df.setFinal();
        			
        			dfa_st_list.add(df);
        			s.setTransition(df.getstate(), alphabet,df);
        		}
        	}si++;
        }
	}
	
	public TreeSet<Integer> delta(TreeSet<Integer> trees, char symb)
	{
		TreeSet<Integer> delt = new TreeSet<Integer>();
		TreeSet<Integer> tree = new TreeSet<Integer>(trees);
		TreeSet<Integer> set1 = new TreeSet<Integer>();
		
		set1.add(1);
		
		while(!set1.isEmpty())
		{
			set1.clear();
		
			java.util.Iterator<Integer> treeitr= tree.iterator();
			
			while(treeitr.hasNext())
			{
				int nx = treeitr.next();
				if(nfa_arr[nx].getSymbol() == symb)
				{
					delt.add((nfa_arr[nx].getNext1().getStateNo()));
					if(!tree.contains(nfa_arr[nx].getNext1().getStateNo()))
					{
						set1.add((nfa_arr[nx].getNext1().getStateNo()));
						if(symb==NFA_State.EPSILON)
						{
							set1.add((nfa_arr[nx].getStateNo()));
						}
					}
				}
				if(nfa_arr[nx].getNext2() != null && nfa_arr[nx].getSymbol2() == symb)
				{
					delt.add((nfa_arr[nx].getNext2().getStateNo()));
					if(!tree.contains(nfa_arr[nx].getNext2().getStateNo()))
					{
						if(symb == NFA_State.EPSILON)
							set1.add((nfa_arr[nx].getStateNo()));
						set1.add((nfa_arr[nx].getNext2().getStateNo()));
					}
				}
			}
		
			java.util.Iterator<Integer> set1Itr= set1.iterator();
		
			while(set1Itr.hasNext())
			{
				int u =set1Itr.next();
				tree.add(u);
				delt.add(u);
			}
		}
		
		if(delt.isEmpty())
			return tree;
		return delt;
	}
	
	public boolean Accept_Language(String input_String)
	{
		DFA_State n = dfa_st_list.get(0).Next1(input_String.charAt(0));
		if(!set_alphabet.contains(input_String.charAt(0)))
			return false;
			
		for(int i = 1; i < input_String.length(); i++)
		{
			if(!set_alphabet.contains(input_String.charAt(i)))
					return false;
			n = n.Next1(input_String.charAt(i));
		}
		if (n.getFinal())
			return true;
		return false;
	}
	
	public String toString()
	{
		String temp= "NFA to DFA"+"\n";
		
		for(int i = 0; i < dfa_st_list.size(); i++)
        	temp = temp + (dfa_st_list.get(i).toString())+"\n";
		return temp;	
	}   	
}
