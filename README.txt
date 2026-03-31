****************
* Project 2 (Nondeterministic Finite Automata)
* CS 361
* 3/30/2026
* Jonathan Boozel and Aaron Eagleton
**************** 


OVERVIEW:


 This project represents an implementation of an
 NFA (Nondeterministic Finite Automata). An NFA is a
 Finite Automata that isn't Deterministic in nature,
 meaning when transitioning based on certain character
 symbols, there are multiple permuations that can be
 explored that may result in the same or even different
 solutions. An NFA contains an alphabet, states, and
 transitions.




INCLUDED FILES:

 e.g.
 * NFA.java - source file
 * NFAInterface.java - source file
 * NFAState.java - source file
 * FAInterface.java - source file
 * State.java - source file
 * NFATest.java - source file
 * hamcrest-core-1.3.jar - test file
 * junit-4.13.2.jar - test file
 * README - this file




COMPILING AND RUNNING:
 
 e.g.
 From the directory containing all source files, compile the
 driver class (and all dependencies) with the command:
 $ javac -cp .:/usr/share/java/junit.jar ./test/nfa/NFATest.java


 Run the compiled class file with the command:
 $ java -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest/core.jar
 org.junit.runner.JUnitCore test.nfa.NFATest


 Results: All test cases passing
 %RUNTIME22 took 445ms to complete




PROGRAM DESIGN AND IMPORTANT CONCEPTS:


 The main goal of this java project is to instantiate a representation of an NFA
 that follows the same rules and would operate identically to one when given the
 correct information to support its design. The NFA.java file comprises the main
 implementation and description of an NFA design, but it is made up of many components
 that describe its inner workings in greater detail.

 One of these components being the NFAState.java class. This class, when instantiated,
 is used to represent a state that is associated with the NFA object that, and which
 contains transitions to and from other states of the same type. An NFAState will differ
 depending on the character symbol it is associated with, and will be placed within its
 own set of states accordingly. Fleshing out some of the transition functionality within
 the NFAState.java file streamlines the program and lifts a bit of the weight off of the
 shoulders of the main implementation class.

 NFAInterface.java is also used to outline the main functionality of the NFA.java file,
 and ensures that every NFA is built with specific, useful methods in mind. For example,
 the interface outlines how every NFA should have a method that defines its eClosure, or
 all the states that can be transitioned to from the current state when only transitioning
 via epsilon character symbols.




TESTING:


 The testing process was primarily driven by the NFATest.java Junit suite.
 Custom tests were added to ensure that the code had correctly handled edge cases
 and specific vulnerabilities encountered while coding. A few of them included a
 machine with no epsilon, or exactly one transition per symbol and infinite epsilon
 loops for stress testing its handling of cases and proper eclosure.




DISCUSSION:
 
 The most significant roadblock during development was a compiler error regarding the
 getState method and the eClosure parameter. The provided FAInterface required getState
 to return a generic State object, but eClosure strictly required an NFAState. Because
 modifying the interface or the test file was prohibited, originally we had them set up
 wrong and could not figure out why everything was fine in the files but those few tests
 that handled those cases. Once we looked at the naming conventions however it became clear
 and then was a matter of tracking down and changing all of the naming throughout the files.
 
 
EXTRA CREDIT:

 N/A


SOURCES:
 https://www.geeksforgeeks.org/java/linkedhashset-in-java-with-examples/
 https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashSet.html

 Google AI overview/gemini for generic questions typed directly into google since it answers them quicker than clicking on links
 Edge test cases recommended by gemini but coded by aaron
----------------------------------------------------------------------------