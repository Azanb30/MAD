package com.example.irtazanadeem.madproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IndexActivity extends AppCompatActivity {

    Button restaurant;
    Button login;
    Button signup;
    Button reserve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        restaurant = (Button)findViewById(R.id.restaurantButton);
        login = (Button)findViewById(R.id.loginButton);
        signup = (Button)findViewById(R.id.signupButton);
        reserve = (Button)findViewById(R.id.reserveButton);

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IndexActivity.this,Restaurants.class);
                startActivity(i);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IndexActivity.this, Registration.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IndexActivity.this, Login.class);
                startActivity(i);
            }
        });

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(this,);
                //startActivity(i);
            }
        });

    }
}
