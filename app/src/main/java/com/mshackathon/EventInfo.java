package com.mshackathon;

import java.sql.Date;

/**
 * Created by omsuthar on 7/25/2017.
 */

public class EventInfo {
    private String category;
    private String date;
    private String startTime;
    private int duration;
    private int requiredNumber;
    private int count;
    private String description;

    private long ngoId;

    private AddressInfo addressInfo;


    public EventInfo(String category, String date, String startTime, int duration, int requiredNumber, int count, String description) {
        this.category = category;
        this.date = date;
        this.startTime = startTime;
        this.duration = duration;
        this.requiredNumber = requiredNumber;
        this.count = count;
        this.description = description;

    }

    public EventInfo(String category, String date, String startTime, int duration, int requiredNumber, int count, String description, long ngoId, AddressInfo addressInfo) {
        this.category = category;
        this.date = date;
        this.startTime = startTime;
        this.duration = duration;
        this.requiredNumber = requiredNumber;
        this.count = count;
        this.description = description;
        this.ngoId = ngoId;
        this.addressInfo = addressInfo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRequiredNumber() {
        return requiredNumber;
    }

    public void setRequiredNumber(int requiredNumber) {
        this.requiredNumber = requiredNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getNgoId() {
        return ngoId;
    }

    public void setNgoId(long ngoId) {
        this.ngoId = ngoId;
    }

    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
