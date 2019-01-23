package com.example.irtazanadeem.madproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity5 extends AppCompatActivity {

    EditText edit_Text_7;
    EditText edit_Text_8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_activity5);
        edit_Text_7 = findViewById(R.id.editText7);
        edit_Text_8 = findViewById(R.id.editText8);
    }
    public void onClick_b(View view)
    {
        if (edit_Text_7.getText().toString().length() != 0 && edit_Text_8.getText().toString().length()!=0)
        {
            if (edit_Text_7.getText().toString().equals(edit_Text_8.getText().toString()))
            {
                Toast.makeText(this,"Sign Up Successfully",Toast.LENGTH_LONG).show();
                Intent i = new Intent(this,RegistrationActivity4.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this,"Password Not Same",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_LONG).show();
        }
    }
}
