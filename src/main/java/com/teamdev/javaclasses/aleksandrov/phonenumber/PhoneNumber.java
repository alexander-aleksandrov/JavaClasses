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

import com.sun.istack.internal.Nullable;

import java.text.ParseException;

/**
 * A class that allows to work with phone number as value object.
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
     * Gets international country code.
     *
     * @return {@link CountryCode} enum
     */
    public CountryCode getCountryCode() {
        return countryCode;
    }

    /**
     * Gets local to country area codes.
     *
     * @return {@link AreaCode} enum
     */
    public AreaCode getAreaCode() {
        return areaCode;
    }

    /**
     * Gets phone line number.
     *
     * @return String with phone line number
     */
    public String getPhoneLineNumber() {
        return phoneLineNumber;
    }

    /**
     * Gets Extension number.
     *
     * @return String with extension number
     */
    public String getExtensionNumber() {
        return extensionNumber;
    }

    public static PhoneNumber.Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for Phone Number.
     */
    public static class Builder {
        private CountryCode countryCode;
        private AreaCode areaCode;
        private String phoneLineNumber;
        private String extensionNumber;

        /**
         * Sets country code for this builder.
         *
         * @param cc {@link CountryCode} enum
         * @return this Builder
         */
        public Builder setCountryCode(CountryCode cc) {
            countryCode = cc;
            return this;
        }

        /**
         * Sets area code for this builder.
         *
         * @param ac {@link AreaCode} enum
         * @return this Builder
         */
        public Builder setAreaCode(AreaCode ac) {
            areaCode = ac;
            return this;
        }

        /**
         * Sets phone line number for this builder.
         *
         * @param ln String with digits of line number
         * @return this Builder
         */
        public Builder setPhoneLineNumber(String ln) {
            phoneLineNumber = ln;
            return this;
        }

        /**
         * Sets extension number for this builder.
         *
         * @param ex String with digits of extension number
         * @return this Builder
         */
        public Builder setExtension(String ex) {
            extensionNumber = ex;
            return this;
        }

        /**
         * Calls constructor and passes itself to it.
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
     *  Creates a new phone number instance.
     *
     * @return {@link PhoneNumber} object
     */
    public static PhoneNumber newPhoneNumber() {

        CountryCode cc = CountryCode.valueOf();
        PhoneNumber ph = PhoneNumber.newBuilder()
                .setCountryCode()
                .setAreaCode()
                .setPhoneLineNumber()
                .setExtension()
                .build();
        return ph;
    }

    public final static PhoneNumber parse(String input) throws ParseException {
        input.toCharArray();
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    public static void main(String[] args) {
        String phoneNumber = "+38065864578";

        try {
            parse(phoneNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
