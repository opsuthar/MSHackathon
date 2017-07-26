package com.mshackathon;

import android.util.Log;

/**
 * Created by omsuthar on 7/25/2017.
 */

public class Event implements  IEvent{

    private EventInfo eventInfo;
    private long eventId;
    private long addressId;

    private DBManager dbManager;


    public Event(DBManager dbManager, EventInfo eventInfo, long eventId, long addressId) {
        this.dbManager = dbManager;
        this.eventInfo = eventInfo;
        this.eventId = eventId;
        this.addressId = addressId;
    }

    public DBManager getDbManager() {
        return dbManager;
    }

    public void setDbManager(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public EventInfo getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(EventInfo eventInfo) {
        this.eventInfo = eventInfo;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }


    @Override
    public void Print() {
        Log.i(Constants.EventTag, ".....................Event info Start...........................");

        Log.i(Constants.EventTag, eventId + " " + eventInfo.getCategory() + " " + eventInfo.getDate() + " " +
                eventInfo.getDuration() + " " + eventInfo.getRequiredNumber() + " " + eventInfo.getCount() + " " +
                eventInfo.getDescription() + "   " + eventInfo.getNgoId() + "      Address:        ");


        AddressInfo addressInfo = eventInfo.getAddressInfo();
        Log.i(Constants.NGOTag, addressId + " " +  addressInfo.getCountry() + " " + addressInfo.getState() + " " + addressInfo.getDistrict() + " " + addressInfo.getTehsil() + " " +
                addressInfo.getHouseNo() + " " + addressInfo.getPinCode());



        Log.i(Constants.EventTag, ".....................Evnt info end...........................");
    }
}
