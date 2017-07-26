package com.mshackathon;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omsuthar on 7/24/2017.
 */

public class NGO implements INGO {

    ArrayList<IEvent> events;
    private NGOInfo ngoInfo;
    private long addressId;
    private DBManager dbManager;

    public NGO(NGOInfo ngoInfo, long addressId, DBManager dbManager) {
        this.ngoInfo = ngoInfo;
        this.addressId = addressId;
        this.dbManager = dbManager;

        events = new ArrayList<IEvent>();
    }



    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public IEvent CreateEvent(EventInfo eventInfo) {

        IEvent event = dbManager.addEvent(eventInfo, ngoInfo.getRegistrationNo());
        if(event == null)
            return null;

        events.add(event);

        return event;
    }


    @Override
    public void Print() {
        Log.i(Constants.NGOTag, ".....................NGO info Start...........................");

        Log.i(Constants.NGOTag, ngoInfo.getRegistrationNo() + " " + ngoInfo.getName() + " ");

        AddressInfo addressInfo = ngoInfo.getAddressInfo();
        Log.i(Constants.NGOTag, addressId + " " +  addressInfo.getCountry() + " " + addressInfo.getState() + " " + addressInfo.getDistrict() + " " + addressInfo.getTehsil() + " " +
                addressInfo.getHouseNo() + " " + addressInfo.getPinCode());


        if(events != null) {
            for (int i = 0; i < events.size(); i++) {
                IEvent event = events.get(i);
                event.Print();
            }
        }


        Log.i(Constants.NGOTag, ".....................NGO Info End...........................");
    }
}
