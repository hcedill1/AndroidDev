package edu.asu.cidse.se.triviaproject.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import edu.asu.cidse.se.triviaproject.controller.AppController;
import edu.asu.cidse.se.triviaproject.model.Question;

/**
 * this is where we are going to use the model class question and use as a repository bank
 */
public class Repository {
    //this array list will contain Question types that we are creating in model package
    //we are instantiating which we are going to populate from the api into the arraylist
    //Array list is an implementation of a list type
    ArrayList<Question> questionArrayList = new ArrayList<Question>();
    String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";

    //it will return a list containing questions
    //this callback is going to be past as a parameter to our method
    public List<Question> getQuestion(final AnswerListAsyncResponse callBack){
        //for this we have go through two arrays
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        //we are getting the array within the array
                        //Log.d("Repo", "Deez: " + response.getJSONArray(i));

                        //now we have to single grab the question and the answer on its own
                        Log.d("Repo","getQuestion(): " + response.getJSONArray(i).getString(0));
                        Log.d("Repo","getQuestion(): " + response.getJSONArray(i).getBoolean(1));

                        //as we look through we want to create a question object

                        //First we need to instantiate a question object
                        //so we have this question object that is being created every time we loop through
                        //but we want to return list
                        //what we are also doing is we are setting categorizing the question into two peaces
                        Question question = new Question(response.getJSONArray(i).getString(0), response.getJSONArray(i).getBoolean(1));

                        //add question to array list/list
                        //so everytime we loop through we are creating a new question object and setting it into the question arraylist
                        questionArrayList.add(question);

                        //this will be printing out objects of type question
                        //we are not probing into the elements into our array
                        //but it means that everything is working perfectly
                        //but if we do this outside of the class
                        //Log.d("List Question","List" +questionArrayList);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                //we have to create a interface class that has a method that is not implement
                //that will be used to connect Reposotiry class to any other class
                //which says if this is ready then we are able to use it in other classes
                //its called a call back method.
                //in order for the array list to asynch you need to have it outside try catch
                if(null != callBack) callBack.processFinished(questionArrayList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Repo","Error could not grab data");

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        return questionArrayList;
    }
}
