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
package com.teamdev.javaclasses.aleksandrov.barcode;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Describes dependency of encoding patterns from first digit used in EAN13.
 *
 * 0 - is used for GroupL patterns
 * 1 - for GroupG patterns
 * 2 - for GroupR patterns
 * @author Alexander Aleksandrov
 */
public enum FirstDigitPattern {
    ZERO(new byte[]{0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2}),
    ONE(new byte[]{0, 0, 1, 0, 1, 1, 2, 2, 2, 2, 2, 2}),
    TWO(new byte[]{0, 0, 1, 1, 0, 1, 2, 2, 2, 2, 2, 2}),
    THREE(new byte[]{0, 0, 1, 1, 1, 0, 2, 2, 2, 2, 2, 2}),
    FOUR(new byte[]{0, 1, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2}),
    FIVE(new byte[]{0, 1, 1, 0, 0, 1, 2, 2, 2, 2, 2, 2}),
    SIX(new byte[]{0, 1, 1, 1, 0, 0, 2, 2, 2, 2, 2, 2}),
    SEVEN(new byte[]{0, 1, 0, 1, 0, 1, 2, 2, 2, 2, 2, 2}),
    EIGHT(new byte[]{0, 1, 0, 1, 1, 0, 2, 2, 2, 2, 2, 2}),
    NINE(new byte[]{0, 1, 1, 0, 1, 0, 2, 2, 2, 2, 2, 2});


    private byte[] pattern;

    FirstDigitPattern(byte[] pattern) {
        this.pattern = pattern;
    }

    public static byte[] getSequence(int num) {
        FirstDigitPattern number = FirstDigitPattern.values()[num];
        return number.getPattern();
    }

    private byte[] getPattern() {
        return pattern;
    }
}
