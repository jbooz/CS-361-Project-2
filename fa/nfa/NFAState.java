package fa.nfa;

import fa.State;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NFAState extends State {

    private Map<Character, Set<NFAState>> transitions;

    public NFAState(String name) {
        super(name);
        this.transitions = new HashMap<>();
    }

    public void addTransition(char onSymb, NFAState toState) {
        // TODO: transition to the map
    }

    public Set<NFAState> getToStates(char onSymb) {
        // TODO: returning the set of states for a given symbol
        return null;
    }
}