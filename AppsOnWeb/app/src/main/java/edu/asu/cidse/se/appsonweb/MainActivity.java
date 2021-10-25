package edu.asu.cidse.se.appsonweb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.android.volley.RequestQueue.*;

/**
 * We are going to be learn how to use Volley Server
 * We used AndroidManifest file to grant permission to grab info from the internet
 * <uses-permission android:name="android.permission.INTERNET"/>
 */

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    //we are going to get everything as a string everything from the url
    //we can get the context of any html
    String url = "https://www.google.com";
    String apiUrl = "https://jsonplaceholder.typicode.com/todos";
    String getApiUrl = "https://jsonplaceholder.typicode.com/todos/1";
    //instance variable
    //RequestQueue queue;
    //We are doing singleton version of request queue
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewDisplay);

        //the request queue is the object that will make sure that all of this transaction
        //if we are going to fetch data from the internal it will queue all the data
        //it queues out request and managers information on how they are going to be executed
        //this has to be inside onCreate in order to make request
        //knows how to queue request in a timely manner
        //queue = Volley.newRequestQueue(this);
        queue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();


        jsonObjectRequ();


        //jsonArrayObject(queue);

        //getUrlString(queue);

    }

    private void jsonObjectRequ() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, getApiUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    //how do we get this to print out into the Interface
                    textView.setText(response.getString("title"));

                    Log.d("jsonObj","onCreate: " + response.getString("title"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("jsonObject","Error");
            }
        });
        //We are going to be using the singleton example in order for classes not to be declared
        //continuously
        //queue.add(jsonObjectRequest);
        queue.add(jsonObjectRequest);
    }


    private void jsonArrayObject(RequestQueue queue) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, apiUrl, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //response returns an array,so since we know its an array
                        //we are able to loop through
                        //inside we have an object inside the json array.
                        //so how do we loop through objects?
                        for(int i = 0; i < response.length(); i++){
                            //so everytime we loop through the zero index we get it as an object
                            //the reason why we need a try catch is that we do not know if it will work
                            try {
                                /**
                                 * [
                                 *   {
                                 *     "userId": 1,
                                 *     "id": 1,
                                 *     "title": "delectus aut autem",
                                 *     "completed": false
                                 *   },
                                 *   {
                                 *     "userId": 1,
                                 *     "id": 2,
                                 *     "title": "quis ut nam facilis et officia qui",
                                 *     "completed": false
                                 *   },
                                 *
                                 *   We can see that we are grabbing these objects inside the array
                                 *   and we are going to try to grab its properties which is userID
                                 *   id, title, completed
                                 */
                                JSONObject jsonObject = response.getJSONObject(i);
                                //what we are going to be doing is grabbing the jsonObject string "title"
                                //because the id is integer
                                //so for "completed" we will do getBoolean();
                                Log.d("Main","onCreate: " + jsonObject.getString("title"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.d("Main","onCreate: " + response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("JSON","Error");
            }
        });

        queue.add(jsonArrayRequest);
    }

    private void getUrlString(RequestQueue queue) {
        //so in this case we are using Request.Method.Get becuase we are trying to grab infromation from a website
        //for the url we are passing where we are getting the information from.
        //for new Response.Listener that we can retrieve the string request
        //so in the response this response is whatever we are getting from the url
        //also url is asking google to give a string representation of the webpage
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //response is what we are going to be getting from our url
                //substring(0,500) instead of getting the whole payload from our url link(google.com)
                //we are just going to get up to 500 characters.
                Log.d("Main","onCreate "+ response.substring(0,500));



            }
        }, new Response.ErrorListener() {
            //anytime we are trying to fetch things from the internet we do not have too much control
            //we need to see these errors
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Main","Failed to get info");
            }
        });

        //so without the queue on line 23 string request could not grab any information
        //request to the request queue
        queue.add(stringRequest);
    }
}