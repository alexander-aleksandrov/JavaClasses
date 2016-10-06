/*
 * Copyright 2016, TeamDev Ltd. All rights reserved.
 *
 * Redistribution and use in source and/or binary forms, with or without
 * modification, must retain the above copyright notice and the following
 * disclaimer.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.teamdev.javaclasses.aleksandrov.timetoanglecalculator;

public class ClockHandsAngleCalculatorImpl implements ClockHandsAngleCalculator {
    public double getMinAngleBetweenClockHands(int hours24Format, int minutes) {


        if (hours24Format > 24 | hours24Format < 0) {
            throw new IllegalArgumentException("Number of hours should be in a range from 0 to 24");
        }
        if (minutes > 60 | minutes < 0) {
            throw new IllegalArgumentException("Number of minutes should be in a range from 0 to 60");
        }

        int hours = hours24Format % 12;

        double hourHandAngle = hours * 30 + minutes * 0.5;
        double minuteHandAngle = minutes * 6;

        double angle = Math.abs(hourHandAngle - minuteHandAngle);
        return angle;

    }


}
