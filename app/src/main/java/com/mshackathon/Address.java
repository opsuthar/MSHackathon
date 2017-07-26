package com.mshackathon;

/**
 * Created by omsuthar on 7/24/2017.
 */

public class Address implements IAddress {

    private AddressInfo addressInfo;
    private long addressId;

    private DBManager dbManager;

    public Address(DBManager dbManager, AddressInfo addressInfo, long addressId) {
        this.dbManager = dbManager;
        this.addressInfo = addressInfo;
        this.addressId = addressId;
    }

    @Override
    public void Print() {
/*               String[] projection = {
                Constants.AddressTable.ID,
                Constants.AddressTable.COUNTRY,
                Constants.AddressTable.STATE,
                Constants.AddressTable.DISTRICT,
                Constants.AddressTable.TEHSIL,
                Constants.AddressTable.HOUSENO,
                Constants.AddressTable.PINCODE,
        };

        Cursor cursor = dbManager.GetReader().query(
                Constants.AddressTable.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        System.out.println(".....................Address Table...........................");
        List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {

            System.out.println(cursor.getLong(0) + " " + cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getString(3) + " " +  cursor.getString(4) + " " +
                    + cursor.getLong(5) + " " + cursor.getLong(6));
        }
        cursor.close();

        System.out.print(".....................Address Table..End........................."); */
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }
}


