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

import com.teamdev.javaclasses.aleksandrov.calculator.parser.BinaryOperatorParser;
import com.teamdev.javaclasses.aleksandrov.calculator.parser.EndOfExpressionParser;
import com.teamdev.javaclasses.aleksandrov.calculator.parser.ExpressionParser;
import com.teamdev.javaclasses.aleksandrov.calculator.parser.NumberParser;
import com.teamdev.javaclasses.aleksandrov.calculator.finitestatemachine.StateRecognizer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParsingService implements StateRecognizer<
        ExpressionReader,
        EvaluationStack,
        CalculationState> {

    private final static Logger LOG = Logger.getLogger(StateRecognizer.class.getName());

    final private Map<CalculationState, ExpressionParser> parsers = new HashMap<CalculationState, ExpressionParser>() {{
        put(CalculationState.NUMBER, new NumberParser());
        put(CalculationState.BINARY_OPERATOR, new BinaryOperatorParser());
        put(CalculationState.FINISH, new EndOfExpressionParser());
    }};

    public boolean accept(ExpressionReader reader, EvaluationStack stack, CalculationState possibleState) {
        final ExpressionParser parser = parsers.get(possibleState);

        if (LOG.isLoggable(Level.INFO)) {
            LOG.info("Next posible state is: " + possibleState);
        }

        if (parser == null) {
            throw new IllegalStateException("ParserImpl not found for state: " + possibleState);
        }
        if (LOG.isLoggable(Level.INFO)) {
            LOG.info("Trying to parse by another parser");
        }
        return parser.parseExpression(reader, stack);
    }
}
