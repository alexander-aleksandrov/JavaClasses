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
package com.teamdev.javaclasses.aleksandrov.phonenumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.text.ParseException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("PhoneNumber should")
public class PhoneNumberTest {

    @TestFactory
    @DisplayName("throw ParseException")
    Stream<DynamicTest> throwParseException() {
        final String[][] testData = {
                // input, test name
                {"*75**162348765#", "more than one '*' in a row"},
                {"872634887##", "'#' more than one '#' in a row"},
                {"++98732498", "more than one '+' in a row"},
                {"+1726357,,123", "more than one ',' in a row"},
                {"+8716238+762354", "several '+' characters in it"},
                {"*8716238762#35#", "several '#' characters in it"},
                {"+8716238,76,2354", "several ',' characters in it"},
                {"+871623762354,", "',' char on the end"},
                {"+871623864*", "'*' char on the end"},
                {"0071623762354+", "'+' char on the end"},
                {"*871623864", "USSD format number ends on a digit"},
                {"*871623864+", "USSD format number ends on a '+'"},
                {"*45674567,", "USSD format number ends on a ','"},
                {"*45674567,213#", "USSD format number contains ','"},
                {"*45674567+234#", "USSD format number contains '+'"},
                {"1*", "any record length is less than 3 char"},
                {"+1234", "number started with '+' has length less than 5 digits"},
                {"+172563761*123", "number started with '+' contains '*'"},
                {"+172563761#123", "number started with '+' contains '#'"},
                {"00000217456456456", "country code is undefined after IDD was parsed"}
        };
        return Stream.of(testData).map(datum -> DynamicTest.dynamicTest("if " + datum[1],
                        () -> assertThrows(ParseException.class, () -> PhoneNumber.parse(datum[0]))));
    }

    @TestFactory
    @DisplayName("format itself")
    Stream<DynamicTest> testFormat() {
        final String[][] testData = {
                // input, expected
                {"*^&% &^ (  9*& ^75*162348765#", "*9*75*162348765#"},
                {"1bdgjmptw", "23456789"}
        };
        return Stream.of(testData).map(datum -> DynamicTest.dynamicTest("from: " + datum[0] + " to standard view",
                () -> assertEquals(datum[1], PhoneNumber.parse(datum[0]).getAreaCode() + PhoneNumber.parse(datum[0]).getSubscriberNumber())));
    }

    @Test
    @DisplayName("parse extension number after ',' sign")
    void parseExtension() {
        PhoneNumber phoneNumber;
        try {
            phoneNumber = PhoneNumber.parse("+380677865876,1234");
            String extensionNumber = phoneNumber.getExtensionNumber();
            assertEquals(extensionNumber, "1234");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("parse USSD number as subscriber number")
    void parseUSSDtest() {
        PhoneNumber phoneNumber;
        try {
            phoneNumber = PhoneNumber.parse("*876578658765#");
            String subscriberNumber = phoneNumber.getSubscriberNumber();
            assertEquals(subscriberNumber, "*876578658765#");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("parse international direct dialing code")
    void parseIDD() {
        PhoneNumber phoneNumber;
        try {
            phoneNumber = PhoneNumber.parse("000675315258");
            String iddPrefix = phoneNumber.getIddPrefix();
            assertEquals(iddPrefix, "000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("parse country calling code after IDD code")
    void parseCC() {
        PhoneNumber phoneNumber;
        try {
            phoneNumber = PhoneNumber.parse("0012642555656");
            String countryCode = phoneNumber.getCountryNumberingPlan().getCountryCallingCode();
            assertEquals(countryCode, "1264");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("parse country calling code after '+' sign")
    void parseCCWithoutIDD() {
        PhoneNumber phoneNumber;
        try {
            phoneNumber = PhoneNumber.parse("+380972555656");
            String countryCode = phoneNumber.getCountryNumberingPlan().getCountryCallingCode();
            assertEquals(countryCode, "380");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("parse area code when country is known")
    void parseAreaCodeBasedOnCountry() {
        PhoneNumber phoneNumber;
        try {
            phoneNumber = PhoneNumber.parse("00380972555656");
            String areaCode = phoneNumber.getAreaCode();
            assertEquals(areaCode, "97");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("parse area code when country doesn't known")
    void parseAreaCodeBasedOnLocalisation() {
        PhoneNumber phoneNumber;
        try {
            phoneNumber = PhoneNumber.parse("0972555656");
            String areaCode = phoneNumber.getAreaCode();
            assertEquals(areaCode, "97");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("parse area code with unfixed length when country is known")
    void parseAreaCodeWithUnfixedLength() {
        PhoneNumber phoneNumber;
        try {
            phoneNumber = PhoneNumber.parse("002016111532656");
            String areaCode = phoneNumber.getAreaCode();
            assertEquals(areaCode, "16111");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("parse short subscriber number ")
    void parseShortSubscriberNumber() {
        PhoneNumber phoneNumber;
        try {
            phoneNumber = PhoneNumber.parse("3040");
            String areaCode = phoneNumber.getSubscriberNumber();
            assertEquals(areaCode, "3040");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
