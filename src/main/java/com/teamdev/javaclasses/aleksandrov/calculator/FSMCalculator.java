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

import com.teamdev.javaclasses.aleksandrov.calculator.finitestatemachine.MachineRunner;

/**
 * The finite state machine realisation in view of a calculator.
 *
 * @author Oleg Melnik
 * @author Alexander Aleksandrov
 */
public class FSMCalculator extends MachineRunner<
        Double,
        CalculationState,
        ExpressionReader,
        EvaluationStack,
        ParsingService,
        CalculatorTransitions> implements MathExpressionCalculator {
    /**
     * A constructor that takes {@link ParsingService} as Recognizer and {@link CalculatorTransitions} as matrix.
     */
    public FSMCalculator() {
        super(new CalculatorTransitions(), new ParsingService());
    }

    /**
     * Evaluates a math expression and shows the result.
     *
     * @param expression math expression
     * @return a result of all moves through expression.
     * @throws IncorrectEvaluationException
     */
    public double evaluate(String expression) throws IncorrectEvaluationException {
        final Double result = move(new ExpressionReader(expression), new EvaluationStack());
        return result;
    }

    /**
     * Throws  {@link IllegalStateException} in case if expression is not valid and machine don't know next state.
     *
     * @param expressionReader {@link ExpressionReader} object
     */
    @Override
    protected void deadlock(ExpressionReader expressionReader) {
        throw new IllegalStateException("Syntax error at position " + expressionReader.getPosition());
    }

    @Override
    protected Double prepareResult(EvaluationStack evaluationStack) {
        return evaluationStack.popNumber();
    }

    public static void main(String[] args) throws Exception {
        final double result = new FSMCalculator().evaluate("6*3/3");
        System.out.println("result = " + result);
    }
}
