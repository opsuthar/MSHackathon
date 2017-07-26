package com.mshackathon;

/**
 * Created by omsuthar on 7/24/2017.
 */

public class AddressInfo
{
    private String country;
    private String state;
    private String district;
    private String tehsil;
    private long houseNo;
    private long pinCode;

    public AddressInfo(String country, String state, String district) {
        this.country = country;
        this.state = state;
        this.district = district;
        this.tehsil = tehsil;
        this.houseNo = houseNo;
        this.pinCode = pinCode;
    }


    public AddressInfo(String country, String state, String district, String tehsil, long houseNo, long pinCode) {
        this.country = country;
        this.state = state;
        this.district = district;
        this.tehsil = tehsil;
        this.houseNo = houseNo;
        this.pinCode = pinCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTehsil() {
        return tehsil;
    }

    public void setTehsil(String tehsil) {
        this.tehsil = tehsil;
    }

    public long getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(long houseNo) {
        this.houseNo = houseNo;
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }
}