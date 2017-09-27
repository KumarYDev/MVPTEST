package com.usermindarchive.h.mvptest;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by HERO on 9/26/2017.
 */

public class Model implements ModelInterface {

    SharedPreferences store;
    Boolean status=false;
    Data share;

    public Model(Context view) {
        share=new Data(view);
//        store=view.getSharedPreferences("Data",Context.MODE_PRIVATE);

    }

    @Override
    public void receiveEdit(String info) {

//        if(store.contains("data")){
//            info=store.getString("data","")+"\n"+info;
//        }
//        SharedPreferences.Editor data=store.edit();
//        data.putString("data",info);
//        data.apply();
//
        share.setData(info);
        setStatus(true);


    }

    @Override
    public String sendText() {
//        return store.getString("data","");
        return share.getData();
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
    public Boolean clearData() {
//        if (store.contains("data")){
//            SharedPreferences.Editor data=store.edit();
//            data.clear();
//            data.apply();
//            return  true;
//        }else
//           return  false;
//        share.clearData();
        return share.clearData();
    }



}
