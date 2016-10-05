package com.teamdev.javaclasses.aleksandrov.timetoanglecalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClockHandsAngleCounterImplTest {
    @Test
    public void testGetAngleBetweenClockHands() throws Exception {
        ClockHandsAngleCalculator clocks = new ClockHandsAngleCalculatorImpl();
        double angle = clocks.getMinAngleBetweenClockHands(12, 10);
        double expected = 55.0;
        assertEquals("Angle should be: ", expected, angle, 0.1);
    }

    @Test
    public void hoursOutOfBoundShouldThrowException() throws Exception {
        ClockHandsAngleCalculator clocks = new ClockHandsAngleCalculatorImpl();
        boolean thrown = false;
        try {
            clocks.getMinAngleBetweenClockHands(25, 40);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void minutesOutOfBoundShouldThrowException() throws Exception {
        ClockHandsAngleCalculator clocks = new ClockHandsAngleCalculatorImpl();
        boolean thrown = false;
        try {
            clocks.getMinAngleBetweenClockHands(21, 61);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }


}
