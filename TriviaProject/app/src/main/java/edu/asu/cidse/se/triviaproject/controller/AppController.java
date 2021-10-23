package edu.asu.cidse.se.triviaproject.controller;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import edu.asu.cidse.se.triviaproject.MainActivity;

/**
 * Our controller we are going to create a singleton for volley
 * extends Application contains all the properties for android application
 * on the manifest file we go into the application
 * and put android:name=".controller.AppController" in
 * order for AppController file to government the app
 * This is code from the singleton
 */


public class AppController extends Application {

    private static AppController instance;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private static Context ctx;


    //from these methods down we will be using it for the project
    //this is where we are creating trhe singleton
    public static synchronized AppController getInstance() {
//        if (instance == null) {
//            instance = new AppController();
//        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    /**
     * We are going to override the onCreate because Application is being inherited
     */

    @Override
    public void onCreate() {

        super.onCreate();
        instance = this;
    }


}
