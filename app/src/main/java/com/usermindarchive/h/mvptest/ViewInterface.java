package com.usermindarchive.h.mvptest;

import android.content.Context;

/**
 * Created by HERO on 9/26/2017.
 */

public interface ViewInterface {
Context getContext();
    void setContext(MainActivity main);
    void onSuccess();

    void onFailure();
    void DataEmpty();

    void DataCleared();
}
