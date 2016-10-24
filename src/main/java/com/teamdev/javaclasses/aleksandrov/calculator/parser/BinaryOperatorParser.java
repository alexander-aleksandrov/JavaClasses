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

import com.teamdev.javaclasses.aleksandrov.calculator.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A parser that takes expression and pushes Binary Operator to stack.
 *
 * @author Alexander Aleksandrov
 */
public class BinaryOperatorParser implements ExpressionParser {

    private static final Logger log = LoggerFactory.getLogger(BinaryOperatorParser.class);
    private final BinaryOperatorRepository reposytory = new BinaryOperatorRepositoryInMemory();

    /**
     * Returns boolean in case if expression was parsed correctly and pushes binary operator object to stack and changes current position in expression.
     *
     * @param reader {@link ExpressionReader} object
     * @param stack  {@link EvaluationStack} object
     * @return boolean
     */
    public boolean parseExpression(ExpressionReader reader, EvaluationStack stack) {
        if (reader.hasMoreToRead()) {
            final String expression = reader.getMathExpression();
            log.info("I'm in the BinaryOperator parser");
            log.info("New expression : " + expression);
            if (reposytory.getRepresentations().contains(expression)) {
                stack.pushOperator(reposytory.getBinaryOperator(expression));
                reader.setPosition(expression.length());
                return true;
            }
        }
        return false;
    }
}
