package com.teamdev.javaclasses.aleksandrov.calculator.finitestatemachine;

import java.util.Set;

public interface TransitionMatrix<State extends Enum> {

    State getStartState();

    State getFinishState();

    Set<State> getPossibleTransitions(State currentState);
}
