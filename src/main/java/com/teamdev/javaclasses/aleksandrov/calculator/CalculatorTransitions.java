/*
 * Copyright 2016, TeamDev Ltd. All rights reserved.
 *
 * Redistribution and use in source and/or binary forms, with or without
 * modification, must retain the above copyright notice and the following
 * disclaimer.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
