package com.teamdev.money;

public class Main {
    public static void main(String[] args) {
        Money m = Money.newAmount("USD", 200);
        System.out.println(m.getCurrency());
        System.out.println(m.getAmount());

    }
}
