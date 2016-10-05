package com.teamdev.javaclasses.aleksandrov.calculator.parser;

import com.teamdev.javaclasses.aleksandrov.calculator.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryOperatorParser implements ExpressionParser {

    private final static Logger LOG = Logger.getLogger(BinaryOperatorParser.class.getName());
    private final BinaryOperatorRepository reposytory = new BinaryOperatorRepositoryInMemo();

    public boolean parseExpression(ExpressionReader reader, EvaluationStack stack) {

        if (reader.hasMoreToRead()) {
            final String expression = reader.getMathExpression();
            if (LOG.isLoggable(Level.FINE)) {
                LOG.fine("I'm in the BinaryOperator parser");
                LOG.fine("New expression : " + expression);
            }
            if (reposytory.getRepresentations().contains(expression)) {
                stack.pushOperator(reposytory.getBinaryOperator(expression));
                reader.setPosition(expression.length());
                return true;
            }
        }
        return false;
    }
}
