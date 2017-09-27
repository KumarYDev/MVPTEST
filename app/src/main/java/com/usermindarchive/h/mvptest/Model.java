package com.usermindarchive.h.mvptest;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by HERO on 9/26/2017.
 */

public class Model implements ModelInterface {
    Presenter presenter;
    String data;
    Context viewInterface;
    SharedPreferences store;
    Boolean status=false;
    Boolean clear=false;

    @Override
    public void receiveEdit(String info) {

        if(store.contains("data")){
            info=store.getString("data","")+"\n"+info;
        }
        SharedPreferences.Editor data=store.edit();
        data.putString("data",info);
        data.apply();
        setStatus(true);


    }

    @Override
    public String sendText() {
        return store.getString("data","");
    }

    @Override
    public void getView(Context view) {
this.viewInterface=view;
    }

    @Override
    public void getShared(SharedPreferences share) {
        this.store=share;
    }

    @Override
    public Boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(Boolean test) {
this.status=test;
    }



    @Override
    public Boolean clearShared() {
        if (store.contains("data")){
            SharedPreferences.Editor data=store.edit();
            data.clear();
            data.apply();
            return  true;
        }else
           return  false;
    }



}
