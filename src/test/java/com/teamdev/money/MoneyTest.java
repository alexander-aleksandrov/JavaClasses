package com.teamdev.money;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

@DisplayName("Money should")
class MoneyTest {

    @Test
    @DisplayName("generate new value by currency and amount")
    void createNewValue() {
        Money money1 = Money.newAmount("GBP", 65);
        assertEquals(money1.getCurrency().getCurrecyCode(), "GBP");
//        fail("new value was not created");
    }

    @Test
    @DisplayName("be comparable in case if they have the same currency")
    void compareMoney() {
        Money money1 = Money.newAmount("GBP", 65);
        Money money2 = Money.newAmount("GBP", 75);
        assertTrue(money1.compareTo(money2) < 0);
//        fail("Equal currencies are not comparable for some reason");
    }

}