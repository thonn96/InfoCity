package com.example.infocity.Presenter;


import com.example.infocity.Model.Cities;
import com.example.infocity.Model.HandleDataCity;
import com.example.infocity.Model.LoadDataCityListener;
import com.example.infocity.View.MainView;

import java.util.ArrayList;

public class MainPresenter implements LoadDataCityListener {
    private HandleDataCity mainHandle;
    private MainView mainView;
    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        mainHandle = new HandleDataCity(this);
    }

    public void loadData() {
        mainHandle.createListCityData();
    }
    @Override
    public void onLoadDataCitySuccess(ArrayList<Cities> listCity) {
        mainView.displayMain(listCity);
    }
}
