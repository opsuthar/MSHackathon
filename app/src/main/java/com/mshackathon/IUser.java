package com.mshackathon;

import java.util.ArrayList;

/**
 * Created by omsuthar on 7/24/2017.
 */

public interface IUser extends  IPrint {
    public boolean update();
    public boolean delete();
    public IPending CreatePendingRequest(RequestInfo requestInfo);
    public long getAadharId();
    public ArrayList<IPending> getPendingRequests();
    public ArrayList<IApproved> getApprovedRequests();
}

