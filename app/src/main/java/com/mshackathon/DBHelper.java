package com.mshackathon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by omsuthar on 7/24/2017.
 */

public final class DBHelper extends SQLiteOpenHelper{

    Context context;
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "17NGO.db";

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Constants.UserTable.SQL_CREATE_USER_ENTRIES);
        sqLiteDatabase.execSQL(Constants.NGOTable.SQL_CREATE_NGO_ENTRIES);
        sqLiteDatabase.execSQL(Constants.AddressTable.SQL_CREATE_ADDRESS_ENTRIES);
        sqLiteDatabase.execSQL(Constants.EventTable.SQL_CREATE_EVENT_ENTRIES);
        sqLiteDatabase.execSQL(Constants.PendingTable.SQL_CREATE_PENDING_REQUEST_ENTRIES);
        sqLiteDatabase.execSQL(Constants.ApprovedTable.SQL_CREATE_APPROVED_REQUEST_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        onUpgrade(sqLiteDatabase, oldVersion, newVersion);


    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);

        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    public void delete() {
        context.deleteDatabase(DATABASE_NAME);
    }

}