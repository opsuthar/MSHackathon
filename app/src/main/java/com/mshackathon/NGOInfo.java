package com.mshackathon;

/**
 * Created by omsuthar on 7/24/2017.
 */

public class NGOInfo {

    private long registrationNo;
    private String name;
    private AddressInfo addressInfo;

    public NGOInfo(long registrationNo, String name, AddressInfo addressInfo) {
        this.registrationNo = registrationNo;
        this.name = name;
        this.addressInfo = addressInfo;
    }

    public NGOInfo(int registrationNo, String name) {
        this.registrationNo = registrationNo;
        this.name = name;
    }


    public long getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(long registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }
}
