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

/**
 * R-code for encoding digits.
 *
 * @author Alexander Aleksandrov
 */
public enum GroupR {
    ZERO(new int[]{1, 1, 1, 0, 0, 1, 0}),
    ONE(new int[]{1, 1, 0, 0, 1, 1, 0}),
    TWO(new int[]{1, 1, 0, 1, 1, 0, 0}),
    THREE(new int[]{1, 0, 0, 0, 0, 1, 0}),
    FOUR(new int[]{1, 0, 1, 1, 1, 0, 0}),
    FIVE(new int[]{1, 0, 0, 1, 1, 1, 0}),
    SIX(new int[]{1, 0, 1, 0, 0, 0, 0}),
    SEVEN(new int[]{1, 0, 0, 0, 1, 0, 0}),
    EIGHT(new int[]{1, 0, 0, 1, 0, 0, 0}),
    NINE(new int[]{1, 1, 1, 0, 1, 0, 0});

    private final int[] code;

    GroupR(int[] code) {
        this.code = code;
    }

    public static int[] getSequence(int num){
        GroupR number = GroupR.values()[num];
        return number.getCode();
    }

    private int[] getCode() {
        return code;
    }
}
