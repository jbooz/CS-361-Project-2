package fa.nfa;

import fa.State;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author JonathanBoozel
 * Date: 3/30/2026
 * 
 * The NFAState class represents a NFAState within an NFA representation. The NFAState
 * tracks what state the NFA is currently on, and also what transitions can be made from
 * the states depending on the character symbol that is used to transition.
 */
public class NFAState extends State {

    private Map<Character, Set<NFAState>> transitions;

    /**
     * Instantiate a new NFAState object
     * 
     * @param name - the name of the NFAState
     */
    public NFAState(String name) {
        super(name);
        // Create a HashMap to store the transitions
        this.transitions = new HashMap<>();
    }

    /**
     * Add a transition between two states depending on the symbol
     * 
     * @param onSymb - the character symbol to transition with
     * @param toState - the state to transition to
     */
    public void addTransition(char onSymb, NFAState toState) {
        if (transitions.containsKey(onSymb) && !(transitions.get(onSymb).contains(toState)))
        {
            // If a transition with the character symbol already exists, add the new state to the transition
            transitions.get(onSymb).add(toState);
        }
        else if (!(transitions.containsKey(onSymb)))
        {
            // Create a new state set to link to the character symbol for transitions
            LinkedHashSet<NFAState> toStates = new LinkedHashSet<>();
            toStates.add(toState);
            transitions.put(onSymb, toStates);
        }
    }

    /**
     * Returns the set of toStates from a particular transition character symbol
     * 
     * @param onSymb - the character symbol to check the transitions associated with
     * @return the set of states associated with the character symbol
     */
    public Set<NFAState> toStates(char onSymb) {
        return transitions.get(onSymb);
    }
}