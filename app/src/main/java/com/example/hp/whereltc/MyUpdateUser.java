package com.example.hp.whereltc;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import okio.BufferedSink;

/**
 * Created by HP on 14/12/2016.
 */


// notice Create Implement Method (Alt+Enter)
public class MyUpdateUser extends AsyncTask<Void, Void, String> {


    //Explicit
    private static final String urlPHP = "http://swiftcodingthai.com/ltc/add_user_Mounoy.php";
    private Context context;
    private String nameString,usernameString,passwordString;

    //Create Constructor (Alt+Insert & Select All Explicit)
    public MyUpdateUser(Context context, String nameString, String usernameString, String passwordString) {
        this.context = context;
        this.nameString = nameString;
        this.usernameString = usernameString;
        this.passwordString = passwordString;
    }


    @Override
    protected String doInBackground(Void... params) {
        try {

            //Add Library - Project Structure >app>dependencies>add library>okhttp
            //include package from com.squreup
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("name", nameString)
                    .add("username", usernameString)
                    .add("password", passwordString)
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            Log.d("14DecV1", "e ++ " + e.toString());
            return null;
        }


    }






}//Main Class
