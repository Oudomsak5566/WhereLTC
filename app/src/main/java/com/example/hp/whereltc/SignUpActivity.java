package com.example.hp.whereltc;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    // Shotcut Alt + Insert and Select Constructor and Select  Explicit
    public void clickSignUpSign(View view) {
        nameString = nameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();
        //Check space
        if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {

            //Have Space
            Log.d("LogChkSpase", "Have Space");
            // Include Class Alert and Send Data
            MyAlert myAlert = new MyAlert(SignUpActivity.this, "Have space", "Please check your input", R.drawable.doremon48);
            myAlert.myDialog();

        } else {

            try {
                MyUpdateUser myUpdateUser = new MyUpdateUser(SignUpActivity.this,nameString,userString,passwordString);
                myUpdateUser.execute();
                String s = myUpdateUser.get();
                Log.d("14DecV3", "Result ==>" + s);
                if (Boolean.parseBoolean(s)) {
                    finish();
                    Toast.makeText(SignUpActivity.this,"Sign up Complete",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this,"Can't Update User",Toast.LENGTH_SHORT).show();
                }








            } catch (Exception e) {
                Log.d("14DecV2", "e++ ??" + e.toString());
            }

        }


    }//Click Sign



}//main class
