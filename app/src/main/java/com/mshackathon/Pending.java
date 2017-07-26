package com.mshackathon;

import android.util.Log;

/**
 * Created by omsuthar on 7/26/2017.
 */

public class Pending implements IPending {

    private RequestInfo requestInfo;

    public Pending(RequestInfo requestInfo) {
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
        Log.i(Constants.PendingRequestTag, ".....................Pending table info Start...........................");

        Log.i(Constants.PendingRequestTag, requestInfo.getEventId() + " " + requestInfo.getUserId());

        Log.i(Constants.PendingRequestTag, ".....................Pending table info end...........................");
    }
}
