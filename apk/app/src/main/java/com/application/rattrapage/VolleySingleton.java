package com.application.rattrapage;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    public static final String BASE_URL = "http://88a9090f.ngrok.io/";
    public static final String BASE_URL_API = BASE_URL+"";
    private static VolleySingleton instance;

    private RequestQueue requestQueue;

    private static Context mContext;

    private VolleySingleton(Context context){
        mContext = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        return requestQueue;
    }

    public static synchronized VolleySingleton getInstance(Context context){
        if (mContext == null)
            instance = new VolleySingleton(context);
        return instance;
    }

    public <T> void addToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }

}
