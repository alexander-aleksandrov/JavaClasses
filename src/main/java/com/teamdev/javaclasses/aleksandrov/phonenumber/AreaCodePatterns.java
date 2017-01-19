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
package com.teamdev.javaclasses.aleksandrov.phonenumber;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Area codes for countries that have not fixed area code length.
 *
 * @author Alexander Aleksandrov
 */
public enum AreaCodePatterns {
    EG(new String[]{"1[0-9][0-9]", "16[0-9][0-9][0-9]", "19[0-9][0-9][0-9]", "0777", "0707", "0800", "0900", "010", "011", "012", "2", "3", "13", "15", "40", "45", "46", "47", "48", "50", "55", "57", "62", "64", "65", "66", "68", "69", "82", "84", "86", "88", "92", "93", "95", "96", "97"}, CountryCode.EG),
    MA(new String[]{"52[2-9][2-9]", "52[0|1|5]", "53[2-9][2-9]", "53[0|1|2]", "52[2-9][2-9][0]", "53[2-9][2-9][0]", "6[0-9][0-9]"}, CountryCode.MA),
    LY(new String[]{"[2-9][0-9][0-9]", "9[1-2]"}, CountryCode.LY),
    ML(new String[]{"6|7", "20[2]", "207[0-9]", "21[2-9]", "212[6-7]", "44[1|2|3|9]", "9[0-9]", "8[2|3|9]"}, CountryCode.ML),
    CI(new String[]{"[4-7][0-9]", "[2-3][0-9][0-9]"}, CountryCode.CI);


    private String[] areaCodeRegex;
    private CountryCode countryCode;

    AreaCodePatterns(String[] areaCodeRegex, CountryCode countryCode) {
        this.countryCode = countryCode;
        this.areaCodeRegex = areaCodeRegex;
    }

    /**
     * Gets area code from a record.
     *
     * @return String with a area code
     */
    private String[] getAreaCodeRegex() {
        return areaCodeRegex;
    }

    /**
     * Searches for area code record based on regular expression.
     *
     * @param input a part of a number
     * @return a list of country calling codes
     */
    public static List<String> findAreaCode(String input, CountryNumberingPlan countryNumberingPlan) {
        List<String> list = new ArrayList<>();
        String countryName = countryNumberingPlan.getCountryCode().getAlpha2();
        AreaCodePatterns areaOfSearch = AreaCodePatterns.valueOf(countryName);
        for (String regex : areaOfSearch.getAreaCodeRegex()) {
            if (Pattern.matches(regex, input)) {
                list.add(regex);
            }
        }

        return list;
    }
}
