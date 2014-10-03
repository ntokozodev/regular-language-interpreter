package za.ac.ukzn.cs.regex2fa.fa;

import java.util.TreeSet;

import za.ac.ukzn.cs.regex2fa.re.Regex;

/**
 * @author Ntokozo
 * This is a class representing a NFA
 */

public class NFA
{
	private static NFA_State gstart_state	= null;
	private static NFA_State final_state = null;
	
	static int nfa_count = 0;
	static int state_count = 0;
	
	private char EPSILON = 0;
	private char ACCEPT = 1;
	
	private NFA_State accept_state;
	private NFA_State start_State;
	
	private static TreeSet<Character> State_Set = new TreeSet<Character>();
	
	public NFA(Regex r)
	{
		this(NFA_State.EPSILON);
	}
	
	public NFA(char symb)
	{
		if (symb != EPSILON)
			State_Set.add(symb);
		
		 accept_state = new NFA_State(null, null, ACCEPT, state_count++);
		 start_State = new NFA_State(accept_state, null, symb, state_count++);
		 
		 if(gstart_state == null)
			 gstart_state = start_State;
		 
		 if(final_state == null)
			 final_state = accept_state;
	}
	
	
	public NFA_State getStart()
	{
		return this.start_State;
	}
	
	
    public NFA_State getAccept()
    {
		return this.accept_state;
	}
	
    
    public void setStart1(NFA_State a)
    {
    	start_State.setNext1(a);
    }
    
    public void setStart2(NFA_State a)
    {
    	start_State.setNext2(a);
    }
    
    public void setAccept1(NFA_State a)
    {
    	accept_state.setNext1(a);
    	accept_state.setSymbol(EPSILON);
    }
    
    public void setAccept2(NFA_State a)
    {
    	accept_state.setNext2(a);
    	accept_state.setSymbol(EPSILON);
    }
    
    public static void setGlobalStart(NFA_State startState)
    {
    	gstart_state = startState;
    }
    public static  NFA_State getGlobalStart()
    {
    	return gstart_state;
    }
    
    public static void setFinal(NFA_State FinalState)
    {
    	final_state = FinalState;
    }
    
    public NFA_State getFinal()
    {
    	return final_state;
    }
    
    public int getNumOfStates()
    {
    	return state_count;
    }
    
    public TreeSet<Character> getAlphabet()
    {
    	return State_Set;
    }
}
