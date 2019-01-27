package com.example.irtazanadeem.madproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RegistrationActivity2 extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_activity2);


        radioGroup = findViewById(R.id.radioGroup);

        Button buttonApply = findViewById(R.id.button2);
        i = new Intent(this,RegistrationActivity3.class);

        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                SharedPreferences sharedpref = getSharedPreferences("User Info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpref.edit();
                radioButton = findViewById(radioId);
                String str = radioButton.getText().toString();
                editor.putString("Gender",str);
                editor.apply();
                startActivity(i);

            }
        });
    }

    public void checkButton(View view)
    {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

    }

}
