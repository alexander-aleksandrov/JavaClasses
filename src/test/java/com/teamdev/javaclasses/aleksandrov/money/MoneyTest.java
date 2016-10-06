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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DisplayName("Money should")
class MoneyTest {

    @Test
    @DisplayName("generate new value by currency and amount")
    void createNewValue() {
        Money money1 = Money.newAmount("GBP", 65);
        assertEquals(money1.getCurrency().getCurrecyCode(), "GBP");
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
        try {
            money1.compareTo(money2);
        } catch (IllegalArgumentException e) {
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
