package com.teamdev.javaclasses.aleksandrov.timetoanglecalculator;

public class ClockHandsAngleCalculatorImpl implements ClockHandsAngleCalculator {
    public double getMinAngleBetweenClockHands(int hours24Format, int minutes) {


        if (hours24Format > 24 | hours24Format < 0){
            throw new IllegalArgumentException("Number of hours should be in a range from 0 to 24");
        }
        if (minutes > 60 | minutes < 0){
            throw new IllegalArgumentException("Number of minutes should be in a range from 0 to 60");
        }

        int hours = hours24Format % 12;

        double hourHandAngle = hours*30 + minutes*0.5;
        double minuteHandAngle = minutes*6;

        double angle = Math.abs(hourHandAngle - minuteHandAngle);
        return angle;

    }


}
