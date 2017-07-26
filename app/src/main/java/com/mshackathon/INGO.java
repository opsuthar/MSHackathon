package com.mshackathon;

/**
 * Created by omsuthar on 7/24/2017.
 */

public interface INGO extends  IPrint {
    public boolean update(); // Delete the user account.
    public boolean delete();
    public IEvent CreateEvent(EventInfo eventInfo);
}
