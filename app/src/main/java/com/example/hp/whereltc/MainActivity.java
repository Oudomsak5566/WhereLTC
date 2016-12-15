package com.example.hp.whereltc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;
    private String[] loginStrings;
    private  boolean aBoolean = true;




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


                JSONArray jsonArray = new JSONArray(s);
                loginStrings = new String[4];
                for (int i = 0; i < jsonArray.length(); i += 1) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    if (userString.equals(jsonObject.getString("username"))) {

                        loginStrings[0] = jsonObject.getString("id");
                        loginStrings[1] = jsonObject.getString("name");
                        loginStrings[2] = jsonObject.getString("username");
                        loginStrings[3] = jsonObject.getString("password");
                        aBoolean = false;
                    }
                }//For


                if (aBoolean) {
                    MyAlert myAlert = new MyAlert(MainActivity.this,
                            getResources().getString(R.string.tile_user_fail),
                            getResources().getString(R.string.message_user_fail),
                            R.drawable.bird48
                    );
                    myAlert.myDialog();
                } else if (passwordString.equals(loginStrings[3])) {
                    //Password true
                    Toast.makeText(MainActivity.this,"Login Success " + loginStrings[1],Toast.LENGTH_LONG).show();

                } else {
                    //Password False
                    MyAlert myAlert = new MyAlert(MainActivity.this,
                            getResources().getString(R.string.tile_password_fail),
                            getResources().getString(R.string.message_password_fail),
                            R.drawable.rat48);
                    myAlert.myDialog();
                }



            } catch (Exception e) {
                Log.d("14DecV2","e Main > "+e.toString());
            }
        }









    }//clickSignIn





} // Main class
