package com.usermindarchive.h.mvptest;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ViewInterface {
   @BindView(R.id.data) EditText data;
    @BindView(R.id.save) Button save;
    @BindView(R.id.show) Button show;
    @BindView(R.id.clear) Button clear;
    @BindView(R.id.display)TextView display;
    Presenter presenter;
    MainActivity main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter=new Presenter(this);




    }
//    @OnClick(R.id.show)
//    public void show(View view) {
//        if(store.contains("file"))
//            display.setText(store.getString("file",""));
//        else
//            Toast.makeText(MainActivity.this,"No Data Saved",Toast.LENGTH_LONG).show();
//    }
//
//    @OnClick(R.id.save)
//    public void save(View view) {
//        Log.e("Data",data.getText().toString());
//        store=MainActivity.this.getSharedPreferences("data",MODE_PRIVATE);
//        SharedPreferences.Editor info=store.edit();
//        info.putString("file",display.getText()+"\n"+data.getText());
//        info.apply();
//    }

    @OnClick(R.id.show)
    public void show(View view) {
        if(!presenter.getData().isEmpty())
        display.setText(presenter.getData());
        else
            display.setText("No data saved");

    }

    @OnClick(R.id.save)
    public void save(View view) {
        if(data.getText().toString().isEmpty())
            data.setError("Enter the Data");
        else
           presenter.setData(data.getText().toString());
    }

    @OnClick(R.id.clear)
    public void clear(View view){
        presenter.setClear(true);
        display.setText(presenter.getData());
    }

    @Override
    public Context getContext() {
        setContext(main);

        return main;
    }

    @Override
    public void setContext(MainActivity main) {
main=MainActivity.this;
    }

    @Override
    public void onSuccess() {
        Toast.makeText(MainActivity.this,"SAVED\n"+data.getText(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure() {
        Toast.makeText(MainActivity.this,"FAILED TO SAVED\n"+data.getText(),Toast.LENGTH_LONG).show();

    }

    @Override
    public void DataEmpty() {
        Toast.makeText(MainActivity.this,"No Data is present",Toast.LENGTH_LONG).show();

    }

    @Override
    public void DataCleared() {
        Toast.makeText(MainActivity.this,"Data is cleared",Toast.LENGTH_LONG).show();

    }
}
