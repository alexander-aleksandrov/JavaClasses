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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Defines current user geographical location.
 *
 * @author Alexander Aleksandrov
 */
public class Localisation {

    /**
     * Gets the country numbering plan based on geolocation of the IP selfrequest.
     *
     * @return Country numbering plan based on location
     */
    public static CountryNumberingPlan getCountryNumberingPlan(){
        URL myCountry;
        try {
            myCountry = new URL("http://ip2c.org/s");
            BufferedReader in = new BufferedReader(new InputStreamReader(myCountry.openStream()));
            String webResponse = in.readLine();
            String alpha2CountryCode = parseLocation(webResponse);
            return CountryNumberingPlan.valueOf(alpha2CountryCode);
        } catch (Exception e) {
        }
        return CountryNumberingPlan.UNDEFINED;
    }

    private static String parseLocation (String webResponse){
        String location = webResponse.split(";")[1];
        return location;
    }
}

