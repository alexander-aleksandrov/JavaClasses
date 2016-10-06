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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EvaluationStack {

    private final static Logger LOG = Logger.getLogger(EvaluationStack.class.getName());
    private final Deque<Double> argumentStack = new ArrayDeque<Double>();
    private final Deque<BinaryOperator> operatorStack = new ArrayDeque<BinaryOperator>();

    public void pushNumber(double number) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.info("The number was pushed to stack: " + number);
        }
        argumentStack.push(number);
    }

    public double popNumber() {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.info("The number was poped from stack: " + argumentStack.peek());
        }
        return argumentStack.pop();
    }

    public void pushOperator(BinaryOperator operator) {

        if (operatorStack.isEmpty() || operatorStack.peek().compareTo(operator) <= 0) {
            operatorStack.push(operator);
            if (LOG.isLoggable(Level.INFO)) {
                LOG.info("Pushed operator to stack: " + operator);
            }
            return;
        }

        if (!operatorStack.isEmpty() && operatorStack.peek().compareTo(operator) > 0) {
            double rightOperand = argumentStack.pop();
            double leftOperand = argumentStack.pop();
            double result = operatorStack.pop().calculate(leftOperand, rightOperand);
            if (LOG.isLoggable(Level.INFO)) {
                LOG.info("The result was pushed to stack: " + result);
            }
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
            if (LOG.isLoggable(Level.INFO)) {
                LOG.info("The result was pushed to stack: " + result);
            }
            argumentStack.push(result);
        }

    }

    public BinaryOperator popOperator() {
        return operatorStack.pop();
    }
}
