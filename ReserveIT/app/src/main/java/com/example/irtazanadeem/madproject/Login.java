package com.example.irtazanadeem.madproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public EditText username;
    public EditText password;
    SQLiteHelper myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        myDatabase = new SQLiteHelper(this);

    }

    public void onClickLoginButton(View view)
    {
        String UN = username.getText().toString();
        String PWD = password.getText().toString();
        SharedPreferences SP = getSharedPreferences("UserInfo", MODE_PRIVATE);

        if(UN.isEmpty())
        {
            Toast.makeText(this, "User Id field is empty", Toast.LENGTH_SHORT).show();
        }
        else if(PWD.isEmpty())
        {
            Toast.makeText(this, "Password field is empty", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (myDatabase.verify_em_ps(UN,PWD))
            {
                Toast.makeText(this, "You are now Logged In", Toast.LENGTH_SHORT).show();
                Intent i = i = new Intent(this,MainActivity.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this, "User Not Exists", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
