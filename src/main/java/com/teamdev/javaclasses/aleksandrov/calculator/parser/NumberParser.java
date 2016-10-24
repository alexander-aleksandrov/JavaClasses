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
package com.teamdev.javaclasses.aleksandrov.calculator.parser;

import com.teamdev.javaclasses.aleksandrov.calculator.EvaluationStack;
import com.teamdev.javaclasses.aleksandrov.calculator.ExpressionReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A parser that takes a chunk of expression and pushes it to number stack.
 *
 * @author Alexander Aleksandrov
 */
public class NumberParser implements ExpressionParser {

    private static final Logger log = LoggerFactory.getLogger(NumberParser.class);

    /**
     * Returns true after a number was pushed to {@link EvaluationStack} and sets a new position to expression reader.
     *
     * @param reader {@link ExpressionReader} object
     * @param stack  {@link EvaluationStack} object
     * @return
     */
    public boolean parseExpression(ExpressionReader reader, EvaluationStack stack) {
        log.info("I'm in the number parser");
        final String expression = reader.getMathExpression();
        final Double number = Double.valueOf(expression);
        stack.pushNumber(number);
        reader.setPosition(expression.length());
        return true;
    }
}
