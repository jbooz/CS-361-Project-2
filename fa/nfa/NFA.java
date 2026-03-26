package fa.nfa;

import fa.State;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class NFA implements NFAInterface {

private Set<NFAState> states;
    private Set<Character> sigma;
    private Set<NFAState> finalStates;
    private NFAState startState;


    public NFA() {
        this.states = new LinkedHashSet<>();
        this.sigma = new LinkedHashSet<>();
        this.finalStates = new LinkedHashSet<>();
        this.startState = null;   
    }

    @Override
    public boolean addState(String name) {
        if (getState(name) != null) {
            return false; // State already exists
        }
        NFAState newState = new NFAState(name); // Create new state with given name
        states.add(newState); // Add new state to the set
        return true; 
    }
    @Override
    public boolean setStart(String name) {
        NFAState state= (NFAState) getState(name);
        if (state == null) {
            return false; // State does not exist
        }
        startState = state; // set the start state to current state
        return true;
    }

    @Override
    public boolean setFinal(String name) {
        NFAState state = (NFAState) getState(name);
        if (state == null) {
            return false; // State does not exist.
        }
        finalStates.add(state); // Add a final state to the set
        return true;    
    }

    @Override
    public boolean isFinal(String name) {
        State state = getState(name);
        return state != null && finalStates.contains(state); // Check if current state is in final states set
    }

    @Override
    public boolean isStart(String name) {
        State state = getState(name);
        return state != null && state.equals(startState); // Check if current state is the designated start state
    }

    @Override
    public void addSigma(char symbol) {
        sigma.add(symbol); // kinda ez, just adds symbol alphabet 
    }

    @Override
    public Set<Character> getSigma() {
        return sigma; // get alphabet and spit it out
    }

    @Override
    public State getState(String name) {
        for (NFAState state : states) {
            if (state.getName().equals(name)) { 
                return state; // return state if its found
            }
        }
        return null;  // return null if state is not found
      }

    @Override
    public Set<NFAState> getToState(NFAState from, char onSymb) {
        return from.getToStates(onSymb); // returns the set of reachable states from currnet state onSymb
    }

    @Override
    public boolean accepts(String s) {
        // TODO: BFS traversal to check if string reaches a final state.
        return false;
    }

    @Override
    public Set<NFAState> eClosure(NFAState s) {
        // TODO: DFS with a stack for epsilon ('e') transitions.
        return null;
    }

    @Override
    public int maxCopies(String s) {
        // TODO: Track max active states during BFS trace.
        return 0; 
    }

    @Override
    public boolean addTransition(String fromState, Set<String> toStates, char onSymb) {
        // TODO: Validate inputs and link 'from' to 'to' states.
        return false;
    }

    @Override
    public boolean isDFA() {
        // TODO: Check for zero epsilon transitions and exactly one transition per symbol.
        return false;
    }
}