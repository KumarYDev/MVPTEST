package com.usermindarchive.h.mvptest;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HERO on 9/26/2017.
 */

class Presenter {


    private ViewInterface view;
    private ModelInterface model;


    public Presenter(ViewInterface View) {
        this.model=new Model(View.getContext());
        this.view= View;

    }

    public void setClear(Boolean clear){
       if(clear) {
           model.clearShared();
           if(model.clearShared())
               view.DataCleared();
           else view.DataEmpty();
       }
    }

    public void setData(String data) {
        model.receiveEdit(data);
        if(model.getStatus()){
            view.onSuccess();
        }else
            view.onFailure();
    }


    public String getData() {
        return model.sendText();

    }

}
