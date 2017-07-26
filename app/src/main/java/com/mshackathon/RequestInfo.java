package com.mshackathon;

/**
 * Created by omsuthar on 7/26/2017.
 */

public class RequestInfo {
    private long eventId;
    private  long userId;

    public RequestInfo(long eventId, long userId) {
        this.eventId = eventId;
        this.userId = userId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
