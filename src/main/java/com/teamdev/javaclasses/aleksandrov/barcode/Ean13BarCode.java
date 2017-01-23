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

import java.util.Arrays;

import static com.teamdev.javaclasses.aleksandrov.barcode.Validation.checkEAN13Format;

/**
 * One dimensional barcode
 *
 * @author Alexander Aleksandrov
 */
public final class Ean13BarCode {
    private final int firstDigit;
    private final byte[] startPattern;
    private final byte[] firstGroup;
    private final byte[] middlePattern;
    private final byte[] lastGroup;
    private final int checksumDigit;
    private final byte[] endPattern;
    private static final byte[] START_PATTERN = {1, 0, 1};
    private static final byte[] MIDDLE_PATTERN = {0, 1, 0, 1, 0};
    private static final byte[] END_PATTERN = {1, 0, 1};

    public int getFirstDigit() {
        return firstDigit;
    }

    public byte[] getStartPattern() {
        return startPattern;
    }

    public byte[] getMiddlePattern() {
        return middlePattern;
    }

    public byte[] getEndPattern() {
        return endPattern;
    }

    public byte[] getFirstGroup() {
        return firstGroup;
    }

    public byte[] getLastGroup() {
        return lastGroup;
    }

    public int getChecksumDigit() {
        return checksumDigit;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int firstDigit;
        private byte[] leftGroup;
        private byte[] rightGroup;
        private int checksumDigit;
        private byte[] startPattern;
        private byte[] middlePattern;
        private byte[] endPattern;

        public Builder setFirstDigit(int digit) {
            firstDigit = digit;
            return this;
        }

        public Builder setStartPattern(byte[] startPatternGroup) {
            startPattern = startPatternGroup;
            return this;
        }

        public Builder setMiddlePattern(byte[] middlePatternGroup) {
            middlePattern = middlePatternGroup;
            return this;
        }

        public Builder setEndPattern(byte[] endPatternGroup) {
            endPattern = endPatternGroup;
            return this;
        }

        public Builder setFirstGroup(byte[] leftGroupDigits) {
            leftGroup = leftGroupDigits;
            return this;
        }

        public Builder setLastGroup(byte[] rightGroupDigits) {
            rightGroup = rightGroupDigits;
            return this;
        }

        public Builder setChecksumDigit(int checkSumDigit) {
            checksumDigit = checkSumDigit;
            return this;
        }

        public Ean13BarCode build() {
            return new Ean13BarCode(this);

        }
    }

    public Ean13BarCode(Builder builder) {
        this.firstDigit = builder.firstDigit;
        this.firstGroup = builder.leftGroup;
        this.lastGroup = builder.rightGroup;
        this.checksumDigit = builder.checksumDigit;
        this.startPattern = builder.startPattern;
        this.middlePattern = builder.middlePattern;
        this.endPattern = builder.endPattern;
    }

    /**
     * Obtains default instance of EAN13 barcode filled with zero values.
     */
    public static Ean13BarCode getDefaultInstance() {
        return parse("000000000000");
    }

    /**
     * Parse target string to barcode.
     *
     * @param str target string with barcode
     * @return EAN13 barcode instance
     */
    public static Ean13BarCode parse(String str) {
        checkEAN13Format(str);

        final String barcode = str.replaceAll("[^\\w]", "") + countCheckSum(str);
        int firstNumber = Integer.parseInt(str.substring(0, 1));
        final byte[] patterns = FirstDigitPattern.getSequence(firstNumber);
        int position = 0;
        final int maxEanModulesNumber = 95;
        byte[] barcodeBuffer = new byte[maxEanModulesNumber];

        for (int i = 1; i < barcode.length(); i++) {
            int num = Integer.parseInt(str.substring(i, i + 1));
            byte code = patterns[(i - 1)];
            if (code == 0) {
                position += appendData(GroupL.getSequence(num), barcodeBuffer, position);
            } else if (code == 1) {
               position += appendData(GroupG.getSequence(num), barcodeBuffer, position);
            } else {
                position += appendData(GroupR.getSequence(num), barcodeBuffer, position);
            }
        }

        return newBuilder().setFirstDigit(firstNumber).
                setStartPattern(START_PATTERN).
                setFirstGroup(Arrays.copyOfRange(barcodeBuffer, 0, 41)).
                setMiddlePattern(MIDDLE_PATTERN).
                setLastGroup(Arrays.copyOfRange(barcodeBuffer, 42, 84)).
                setEndPattern(END_PATTERN).
                setChecksumDigit(countCheckSum(str)).
                build();
    }

    private static int appendData(byte[] src, byte[] dst, int pos) {
        System.arraycopy(src, 0, dst, pos, src.length);
        return src.length;
    }

    /**
     * Converts barcode instance to string value.
     *
     * @param barCode EAN13 barcode
     * @return String view of information inside barcode
     */
    public String toString(Ean13BarCode barCode) {
        String result = String.valueOf(barCode.getFirstDigit()) +
                String.valueOf(barCode.getFirstGroup()) +
                String.valueOf(barCode.getLastGroup()) +
                String.valueOf(barCode.getChecksumDigit());
        return result;
    }

    public String fromBytes(byte[] barcode) {
        return "";
    }

    /**
     * Counts checksum digit for any one dimensional barcode.
     */
    private static int countCheckSum(String str) {
        int result = 0;
        char[] barcode = str.toCharArray();
        int i;
        for (i = 0; i < str.toCharArray().length; i++) {
            if (i % 2 == 0) {
                result += Integer.parseInt(String.valueOf(barcode[i]));
            } else {
                result += Integer.parseInt(String.valueOf(barcode[i])) * 3;
            }
        }
        return 10 - result % 10;
    }
}
