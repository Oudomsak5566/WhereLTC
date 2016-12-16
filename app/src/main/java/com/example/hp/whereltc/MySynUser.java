package com.example.hp.whereltc;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by HP on 14/12/2016.
 */
//Create Extends & Implement Method String (Alt+Insert)
public class MySynUser extends AsyncTask<Void,Void,String>{
    //Explicit
    private Context context;
    private static final String urlJSON = "http://lao-hosting.com/ltc/get_user_master.php";



    //Create Constructor (Alt+Insert)
    public MySynUser(Context context) {
        this.context = context;
    }


    @Override
    protected String doInBackground(Void... params) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlJSON).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            //Chk Log (Alt+6)
            Log.d("14DecV2", "e SynUser > "+e.toString());
            return null;
        }

    }
}//Main
