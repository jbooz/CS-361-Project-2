package fa.nfa;

import fa.State;
import java.util.LinkedHashSet;
import java.util.Set;

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
        // TODO: Create and add state if it doesn't exist.
        return false;
    }

    @Override
    public boolean setFinal(String name) {
        // TODO: Find state and mark as final.
        return false;
    }

    @Override
    public boolean setStart(String name) {
        // TODO: Find state and set as start state.
        return false;
    }

    @Override
    public void addSigma(char symbol) {
        sigma.add(symbol);
    }

    @Override
    public boolean accepts(String s) {
        // TODO: BFS traversal to check if string reaches a final state.
        return false;
    }

    @Override
    public Set<Character> getSigma() {
        return sigma;
    }

    @Override
    public State getState(String name) {
        // TODO: Return the matching state or null.
        return null;
    }

    @Override
    public boolean isFinal(String name) {
        // TODO: Check if state is in your final states collection.
        return false;
    }

    @Override
    public boolean isStart(String name) {
        // TODO: Check if state matches startState.
        return false;
    }

    @Override
    public Set<NFAState> getToState(NFAState from, char onSymb) {
        // TODO: Return the state's transitions for this symbol.
        return null;
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