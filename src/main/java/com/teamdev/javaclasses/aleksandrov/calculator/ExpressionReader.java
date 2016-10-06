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

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpressionReader {

    final private String mathExpression;
    private final static Logger LOG = Logger.getLogger(ExpressionReader.class.getName());
    private int position = 0;

    public ExpressionReader(String mathExpression) {
        this.mathExpression = mathExpression;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newposition) {
        this.position = position + newposition;
    }

    public String getMathExpression() {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.info("Current position is: " + getPosition());
        }
        String remainedExpression = mathExpression.substring(getPosition());

        if (LOG.isLoggable(Level.INFO)) {
            LOG.info("remainedExpression is: " + remainedExpression);
        }

        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (char c : remainedExpression.toCharArray()) {

            if (Character.isDigit(c)) {
                sb.append(c);
                found = true;
            } else if (found) {
                break;
            }

            if (c=='+'||c=='-'||c=='*'||c=='/'){
                sb.append(c);
                break;
            }

        }
        String newExpression = sb.toString();
        if (LOG.isLoggable(Level.INFO)) {
            LOG.info("Reader gives a String:" + newExpression);
        }
        return newExpression;

    }



    public boolean hasMoreToRead() {
        return position < mathExpression.length() - 1;
    }
}
