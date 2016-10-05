package com.teamdev.javaclasses.aleksandrov.timetoanglecalculator;

public class Main {

    public static void main(String[] args) {
        ClockHandsAngleCalculator clocks = new ClockHandsAngleCalculatorImpl();
        double angle = clocks.getMinAngleBetweenClockHands(15, 5);
        System.out.println(angle);

    }
}
