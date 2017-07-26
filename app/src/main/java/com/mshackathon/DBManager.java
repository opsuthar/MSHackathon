package com.mshackathon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by omsuthar on 7/24/2017.
 */

public class DBManager {

    DBHelper dbHelper;
    private SQLiteDatabase reader;
    private SQLiteDatabase writer;

    public DBManager(Context context) {

        dbHelper = new DBHelper(context);

        reader = dbHelper.getReadableDatabase();
        writer = dbHelper.getWritableDatabase();
    }

    public void Destroy() {
        dbHelper.delete();
    }

    public IUser addUser(UserInfo userInfo) {

            AddressInfo addressInfo = userInfo.getAddressInfo();

        if(addressInfo == null) {
            System.out.println("User address is null");
            return null;
        }

            // First try to insert the new address.
            ContentValues addressValues = new ContentValues();
            addressValues.put(Constants.AddressTable.COUNTRY, addressInfo.getCountry());
            addressValues.put(Constants.AddressTable.STATE, addressInfo.getState());
            addressValues.put(Constants.AddressTable.DISTRICT, addressInfo.getDistrict());
            addressValues.put(Constants.AddressTable.TEHSIL, addressInfo.getTehsil());
            addressValues.put(Constants.AddressTable.HOUSENO, addressInfo.getHouseNo());
            addressValues.put(Constants.AddressTable.PINCODE, addressInfo.getPinCode());

            // Insert the new row, returning the primary key value of the new row
            long newRowIdAddress = writer.insert(Constants.AddressTable.TABLE_NAME, null, addressValues);
            if(newRowIdAddress == -1) {
                Log.e(Constants.AddressTag,  "Adding new address failed" + addressValues.toString());
                return null;
            }

            ContentValues userValues = new ContentValues();
            userValues.put(Constants.UserTable.ID, userInfo.getAadharNo());
            userValues.put(Constants.UserTable.USER_NAME, userInfo.getUserName());
            userValues.put(Constants.UserTable.INTERESTS, userInfo.getInterests());
            userValues.put(Constants.UserTable.ADDRESS_ID, newRowIdAddress);

            // Insert the new row, returning the primary key value of the new row
            long newRowIdUser = writer.insert(Constants.UserTable.TABLE_NAME, null, userValues);
            if(newRowIdUser == -1) {
                Log.e(Constants.UserTag,  "Adding new User failed" + userValues.toString());
                return null;
            }

        return new User(this, userInfo, newRowIdAddress);
    }

    public INGO addNGO(NGOInfo ngoInfo) {

        AddressInfo addressInfo = ngoInfo.getAddressInfo();

        if(addressInfo == null) {
            System.out.println("NGO address is null");
            return null;
        }

        // First try to insert the new address.
        ContentValues addressValues = new ContentValues();
        addressValues.put(Constants.AddressTable.COUNTRY, addressInfo.getCountry());
        addressValues.put(Constants.AddressTable.STATE, addressInfo.getState());
        addressValues.put(Constants.AddressTable.DISTRICT, addressInfo.getDistrict());
        addressValues.put(Constants.AddressTable.TEHSIL, addressInfo.getTehsil());
        addressValues.put(Constants.AddressTable.HOUSENO, addressInfo.getHouseNo());
        addressValues.put(Constants.AddressTable.PINCODE, addressInfo.getPinCode());

        // Insert the new row, returning the primary key value of the new row
        long newRowIdAddress = writer.insert(Constants.AddressTable.TABLE_NAME, null, addressValues);
        if(newRowIdAddress == -1) {
            Log.e(Constants.NGOTag, "Adding new address failed for NGO" + addressValues.toString());
            return null;
        }

        // First try to insert the new address row
        ContentValues ngoValues = new ContentValues();
        ngoValues.put(Constants.NGOTable.ID, ngoInfo.getRegistrationNo());
        ngoValues.put(Constants.NGOTable.NAME, ngoInfo.getName());

        // Insert the new row, returning the primary key value of the new row
        long newRowIdNGO = writer.insert(Constants.NGOTable.TABLE_NAME, null, ngoValues);
        if(newRowIdNGO == -1) {
            Log.e(Constants.NGOTag, "Adding new address failed for NGO" + ngoValues.toString());
            return null;
        }

        return new NGO(ngoInfo, newRowIdAddress, this);
    }

    public IEvent addEvent(EventInfo eventInfo, long ngoId) {

        AddressInfo addressInfo = eventInfo.getAddressInfo();

        if(addressInfo == null) {
            System.out.println("Event address is null");
            return null;
        }

        // First try to insert the new address.
        ContentValues addressValues = new ContentValues();
        addressValues.put(Constants.AddressTable.COUNTRY, addressInfo.getCountry());
        addressValues.put(Constants.AddressTable.STATE, addressInfo.getState());
        addressValues.put(Constants.AddressTable.DISTRICT, addressInfo.getDistrict());
        addressValues.put(Constants.AddressTable.TEHSIL, addressInfo.getTehsil());
        addressValues.put(Constants.AddressTable.HOUSENO, addressInfo.getHouseNo());
        addressValues.put(Constants.AddressTable.PINCODE, addressInfo.getPinCode());

        // Insert the new row, returning the primary key value of the new row
        long addressId = writer.insert(Constants.AddressTable.TABLE_NAME, null, addressValues);
        if(addressId == -1) {
            System.out.println("Adding new address failed for NGO" + addressValues.toString());
            return null;
        }

        // First try to insert the new address row
        ContentValues eventValues = new ContentValues();
        eventValues.put(Constants.EventTable.CATEGORY, eventInfo.getCategory());

        // TODO: add time valyes.

        eventValues.put(Constants.EventTable.DURATION, eventInfo.getDuration());
        eventValues.put(Constants.EventTable.REQUIRED_NO, eventInfo.getRequiredNumber());
        eventValues.put(Constants.EventTable.COUNT, eventInfo.getCount());
        eventValues.put(Constants.EventTable.DESCRIPTION, eventInfo.getDescription());
        eventValues.put(Constants.EventTable.ADDRESS_ID, addressId);
        eventValues.put(Constants.EventTable.NGO_ID, ngoId);

        // Insert the new row, returning the primary key value of the new row
        long eventId = writer.insert(Constants.EventTable.TABLE_NAME, null, eventValues);
        if(eventId == -1) {
            System.out.println("Adding new address failed for NGO" + eventValues.toString());
            return null;
        }

        return new Event(this, eventInfo, eventId, addressId);
    }

    public IPending addRequest(RequestInfo requestInfo) {

        ContentValues pendingRequestValues = new ContentValues();
        pendingRequestValues.put(Constants.PendingTable.ID, requestInfo.getEventId());
        pendingRequestValues.put(Constants.PendingTable.USER_ID, requestInfo.getUserId());

        // Insert the new row, returning the primary key value of the new row
        long pendingRow = writer.insert(Constants.PendingTable.TABLE_NAME, null, pendingRequestValues);
        if(pendingRow == -1) {
            Log.e(Constants.PendingRequestTag, "Adding new pending table entry failed." + requestInfo);
            return null;
        }

        return new Pending(requestInfo);
    }

    public Cursor getCursor(String tableName, String [] projection) {

        return reader.query(
                tableName,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
    }

    public ArrayList<IPending> getPendingRequests(long aadharNo) {


        return null;
    }

    public SQLiteDatabase GetReader() {
        return reader;
    }

    public SQLiteDatabase GetWriter() {
        return writer;
    }
}
