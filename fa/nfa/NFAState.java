package fa.nfa;

import fa.State;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class NFAState extends State {

    private Map<Character, Set<NFAState>> transitions;

    public NFAState(String name) {
        super(name);
        this.transitions = new HashMap<>();
    }

    public void addTransition(char onSymb, NFAState toState) {
        if (transitions.containsKey(onSymb) && !(transitions.get(onSymb).contains(toState)))
        {
            transitions.get(onSymb).add(toState);
        }
        else if (!(transitions.containsKey(onSymb)))
        {
            LinkedHashSet<NFAState> toStates = new LinkedHashSet<>();
            toStates.add(toState);
            transitions.put(onSymb, toStates);
        }
    }

    public Set<NFAState> getToStates(char onSymb) {
        return transitions.get(onSymb);
    }
}