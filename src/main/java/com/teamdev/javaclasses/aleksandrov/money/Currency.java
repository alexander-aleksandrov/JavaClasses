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
package com.teamdev.javaclasses.aleksandrov.money;

/**
 * Contains only few records (USD, GBP, CHF) for this specific example. Currency codes and symbols are taken from "ISO 4217 Currency Codes."
 *
 * @author Alexander Aleksandrov
 */
public enum Currency {
    /**
     * United States Dollar
     */
    USD(new int[]{36}, "USD"),
    /**
     * United Kingdom Pound
     */
    GBP(new int[]{163}, "GBP"),
    /**
     * Switzerland Franc
     */
    CHF(new int[]{67, 72, 70}, "CHF");

    private final int[] symbolUnicodeDecimal;
    private final String code;

    Currency(int[] symbolUnicodeDecimal, String code) {
        this.symbolUnicodeDecimal = symbolUnicodeDecimal;
        this.code = code;
    }

    /**
     * Gets the symbolic representation of specified currency.
     *
     * @return A string with representation.
     */
    public String getSymbol() {
        String symbol = "";
        for (int unicode : symbolUnicodeDecimal) {
            symbol = symbol + Character.toString((char) unicode);
        }
        return symbol;
    }

    /**
     * Gets currency code.
     *
     * @return A string with currency code
     */
    public String getCurrencyCode() {
        return code;
    }
}
