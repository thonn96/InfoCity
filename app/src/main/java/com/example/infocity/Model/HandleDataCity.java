package com.example.infocity.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class HandleDataCity {
    private LoadDataCityListener listener;
    SQLiteDatabase db = null;
    public static final String DATABASE_NAME = "utopia_cities.db";
    private static final int DATABASE_VERSION = 1;
    public static final String n_country = "country";
    public static final String n_city = "city";
    public static final String n_population = "population";

    //create constructor
    public HandleDataCity(LoadDataCityListener listener){
        this.listener = listener;
    } // end constructor
// open Dababase and create list contain data from database
    public void createListCityData(){
        ArrayList<Cities> citiesList = new ArrayList<>();
        


        String myPath = "/data/data/com.example.infocity/databases/utopia_cities.db";

        db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor res = db.rawQuery("SELECT * FROM cities",null);

        if (res.moveToFirst()) {
            while(!res.isAfterLast()) {
                String name_country = res.getString(res.getColumnIndex(n_country));
                String name_city = res.getString(res.getColumnIndex(n_city));
                String population = res.getString(res.getColumnIndex(n_population));
                Cities newCities = new Cities(name_country, name_city, population);
                citiesList.add(newCities);
                res.moveToNext();
            }
        }
        listener.onLoadDataCitySuccess(citiesList);

    }
    // end.
}
