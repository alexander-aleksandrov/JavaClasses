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
 * Class that allows to work with money as value object.
 *
 * @author Alexander Aleksandrov
 */
public class Money implements Comparable<Money> {

    private final Currency currency;
    private final long amount;

    private static Money.Builder newBuilder() {
        return new Builder();
    }

    /**
     * Gets currency.
     *
     * @return Enum {@link Currency}
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Gets amount of money.
     *
     * @return long value
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Builder for money object.
     */
    public static class Builder {
        public static Currency currency;
        public static long amount;

        public Builder setCurrency(Currency currencyCode) {
            currency = currencyCode;
            return this;
        }

        public Builder setAmount(long value) {
            amount = value;
            return this;

        }

        public Money build() {
            return new Money(this);
        }

    }

    /**
     * Constructor that takes Builder as a parameter.
     *
     * @param builder {@link Builder} object
     */
    private Money(Builder builder) {
        this.currency = builder.currency;
        this.amount = builder.amount;
    }

    /**
     * Creates a new money object.
     *
     * @param currencyCode String that contains international currency code
     * @param amount       long value of new amount
     * @return {@link Money} object
     */
    public static Money newAmount(String currencyCode, long amount) {
        Currency currency = Currency.valueOf(currencyCode);
        Money newAmount = Money.newBuilder().setCurrency(currency).setAmount(amount).build();
        return newAmount;
    }

    /**
     * Compares amounts of moneys in case if they have the same currency.
     *
     * @param o {@link Money} object
     * @return itn value less than zero in case if comparable is bigger, zero if equals, and more than zero if bigger
     */
    @Override
    public int compareTo(Money o) {
        if (getCurrency() != o.getCurrency()) {
            String errMsg = String.format("Cannot compare money of different currencies %s, %s", getCurrency(), o.getCurrency());
            throw new IllegalArgumentException(errMsg);
        }
        long result = getAmount() - o.getAmount();
        return (int) result;
    }
}
