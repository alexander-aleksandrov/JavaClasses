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

/**
 * Country phone  codes.
 *
 * @author Alexander Aleksandrov
 */
public enum CountryCode {

    ANGUILLA("1-264", "Anguilla"),
    CANADA("1", "Canada"),
    UNITED_STATES("1", "United States"),
    DEFAULT("Not Found", "No Such country");

    private String countryCode;
    private String country;

    private CountryCode(String code, String countryName) {
        this.countryCode = code;
        this.country = countryName;
    }

    /**
     * Gets country  code from a record.
     *
     * @return String with a country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Gets country  full name.
     *
     * @return String with a full name
     */
    public String getCountryName() {
        return country;
    }

    /**
     *
     * @param test
     * @return
     */
    public static CountryCode contains(String test) {
        for (CountryCode c : CountryCode.values()) {
            if (c.name().equals(test)) {
                return c;
            }
        }
        return CountryCode.DEFAULT;
    }
}
