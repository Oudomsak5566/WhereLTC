package com.example.hp.whereltc;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {


    //Explicit
    private EditText nameEditText, userEditText, passwordEditText;
    private String nameString, userString, passwordString;


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
        nameString = nameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check space
        if (nameString.equals("")|| userString.equals("")||passwordString.equals("")) {

            //Have Space
            Log.d("LogChkSpase", "Have Space");

            MyAlert myAlert = new MyAlert(SignUpActivity.this,"Have space","Please check your input",R.drawable.doremon48);
            myAlert.myDialog();

        }


    }//Click Sign



}//main class
