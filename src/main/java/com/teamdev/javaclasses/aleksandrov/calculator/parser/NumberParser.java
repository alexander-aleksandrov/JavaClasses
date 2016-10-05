package com.teamdev.javaclasses.aleksandrov.calculator.parser;

import com.teamdev.javaclasses.aleksandrov.calculator.EvaluationStack;
import com.teamdev.javaclasses.aleksandrov.calculator.ExpressionReader;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NumberParser implements ExpressionParser {

    private final static Logger LOG = Logger.getLogger(NumberParser.class.getCanonicalName());

    public boolean parseExpression(ExpressionReader reader, EvaluationStack stack) {


        if (LOG.isLoggable(Level.INFO)) {
            LOG.info("I'm in the number parser");
        }

        final String expression = reader.getMathExpression();

        final Double number = Double.valueOf(expression);

        stack.pushNumber(number);

        reader.setPosition(expression.length());

        return true;


    }
}
