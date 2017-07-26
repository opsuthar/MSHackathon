package com.mshackathon;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omsuthar on 7/24/2017.
 */

public class User implements IUser {

    private UserInfo userInfo;
    private ArrayList<IPending> pendingRequests;
    private ArrayList<IApproved> approvedRequests;
    private long addressId;
    private DBManager dbManager;

    public User(DBManager dbManager, UserInfo userInfo, long addressId) {
        this.dbManager = dbManager;
        this.userInfo = userInfo;

        this.addressId = addressId;

        pendingRequests = new ArrayList<IPending>();
        approvedRequests = new ArrayList<IApproved>();
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
    public IPending CreatePendingRequest(RequestInfo requestInfo) {

        IPending pendingRequest = dbManager.addRequest(requestInfo);
        if(pendingRequest == null)
            return null;

        pendingRequests.add(pendingRequest);

        return pendingRequest;
    }

    @Override
    public long getAadharId() {
        return userInfo.getAadharNo();
    }

    @Override
    public ArrayList<IPending> getPendingRequests() {
        // Don't cache pending requests as they might can converted into approved by the  NGO.
        return dbManager.getPendingRequests(userInfo.getAadharNo());
    }

    @Override
    public ArrayList<IApproved> getApprovedRequests() {
            return null;
    }

    @Override
    public void Print() {

        Log.i(Constants.UserTag, ".....................User info Start...........................");

        Log.i(Constants.UserTag, userInfo.getAadharNo() + " " + userInfo.getUserName() + " " + userInfo.getInterests() + " ");

        AddressInfo addressInfo = userInfo.getAddressInfo();
        Log.i(Constants.UserTag, addressId + " " +  addressInfo.getCountry() + " " + addressInfo.getState() + " " + addressInfo.getDistrict() + " " + addressInfo.getTehsil() + " " +
            addressInfo.getHouseNo() + " " + addressInfo.getPinCode());

        Log.i(Constants.UserTag, ".....................User Info End...........................");
 /*       String[] projection = {
                Constants.UserTable.ID,
                Constants.UserTable.USER_NAME,
                Constants.UserTable.INTERESTS,
                Constants.UserTable.ADDRESS_ID,
        };

        Cursor cursor = dbManager.getCursor(Constants.UserTable.TABLE_NAME, projection);
        if(cursor == null) {
            System.out.println("Getting cursor for printing user info failed" + this.toString());
            return;
        }

        System.out.println(".....................User Table...........................");
        List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {

            System.out.print(cursor.getLong(0) + " " + cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getLong(3));
        }
        cursor.close();

        Cursor addressCursor = dbManager.getCursor(Constants.AddressTable.TABLE_NAME, projection);
        if(cursor == null) {
            System.out.println("Getting cursor for printing user info failed" + this.toString());
            return;
        }

        System.out.println(".....................User Table..End.........................");
        */


    }
}


