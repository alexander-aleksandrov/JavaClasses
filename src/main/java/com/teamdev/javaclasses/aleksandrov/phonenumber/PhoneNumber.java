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

public final class PhoneNumber {
    @Nullable
    private final CountryCode countryCode;
    @Nullable
    private final AreaCode areaCode;
    private final String phoneLineNumber;
    @Nullable
    private final String extensionNumber;

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public AreaCode getAreaCode() {
        return areaCode;
    }

    public String getPhoneLineNumber() {
        return phoneLineNumber;
    }

    public String getExtensionNumber() {
        return extensionNumber;
    }

    public static PhoneNumber.Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private CountryCode countryCode;
        private AreaCode areaCode;
        private String phoneLineNumber;
        private String extensionNumber;

        public Builder setCountryCode(CountryCode cc) {
            countryCode = cc;
            return this;
        }

        public Builder setAreaCode(AreaCode ac) {
            areaCode = ac;
            return this;
        }

        public Builder setPhoneLineNumber(String ln) {
            phoneLineNumber = ln;
            return this;
        }

        public Builder setExtention(String ex) {
            extensionNumber = ex;
            return this;
        }

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

    public static PhoneNumber newPhoneNumber() {

        CountryCode cc = CountryCode.valueOf();
        PhoneNumber ph = PhoneNumber.newBuilder()
                .setCountryCode()
                .setAreaCode()
                .setPhoneLineNumber()
                .setExtention()
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
