package com.example.hp.whereltc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {


    //Explicit
    private EditText nameEditText, userEditText, passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Bind Widget
        nameEditText = (EditText) findViewById(R.id.editText1);
        userEditText = (EditText) findViewById(R.id.editText3);
        passwordEditText = (EditText) findViewById(R.id.editText4);


    } //main

    public void clickSignUpSign(View view) {


    }


}//main class
