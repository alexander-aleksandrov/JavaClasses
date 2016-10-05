package com.teamdev.javaclasses.aleksandrov.money;

public enum Currency {

    USD('$', "USD"),

    GBP('£', "GBP");

    private final char symbol;
    private final String code;

    Currency(char symbol, String code){
        this.symbol = symbol;
        this.code = code;
    }

    public char getSymbol(){
        return symbol;
    }

    public String getCurrecyCode(){
        return code;
    }
}
