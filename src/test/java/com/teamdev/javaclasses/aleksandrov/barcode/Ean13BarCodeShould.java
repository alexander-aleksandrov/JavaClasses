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

package com.teamdev.javaclasses.aleksandrov.barcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Ean13BarCode should")
class Ean13BarCodeShould {

    @Test
    @DisplayName("have default instance")
    void getDefaultInstance() {
        Ean13BarCode barcode = Ean13BarCode.getDefaultInstance();
        assertEquals(0, barcode.getFirstDigit());
        assertEquals("000000", Ean13BarCode.groupToString(barcode.getFirstGroup()));
        assertEquals("000000", Ean13BarCode.groupToString(barcode.getLastGroup()));
        assertEquals(0, barcode.getChecksumDigit());
    }

    @Test
    @DisplayName("parse from string")
    void parseFromString() {
        Ean13BarCode barcode = Ean13BarCode.parse("978020137962");
        assertEquals(9, barcode.getFirstDigit());
        assertEquals("780201", Ean13BarCode.groupToString(barcode.getFirstGroup()));
        assertEquals("379624", Ean13BarCode.groupToString(barcode.getLastGroup()));
        assertEquals(4, barcode.getChecksumDigit());
    }
    @Test
    @DisplayName("have toString method")
    void barcodeToString(){
        Ean13BarCode barCode = Ean13BarCode.parse("978020137962");
        assertEquals("978020137962" + barCode.getChecksumDigit(), barCode.toString(barCode));
    }
}
