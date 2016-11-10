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


import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class  that allows to work with phone number as value object.
 *
 * @author Alexander Aleksandrov
 */
public final class PhoneNumber {
    @Nullable
    private final CountryCode countryCode;
    @Nullable
    private final AreaCode areaCode;
    private final String phoneLineNumber;
    @Nullable
    private final String extensionNumber;

    /**
     * Gets  international country code.
     *
     * @return {@link CountryCode} enum
     */
    public CountryCode getCountryCode() {
        return countryCode;
    }

    /**
     * Gets  local to country area codes.
     *
     * @return {@link AreaCode} enum
     */
    public AreaCode getAreaCode() {
        return areaCode;
    }

    /**
     * Gets  phone line number.
     *
     * @return String with phone line number
     */
    public String getPhoneLineNumber() {
        return phoneLineNumber;
    }

    /**
     * Gets  Extension number.
     *
     * @return String with extension number
     */
    public String getExtensionNumber() {
        return extensionNumber;
    }

    public static Builder newPhoneNumber() {
        return new Builder();
    }

    /**
     * Builder  for Phone Number.
     */
    public static class Builder {
        private CountryCode countryCode;
        private AreaCode areaCode;
        private String phoneLineNumber;
        private String extensionNumber;

        /**
         * Sets  country code for this builder.
         *
         * @param cc {@link CountryCode} enum
         * @return this Builder
         */
        public Builder setCountryCode(CountryCode code) {
            countryCode = code;
            return this;
        }

        /**
         * Sets  area code for this builder.
         *
         * @param ac {@link AreaCode} enum
         * @return this Builder
         */
        public Builder setAreaCode(AreaCode ac) {
            areaCode = ac;
            return this;
        }

        /**
         * Sets  phone line number for this builder.
         *
         * @param ln String with digits of line number
         * @return this Builder
         */
        public Builder setPhoneLineNumber(String ln) {
            phoneLineNumber = ln;
            return this;
        }

        /**
         * Sets  extension number for this builder.
         *
         * @param ex String with digits of extension number
         * @return this Builder
         */
        public Builder setExtension(String ex) {
            extensionNumber = ex;
            return this;
        }

        /**
         * Calls  constructor and passes itself to it.
         *
         * @return {@link PhoneNumber} object
         */
        public PhoneNumber build() {
            return new PhoneNumber(this);
        }
    }

    private PhoneNumber(Builder builder) {
        this.countryCode = builder.countryCode;
        this.areaCode = builder.areaCode;
        this.phoneLineNumber = builder.phoneLineNumber;
        this.extensionNumber = builder.extensionNumber;

    }

    /**
     * Creates  a new phone number instance.
     *
     * @param input Any input from client
     * @return Phone Number
     * @throws ParseException
     */
    public static PhoneNumber parse(String input) throws ParseException {
        Iterable<String> phoneSplit = Splitter.on(CharMatcher.anyOf("-)("))
                .omitEmptyStrings().trimResults().split(input);
        String countryCode = Iterables.get(phoneSplit, 0);
        String areaCode = Iterables.get(phoneSplit, 1);
        String lineNumber = Iterables.get(phoneSplit, 2) + Iterables.get(phoneSplit, 3) + Iterables.get(phoneSplit, 4);
        System.out.println(countryCode + " " + areaCode + " " + lineNumber);

        PhoneNumber ph = newPhoneNumber().setCountryCode(CountryCode.contains(countryCode)).setAreaCode(AreaCode.contains(areaCode)).build();
        return ph;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
