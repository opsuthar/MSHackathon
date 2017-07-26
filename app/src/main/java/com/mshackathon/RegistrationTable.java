package com.mshackathon;

/**
 * Created by omsuthar on 7/26/2017.
 */

class RegistratinoDetail {
    private long registrationNo;
    private String name;
    private String mobile;
    private String country;
    private String state;
    private String district;

    public RegistratinoDetail(long registrationNo, String name, String mobile, String country, String state, String district) {
        this.registrationNo = registrationNo;
        this.name = name;
        this.mobile = mobile;
        this.country = country;
        this.state = state;
        this.district = district;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
}
public class RegistrationTable {
    private static  final RegistratinoDetail[] registratinoDetails = {

            new RegistratinoDetail(1234L, "Chanakya", "9160130101", "India", "Uttarakhand", "Deharadun"),
            new RegistratinoDetail(2345L, "Goonj", "9030162809", "India", "Rajasthan", "Bhilwara"),
            new RegistratinoDetail(3456L, "Mitra", "9828604992", "India", "Rajasthan", "Bhilwara"),
    };

    public RegistrationTable() {
    }

    public NGOInfo Authenticate(long registrationNo) {

        for(int i = 0; i < registratinoDetails.length; i++ ) {
            RegistratinoDetail registratinoDetail = registratinoDetails[i];

            if(registratinoDetail.getRegistrationNo() == registrationNo)
            {
                AddressInfo addressInfo = new AddressInfo(registratinoDetail.getCountry(), registratinoDetail.getState(), registratinoDetail.getDistrict());
                return new NGOInfo(registrationNo, registratinoDetail.getName(), addressInfo);
            }
        }

        return null;
    }
}
