package com.teamdev.javaclasses.aleksandrov.calculator;

public class IncorrectEvaluationException extends Exception {

    private final int errorPosition;

    public IncorrectEvaluationException(String message, int errorPosition) {
        super(message);
        this.errorPosition = errorPosition;
    }

    public int getErrorPosition() {
        return errorPosition;
    }
}
