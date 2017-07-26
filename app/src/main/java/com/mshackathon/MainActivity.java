package com.mshackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final long aadhaarNos[] = {1234123412341234L, 2345234523452345L, 3456345634563456L};

    public static final long registratinoNos[] = {1234L, 2345L, 3456L};

    public static final EventInfo eventInfos[] = {
            new EventInfo("Education", "August 10, 2017", "10AM", 4, 10, 0, "Teach 10th class children"),

            new EventInfo("Plantation", "August 11, 2017", "10AM", 4, 50, 0, "Plant trees"),
            new EventInfo("Cleaning", "August 10, 2017", "10AM", 4, 20, 0, "Clean roads"),
    };

    public static final AddressInfo Addresses[] = {
            new AddressInfo("India", "Rajasthan", "Bhilwara"),
            new AddressInfo("India", "Uttarakhand", "Delhi"),
            new AddressInfo("India", "Telangana", "Hyderabad"),
    };

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager = new DBManager(getApplicationContext());

        int index = 0;

        AadharTable aadharTable = new AadharTable();
        UserInfo userInfo = aadharTable.Authenticate(aadhaarNos[index]);
        if(userInfo != null) {
            System.out.println("User Login successful");
        }
        else {
            System.out.println("Login un successful");
            return;
        }

        // Register 1st User.


        userInfo.setAddressInfo(Addresses[index]);
        IUser user = dbManager.addUser(userInfo);
        if(user != null) {
            System.out.println("Adding new user to database successful");

        }
        else {
            System.out.println("Adding new user to database un-successful");
            return;
        }

        user.Print();

        // register 1st NGO

        RegistrationTable registrationTable = new RegistrationTable();

        NGOInfo ngoInfo = registrationTable.Authenticate(registratinoNos[index]);
        if(ngoInfo != null) {
            System.out.println("NGO Login successful");

        }
        else {
            System.out.println("NGO Login un successful");
            return;
        }

        INGO ngo = dbManager.addNGO(ngoInfo);
        if(ngo != null) {
            System.out.println("Adding new NGO to database successful");

        }
        else {
            System.out.println("Adding new NGO to database un-successful");
            return;
        }

        ngo.Print();

        // Create an event.
        EventInfo eventInfo = eventInfos[index];

        eventInfo.setAddressInfo(Addresses[index]);
        IEvent event = ngo.CreateEvent(eventInfo);
        if(event != null) {
            System.out.println("Adding new Event to database successful");

        }
        else {
            System.out.println("Adding new Event to database un-successful");
            return;
        }

        event.Print();

        // Add a user request to join the above event.
        RequestInfo requestInfo = new RequestInfo(event.getEventId(), user.getAadharId());

        IPending pendingRequest = dbManager.addRequest(requestInfo);

        if(pendingRequest != null) {
            System.out.println("Adding Pending request to database successful");

        }
        else {
            System.out.println("Adding pending requst to database un-successful");
            return;
        }

        // Get all the request for the user.


        }
}
