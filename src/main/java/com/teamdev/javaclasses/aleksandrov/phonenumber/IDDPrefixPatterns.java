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
 * An international dialling code (or prefix) is used to make an international phone call out of a country. These codes are also referred to as international access codes, international direct dialling (IDDPrefixPatterns) codes and exit codes.
 *
 * @author Alexander Aleksandrov
 */
public enum IDDPrefixPatterns {
    UNDEFINED("", ""),
    A("01[0-9]", "01?"),
    B("00[0-9][0-9][0-9]", "00???"),
    C("8[0-9][0-9]", "8??"),
    D("1[0-9][0-9]0", "1??0"),
    E("99[0-9][0-9]", "99??");

    private final String iddPrefixRegex;
    private final String iddPrefix;

    private IDDPrefixPatterns(String iddPrefixRegex, String iddPrefix) {
        this.iddPrefixRegex = iddPrefixRegex;
        this.iddPrefix = iddPrefix;
    }

    /**
     * Gets international direct dialing regex.
     *
     * @return regular expression for IDD code
     */
    public String getIDDPrefixRegex() {
        return iddPrefixRegex;
    }

    /**
     * Gets international direct dialing prefix code from a record.
     *
     * @return example of IDD code
     */
    public String getIDDPrefix() {
        return iddPrefix;
    }

    /**
     * Searches for records based on regular expression.
     *
     * @param input a part of a number
     * @return a list of country calling codes
     */
    public static List<IDDPrefixPatterns> findIDDCode(String input) {
        List<IDDPrefixPatterns> list = new ArrayList<IDDPrefixPatterns>();
        for (IDDPrefixPatterns entry : values()) {
            if (Pattern.matches(entry.getIDDPrefixRegex(), input)) {
                list.add(entry);
            }

        }
        return list;
    }
}
