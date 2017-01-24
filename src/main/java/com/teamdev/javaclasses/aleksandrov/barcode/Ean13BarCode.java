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
import static com.teamdev.javaclasses.aleksandrov.barcode.Validation.checkScannedBarcode;

/**
 * One dimensional barcode
 *
 * @author Alexander Aleksandrov
 */
@SuppressWarnings("MagicNumber")
public final class Ean13BarCode {
    private final int firstDigit;
    private final int[] startPattern;
    private final int[] firstGroup;
    private final int[] middlePattern;
    private final int[] lastGroup;
    private final int checksumDigit;
    private final int[] endPattern;
    private static final int[] START_PATTERN = {1, 0, 1};
    private static final int[] MIDDLE_PATTERN = {0, 1, 0, 1, 0};
    private static final int[] END_PATTERN = {1, 0, 1};

    public int getFirstDigit() {
        return firstDigit;
    }

    public int[] getStartPattern() {
        return startPattern;
    }

    public int[] getMiddlePattern() {
        return middlePattern;
    }

    public int[] getEndPattern() {
        return endPattern;
    }

    public int[] getFirstGroup() {
        return firstGroup;
    }

    public int[] getLastGroup() {
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
        private int[] leftGroup;
        private int[] rightGroup;
        private int checksumDigit;
        private int[] startPattern;
        private int[] middlePattern;
        private int[] endPattern;

        public Builder setFirstDigit(int digit) {
            firstDigit = digit;
            return this;
        }

        public Builder setStartPattern(int[] startPatternGroup) {
            startPattern = startPatternGroup;
            return this;
        }

        public Builder setMiddlePattern(int[] middlePatternGroup) {
            middlePattern = middlePatternGroup;
            return this;
        }

        public Builder setEndPattern(int[] endPatternGroup) {
            endPattern = endPatternGroup;
            return this;
        }

        public Builder setFirstGroup(int[] leftGroupDigits) {
            leftGroup = leftGroupDigits;
            return this;
        }

        public Builder setLastGroup(int[] rightGroupDigits) {
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
        final int[] patterns = FirstDigitPattern.getSequence(firstNumber);
        int position = 0;
        final int maxEanModulesNumber = 1000;
        int[] barcodeBuffer = new int[maxEanModulesNumber];

        for (int i = 1; i < barcode.length(); i++) {
            int num = 0;
            if (i == 12) {
                num = Integer.parseInt(barcode.substring(i));
            } else {
                num = Integer.parseInt(barcode.substring(i, i + 1));
            }
            int code = patterns[(i - 1)];
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
                setFirstGroup(Arrays.copyOfRange(barcodeBuffer, 0, 42)).
                setMiddlePattern(MIDDLE_PATTERN).
                setLastGroup(Arrays.copyOfRange(barcodeBuffer, 42, 84)).
                setEndPattern(END_PATTERN).
                setChecksumDigit(countCheckSum(str)).
                build();
    }

    private static int appendData(int[] src, int[] dst, int pos) {
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

        return String.valueOf(barCode.getFirstDigit()) +
                groupToString(barCode.getFirstGroup()) +
                groupToString(barCode.getLastGroup());
    }

    public static String groupToString(int[] group) {
        int i = 0;
        StringBuilder builder = new StringBuilder();
        for (i = 0; i < group.length; i = i + 7) {
            builder.append(getNumberFromSequence((Arrays.copyOfRange(group, i, i + 7))));
        }
        return builder.toString();
    }

    /**
     * Converts barcode binary sequence to string value.
     *
     * @param barcode EAN13 barcode binary sequence
     * @return String view of information inside barcode
     */
    public static Ean13BarCode fromScanner(int[] barcode) {
        checkScannedBarcode(barcode);

        int firstDigit = getFirstDigitFromSequence(Arrays.copyOfRange(barcode, 3, 45));
        int checkSumDigit = getCheckSumDigitFromSequence(Arrays.copyOfRange(barcode, 85, 92));

        return newBuilder().setFirstDigit(firstDigit).
                setStartPattern(START_PATTERN).
                setFirstGroup(Arrays.copyOfRange(barcode, 3, 45)).
                setMiddlePattern(MIDDLE_PATTERN).
                setLastGroup(Arrays.copyOfRange(barcode, 50, 92)).
                setEndPattern(END_PATTERN).
                setChecksumDigit(checkSumDigit).
                build();
    }

    private static int getFirstDigitFromSequence(int[] sequence) {
        int[] firstDigitSequence = new int[7];
        int i;
        int j = 0;
        int firstDigit = 0;

        for (i = 0; i < sequence.length; i = i + 6) {
            firstDigitSequence[j] = getGroupType(Arrays.copyOfRange(sequence, i, i + 6));
            ++j;
        }

        int k = 0;
        for (k = 0; k < 9; k++) {
            if (Arrays.equals(FirstDigitPattern.getSequence(k), firstDigitSequence)) {
                firstDigit = k;
                break;
            }
        }
        return firstDigit;
    }

    private static int getCheckSumDigitFromSequence(int[] sequence) {
        int i = 0;
        int number = 0;
        for (i = 0; i < 9; i++) {
            if (Arrays.equals(GroupR.getSequence(i), sequence)) {
                number = i;
                break;
            }
        }
        return number;
    }

    private static int getGroupType(int[] sequence) {
        int i = 0;
        int group = 0;
        for (i = 0; i < 9; i++) {
            if (Arrays.equals(GroupL.getSequence(i), sequence)) {
                group = 0;
                break;
            }
        }
        i = 0;
        for (i = 0; i < 9; i++) {
            if (Arrays.equals(GroupG.getSequence(i), sequence)) {
                group = 1;
                break;
            }
        }
        return group;
    }

    private static int getNumberFromSequence(int[] sequence) {
        int i = 0;
        int number = 0;
        for (i = 0; i <= 9; i++) {
            if (Arrays.equals(GroupL.getSequence(i), sequence)) {
                number = i;
                break;
            }
        }
        i = 0;
        for (i = 0; i <= 9; i++) {
            if (Arrays.equals(GroupG.getSequence(i), sequence)) {
                number = i;
                break;
            }
        }
        i= 0;
        for (i = 0; i <= 9; i++) {
            if (Arrays.equals(GroupR.getSequence(i), sequence)) {
                number = i;
                break;
            }
        }
        return number;
    }


    /**
     * Counts checksum digit for any one dimensional barcode.
     */
    private static int countCheckSum(String str) {
        int result = 0;
        char[] barcode = str.toCharArray();
        int i;
        for (i = 0; i < barcode.length; i++) {
            if (i % 2 == 0) {
                result += Integer.parseInt(String.valueOf(barcode[i]));
            } else {
                result += Integer.parseInt(String.valueOf(barcode[i])) * 3;
            }
        }
        if (result % 10 == 0) {
            result = 0;
        } else {
            result = 10 - (result % 10);
        }
        return result;
    }
}
