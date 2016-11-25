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

import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * A class  that allows to work with phone number as value object.
 *
 * @author Alexander Aleksandrov
 */
public final class PhoneNumber {
    @Nullable
    private final String iddPrefix;
    @Nullable
    private final String trunkCode;
    @Nullable
    private final CountryNumberingPlan countryNumberingPlan;
    @Nullable
    private final String areaCode;
    private final String subscriberNumber;
    @Nullable
    private final String extensionNumber;

    private static String phoneRemainder;

    private static String getPhoneRemainder() {
        return phoneRemainder;
    }

    private static void setPhoneRemainder(String phoneNumber) {
        phoneRemainder = phoneNumber;
    }

    /**
     * Gets international direct dialing code.
     *
     * @return {@link IDDPrefixPatterns} enum
     */
    @Nullable
    public String getIddPrefix() {
        return iddPrefix;
    }

    /**
     * Gets trunk code.
     *
     * @return {@link IDDPrefixPatterns} enum
     */
    @Nullable
    public String getTrunkCode() {
        return trunkCode;
    }

    /**
     * Gets international country code.
     *
     * @return {@link CountryNumberingPlan} enum
     */
    @Nullable
    public CountryNumberingPlan getCountryNumberingPlan() {
        return countryNumberingPlan;
    }

    /**
     * Gets local to country area codes.
     *
     * @return {@link AreaCodePatterns} enum
     */
    @Nullable
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * Gets phone line number.
     *
     * @return String with phone line number
     */
    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    /**
     * Gets Extension number.
     *
     * @return String with extension number
     */
    @Nullable
    public String getExtensionNumber() {
        return extensionNumber;
    }

    /**
     * Gets a number.
     *
     * @return whole number in string
     */
    public String getNumber() {
        String countryCode = "";
        if (iddPrefix.isEmpty() && countryNumberingPlan != CountryNumberingPlan.UNDEFINED) {
            countryCode = "+" + countryNumberingPlan.getCountryCallingCode();
        }
        String number = iddPrefix + trunkCode + countryCode + areaCode + subscriberNumber + extensionNumber;
        return number;
    }

    public static Builder newPhoneNumber() {
        return new Builder();
    }

    /**
     * Builder  for Phone Number.
     */
    public static class Builder {
        private String iddPrefix;
        private String trunkCode;
        private IDDPrefixPatterns iddPrefixPatterns;
        private CountryNumberingPlan countryNumberingPlan;
        private String areaCode;
        private String phoneLineNumber;
        private String extensionNumber;

        /**
         * Sets international direct dialing code for this builder.
         *
         * @param prefix {@link IDDPrefixPatterns} enum
         * @return this Builder
         */
        public Builder setIDDPrefix(String prefix) {
            iddPrefix = prefix;
            return this;
        }

        /**
         * Sets trunk code for this builder.
         *
         * @param trunk {@link IDDPrefixPatterns} enum
         * @return this Builder
         */
        public Builder setTrunkCde(String trunk) {
            trunkCode = trunk;
            return this;
        }

        /**
         * Sets country code for this builder.
         *
         * @param code {@link CountryNumberingPlan} enum
         * @return this Builder
         */
        public Builder setCountryNumberingPlan(CountryNumberingPlan code) {
            countryNumberingPlan = code;
            return this;
        }

        /**
         * Sets area code for this builder.
         *
         * @param ac area code
         * @return this Builder
         */
        public Builder setAreaCode(String ac) {
            areaCode = ac;
            return this;
        }

        /**
         * Sets phone line number for this builder.
         *
         * @param ln String with digits of line number
         * @return this Builder
         */
        public Builder setPhoneLineNumber(String ln) {
            phoneLineNumber = ln;
            return this;
        }

        /**
         * Sets extension number for this builder.
         *
         * @param ex String with digits of extension number
         * @return this Builder
         */
        public Builder setExtension(String ex) {
            extensionNumber = ex;
            return this;
        }

        /**
         * Calls constructor and passes itself to it.
         *
         * @return {@link PhoneNumber} object
         */
        public PhoneNumber build() {
            return new PhoneNumber(this);
        }
    }

    private PhoneNumber(Builder builder) {
        this.iddPrefix = builder.iddPrefix;
        this.trunkCode = builder.trunkCode;
        this.countryNumberingPlan = builder.countryNumberingPlan;
        this.areaCode = builder.areaCode;
        this.subscriberNumber = builder.phoneLineNumber;
        this.extensionNumber = builder.extensionNumber;

    }

    /**
     * Parse a phone number. In case if the phone number starts with "+" sign or international direct dialing(IDD) code
     * it will have a structure of IDD(if stated) + CC + NDC + SN.
     * <p>Where:
     * <p>IDD - International direct dialing code
     * <p>CC - Country calling code
     * <p>NDC - National destination code (Area code)
     * <p>SN - Subscriber number
     * <p>
     * <p>In all other cases phone number will be parsed as National (Significant) number(NSN). It will have a structure
     * NDC + SN.
     *
     * @param phoneNumber Any phoneNumber from client
     * @return {@link PhoneNumber}
     * @throws ParseException
     */
    public static PhoneNumber parse(String phoneNumber) throws ParseException {
        String iddPrefix = "";
        String trunkCode = "";
        String areaCode = "";
        String subscriberNumber = "";
        String extensionNumber = "";
        CountryNumberingPlan countryNumberingPlan = CountryNumberingPlan.UNDEFINED;

        phoneNumber = format(phoneNumber);
        Validation.applyTo(phoneNumber);
        setPhoneRemainder(phoneNumber);

        while (getPhoneRemainder().length() != 0) {
            /*Parsing of country calling code.*/
            if (phoneNumber.startsWith("+") && countryNumberingPlan == CountryNumberingPlan.UNDEFINED) {
                countryNumberingPlan = parseCountryCodeAfterPlus();
            }
            if (iddPrefix.length() > 1 && countryNumberingPlan == CountryNumberingPlan.UNDEFINED) {
                countryNumberingPlan = parseCountryCodeAfterIDD();
            }

            /*Parsing of international direct dialing code.*/
            final String possibleIDDRegex = "(00[0-9][0-9][0-9]|01[0-9]|8[0-9][0-9]|1[0-9][0-9]0|99[0-9][0-9]).*";
            if (phoneNumber.matches(possibleIDDRegex) && iddPrefix.isEmpty()) {
                iddPrefix = parseIDDCode();
            }

            /*Parsing of area code in case if the country code is already known.*/
            if (countryNumberingPlan != CountryNumberingPlan.UNDEFINED && areaCode.isEmpty()) {
                areaCode = parseAreaCodeByNumberingPlan(countryNumberingPlan);
            }

            /*Parsing of area code in case if the country code is not stated.*/
            final String trunkCodeRegex = "(0|1|01|02|8).*";
            if (phoneNumber.matches(trunkCodeRegex) && areaCode.isEmpty() && iddPrefix.isEmpty()) {
                countryNumberingPlan = Localisation.getCountryNumberingPlan();
                areaCode = parseAreaCodByLocalisation();
                trunkCode = parseTrunkCodByLocalisation();
            }

            /*Parsing of subscriber number*/
            if (phoneNumber.length() <= 4 || phoneNumber.startsWith("*") & phoneNumber.endsWith("#")) {
                subscriberNumber = getPhoneRemainder();
                setPhoneRemainder("");
            }
            if (getPhoneRemainder().length() != 0 && areaCode.length() != 0 && !getPhoneRemainder().matches(".*[,].*")) {
                subscriberNumber = getPhoneRemainder();
                setPhoneRemainder("");
            }

            /*Parsing of extension code.*/
            if (getPhoneRemainder().length() != 0 && getPhoneRemainder().matches(".*[,].*")) {
                extensionNumber = getPhoneRemainder().split(",")[1];
                cutPhoneRemainder(0, getPhoneRemainder().length() - extensionNumber.length()-1);
                System.out.println(getPhoneRemainder());
            }

        }
        PhoneNumber ph = newPhoneNumber()
                .setIDDPrefix(iddPrefix)
                .setTrunkCde(trunkCode)
                .setCountryNumberingPlan(countryNumberingPlan)
                .setAreaCode(areaCode)
                .setPhoneLineNumber(subscriberNumber)
                .setExtension(extensionNumber)
                .build();
        return ph;
    }

    private static void cutPhoneRemainder(int startIndex, int endIndex) {
        setPhoneRemainder(getPhoneRemainder().substring(startIndex, endIndex));
    }

    private static CountryNumberingPlan parseCountryCodeAfterPlus() {
        int i;
        CountryNumberingPlan countryNumberingPlan = null;
        for (i = 5; i >= 1; i--) {
            final String regex = getPhoneRemainder().substring(1, i);
            final List<CountryNumberingPlan> list = CountryNumberingPlan.findByCountryCallingCode(regex);
            if (!list.isEmpty()) {
                countryNumberingPlan = list.get(0);
                cutPhoneRemainder(countryNumberingPlan.getCountryCallingCode().length() + 1, getPhoneRemainder().length());
                break;
            }
        }
        return countryNumberingPlan;
    }

    private static CountryNumberingPlan parseCountryCodeAfterIDD() throws ParseException {
        int i;
        CountryNumberingPlan countryNumberingPlan = CountryNumberingPlan.UNDEFINED;
        for (i = 4; i >= 1; i--) {
            final String regex = getPhoneRemainder().substring(0, i);
            final List<CountryNumberingPlan> list = CountryNumberingPlan.findByCountryCallingCode(regex);
            if (!list.isEmpty()) {
                countryNumberingPlan = list.get(0);
                cutPhoneRemainder(countryNumberingPlan.getCountryCallingCode().length(), getPhoneRemainder().length());
                break;
            }
        }
        if (countryNumberingPlan == CountryNumberingPlan.UNDEFINED) {
            throw new ParseException("Country calling code cannot be undefined after IDD code is presented", 1);
        }
        return countryNumberingPlan;
    }

    private static String parseAreaCodeByNumberingPlan(CountryNumberingPlan countryNumberingPlan) {
        final boolean areaCodeHasFixedLength = countryNumberingPlan.getAreaCodeRange().length == 1;
        String areaCode = "";
        if (areaCodeHasFixedLength) {
            areaCode = getPhoneRemainder().substring(0, countryNumberingPlan.getAreaCodeRange()[0]);
            cutPhoneRemainder(areaCode.length(), getPhoneRemainder().length());
        } else {
            int i;
            final int maxAreaCodeLength = countryNumberingPlan.getAreaCodeRange()[1];
            for (i = maxAreaCodeLength; i >= 1; i--) {
                String probableAreaCode = getPhoneRemainder().substring(0, i);
                List<String> listOfAreaCodes = AreaCodePatterns.findAreaCode(probableAreaCode, countryNumberingPlan);
                if (!listOfAreaCodes.isEmpty()) {
                    areaCode = probableAreaCode;
                    cutPhoneRemainder(areaCode.length(), getPhoneRemainder().length());
                    break;
                }

            }
        }
        return areaCode;
    }

    private static String parseIDDCode() {
        int i;
        int j;
        String iddPrefix = "";
        for (i = 5; i >= 1; i--) {
            final String clippedPhoneNumber = getPhoneRemainder().substring(0, i);
            final List<IDDPrefixPatterns> iddList = IDDPrefixPatterns.findIDDCode(clippedPhoneNumber);
            if (!iddList.isEmpty()) {
                iddPrefix = clippedPhoneNumber;
                final IDDPrefixPatterns iddPrefixPatterns = iddList.get(0);
                CountryNumberingPlan countryNumberingPlan = CountryNumberingPlan.UNDEFINED;
                switch (iddPrefixPatterns.getIDDPrefix()) {
                    case "01?":
                    case "8??":
                    case "1??0":
                        iddPrefix = clippedPhoneNumber;
                        cutPhoneRemainder(iddPrefix.length(), getPhoneRemainder().length());
                        break;
                    case "00???":
                        iddPrefix = clippedPhoneNumber;
                        for (i = 2; i < 6; i++) {
                            String regex = getPhoneRemainder().substring(i, i + 4);
                            for (j = 4; j >= 1; j--) {
                                String regex1 = regex.substring(0, j);
                                List<CountryNumberingPlan> countryNumPlanList = CountryNumberingPlan.findByCountryCallingCode(regex1);
                                if (!countryNumPlanList.isEmpty()) {
                                    countryNumberingPlan = countryNumPlanList.get(0);
                                    iddPrefix = getPhoneRemainder().split(regex1)[0];
                                    cutPhoneRemainder(iddPrefix.length(), getPhoneRemainder().length());
                                    break;
                                }
                            }
                            if (countryNumberingPlan != CountryNumberingPlan.UNDEFINED) {
                                break;
                            }
                        }
                        break;
                    case "99??":
                        iddPrefix = clippedPhoneNumber;
                        for (i = 2; i < 5; i++) {
                            String regex = getPhoneRemainder().substring(i, i + 4);
                            for (j = 4; j >= 1; j--) {
                                String regex1 = regex.substring(0, j);
                                List<CountryNumberingPlan> countryNumPlanList = CountryNumberingPlan.findByCountryCallingCode(regex1);
                                if (!countryNumPlanList.isEmpty()) {
                                    countryNumberingPlan = countryNumPlanList.get(0);
                                    iddPrefix = getPhoneRemainder().split(regex1)[0];
                                    cutPhoneRemainder(iddPrefix.length(), getPhoneRemainder().length());
                                    break;

                                }
                            }
                            if (countryNumberingPlan != CountryNumberingPlan.UNDEFINED) {
                                break;
                            }
                        }
                        break;
                }
                break;
            }
        }
        return iddPrefix;
    }

    private static String parseAreaCodByLocalisation() {
        CountryNumberingPlan countryNumberingPlan = Localisation.getCountryNumberingPlan();
        String areaCode = "";
        if (countryNumberingPlan.getCountryCode() != CountryCode.MN) {
            areaCode = getPhoneRemainder().substring(1, countryNumberingPlan.getAreaCodeRange()[0] + 1);
            cutPhoneRemainder(areaCode.length() + 1, getPhoneRemainder().length());
        } else {
            areaCode = getPhoneRemainder().substring(2, countryNumberingPlan.getAreaCodeRange()[0] + 2);
            cutPhoneRemainder(areaCode.length() + 2, getPhoneRemainder().length());
        }
        return areaCode;
    }

    private static String parseTrunkCodByLocalisation() {
        CountryNumberingPlan countryNumberingPlan = Localisation.getCountryNumberingPlan();
        String trunkCode = "";
        if (countryNumberingPlan.getCountryCode() != CountryCode.MN) {
            trunkCode = getPhoneRemainder().substring(0, 1);
        } else {
            trunkCode = getPhoneRemainder().substring(0, 2);
        }
        return trunkCode;
    }

    private static String format(String rawPhoneNumber) {
        String phoneNumber = rawPhoneNumber.replaceAll("[^\\w+#*,]", "");
        boolean containsLetters = Pattern.compile("[a-zA-z]").matcher(phoneNumber).find();
        if (containsLetters) {
            phoneNumber = phoneNumber.replaceAll("[a-cA-C]", "2");
            phoneNumber = phoneNumber.replaceAll("[d-fD-F]", "3");
            phoneNumber = phoneNumber.replaceAll("[g-iG-I]", "4");
            phoneNumber = phoneNumber.replaceAll("[j-lJ-L]", "5");
            phoneNumber = phoneNumber.replaceAll("[m-oM-O]", "6");
            phoneNumber = phoneNumber.replaceAll("[p-sP-S]", "7");
            phoneNumber = phoneNumber.replaceAll("[t-vT-V]", "8");
            phoneNumber = phoneNumber.replaceAll("[w-zW-Z]", "9");
        }
        return phoneNumber;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
