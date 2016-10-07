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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationStack {

    private static final Logger log = LoggerFactory.getLogger(EvaluationStack.class);
    private final Deque<Double> argumentStack = new ArrayDeque<Double>();
    private final Deque<BinaryOperator> operatorStack = new ArrayDeque<BinaryOperator>();

    public void pushNumber(double number) {
        log.info("The number was pushed to stack: " + number);
        argumentStack.push(number);
    }

    public double popNumber() {
        log.info("The number was poped from stack: " + argumentStack.peek());
        return argumentStack.pop();
    }

    public void pushOperator(BinaryOperator operator) {

        if (operatorStack.isEmpty() || operatorStack.peek().compareTo(operator) <= 0) {
            operatorStack.push(operator);
            log.info("Pushed operator to stack: " + operator);
            return;
        }

        if (!operatorStack.isEmpty() && operatorStack.peek().compareTo(operator) > 0) {
            double rightOperand = argumentStack.pop();
            double leftOperand = argumentStack.pop();
            double result = operatorStack.pop().calculate(leftOperand, rightOperand);
            log.info("The result was pushed to stack: " + result);
            argumentStack.push(result);
            operatorStack.push(operator);
            return;
        }

    }

    public void finalCalculation() {
        while (!operatorStack.isEmpty()) {
            double rightOperand = argumentStack.pop();
            double leftOperand = argumentStack.pop();
            double result = operatorStack.pop().calculate(leftOperand, rightOperand);
            log.info("The result was pushed to stack: " + result);
            argumentStack.push(result);
        }

    }

    public BinaryOperator popOperator() {
        return operatorStack.pop();
    }
}
