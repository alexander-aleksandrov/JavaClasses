package com.teamdev.javaclasses.aleksandrov.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MathExpressionCalculatorImplTest {

    private String mathEquation;
    private double expectedResult;
    private final MathExpressionCalculator calculator = new FSMCalculator();

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0.0, "0"},
                {1.0, "1"},
                {2.0, "2"}
        });
    }

    public MathExpressionCalculatorImplTest(double expectedResult, String mathEquation) {
        this.mathEquation = mathEquation;
        this.expectedResult = expectedResult;
    }

    @Test
    public void singleNumberTest() throws Exception {
        assertEquals(expectedResult, calculator.evaluate(mathEquation), 0.0);
    }
}

