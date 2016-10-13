package com.teamdev.javaclasses.aleksandrov.calculator;

import com.teamdev.javaclasses.aleksandrov.calculator.finitestatemachine.TransitionMatrix;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CalculatorTransitions implements TransitionMatrix<CalculationState> {

    private final Map<CalculationState, Set<CalculationState>> transitions = new HashMap<CalculationState, Set<CalculationState>>() {{
        put(CalculationState.START, EnumSet.of(CalculationState.NUMBER));
        put(CalculationState.NUMBER, EnumSet.of(CalculationState.BINARY_OPERATOR, CalculationState.FINISH));
        put(CalculationState.BINARY_OPERATOR, EnumSet.of(CalculationState.NUMBER));
        put(CalculationState.FINISH, EnumSet.noneOf(CalculationState.class));
    }};

    public CalculationState getStartState() {
        return CalculationState.START;
    }

    public CalculationState getFinishState() {
        return CalculationState.FINISH;
    }

    public Set<CalculationState> getPossibleTransitions(CalculationState currentState) {
        return transitions.get(currentState);
    }

}
