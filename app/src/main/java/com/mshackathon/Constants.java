package com.mshackathon;

/**
 * Created by omsuthar on 7/24/2017.
 */
public final class Constants {

    public static class UserTable  {

        public static final String TABLE_NAME = "UserTable";

        // Columns
        public static final String ID = "AadhaarNo";
        public static final String USER_NAME = "UserName";
        public static final String ADDRESS_ID = "AddressId";
        public static final String INTERESTS = "Enterests";


        public static final String SQL_CREATE_USER_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        ID  + " INTEGER PRIMARY KEY," +
                        USER_NAME + " TEXT," +
                        ADDRESS_ID + " INTEGER," +
                        INTERESTS + " TEXT," +
                        "FOREIGN KEY(" + ADDRESS_ID + ") REFERENCES  "+
                        AddressTable.TABLE_NAME + "(" + AddressTable.ID + "));";

        public  static final String SQL_DELETE_USER_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class NGOTable  {

        public static final String TABLE_NAME = "NGOTable";

        // Columns
        public static final String ID = "RegistrationNo";
        public static final String NAME = "UserName";
        public static final String ADDRESS_ID = "AdressId";


        public static final String SQL_CREATE_NGO_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        ID  + " INTEGER PRIMARY KEY," +
                        NAME + " TEXT," +
                        ADDRESS_ID + " INTEGER," +
                        "FOREIGN KEY(" + ADDRESS_ID + ") REFERENCES  "+
                        AddressTable.TABLE_NAME + "(" + AddressTable.ID + "));";

        public  static final String SQL_DELETE_NGO_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }


    public static class EventTable  {

        public static final String TABLE_NAME = "EventTable";

        // Columns
        public static final String ID = "EventId";
        public static final String START_TIME = "StartTime";
        public static final String DURATION = "Duration";
        public static final String REQUIRED_NO = "RequiredNo";
        public static final String COUNT = "Count";
        public static final String DESCRIPTION = "Description";
        public static final String CATEGORY = "Category";
        public static final String ADDRESS_ID = "AddressId";
        public static final String NGO_ID = "NGOId";


        public static final String SQL_CREATE_EVENT_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        ID  + " INTEGER PRIMARY KEY," +
                        START_TIME + " DATE," +
                        DURATION + " INTEGER," +
                        REQUIRED_NO + " INTEGER," +
                        COUNT + " INTEGER," +
                        DESCRIPTION + " TEXT," +
                        CATEGORY + " TEXT," +
                        ADDRESS_ID + " INTEGER," +
                        NGO_ID + " INTEGER)";

        public  static final String SQL_DELETE_EVENT_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }


    public static class PendingTable  {

        public static final String TABLE_NAME = "PendingTable";

        // Columns
        public static final String ID = "EventId";
        public static final String USER_ID = "UserId";


        public static final String SQL_CREATE_PENDING_REQUEST_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        ID  + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        USER_ID + " INTEGER," +
                        "FOREIGN KEY(" + ID + ") REFERENCES  "+
                        EventTable.TABLE_NAME + "(" + EventTable.ID + "), " +
                        "FOREIGN KEY(" + USER_ID + ") REFERENCES  "+
                        UserTable.TABLE_NAME + "(" + UserTable.ID + "));";

        public  static final String SQL_DELETE_PENDING_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class ApprovedTable  {

        public static final String TABLE_NAME = "ApprovedTable";

        // Columns
        public static final String ID = "PendingId";
        public static final String EVENT_ID = "EventId";
        public static final String USER_ID = "UserId";


        public static final String SQL_CREATE_APPROVED_REQUEST_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        ID  + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        EVENT_ID  + " INTEGER," +
                        USER_ID + " INTEGER," +
                        "FOREIGN KEY(" + EVENT_ID + ") REFERENCES  "+
                        EventTable.TABLE_NAME + "(" + EventTable.ID + "), " +
                        "FOREIGN KEY(" + USER_ID + ") REFERENCES  "+
                        UserTable.TABLE_NAME + "(" + UserTable.ID + "));";


        public  static final String SQL_DELETE_APPROVED_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }


    public static class AddressTable  {

        public static final String TABLE_NAME = "AddressTable";

        // Columns
        public static final String ID = "AddressId";
        public static final String COUNTRY = "Country";
        public static final String STATE = "State";
        public static final String DISTRICT = "District";
        public static final String TEHSIL = "Tehsil";
        public static final String PINCODE = "PinCode";
        public static final String HOUSENO = "HouseNo";

        public static final String SQL_CREATE_ADDRESS_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        ID  + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COUNTRY + " TEXT," +
                        STATE + " TEXT," +
                        DISTRICT + " TEXT," +
                        TEHSIL + " TEXT," +
                        HOUSENO + " INTEGER," +
                        PINCODE + " INTEGER)";

        public  static final String SQL_DELETE_ADDRESS_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final String UserTag = "User";

    public static final String NGOTag = "NGO";

    public static final String EventTag = "NGO";

    public static final String AddressTag = "Address";

    public static final String PendingRequestTag = "PendingRequest";

    public static final String ApprovedRequestTag = "ApprovedRequest";

}
