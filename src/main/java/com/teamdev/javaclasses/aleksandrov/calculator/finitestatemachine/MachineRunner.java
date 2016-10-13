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
package com.teamdev.javaclasses.aleksandrov.calculator.finitestatemachine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 *
 * @param <Result>
 * @param <State>
 * @param <InputContext>
 * @param <OutputContext>
 * @param <Recognizer>
 * @param <Matrix>
 */
public abstract class MachineRunner<
        Result,
        State extends Enum,
        InputContext,
        OutputContext,
        Recognizer extends StateRecognizer<InputContext, OutputContext, State>,
        Matrix extends TransitionMatrix<State>> {

    private final Matrix matrix;
    private final Recognizer recognizer;

    private static final Logger log = LoggerFactory.getLogger(MachineRunner.class);

    public MachineRunner(Matrix matrix, Recognizer recognizer) {
        this.matrix = matrix;
        this.recognizer = recognizer;
    }

    public Result move(InputContext inputContext, OutputContext outputContext) {
        State currentState = matrix.getStartState();

        log.info("Start State is set to: " + currentState);

        while (currentState != matrix.getFinishState()) {
            currentState = acceptNewState(inputContext, outputContext, matrix.getPossibleTransitions(currentState));
            log.info("Accepted a new state: " + currentState);
            if (currentState == null) {
                deadlock(inputContext);
            }
        }
        return prepareResult(outputContext);
    }

    private State acceptNewState(InputContext inputContext,
                                 OutputContext outputContext,
                                 Set<State> possibleTransitions) {
        for (State possibleState : possibleTransitions) {
            if (recognizer.accept(inputContext, outputContext, possibleState)) {
                log.info("Trying to accept new state: " + possibleState);
                return possibleState;
            }
        }
        log.info("Unable to accept state: " + possibleTransitions);
        return null;
    }

    protected abstract void deadlock(InputContext inputContext);

    protected abstract Result prepareResult(OutputContext outputContext);
}
