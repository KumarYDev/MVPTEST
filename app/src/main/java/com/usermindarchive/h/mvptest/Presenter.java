package com.usermindarchive.h.mvptest;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HERO on 9/26/2017.
 */

class Presenter {


    private ViewInterface view;
    private ModelInterface model;
    private String dataP;
    private SharedPreferences store;

    public Presenter(MainActivity View) {
//        setView(view);
        this.model=new Model();
        this.view= View;
        store=View.getSharedPreferences("Data",Context.MODE_PRIVATE);
    }

    public void setClear(Boolean clear){
        model.getShared(store);
       if(clear) {
           model.clearShared();
           if(model.clearShared())
               view.DataCleared();
           else view.DataEmpty();
       }
    }

    public void setData(String data) {
        this.dataP=data;
        model.getShared(store);
        model.receiveEdit(data);
        model.getView(view.getContext());
        if(model.getStatus()){
            view.onSuccess();
        }else
            view.onFailure();
    }


    public String getData() {
        model.getShared(store);
        return model.sendText();

    }

}
