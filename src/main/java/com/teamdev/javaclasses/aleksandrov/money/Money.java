package com.teamdev.javaclasses.aleksandrov.money;

public class Money implements Comparable<Money>{

    private final Currency currency;
    private final long amount;

    private static Money.Builder newBuilder() {
        return new Builder();
    }

    public Currency getCurrency() {
        return currency;
    }

    public long getAmount(){
        return amount;
    }
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

        public Money build(){
            return new Money(this);
        }

    }

    private Money(Builder builder) {
        this.currency = builder.currency;
        this.amount = builder.amount;
    }

    public static Money newAmount(String currencyCode, long amount){
        Currency currency = Currency.valueOf(currencyCode);
        Money newAmount = Money.newBuilder().setCurrency(currency).setAmount(amount).build();
        return newAmount;
    }

    public int compareTo(Money o) {
        if (getCurrency() != o.getCurrency()) {
            String errMsg = String.format("Cannot compare money of different currencies %s, %s", getCurrency(), o.getCurrency());
            throw new IllegalArgumentException(errMsg);
        }
        long result = getAmount() - o.getAmount();
        return (int)result;
    }
}
