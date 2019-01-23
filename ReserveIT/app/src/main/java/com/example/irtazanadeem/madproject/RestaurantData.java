package com.example.irtazanadeem.madproject;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RestaurantData extends AppCompatActivity
{
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_data);

        Bundle data = getIntent().getExtras();
        TextView resNameView=(TextView)findViewById(R.id.R_res_name);
        resNameView.setText(data.getString("restaurantName"));

        viewPager = (ViewPager)findViewById(R.id.pageViewer);

        ViewPagerAdapter imageSlider=new ViewPagerAdapter(this);
        viewPager.setAdapter(imageSlider);

        TextView resAddressview = (TextView)findViewById(R.id.R_res_address);
        String Address = "M M Alam Road, Lahore Pakistan";
        resAddressview.setText(Address);

        TextView resContactview = (TextView)findViewById(R.id.R_res_contact);
        String Contact = "03208482564";
        String phone = "04235123456";
        resContactview.setText("Mobile:" + Contact + " LandLine: " + phone);
    }
}
