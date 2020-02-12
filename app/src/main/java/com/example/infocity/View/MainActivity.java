package com.example.infocity.View;

import android.os.Bundle;

import com.example.infocity.CustomAdapter;
import com.example.infocity.Model.Cities;
import com.example.infocity.Presenter.MainPresenter;
import com.example.infocity.R;


import androidx.appcompat.app.AppCompatActivity;

import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView{
    private MainPresenter mainPresenter;
    public ListView myListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListview = findViewById(R.id.listview);
        initPresenter();
        mainPresenter.loadData();
    }
    private void initPresenter() {
        mainPresenter = new MainPresenter(this);
    }
    @Override
    public void displayMain(ArrayList<Cities> listCity) {
        CustomAdapter myAdapter = new CustomAdapter(listCity, this);
        myListview.setAdapter(myAdapter);
    }
}