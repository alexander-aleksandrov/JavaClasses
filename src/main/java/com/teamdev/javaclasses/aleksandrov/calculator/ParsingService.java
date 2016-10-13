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
