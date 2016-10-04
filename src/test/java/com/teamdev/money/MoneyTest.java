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
    void compareSameCurrencyMoney() {
        Money money1 = Money.newAmount("GBP", 65);
        Money money2 = Money.newAmount("GBP", 75);
        assertTrue(money1.compareTo(money2) < 0);
    }

    @Test
    @DisplayName("not be comparable in case if they have the different currency")
    void comparedDiffernetCurrency() {
        Money money1 = Money.newAmount("GBP", 65);
        Money money2 = Money.newAmount("USD", 75);
        try { money1.compareTo(money2);
        }catch (IllegalArgumentException e){
            assertEquals("Cannot compare money of different currencies GBP, USD", e.getMessage());
        }

    }

    @Test
    @DisplayName("give currency symbol")
    void getCurrencySymbol() {
        Money money1 = Money.newAmount("GBP", 65);
        assertEquals(money1.getCurrency().getSymbol(), '£');
    }
}