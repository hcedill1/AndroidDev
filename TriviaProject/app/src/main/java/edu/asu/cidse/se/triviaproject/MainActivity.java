package edu.asu.cidse.se.triviaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import edu.asu.cidse.se.triviaproject.controller.AppController;
import edu.asu.cidse.se.triviaproject.data.AnswerListAsyncResponse;
import edu.asu.cidse.se.triviaproject.data.Repository;
import edu.asu.cidse.se.triviaproject.databinding.ActivityMainBinding;
import edu.asu.cidse.se.triviaproject.model.Question;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    //this is going to be keeping the current question index.
    private int currentQuestionIndex = 0;
    List<Question>  questionList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //why doesnt this simply work, this only prints out an empty list but on the Question file does work
        //reason is is because when we are looking at json array request or fetching data from remote data
        //is becuase they are not synchronous, two processes is going on the same time while the other one is
        //waiting. So to protect the integerity in the background so they wont polute the user interface
        //the android system prevents us to grab the information. In order to make this to work is play by the rules
        //so whatever we are doing it needs to be asynchronous we need to send a signal from Repository.java
        // Log.d("Main","onCreate " + questions);
        questionList = new Repository().getQuestion(questionArrayList ->{
            //remember to add the curly braces to show that you want to add more than one line of code
                    binding.questionTextView.setText( questionArrayList.get(currentQuestionIndex).getAnswer());

                }
        );

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
                currentQuestionIndex = (currentQuestionIndex + 1) % questionList.size();

            }
        });
        binding.buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        binding.buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);

            }
        });

    }

    private void checkAnswer(boolean check) {
        boolean answer = questionList.get(currentQuestionIndex).isAnswerTrue();
        int snackMessageId = 0;

        if(check == answer){
            snackMessageId = R.string.correct_answer;
        }else{
            snackMessageId = R.string.incorrect_answer;
        }

        Snackbar.make(binding.cardView,snackMessageId,Snackbar.LENGTH_SHORT).show();

    }

    private void updateCounter(ArrayList<Question> questionArrayList) {
        binding.textViewOutOf.setText(String.format(getString(R.string.formated), currentQuestionIndex,
                questionArrayList.size()));
    }

    private void updateQuestion(){
        String question = questionList.get(currentQuestionIndex).getAnswer();
        binding.questionTextView.setText(question);
        updateCounter((ArrayList<Question>) questionList);
    }

}