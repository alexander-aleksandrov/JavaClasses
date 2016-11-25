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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Country codes from <a href="http://en.wikipedia.org/wiki/ISO_3166-1">ISO 3166-1</a> standard represented in Alpha-2, Alpha-3, and numeric formats.
 *
 * @author Alexander Aleksandrov
 */
public enum CountryCode {
    UNDEFINED("Undefined", null, -1),
    AC("Ascension Island", "ASC", -1),
    AD("Andorra", "AND", 20),
    AE("United Arab Emirates", "ARE", 784),
    AF("Afghanistan", "AFG", 4),
    AG("Antigua and Barbuda", "ATG", 28),
    AI("Anguilla", "AIA", 660),
    AL("Albania", "ALB", 8),
    AM("Armenia", "ARM", 51),
    AN("Netherlands Antilles", "ANT", 530),
    AO("Angola", "AGO", 24),
    AQ("Antarctica", "ATA", 10),
    AR("Argentina", "ARG", 32),
    AS("American Samoa", "ASM", 16),
    AT("Austria", "AUT", 40),
    AU("Australia", "AUS", 36),
    AW("Aruba", "ABW", 533),
    AX("\u00C5land Islands", "ALA", 248),
    AZ("Azerbaijan", "AZE", 31),
    BA("Bosnia and Herzegovina", "BIH", 70),
    BB("Barbados", "BRB", 52),
    BD("Bangladesh", "BGD", 50),
    BE("Belgium", "BEL", 56),
    BF("Burkina Faso", "BFA", 854),
    BG("Bulgaria", "BGR", 100),
    BH("Bahrain", "BHR", 48),
    BI("Burundi", "BDI", 108),
    BJ("Benin", "BEN", 204),
    BL("Saint Barth\u00E9lemy", "BLM", 652),
    BM("Bermuda", "BMU", 60),
    BN("Brunei Darussalam", "BRN", 96),
    BO("Bolivia, Plurinational State of", "BOL", 68),
    BQ("Bonaire, Sint Eustatius and Saba", "BES", 535),
    BR("Brazil", "BRA", 76),
    BS("Bahamas", "BHS", 44),
    BT("Bhutan", "BTN", 64),
    BU("Burma", "BUR", 104),
    BV("Bouvet Island", "BVT", 74),
    BW("Botswana", "BWA", 72),
    BY("Belarus", "BLR", 112),
    BZ("Belize", "BLZ", 84),
    CA("Canada", "CAN", 124),
    CC("Cocos (Keeling) Islands", "CCK", 166),
    CD("Congo, the Democratic Republic of the", "COD", 180),
    CF("Central African Republic", "CAF", 140),
    CG("Congo", "COG", 178),
    CH("Switzerland", "CHE", 756),
    CI("C\u00F4te d'Ivoire", "CIV", 384),
    CK("Cook Islands", "COK", 184),
    CL("Chile", "CHL", 152),
    CM("Cameroon", "CMR", 120),
    CN("China", "CHN", 156),
    CO("Colombia", "COL", 170),
    CP("Clipperton Island", "CPT", -1),
    CR("Costa Rica", "CRI", 188),
    CS("Serbia and Montenegro", "SCG", 891),
    CT("Northern Cyprus", null, -1),
    CU("Cuba", "CUB", 192),
    CV("Cape Verde", "CPV", 132),
    CW("Cura\u00E7ao", "CUW", 531),
    CX("Christmas Island", "CXR", 162),
    CY("Cyprus", "CYP", 196),
    CZ("Czech Republic", "CZE", 203),
    DE("Germany", "DEU", 276),
    DG("Diego Garcia", "DGA", -1),
    DJ("Djibouti", "DJI", 262),
    DK("Denmark", "DNK", 208),
    DM("Dominica", "DMA", 212),
    DO("Dominican Republic", "DOM", 214),
    DZ("Algeria", "DZA", 12),
    EA("Ceuta, Melilla", null, -1),
    EC("Ecuador", "ECU", 218),
    EE("Estonia", "EST", 233),
    EG("Egypt", "EGY", 818),
    EH("Western Sahara", "ESH", 732),
    ER("Eritrea", "ERI", 232),
    ES("Spain", "ESP", 724),
    ET("Ethiopia", "ETH", 231),
    EU("European Union", null, -1),
    FI("Finland", "FIN", 246),
    FJ("Fiji", "FJI", 242),
    FK("Falkland Islands (Malvinas)", "FLK", 238),
    FM("Micronesia, Federated States of", "FSM", 583),
    FO("Faroe Islands", "FRO", 234),
    FR("France", "FRA", 250),
    FX("France, Metropolitan", "FXX", 249),
    GA("Gabon", "GAB", 266),
    GB("United Kingdom", "GBR", 826),
    GD("Grenada", "GRD", 308),
    GE("Georgia", "GEO", 268),
    GF("French Guiana", "GUF", 254),
    GG("Guernsey", "GGY", 831),
    GH("Ghana", "GHA", 288),
    GI("Gibraltar", "GIB", 292),
    GL("Greenland", "GRL", 304),
    GM("Gambia", "GMB", 270),
    GN("Guinea", "GIN", 324),
    GP("Guadeloupe", "GLP", 312),
    GQ("Equatorial Guinea", "GNQ", 226),
    GR("Greece", "GRC", 300),
    GS("South Georgia and the South Sandwich Islands", "SGS", 239),
    GT("Guatemala", "GTM", 320),
    GU("Guam", "GUM", 316),
    GW("Guinea-Bissau", "GNB", 624),
    GY("Guyana", "GUY", 328),
    HK("Hong Kong", "HKG", 344),
    HM("Heard Island and McDonald Islands", "HMD", 334),
    HN("Honduras", "HND", 340),
    HR("Croatia", "HRV", 191),
    HT("Haiti", "HTI", 332),
    HU("Hungary", "HUN", 348),
    IC("Canary Islands", null, -1),
    ID("Indonesia", "IDN", 360),
    IE("Ireland", "IRL", 372),
    IL("Israel", "ISR", 376),
    IM("Isle of Man", "IMN", 833),
    IN("India", "IND", 356),
    IO("British Indian Ocean Territory", "IOT", 86),
    IQ("Iraq", "IRQ", 368),
    IR("Iran, Islamic Republic of", "IRN", 364),
    IS("Iceland", "ISL", 352),
    IT("Italy", "ITA", 380),
    JE("Jersey", "JEY", 832),
    JM("Jamaica", "JAM", 388),
    JO("Jordan", "JOR", 400),
    JP("Japan", "JPN", 392),
    KE("Kenya", "KEN", 404),
    KG("Kyrgyzstan", "KGZ", 417),
    KH("Cambodia", "KHM", 116),
    KI("Kiribati", "KIR", 296),
    KM("Comoros", "COM", 174),
    KN("Saint Kitts and Nevis", "KNA", 659),
    KP("Korea, Democratic People's Republic of", "PRK", 408),
    KR("Korea, Republic of", "KOR", 410),
    KW("Kuwait", "KWT", 414),
    KY("Cayman Islands", "CYM", 136),
    KZ("Kazakhstan", "KAZ", 398),
    LA("Lao People's Democratic Republic", "LAO", 418),
    LB("Lebanon", "LBN", 422),
    LC("Saint Lucia", "LCA", 662),
    LI("Liechtenstein", "LIE", 438),
    LK("Sri Lanka", "LKA", 144),
    LR("Liberia", "LBR", 430),
    LS("Lesotho", "LSO", 426),
    LT("Lithuania", "LTU", 440),
    LU("Luxembourg", "LUX", 442),
    LV("Latvia", "LVA", 428),
    LY("Libya", "LBY", 434),
    MA("Morocco", "MAR", 504),
    MC("Monaco", "MCO", 492),
    MD("Moldova, Republic of", "MDA", 498),
    ME("Montenegro", "MNE", 499),
    MF("Saint Martin (French part)", "MAF", 663),
    MG("Madagascar", "MDG", 450),
    MH("Marshall Islands", "MHL", 584),
    MK("Macedonia, the former Yugoslav Republic of", "MKD", 807),
    ML("Mali", "MLI", 466),
    MM("Myanmar", "MMR", 104),
    MN("Mongolia", "MNG", 496),
    MO("Macao", "MAC", 446),
    MP("Northern Mariana Islands", "MNP", 580),
    MQ("Martinique", "MTQ", 474),
    MR("Mauritania", "MRT", 478),
    MS("Montserrat", "MSR", 500),
    MT("Malta", "MLT", 470),
    MU("Mauritius", "MUS", 480),
    MV("Maldives", "MDV", 462),
    MW("Malawi", "MWI", 454),
    MX("Mexico", "MEX", 484),
    MY("Malaysia", "MYS", 458),
    MZ("Mozambique", "MOZ", 508),
    NA("Namibia", "NAM", 516),
    NC("New Caledonia", "NCL", 540),
    NE("Niger", "NER", 562),
    NF("Norfolk Island", "NFK", 574),
    NG("Nigeria", "NGA", 566),
    NI("Nicaragua", "NIC", 558),
    NL("Netherlands", "NLD", 528),
    NO("Norway", "NOR", 578),
    NP("Nepal", "NPL", 524),
    NR("Nauru", "NRU", 520),
    NT("Neutral Zone", "NTZ", 536),
    NU("Niue", "NIU", 570),
    NZ("New Zealand", "NZL", 554),
    OM("Oman", "OMN", 512),
    PA("Panama", "PAN", 591),
    PE("Peru", "PER", 604),
    PF("French Polynesia", "PYF", 258),
    PG("Papua New Guinea", "PNG", 598),
    PH("Philippines", "PHL", 608),
    PK("Pakistan", "PAK", 586),
    PL("Poland", "POL", 616),
    PM("Saint Pierre and Miquelon", "SPM", 666),
    PN("Pitcairn", "PCN", 612),
    PR("Puerto Rico", "PRI", 630),
    PS("Palestine, State of", "PSE", 275),
    PT("Portugal", "PRT", 620),
    PW("Palau", "PLW", 585),
    PY("Paraguay", "PRY", 600),
    QA("Qatar", "QAT", 634),
    QN("Nagorno-Karabakh", null, -1),
    RE("R\u00E9union", "REU", 638),
    RO("Romania", "ROU", 642),
    RS("Serbia", "SRB", 688),
    RU("Russian Federation", "RUS", 643),
    RW("Rwanda", "RWA", 646),
    SA("Saudi Arabia", "SAU", 682),
    SB("Solomon Islands", "SLB", 90),
    SC("Seychelles", "SYC", 690),
    SD("Sudan", "SDN", 729),
    SE("Sweden", "SWE", 752),
    SF("Finland", "FIN", 246),
    SG("Singapore", "SGP", 702),
    SH("Saint Helena, Ascension and Tristan da Cunha", "SHN", 654),
    SI("Slovenia", "SVN", 705),
    SJ("Svalbard and Jan Mayen", "SJM", 744),
    SK("Slovakia", "SVK", 703),
    SL("Sierra Leone", "SLE", 694),
    SM("San Marino", "SMR", 674),
    SN("Senegal", "SEN", 686),
    SO("Somalia", "SOM", 706),
    SR("Suriname", "SUR", 740),
    SS("South Sudan", "SSD", 728),
    ST("Sao Tome and Principe", "STP", 678),
    SU("USSR", "SUN", 810),
    SV("El Salvador", "SLV", 222),
    SX("Sint Maarten (Dutch part)", "SXM", 534),
    SY("Syrian Arab Republic", "SYR", 760),
    SZ("Swaziland", "SWZ", 748),
    TA("Tristan da Cunha", "TAA", -1),
    TC("Turks and Caicos Islands", "TCA", 796),
    TD("Chad", "TCD", 148),
    TF("French Southern Territories", "ATF", 260),
    TG("Togo", "TGO", 768),
    TH("Thailand", "THA", 764),
    TJ("Tajikistan", "TJK", 762),
    TK("Tokelau", "TKL", 772),
    TL("Timor-Leste", "TLS", 626),
    TM("Turkmenistan", "TKM", 795),
    TN("Tunisia", "TUN", 788),
    TO("Tonga", "TON", 776),
    TP("East Timor", "TMP", 626),
    TR("Turkey", "TUR", 792),
    TT("Trinidad and Tobago", "TTO", 780),
    TV("Tuvalu", "TUV", 798),
    TW("Taiwan, Province of China", "TWN", 158),
    TZ("Tanzania, United Republic of", "TZA", 834),
    UA("Ukraine", "UKR", 804),
    UG("Uganda", "UGA", 800),
    UK("United Kingdom", "GBR", 826),
    UM("United States Minor Outlying Islands", "UMI", 581),
    US("United States", "USA", 840),
    UY("Uruguay", "URY", 858),
    UZ("Uzbekistan", "UZB", 860),
    VA("Holy See (Vatican City State)", "VAT", 336),
    VC("Saint Vincent and the Grenadines", "VCT", 670),
    VE("Venezuela, Bolivarian Republic of", "VEN", 862),
    VG("Virgin Islands, British", "VGB", 92),
    VI("Virgin Islands, U.S.", "VIR", 850),
    VN("Viet Nam", "VNM", 704),
    VU("Vanuatu", "VUT", 548),
    WF("Wallis and Futuna", "WLF", 876),
    WS("Samoa", "WSM", 882),
    XC("International Telecommunications Public Correspondence Service", null, -1),
    XD("United Nations Office for the Coordination of Humanitarian Affairs", null, -1),
    XG("Global Mobile Satellite System", null, -1),
    XK("Kosovo, Republic of", "XXK", -1),
    XN("Inmarsat", null, -1),
    XP("Universal Personal Telecommunications", null, -1),
    XR("International Premium Rate Service", null, -1),
    XS("Shared-cost service", null, -1),
    XT("Universal International Freephone Number", null, -1),
    XV("International Networks", null, -1),
    YE("Yemen", "YEM", 887),
    YT("Mayotte", "MYT", 175),
    YU("Yugoslavia", "YUG", 890),
    ZA("South Africa", "ZAF", 710),
    ZM("Zambia", "ZMB", 894),
    ZR("Zaire", "ZAR", 180),
    ZW("Zimbabwe", "ZWE", 716);

    private final String name;
    private final String alpha3;
    private final int numeric;

    CountryCode(String name, String alpha3, int numeric) {
        this.name = name;
        this.alpha3 = alpha3;
        this.numeric = numeric;
    }

    public String getName() {
        return name;
    }

    public String getAlpha2() {
        return name();
    }

    public String getAlpha3() {
        return alpha3;
    }

    public int getNumeric() {
        return numeric;
    }

    private static CountryCode getByAlpha2Code(String code) {
        try {
            return Enum.valueOf(CountryCode.class, code);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * Searches for countries based on regular expression describing a name.
     *
     * @param regex regular expression for country name
     * @return a list of countries codes
     */
    public static List<CountryCode> findByName(String regex) {
        Pattern pattern = Pattern.compile(regex);
        List<CountryCode> list = new ArrayList<CountryCode>();
        for (CountryCode entry : values()) {
            if (pattern.matcher(entry.getName()).matches()) {
                list.add(entry);
            }
        }
        return list;
    }
}

