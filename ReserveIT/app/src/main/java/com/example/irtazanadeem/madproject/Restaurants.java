package com.example.irtazanadeem.madproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Restaurants extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        String[] restaurants = {"Howdy", "Arcadian Cafe", "Monal Lahore", "mcDonald`s", "Cafe Aylanto"};

        ArrayAdapter myArrayAdapter = new customAdapter(this, restaurants);

        ListView myListView = (ListView)findViewById(R.id.restaurents_List);
        myListView.setAdapter(myArrayAdapter);
        myListView.setOnItemClickListener
        (
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        String res = String.valueOf(parent.getItemAtPosition(position));

                        Intent nextActivity = new Intent(Restaurants.this, RestaurantData.class);
                        nextActivity.putExtra("restaurantName", res);
                        startActivity(nextActivity);
                    }
                }
        );
    }
}
















