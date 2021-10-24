package edu.asu.cidse.se.triviaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import edu.asu.cidse.se.triviaproject.controller.AppController;
import edu.asu.cidse.se.triviaproject.data.AnswerListAsyncResponse;
import edu.asu.cidse.se.triviaproject.data.Repository;
import edu.asu.cidse.se.triviaproject.model.Question;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //why doesnt this simply work, this only prints out an empty list but on the Question file does work
        //reason is is because when we are looking at json array request or fetching data from remote data
        //is becuase they are not synchronous, two processes is going on the same time while the other one is
        //waiting. So to protect the integerity in the background so they wont polute the user interface
        //the android system prevents us to grab the information. In order to make this to work is play by the rules
        //so whatever we are doing it needs to be asynchronous we need to send a signal from Repository.java
        // Log.d("Main","onCreate " + questions);
        List<Question> questions = new Repository().getQuestion(questionArrayList ->
                Log.d("Main","onCreate " + questionArrayList));




    }
}