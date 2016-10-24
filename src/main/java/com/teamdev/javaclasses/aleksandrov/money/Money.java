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
 * An amount of money of specified currency. Only (USD, GBP, CHF) cna be used now.
 *
 * @author Alexander Aleksandrov
 */
public class Money implements Comparable<Money> {

    private final Currency currency;
    private final long amount;

    /**
     * Creates a new money object.
     *
     * @param currencyCode String that contains international currency code
     * @param amount       long value of new amount
     * @return {@link Money} object
     */
    public static Money createNewAmount(String currencyCode, long amount) {
        final Currency currency = Currency.valueOf(currencyCode);
        return new Money(currency, amount);
    }

    private Money(Currency currency, long amount) {
        this.currency = currency;
        this.amount = amount;
    }

    /**
     * Obtains currency of the money amount.
     *
     * @return the {@link Currency} object of this money
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Obtains amount of money in minor currency units.
     *
     * @return amount of money in minor currency units
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Compares amounts of money in case if they have the same currency otherwise throws error message.
     *
     * @param o {@link Money} object
     * @return negative in case if comparable is bigger, zero if equals, and positive if bigger
     */
    @Override
    public int compareTo(Money o) {
        if (getCurrency() != o.getCurrency()) {
            String errMsg = String.format("Cannot compare money of different currencies %s, %s", getCurrency(), o.getCurrency());
            throw new IllegalArgumentException(errMsg);
        }
        @SuppressWarnings({"SubtractionInCompareTo", // OK to do since we compare numeric values
                           "NumericCastThatLosesPrecision"}) // we only need the sign
        final int result = (int)(getAmount() - o.getAmount());
        return result;
    }
}
