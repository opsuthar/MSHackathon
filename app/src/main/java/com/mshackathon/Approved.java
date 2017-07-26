package com.mshackathon;

import android.util.Log;

/**
 * Created by omsuthar on 7/26/2017.
 */

public class Approved implements IApproved {
    private RequestInfo requestInfo;

    public Approved(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
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
    public void Print() {
        Log.i(Constants.PendingRequestTag, ".....................Approved table info Start...........................");

        Log.i(Constants.PendingRequestTag, requestInfo.getEventId() + " " + requestInfo.getUserId());

        Log.i(Constants.PendingRequestTag, ".....................Approved table info end...........................");
    }
}
