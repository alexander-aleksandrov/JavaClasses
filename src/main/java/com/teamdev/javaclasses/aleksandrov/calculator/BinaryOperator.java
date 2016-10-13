package com.teamdev.javaclasses.aleksandrov.calculator;

public interface BinaryOperator<O extends BinaryOperator> extends Comparable<O> {

    double calculate(double leftOperand, double rightOperand);
}
