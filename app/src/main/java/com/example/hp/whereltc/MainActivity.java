package com.example.hp.whereltc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editTextUser);
        passwordEditText = (EditText) findViewById(R.id.editTextPassword);//findViewById(R.id.editTextPassword > Cast to (Alt+Enter)

    } // Main method

    public void clickSingUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

    public void clickSignIn(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        if (userString.equals("")||passwordString.equals("")) {
            //Have Space
            MyAlert myAlert = new MyAlert(MainActivity.this,
                    getResources().getString(R.string.tile_have_space) ,
                    getResources().getString(R.string.message_have_space),
                    R.drawable.nobita48);
            myAlert.myDialog();
        } else {
            //No Space
            try {
                MySynUser mySynUser = new MySynUser(MainActivity.this);
                mySynUser.execute();
                String s = mySynUser.get();
                Log.d("14DecV2", "JSon > " + s);




            } catch (Exception e) {
                Log.d("14DecV2","e Main > "+e.toString());
            }
        }









    }//clickSignIn





} // Main class
