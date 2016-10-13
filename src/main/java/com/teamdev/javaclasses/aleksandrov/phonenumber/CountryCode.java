package com.teamdev.javaclasses.aleksandrov.phonenumber;

public enum CountryCode {

    ANGUILLA("1-264", "Anguilla"),
    CANADA("1", "Canada"),
    UNITED_STATES("1", "United States");

    private String countryCode;
    private String country;

    private CountryCode(String code, String countryName) {
        this.countryCode = code;
        this.country = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }
    public String getCountryName() {
        return country;
    }

}
