package com.example.irtazanadeem.madproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity3 extends AppCompatActivity {

    EditText edit_Text_3;
    EditText edit_Text_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_activity3);
        edit_Text_3 = findViewById(R.id.editText3);
        edit_Text_4 = findViewById(R.id.editText4);
    }
    public void onClick_button(View view)
    {
        SharedPreferences sharedpref = getSharedPreferences("User Info",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        if (edit_Text_3.getText().toString().length() != 11)
        {
            Toast.makeText(this,"Invalid Mob Number",Toast.LENGTH_LONG).show();
        }
        else
        {
            editor.putString("Number",edit_Text_3.getText().toString());
            editor.putString("Email",edit_Text_4.getText().toString());
            editor.apply();
            Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
            Intent i = new Intent(this,RegistrationActivity5.class);
            startActivity(i);
        }
    }
}
