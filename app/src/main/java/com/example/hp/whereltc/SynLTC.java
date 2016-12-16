package com.example.hp.whereltc;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by HP on 16/12/2016.
 */

public class SynLTC extends AsyncTask<Void,Void,String>{
    private Context context;
    private static final String urlJSON = "http://lao-hosting.com/ltc/get_ltc.php";

    public SynLTC(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlJSON).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}//Main Class
