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

import java.text.ParseException;
import java.util.regex.Pattern;

/**
 * Validates if the phone number have a correct format.
 *
 * @author Alexander Aleksandrov
 */
final class Validation {
    private static final String[] restrictedRegex = {
            //special characters more than one in a row
            "^.*(,{2,}|\\+{2,}|#{2,}|\\*{2,}).*$",
            //several special characters in number except "*"
            "^.*((\\+).*(\\+)).*$",
            "^.*((\\,).*(\\,)).*$",
            "^.*((\\#).*(\\#)).*$",
            //ending of a number on any special character except "#"
            "^.*(,|\\+|\\*)$",
            //ending of USSD number on any char except "#"
            "^\\*.*(,|\\+|\\*|[0-9])$",
            //any number with length less than 3 char
            "^.{1,2}$",
            //any international number started with "+" and length less than 5 digits
            "^\\+\\d{1,4}$",
            //any international number started with "+" and containing other special characters except "," extension
            "^\\+.*(\\*|#).*$",
            //any subscriber number less than 2 digits
            "^\\d{1,2}$",
            //USSD contains any special char except "*" and "#"
            "^\\*.*(\\,|\\+).*$"

    };
    private static final String[] allowedRegex = {"[+][0-9]*", "[*].*[#]"};

    /**
     *
     *
     * @param phoneNumber
     * @throws ParseException in case when the phone number doesn't match E.164 format
     */
    public static void applyTo (String phoneNumber) throws ParseException {
        for (String pattern : restrictedRegex) {
            if (Pattern.matches(pattern, phoneNumber)) {
                throw new ParseException("Phone number has wrong format", 0);
            }
        }
        for (String pattern: allowedRegex){
            if(Pattern.matches(pattern, phoneNumber)){

            }
        }

    }
}
