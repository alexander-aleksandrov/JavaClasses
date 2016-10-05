package com.teamdev.javaclasses.aleksandrov.calculator.parser;

import com.teamdev.javaclasses.aleksandrov.calculator.EvaluationStack;
import com.teamdev.javaclasses.aleksandrov.calculator.ExpressionReader;

public interface ExpressionParser {

    boolean parseExpression(ExpressionReader reader, EvaluationStack stack);

}
