package com.usermindarchive.h.mvptest;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HERO on 9/26/2017.
 */

public interface ModelInterface {
    void receiveEdit(String data);
    String sendText();
    void getView( Context view);
    void getShared(SharedPreferences share);
    Boolean getStatus();
    void setStatus(Boolean test);
    Boolean clearShared();

}
