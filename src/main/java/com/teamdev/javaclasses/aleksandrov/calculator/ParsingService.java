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

import com.google.common.collect.ImmutableMap;
import com.teamdev.javaclasses.aleksandrov.calculator.finitestatemachine.StateRecognizer;
import com.teamdev.javaclasses.aleksandrov.calculator.parser.BinaryOperatorParser;
import com.teamdev.javaclasses.aleksandrov.calculator.parser.EndOfExpressionParser;
import com.teamdev.javaclasses.aleksandrov.calculator.parser.ExpressionParser;
import com.teamdev.javaclasses.aleksandrov.calculator.parser.NumberParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation  of {@link StateRecognizer} allows to chose specific state and run a parser for it.
 *
 * @author Oleg Melnik
 * @author Alexander Aleksandrov
 */
public class ParsingService implements StateRecognizer<
        ExpressionReader,
        EvaluationStack,
        CalculationState> {

    private static final Logger log = LoggerFactory.getLogger(ParsingService.class);

    static final ImmutableMap<CalculationState, ExpressionParser> parsers =
            new ImmutableMap.Builder<CalculationState, ExpressionParser>()
                    .put(CalculationState.NUMBER, new NumberParser())
                    .put(CalculationState.BINARY_OPERATOR, new BinaryOperatorParser())
                    .put(CalculationState.FINISH, new EndOfExpressionParser())
                    .build();

    /**
     * Returns  true in case if state parser was run well.
     *
     * @param reader        {@link ExpressionReader} object
     * @param stack         {@link EvaluationStack} object
     * @param possibleState {@link CalculationState} object
     * @return boolean
     */
    public boolean accept(ExpressionReader reader, EvaluationStack stack, CalculationState possibleState) {
        final ExpressionParser parser = parsers.get(possibleState);
        log.info("Next posible state is: " + possibleState);
        if (parser == null) {
            throw new IllegalStateException("ParserImpl not found for state: " + possibleState);
        }
        log.info("Trying to parse by another parser");
        return parser.parseExpression(reader, stack);
    }
}
