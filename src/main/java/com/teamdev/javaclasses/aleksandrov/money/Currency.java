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
 * Represents different currencies.
 *
 * @author Alexander Aleksandrov
 */
public enum Currency {
    /**
     * Dollars of United States of America
     */
    USD('$', "USD"),
    /**
     * Great Britain Pounds
     */
    GBP('£', "GBP");

    private final char symbol;
    private final String code;

    Currency(char symbol, String code) {
        this.symbol = symbol;
        this.code = code;
    }

    /**
     * Gets the symbol of specified currency.
     *
     * @return char
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Gets international currency code.
     *
     * @return String with currency code
     */
    public String getCurrecyCode() {
        return code;
    }
}
