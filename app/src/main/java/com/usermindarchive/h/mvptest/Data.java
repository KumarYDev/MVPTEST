package com.usermindarchive.h.mvptest;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HERO on 9/27/2017.
 */

public class Data {

    SharedPreferences store;

    public Data(Context data) {
        store=data.getSharedPreferences("Data",Context.MODE_PRIVATE);

    }

    public void setData(String info){
        if(store.contains("data")){
            info=store.getString("data","")+"\n"+info;
        }
        SharedPreferences.Editor data=store.edit();
        data.putString("data",info);
        data.apply();


    }

    public String getData(){
        return store.getString("data","");
    }

    public Boolean clearData(){
        if (store.contains("data")){
            SharedPreferences.Editor data=store.edit();
            data.clear();
            data.apply();
            return  true;
        }else
            return  false;
    }
}
