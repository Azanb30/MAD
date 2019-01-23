package com.example.irtazanadeem.madproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegistrationActivity4 extends AppCompatActivity {

    TextView textView_1;
    TextView textView_2;
    TextView textView_3;
    TextView textView_4;
    Button button;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_activity4);
        textView_1 = findViewById(R.id.textView4);
        textView_2 = findViewById(R.id.textView7);
        textView_3 = findViewById(R.id.textView8);
        textView_4 = findViewById(R.id.textView9);
        button = findViewById(R.id.button4);
        i = new Intent(this,RegistrationActivity3.class);//yahn sy load ho gi irtaza ki login page
        SharedPreferences sharedpref = getSharedPreferences("User Info",Context.MODE_PRIVATE);
        String name = sharedpref.getString("FirstName","");
        String sn = sharedpref.getString("SurName","");
        String m = sharedpref.getString("Number","");
        String e = sharedpref.getString("Email","");
        textView_1.setText(name);
        textView_2.setText(sn);
        textView_3.setText(m);
        textView_4.setText(e);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);

            }
        });
    }
}
