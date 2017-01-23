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
 * G-code for encoding digits
 *
 * @author Alexander Aleksandrov
 */
public enum GroupG {
    ZERO(new int[]{0, 1, 0, 0, 1, 1, 1}),
    ONE(new int[]{0, 1, 1, 0, 0, 1, 1}),
    TWO(new int[]{0, 0, 1, 1, 0, 1, 1}),
    THREE(new int[]{0, 1, 0, 0, 0, 0, 1}),
    FOUR(new int[]{0, 0, 1, 1, 1, 0, 1}),
    FIVE(new int[]{0, 1, 1, 1, 0, 0, 1}),
    SIX(new int[]{0, 0, 0, 0, 1, 0, 1}),
    SEVEN(new int[]{0, 0, 1, 0, 0, 0, 1}),
    EIGHT(new int[]{0, 0, 0, 1, 0, 0, 1}),
    NINE(new int[]{0, 0, 1, 0, 1, 1, 1});

    private final int[] code;

    GroupG(int[] code) {
        this.code = code;
    }

    public static int[] getSequence(int num){
        GroupG number = GroupG.values()[num];
        return number.getCode();
    }

    private int[] getCode() {
        return code;
    }
}
