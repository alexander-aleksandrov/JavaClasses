package com.teamdev.javaclasses.aleksandrov.calculator;


public interface MathExpressionCalculator {
    double evaluate(String equation) throws IncorrectEvaluationException;
}
