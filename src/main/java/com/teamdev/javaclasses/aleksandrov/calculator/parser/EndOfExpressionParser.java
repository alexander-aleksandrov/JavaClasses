package com.teamdev.javaclasses.aleksandrov.calculator.parser;

import com.teamdev.javaclasses.aleksandrov.calculator.EvaluationStack;
import com.teamdev.javaclasses.aleksandrov.calculator.ExpressionReader;

public class EndOfExpressionParser implements ExpressionParser {

    public boolean parseExpression(ExpressionReader reader, EvaluationStack stack) {
        stack.finalCalculation();
        return !reader.hasMoreToRead();
    }
}
