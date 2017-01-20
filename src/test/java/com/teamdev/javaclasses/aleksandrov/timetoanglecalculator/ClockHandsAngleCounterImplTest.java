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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClockHandsAngleCounterImplTest {
    @Test
    public void testGetAngleBetweenClockHands() throws Exception {
        ClockHandsAngleCalculator clocks = new ClockHandsAngleCalculatorImpl();
        double angle = clocks.getMinAngleBetweenClockHands(12, 10);
        double expected = 55.0;
        assertEquals(expected, angle, "Angle should be: ");
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
