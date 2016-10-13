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
