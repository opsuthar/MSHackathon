package com.mshackathon;

/**
 * Created by omsuthar on 7/25/2017.
 */

public interface IEvent extends  IPrint {
    public boolean update();
    public boolean delete();
    public long getEventId();
}
