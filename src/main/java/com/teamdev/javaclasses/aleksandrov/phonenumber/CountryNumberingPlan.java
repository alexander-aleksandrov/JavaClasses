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
 * Telephone dialing prefixes for the member countries of the International Telecommunication Union (ITU).
 *
 * @author Alexander Aleksandrov
 */
public enum CountryNumberingPlan {

    UNDEFINED(" ", new int[]{}, new int[]{}, CountryCode.UNDEFINED),

    /*Zone 1: North American Numbering Plan Area*/
    CA("1", new int[]{3}, new int[]{7}, CountryCode.CA),
    US("1", new int[]{3}, new int[]{7}, CountryCode.US),
    BS("1242", new int[]{3}, new int[]{4}, CountryCode.BS),
    BB("1246", new int[]{3}, new int[]{4}, CountryCode.BB),
    AI("1264", new int[]{3}, new int[]{4}, CountryCode.AI),
    AG("1268", new int[]{3}, new int[]{4}, CountryCode.AG),
    VG("1284", new int[]{3}, new int[]{4}, CountryCode.VG),
    VI("1340", new int[]{3}, new int[]{4}, CountryCode.VI),
    KY("1345", new int[]{3}, new int[]{4}, CountryCode.KY),
    BM("1441", new int[]{3}, new int[]{4}, CountryCode.BM),
    GD("1473", new int[]{3}, new int[]{4}, CountryCode.GD),
    TC("1649", new int[]{3}, new int[]{4}, CountryCode.TC),
    MS("1664", new int[]{3}, new int[]{4}, CountryCode.MS),
    MP("1670", new int[]{3}, new int[]{4}, CountryCode.MP),
    GU("1671", new int[]{3}, new int[]{4}, CountryCode.GU),
    AS("1684", new int[]{3}, new int[]{4}, CountryCode.AS),
    SX("1721", new int[]{3}, new int[]{4}, CountryCode.SX),
    LC("1758", new int[]{3}, new int[]{4}, CountryCode.LC),
    DM("1767", new int[]{3}, new int[]{4}, CountryCode.DM),
    VC("1784", new int[]{3}, new int[]{4}, CountryCode.VC),
    PR_1("1787", new int[]{3}, new int[]{4}, CountryCode.PR),
    DO_1("1809", new int[]{3}, new int[]{4}, CountryCode.DO),
    DO_2("1829", new int[]{3}, new int[]{4}, CountryCode.DO),
    DO_3("1849", new int[]{3}, new int[]{4}, CountryCode.DO),
    TT("1868", new int[]{3}, new int[]{4}, CountryCode.TT),
    KN("1869", new int[]{3}, new int[]{4}, CountryCode.KN),
    JM("1876", new int[]{3}, new int[]{4}, CountryCode.JM),
    PR_2("1939", new int[]{3}, new int[]{4}, CountryCode.PR),

    /*Zone 2: mostly Africa (but also Aruba, Faroe Islands, Greenland and British Indian Ocean Territory)*/
    EG("20", new int[]{1, 5}, new int[]{3, 11}, CountryCode.EG),
    SS("211", new int[]{2}, new int[]{7}, CountryCode.SS),
    MA("212", new int[]{4, 6}, new int[]{4, 6}, CountryCode.MA),
    DZ("213", new int[]{2}, new int[]{7}, CountryCode.DZ),
    TN("216", new int[]{2}, new int[]{6}, CountryCode.TN),
    LY("218", new int[]{2, 3}, new int[]{6, 7}, CountryCode.LY),
    GM("220", new int[]{3}, new int[]{4}, CountryCode.GM),
    SN("221", new int[]{2}, new int[]{7}, CountryCode.SN),
    MR("222", new int[]{3}, new int[]{5}, CountryCode.MR),
    ML("223", new int[]{1, 4}, new int[]{4, 8}, CountryCode.ML),
    GN("224", new int[]{3}, new int[]{6}, CountryCode.GN),
    CI("225", new int[]{2, 3}, new int[]{5, 6}, CountryCode.CI),
    BF("226", new int[]{4}, new int[]{4}, CountryCode.BF),
    NE("227", new int[]{4}, new int[]{4}, CountryCode.NE),
    TG("228", new int[]{2}, new int[]{6}, CountryCode.TG),
    BJ("229", new int[]{2}, new int[]{3, 6}, CountryCode.BJ),
    MU("230", new int[]{2}, new int[]{3, 7}, CountryCode.MU),
//TODO:2016-11-24:alexander.aleksandrov: finish with areacode range
    LR("231", new int[]{2}, new int[]{7}, CountryCode.LR),
    SL("232", new int[]{2}, new int[]{7}, CountryCode.SL),
    GH("233", new int[]{2}, new int[]{7}, CountryCode.GH),
    NG("234", new int[]{2}, new int[]{7}, CountryCode.NG),
    TD("235", new int[]{2}, new int[]{7}, CountryCode.TD),
    CF("236", new int[]{2}, new int[]{7}, CountryCode.CF),
    CM("237", new int[]{2}, new int[]{7}, CountryCode.CM),
    CV("238", new int[]{2}, new int[]{7}, CountryCode.CV),
    ST("239", new int[]{2}, new int[]{7}, CountryCode.ST),
    GQ("240", new int[]{2}, new int[]{7}, CountryCode.GQ),
    GA("241", new int[]{2}, new int[]{7}, CountryCode.GA),
    CG("242", new int[]{2}, new int[]{7}, CountryCode.CG),
    CD("243", new int[]{2}, new int[]{7}, CountryCode.CD),
    AO("244", new int[]{2}, new int[]{7}, CountryCode.AO),
    GW("245", new int[]{2}, new int[]{7}, CountryCode.GW),
    IO("246", new int[]{2}, new int[]{7}, CountryCode.IO),
    AC("247", new int[]{2}, new int[]{7}, CountryCode.AC),
    SC("248", new int[]{2}, new int[]{7}, CountryCode.SC),
    SD("249", new int[]{2}, new int[]{7}, CountryCode.SD),
    RW("250", new int[]{2}, new int[]{7}, CountryCode.RW),
    ET("251", new int[]{2}, new int[]{7}, CountryCode.ET),
    SO("252", new int[]{2}, new int[]{7}, CountryCode.SO),
    DJ("253", new int[]{2}, new int[]{7}, CountryCode.DJ),
    KE("254", new int[]{2}, new int[]{7}, CountryCode.KE),
    TZ("255", new int[]{2}, new int[]{7}, CountryCode.TZ),
    UG("256", new int[]{2}, new int[]{7}, CountryCode.UG),
    BI("257", new int[]{2}, new int[]{7}, CountryCode.BI),
    MZ("258", new int[]{2}, new int[]{7}, CountryCode.MZ),
    ZM("260", new int[]{2}, new int[]{7}, CountryCode.ZM),
    MG("261", new int[]{2}, new int[]{7}, CountryCode.MG),
    RE("262", new int[]{2}, new int[]{7}, CountryCode.RE),
    YT("262", new int[]{2}, new int[]{7}, CountryCode.YT),
    TF("262", new int[]{2}, new int[]{7}, CountryCode.TF),
    ZW("263", new int[]{2}, new int[]{7}, CountryCode.ZW),
    NA("264", new int[]{2}, new int[]{7}, CountryCode.NA),
    MW("265", new int[]{2}, new int[]{7}, CountryCode.MW),
    LS("266", new int[]{2}, new int[]{7}, CountryCode.LS),
    BW("267", new int[]{2}, new int[]{7}, CountryCode.BW),
    SZ("268", new int[]{2}, new int[]{7}, CountryCode.SZ),
    KM("269", new int[]{2}, new int[]{7}, CountryCode.KM),
    ZA("27", new int[]{2}, new int[]{7}, CountryCode.ZA),
    SH("290", new int[]{2}, new int[]{7}, CountryCode.SH),
    TA("290", new int[]{2}, new int[]{7}, CountryCode.TA),
    ER("291", new int[]{2}, new int[]{7}, CountryCode.ER),
    AW("297", new int[]{2}, new int[]{7}, CountryCode.AW),
    FO("298", new int[]{2}, new int[]{7}, CountryCode.FO),
    GL("299", new int[]{2}, new int[]{7}, CountryCode.GL),

    /*Zones 3-4: Europe*/
    GR("30", new int[]{2}, new int[]{7}, CountryCode.GR),
    NL("31", new int[]{2}, new int[]{7}, CountryCode.NL),
    BE("32", new int[]{2}, new int[]{7}, CountryCode.BE),
    FR("33", new int[]{2}, new int[]{7}, CountryCode.FR),
    ES("34", new int[]{2}, new int[]{7}, CountryCode.ES),
    GI("350", new int[]{2}, new int[]{7}, CountryCode.GI),
    PT("351", new int[]{2}, new int[]{7}, CountryCode.PT),
    LU("352", new int[]{2}, new int[]{7}, CountryCode.LU),
    IE("353", new int[]{2}, new int[]{7}, CountryCode.IE),
    IS("354", new int[]{2}, new int[]{7}, CountryCode.IS),
    AL("355", new int[]{2}, new int[]{7}, CountryCode.AL),
    MT("356", new int[]{2}, new int[]{7}, CountryCode.MT),
    CY("357", new int[]{2}, new int[]{7}, CountryCode.CY),
    FI("358", new int[]{2}, new int[]{7}, CountryCode.FI),
    AX("358", new int[]{2}, new int[]{7}, CountryCode.AX),
    BG("359", new int[]{2}, new int[]{7}, CountryCode.BG),
    HU("36", new int[]{2}, new int[]{7}, CountryCode.HU),
    LT("370", new int[]{2}, new int[]{7}, CountryCode.LT),
    LV("371", new int[]{2}, new int[]{7}, CountryCode.LV),
    EE("372", new int[]{2}, new int[]{7}, CountryCode.EE),
    MD("373", new int[]{2}, new int[]{7}, CountryCode.MD),
    AM("374", new int[]{2}, new int[]{7}, CountryCode.AM),
    QN("374", new int[]{2}, new int[]{7}, CountryCode.QN),
    BY("375", new int[]{2}, new int[]{7}, CountryCode.BY),
    AD("376", new int[]{2}, new int[]{7}, CountryCode.AD),
    MC("377", new int[]{2}, new int[]{7}, CountryCode.MC),
    SM("378", new int[]{2}, new int[]{7}, CountryCode.SM),
    VA_1("379", new int[]{2}, new int[]{7}, CountryCode.VA),
    UA("380", new int[]{2}, new int[]{7}, CountryCode.UA),
    RS("381", new int[]{2}, new int[]{7}, CountryCode.RS),
    ME("382", new int[]{2}, new int[]{7}, CountryCode.ME),
    XK("383", new int[]{2}, new int[]{7}, CountryCode.XK),
    HR("385", new int[]{2}, new int[]{7}, CountryCode.HR),
    SI("386", new int[]{2}, new int[]{7}, CountryCode.SI),
    BA("387", new int[]{2}, new int[]{7}, CountryCode.BA),
    EU("388", new int[]{2}, new int[]{7}, CountryCode.EU),
    MK("389", new int[]{2}, new int[]{7}, CountryCode.MK),
    IT("39", new int[]{2}, new int[]{7}, CountryCode.IT),
    VA_2("39", new int[]{2}, new int[]{7}, CountryCode.VA),
    RO("40", new int[]{2}, new int[]{7}, CountryCode.RO),
    CH("41", new int[]{2}, new int[]{7}, CountryCode.CH),
    CZ("420", new int[]{2}, new int[]{7}, CountryCode.CZ),
    SK("421", new int[]{2}, new int[]{7}, CountryCode.SK),
    LI("423", new int[]{2}, new int[]{7}, CountryCode.LI),
    AT("43", new int[]{2}, new int[]{7}, CountryCode.AT),
    GB("44", new int[]{2}, new int[]{7}, CountryCode.GB),
    GG("44", new int[]{2}, new int[]{7}, CountryCode.GG),
    IM("44", new int[]{2}, new int[]{7}, CountryCode.IM),
    JE("44", new int[]{2}, new int[]{7}, CountryCode.JE),
    DK("45", new int[]{2}, new int[]{7}, CountryCode.DK),
    SE("46", new int[]{2}, new int[]{7}, CountryCode.SE),
    NO("47", new int[]{2}, new int[]{7}, CountryCode.NO),
    SJ("47", new int[]{2}, new int[]{7}, CountryCode.SJ),
    PL("48", new int[]{2}, new int[]{7}, CountryCode.PL),
    DE("49", new int[]{3, 5}, new int[]{3, 14}, CountryCode.DE),

    /*Zone 5: Central America and South America*/
    FK("500", new int[]{2}, new int[]{7}, CountryCode.FK),
    GS("500", new int[]{2}, new int[]{7}, CountryCode.GS),
    BZ("501", new int[]{2}, new int[]{7}, CountryCode.BZ),
    GT("502", new int[]{2}, new int[]{7}, CountryCode.GT),
    SV("503", new int[]{2}, new int[]{7}, CountryCode.SV),
    HN("504", new int[]{2}, new int[]{7}, CountryCode.HN),
    NI("505", new int[]{2}, new int[]{7}, CountryCode.NI),
    CR("506", new int[]{2}, new int[]{7}, CountryCode.CR),
    PA("507", new int[]{2}, new int[]{7}, CountryCode.PA),
    PM("508", new int[]{2}, new int[]{7}, CountryCode.PM),
    HT("509", new int[]{2}, new int[]{7}, CountryCode.HT),
    PE("51", new int[]{2}, new int[]{7}, CountryCode.PE),
    MX("52", new int[]{2}, new int[]{7}, CountryCode.MX),
    CU("53", new int[]{2}, new int[]{7}, CountryCode.CU),
    AR("54", new int[]{2}, new int[]{7}, CountryCode.AR),
    BR("55", new int[]{2}, new int[]{7}, CountryCode.BR),
    CL("56", new int[]{2}, new int[]{7}, CountryCode.CL),
    CO("57", new int[]{2}, new int[]{7}, CountryCode.CO),
    VE("58", new int[]{2}, new int[]{7}, CountryCode.VE),
    GP("590", new int[]{2}, new int[]{7}, CountryCode.GP),
    BL("590", new int[]{2}, new int[]{7}, CountryCode.BL),
    MF("590", new int[]{2}, new int[]{7}, CountryCode.MF),
    BO("591", new int[]{2}, new int[]{7}, CountryCode.BO),
    GY("592", new int[]{2}, new int[]{7}, CountryCode.GY),
    EC("593", new int[]{2}, new int[]{7}, CountryCode.EC),
    GF("594", new int[]{2}, new int[]{7}, CountryCode.GF),
    PY("595", new int[]{2}, new int[]{7}, CountryCode.PY),
    MQ("596", new int[]{2}, new int[]{7}, CountryCode.MQ),
    SR("597", new int[]{2}, new int[]{7}, CountryCode.SR),
    UY("598", new int[]{2}, new int[]{7}, CountryCode.UY),
    BQ("599", new int[]{2}, new int[]{7}, CountryCode.BQ),
    CW("599", new int[]{2}, new int[]{7}, CountryCode.CW),

    /*Zone 6: Southeast Asia and Oceania*/
    MY("60", new int[]{2}, new int[]{7}, CountryCode.MY),
    AU("61", new int[]{2}, new int[]{7}, CountryCode.AU),
    CX("61", new int[]{2}, new int[]{7}, CountryCode.CX),
    CC("61", new int[]{2}, new int[]{7}, CountryCode.CC),
    ID("62", new int[]{2}, new int[]{7}, CountryCode.ID),
    PH("63", new int[]{2}, new int[]{7}, CountryCode.PH),
    NZ("64", new int[]{2}, new int[]{7}, CountryCode.NZ),
    PN("64", new int[]{2}, new int[]{7}, CountryCode.PN),
    SG("65", new int[]{2}, new int[]{7}, CountryCode.SG),
    TH("66", new int[]{2}, new int[]{7}, CountryCode.TH),
    TL("670", new int[]{2}, new int[]{7}, CountryCode.TL),
    NF("672", new int[]{2}, new int[]{7}, CountryCode.NF),
    AQ("672", new int[]{2}, new int[]{7}, CountryCode.AQ),
    BN("673", new int[]{2}, new int[]{7}, CountryCode.BN),
    NR("674", new int[]{2}, new int[]{7}, CountryCode.NR),
    PG("675", new int[]{2}, new int[]{7}, CountryCode.PG),
    TO("676", new int[]{2}, new int[]{7}, CountryCode.TO),
    SB("677", new int[]{2}, new int[]{7}, CountryCode.SB),
    VU("678", new int[]{2}, new int[]{7}, CountryCode.VU),
    FJ("679", new int[]{2}, new int[]{7}, CountryCode.FJ),
    PW("680", new int[]{2}, new int[]{7}, CountryCode.PW),
    WF("681", new int[]{2}, new int[]{7}, CountryCode.WF),
    CK("682", new int[]{2}, new int[]{7}, CountryCode.CK),
    NU("683", new int[]{2}, new int[]{7}, CountryCode.NU),
    WS("685", new int[]{2}, new int[]{7}, CountryCode.WS),
    KI("686", new int[]{2}, new int[]{7}, CountryCode.KI),
    NC("687", new int[]{2}, new int[]{7}, CountryCode.NC),
    TV("688", new int[]{2}, new int[]{7}, CountryCode.TV),
    PF("689", new int[]{2}, new int[]{7}, CountryCode.PF),
    TK("690", new int[]{2}, new int[]{7}, CountryCode.TK),
    FM("691", new int[]{2}, new int[]{7}, CountryCode.FM),
    MH("692", new int[]{2}, new int[]{7}, CountryCode.MH),

    /*Zone 7: Parts of the former Soviet Union*/
    RU_1("7", new int[]{2}, new int[]{7}, CountryCode.RU),
    KZ_1("7", new int[]{2}, new int[]{7}, CountryCode.KZ),
    RU_2("73", new int[]{2}, new int[]{7}, CountryCode.RU),
    RU_3("74", new int[]{2}, new int[]{7}, CountryCode.RU),
    KZ_2("76", new int[]{2}, new int[]{7}, CountryCode.KZ),
    KZ_3("77", new int[]{2}, new int[]{7}, CountryCode.KZ),
    RU_4("78", new int[]{2}, new int[]{7}, CountryCode.RU),
    RU_5("79", new int[]{2}, new int[]{7}, CountryCode.RU),

    /*Zone 8: East Asia and special services*/
    XT("800", new int[]{2}, new int[]{7}, CountryCode.XT),
    XS("808", new int[]{2}, new int[]{7}, CountryCode.XS),
    JP("81", new int[]{2}, new int[]{7}, CountryCode.JP),
    KR("82", new int[]{2}, new int[]{7}, CountryCode.KR),
    VN("84", new int[]{2}, new int[]{7}, CountryCode.VN),
    KP("850", new int[]{2}, new int[]{7}, CountryCode.KP),
    HK("852", new int[]{2}, new int[]{7}, CountryCode.HK),
    MO("853", new int[]{2}, new int[]{7}, CountryCode.MO),
    KH("855", new int[]{2}, new int[]{7}, CountryCode.KH),
    LA("856", new int[]{2}, new int[]{7}, CountryCode.LA),
    CN("86", new int[]{2}, new int[]{7}, CountryCode.CN),
    XN("870", new int[]{2}, new int[]{7}, CountryCode.XN),
    XP("878", new int[]{2}, new int[]{7}, CountryCode.XP),
    BD("880", new int[]{2}, new int[]{7}, CountryCode.BD),
    XG("881", new int[]{2}, new int[]{7}, CountryCode.XG),
    XV_1("882", new int[]{2}, new int[]{7}, CountryCode.XV),
    XV_2("883", new int[]{2}, new int[]{7}, CountryCode.XV),
    TW("886", new int[]{2}, new int[]{7}, CountryCode.TW),
    XD("888", new int[]{2}, new int[]{7}, CountryCode.XD),

    /*Zone 9: mostly Asia*/
    TR("90", new int[]{2}, new int[]{7}, CountryCode.TR),
    CT("90", new int[]{2}, new int[]{7}, CountryCode.CT),
    IN("91", new int[]{2}, new int[]{7}, CountryCode.IN),
    PK("92", new int[]{2}, new int[]{7}, CountryCode.PK),
    AF("93", new int[]{2}, new int[]{7}, CountryCode.AF),
    LK("94", new int[]{2}, new int[]{7}, CountryCode.LK),
    MM("95", new int[]{2}, new int[]{7}, CountryCode.MM),
    MV("960", new int[]{2}, new int[]{7}, CountryCode.MV),
    LB("961", new int[]{2}, new int[]{7}, CountryCode.LB),
    JO("962", new int[]{2}, new int[]{7}, CountryCode.JO),
    SY("963", new int[]{2}, new int[]{7}, CountryCode.SY),
    IQ("964", new int[]{2}, new int[]{7}, CountryCode.IQ),
    KW("965", new int[]{2}, new int[]{7}, CountryCode.KW),
    SA("966", new int[]{2}, new int[]{7}, CountryCode.SA),
    YE("967", new int[]{2}, new int[]{7}, CountryCode.YE),
    OM("968", new int[]{2}, new int[]{7}, CountryCode.OM),
    PS("970", new int[]{2}, new int[]{7}, CountryCode.PS),
    AE("971", new int[]{2}, new int[]{7}, CountryCode.AE),
    IL("972", new int[]{2}, new int[]{7}, CountryCode.IL),
    BH("973", new int[]{2}, new int[]{7}, CountryCode.BH),
    QA("974", new int[]{2}, new int[]{7}, CountryCode.QA),
    BT("975", new int[]{2}, new int[]{7}, CountryCode.BT),
    MN("976", new int[]{2}, new int[]{7}, CountryCode.MN),
    NP("977", new int[]{2}, new int[]{7}, CountryCode.NP),
    XR("979", new int[]{2}, new int[]{7}, CountryCode.XR),
    IR("98", new int[]{2}, new int[]{7}, CountryCode.IR),
    XC("991", new int[]{2}, new int[]{7}, CountryCode.XC),
    TJ("992", new int[]{2}, new int[]{7}, CountryCode.TJ),
    TM("993", new int[]{2}, new int[]{7}, CountryCode.TM),
    AZ("994", new int[]{2}, new int[]{7}, CountryCode.AZ),
    GE("995", new int[]{2}, new int[]{7}, CountryCode.GE),
    KG("996", new int[]{2}, new int[]{7}, CountryCode.KG),
    UZ("998", new int[]{2}, new int[]{7}, CountryCode.UZ);


    private final String countryCallingCode;
    private final int[] areaCodeRange;
    private final int[] subscriberNumberRange;
    private final CountryCode countryCode;

    private CountryNumberingPlan(String countryCallingCode, int[] areaCodeRange, int[] subscriberNumberRange, CountryCode countryCode) {
        this.countryCallingCode = countryCallingCode;
        this.areaCodeRange = areaCodeRange;
        this.subscriberNumberRange = subscriberNumberRange;
        this.countryCode = countryCode;
    }

    /**
     * Gets allowed range of digits for area number .
     *
     * @return allowed range of digits
     */
    public int[] getAreaCodeRange() {
        return areaCodeRange;
    }
    
    /**
     * Gets allowed range of digits for subscriber number .
     *
     * @return allowed range of digits
     */
    public int[] getSubscriberNumberRange() {
        return subscriberNumberRange;
    }

    /**
     * Gets international country calling code from a record.
     *
     * @return international country calling code
     */
    public String getCountryCallingCode() {
        return countryCallingCode;
    }

    /**
     * Gets {@link CountryCode}
     *
     * @return  with a full name
     */
    public CountryCode getCountryCode() {
        return countryCode;
    }

    /**
     * Searches for records based on regular expression.
     *
     * @param regex regular expression for codes
     * @return a list of country calling codes
     */
    public static List<CountryNumberingPlan> findByCountryCallingCode(String regex) {
        Pattern pattern = Pattern.compile(regex);
        List<CountryNumberingPlan> list = new ArrayList<CountryNumberingPlan>();
        for (CountryNumberingPlan entry : values()) {
            if (pattern.matcher(entry.getCountryCallingCode()).matches()) {
                list.add(entry);
            }
        }
        return list;
    }
}
