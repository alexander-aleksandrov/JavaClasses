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

/**
 * Expression  container that allows to work with it.
 *
 * @author Alexander Aleksandrov
 */
public class ExpressionReader {

    private final String mathExpression;
    private static final Logger log = LoggerFactory.getLogger(ExpressionReader.class);
    private int position = 0;

    /**
     * Constructor  that takes expression String as parameter.
     *
     * @param mathExpression
     */
    public ExpressionReader(String mathExpression) {
        this.mathExpression = mathExpression;
    }

    /**
     * Gets  a current position in expression.
     *
     * @return
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets  the position of current symbol in expression ro specific value.
     *
     * @param newposition
     */
    public void setPosition(int newposition) {
        this.position = position + newposition;
    }

    /**
     * Parse  the expression and passes a chunk of expression either it will be a number or a binary operator.
     *
     * @return String with next part of expression
     */
    public String getMathExpression() {
        log.info("Current position is: " + getPosition());
        String remainedExpression = mathExpression.substring(getPosition());

        log.info("remainedExpression is: " + remainedExpression);

        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (char c : remainedExpression.toCharArray()) {

            if (Character.isDigit(c)) {
                sb.append(c);
                found = true;
            } else if (found) {
                break;
            }
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                sb.append(c);
                break;
            }

        }
        String newExpression = sb.toString();
        log.info("Reader gives a String:" + newExpression);
        return newExpression;

    }

    /**
     * Return  true in case if there a still has something to read in expression.
     *
     * @return boolean
     */
    public boolean hasMoreToRead() {
        return position < mathExpression.length() - 1;
    }
}
