package com.teamdev.money;

public class Money implements Comparable<Money>{
    private final Currency currency;
    private final long amount;

    private static Money.Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        public Currency currency;
        public long amount;

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

    public Money createNewAmount(String currencyCode, long newValue){
        Currency currency = Currency.valueOf(currencyCode);
        Money newAmount = Money.newBuilder().setCurrency(currency).setAmount(newValue).build();
        return newAmount;
    }

    public long getCurrentAmount(){
        return amount;
    }

    // TODO: 10/4/2016 define how to override this method
    public int compareTo(Money o) {
        return 0;
    }
}
