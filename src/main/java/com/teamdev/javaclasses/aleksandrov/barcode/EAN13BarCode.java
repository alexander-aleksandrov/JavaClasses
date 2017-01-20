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

import static com.teamdev.javaclasses.aleksandrov.barcode.Validation.checkEAN13Format;
import static java.lang.Integer.valueOf;

/**
 * One dimensional barcode
 *
 * @author Alexander Aleksandrov
 */
public final class EAN13BarCode {
    private final int firstDigit;
    private final int leftGroup;
    private final int rightGroup;
    private final int checksumDigit;

    public int getFirstDigit() {
        return firstDigit;
    }

    public int getLeftGroup() {
        return leftGroup;
    }

    public int getRightGroup() {
        return rightGroup;
    }

    public int getChecksumDigit() {
        return checksumDigit;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int firstDigit;
        private int leftGroup;
        private int rightGroup;
        private int checksumDigit;

        public Builder setFirstDigit(int digit) {
            firstDigit = digit;
            return this;
        }

        public Builder setLeftGroup(int leftGroupDigits) {
            leftGroup = leftGroupDigits;
            return this;
        }

        public Builder setRightGroup(int rightGroupDigits) {
            rightGroup = rightGroupDigits;
            return this;
        }

        public Builder setChecksumDigit(int checkSumDigit) {
            checksumDigit = checkSumDigit;
            return this;
        }

        public EAN13BarCode build() {
            return new EAN13BarCode(this);

        }
    }

    public EAN13BarCode(Builder builder) {
        this.firstDigit = builder.firstDigit;
        this.leftGroup = builder.leftGroup;
        this.rightGroup = builder.rightGroup;
        this.checksumDigit = builder.checksumDigit;
    }

    public static EAN13BarCode getDefaultInstance() {
        return EAN13BarCode.newBuilder().setFirstDigit(0).
                setLeftGroup(000000).
                setRightGroup(00000).
                setChecksumDigit(0).
                build();
    }

    public static EAN13BarCode parse(String str) {
        checkEAN13Format(str);

        String barcode = str.replaceAll("[^\\w]", "");
        return EAN13BarCode.newBuilder().setFirstDigit(Integer.parseInt(barcode.substring(0, 1))).
                setLeftGroup(Integer.parseInt(barcode.substring(1, 7))).
                setRightGroup(Integer.parseInt(barcode.substring(7, 12))).
                setChecksumDigit(countCheckSum(barcode)).
                build();
    }

    public String toString(EAN13BarCode barCode) {
        String result = String.valueOf(barCode.getFirstDigit()) +
                String.valueOf(barCode.getLeftGroup()) +
                String.valueOf(barCode.getRightGroup()) +
                String.valueOf(barCode.getChecksumDigit());
        return result;
    }

    public static int countCheckSum(String string) {
        int result = 0;
        char[] barcode = string.toCharArray();
        int i;
        for (i = 0; i < string.toCharArray().length; i++) {
            if (i % 2 == 0) {
                result += Integer.parseInt(String.valueOf(barcode[i]));
            }else {
                result += Integer.parseInt(String.valueOf(barcode[i])) * 3;
            }
        }
        return 10 - result % 10;
    }
}
