package com.example.infocity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;


import com.example.infocity.Model.Cities;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private ArrayList<Cities> citiesList;
    private Context context;
    public CustomAdapter(ArrayList<Cities> list, Context cont){
        this.citiesList = list;
        this.context = cont;
    }

    @Override
    public int getCount() {
        return this.citiesList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.citiesList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            LayoutInflater inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.listview_row_layout, null);
            holder = new ViewHolder();
            holder.name_country = (TextView)view.findViewById(R.id.text_countryName);
            holder.name_city = (TextView)view.findViewById(R.id.text_cityName);
            holder.population = (TextView)view.findViewById(R.id.text_population);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        Cities stu = citiesList.get(position);
        holder.name_country.setText(stu.getNameCountry());
        holder.name_city.setText(stu.getNameCity());
        holder.population.setText(stu.getPopulation());

        return view;
    }
    private static class ViewHolder{
        public TextView name_country;
        public TextView name_city;
        public TextView population;
    }
}
