package com.example.irtazanadeem.madproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText edit_Text_1;
    EditText edit_Text_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        edit_Text_1 = findViewById(R.id.editText);
        edit_Text_2 = findViewById(R.id.editText2);
    }
    public void onClick_button(View view)
    {
        SharedPreferences sharedpref = getSharedPreferences("User Info",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("FirstName",edit_Text_1.getText().toString());
        editor.putString("SurName",edit_Text_2.getText().toString());
        editor.apply();
        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,RegistrationActivity2.class);
        startActivity(i);
    }

}
