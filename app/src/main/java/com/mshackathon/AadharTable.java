package com.mshackathon;

/**
 * Created by omsuthar on 7/25/2017.
 */


class AadharDetail {
    private long aadhaarNo;
    private String name;
    private String mobile;
    private String country;
    private String state;
    private String district;

    public AadharDetail(long aadhaarNo, String name, String mobile, String country, String state, String district) {
        this.aadhaarNo = aadhaarNo;
        this.name = name;
        this.mobile = mobile;
        this.country = country;
        this.state = state;
        this.district = district;
    }

    public long getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(long aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }
}

public class AadharTable {

    private static  final AadharDetail[] aadharDetails = {

            new AadharDetail(1234123412341234L, "Saurabh", "9160130101", "India", "Uttarakhand", "Deharadun"),
            new AadharDetail(2345234523452345L, "Om Prakash Suthar", "9030162809", "India", "Rajasthan", "Bhilwara"),
            new AadharDetail(3456345634563456L, "Mahaveer", "9828604992", "India", "Rajasthan", "Bhilwara"),
    };

    public AadharTable() {
    }

    public UserInfo Authenticate(long aadharNo) {

        for(int i = 0; i < aadharDetails.length; i++ ) {
            AadharDetail aadharDetail = aadharDetails[i];

            if(aadharDetail.getAadhaarNo() == aadharNo)
                return new UserInfo(aadharNo, aadharDetail.getName(), "");
        }

        return null;
    }
}