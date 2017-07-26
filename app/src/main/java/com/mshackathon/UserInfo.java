package com.mshackathon;

/**
 * Created by omsuthar on 7/24/2017.
 */

public class UserInfo
{
    public long aadharNo;
    public String userName;
    public String interests;

    private AddressInfo addressInfo;

    public UserInfo(long aadharNo, String userName, String interests) {
        this.aadharNo = aadharNo;
        this.userName = userName;
        this.interests = interests;
        this.addressInfo = addressInfo;
    }

    public UserInfo(long aadharNo, String userName, String interests, AddressInfo addressInfo) {
        this.aadharNo = aadharNo;
        this.userName = userName;
        this.interests = interests;
        this.addressInfo = addressInfo;
    }

    public long getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(long aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }
}