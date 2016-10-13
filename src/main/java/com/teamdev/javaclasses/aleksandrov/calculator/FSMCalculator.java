package com.teamdev.javaclasses.aleksandrov.calculator;

import com.teamdev.javaclasses.aleksandrov.calculator.finitestatemachine.MachineRunner;

public class FSMCalculator extends MachineRunner<
        Double,
        CalculationState,
        ExpressionReader,
        EvaluationStack,
        ParsingService,
        CalculatorTransitions> implements MathExpressionCalculator {

    public FSMCalculator() {
        super(new CalculatorTransitions(), new ParsingService());
    }

    public double evaluate(String equation) throws IncorrectEvaluationException {
        return move(new ExpressionReader(equation), new EvaluationStack());
    }

    @Override
    protected void deadlock(ExpressionReader expressionReader) {
        throw new IllegalStateException("Syntax error at position " + expressionReader.getPosition());
    }

    @Override
    protected Double prepareResult(EvaluationStack evaluationStack) {
        return evaluationStack.popNumber();
    }

    public static void main(String[] args) throws Exception {

        final double result = new FSMCalculator().evaluate("6*3/3");
        System.out.println("result = " + result);
    }
}
