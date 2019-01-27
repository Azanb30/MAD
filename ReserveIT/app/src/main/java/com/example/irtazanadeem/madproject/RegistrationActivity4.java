package com.example.irtazanadeem.madproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity4 extends AppCompatActivity {

    TextView textView_1;
    TextView textView_2;
    TextView textView_3;
    TextView textView_4;
    TextView textView_5;
    SQLiteHelper myDatabase;
    Button button;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_activity4);
        myDatabase = new SQLiteHelper(this);
        textView_1 = findViewById(R.id.textView4);
        textView_2 = findViewById(R.id.textView7);
        textView_3 = findViewById(R.id.textView8);
        textView_4 = findViewById(R.id.textView9);
        textView_5 = findViewById(R.id.textView10);
        button = findViewById(R.id.button4);
        i = new Intent(this,Restaurants.class);//yahn sy load ho gi irtaza ki login page
        SharedPreferences sharedpref = getSharedPreferences("User Info",Context.MODE_PRIVATE);
        final String name = sharedpref.getString("FirstName","");
        final String sn = sharedpref.getString("SurName","");
        final String m = sharedpref.getString("Number","");
        final String e = sharedpref.getString("Email","");
        final String g = sharedpref.getString("Gender","");
        final String p = sharedpref.getString("pass","");
        textView_1.setText(name);
        textView_2.setText(sn);
        textView_3.setText(m);
        textView_4.setText(e);
        textView_5.setText(g);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInserted = myDatabase.insertData(e,name,sn,g,m,p);
                if (isInserted == true)
                    Toast.makeText(RegistrationActivity4.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(RegistrationActivity4.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });
    }
}
