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
        Set<NFAState> currentStates = eClosure(startState); // Start with the epsilon closure of the start state

        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i); // Get the current symbol from the input string
            Set<NFAState> nextStates = new LinkedHashSet<>();  // Create a new set to hold the next states

            for (NFAState state : currentStates) {
                Set<NFAState> transitions = state.getToStates(symbol); // Get reachable states
                if (transitions != null) {
                    for (NFAState next : transitions) {
                        nextStates.addAll(eClosure(next));
                    }
                }
            }
            currentStates = nextStates;
        }

        for (NFAState state : currentStates) {
            if (finalStates.contains(state)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<NFAState> eClosure(NFAState s) {
        Set<NFAState> closure = new LinkedHashSet<>();
        Stack<NFAState> stack = new Stack<>();

        stack.push(s);
        closure.add(s);

        while (!stack.isEmpty()) {
            NFAState current = stack.pop();
            Set<NFAState> eTransitions = current.getToStates('e'); // Get epsilon transitions from the current state
            
            if (eTransitions != null) {
                for (NFAState next : eTransitions) { 
                    if (!closure.contains(next)) {
                        closure.add(next); 
                        stack.push(next);
                    }
                }
            }
        }
        return closure;
    }

    @Override
    public int maxCopies(String s) {
        Set<NFAState> currentStates = eClosure(startState);
        int max = currentStates.size();

        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            Set<NFAState> nextStates = new LinkedHashSet<>(); // Create a new set to hold the next states

            for (NFAState state : currentStates) {
                Set<NFAState> transitions = state.getToStates(symbol);
                if (transitions != null) {
                    for (NFAState next : transitions) {
                        nextStates.addAll(eClosure(next));
                    }
                }
            }
            currentStates = nextStates;
            
            if (currentStates.size() > max) {
                max = currentStates.size();
            }
        }
        return max;
    }

@Override
    public boolean addTransition(String fromState, Set<String> toStates, char onSymb) {
        NFAState from = (NFAState) getState(fromState);
        if (from == null) {
            return false;
        }
        
        if (!sigma.contains(onSymb) && onSymb != 'e') {
            return false;
        }

        for (String toName : toStates) {
            NFAState to = (NFAState) getState(toName);
            if (to == null) {
                return false;
            }
            from.addTransition(onSymb, to);
        }
        return true;
    }

    @Override
    public boolean isDFA() {
        for (NFAState state : states) {
            Set<NFAState> eTrans = state.getToStates('e');
            if (eTrans != null && !eTrans.isEmpty()) {
                return false;
            }
            
            for (char symbol : sigma) {
                Set<NFAState> transitions = state.getToStates(symbol);
                if (transitions == null || transitions.size() != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}