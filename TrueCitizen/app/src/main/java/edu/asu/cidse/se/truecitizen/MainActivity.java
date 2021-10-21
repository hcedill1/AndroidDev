package edu.asu.cidse.se.truecitizen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import edu.asu.cidse.se.truecitizen.databinding.ActivityMainBinding;
import edu.asu.cidse.se.truecitizen.model.Question;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int currentQuestionIndex = 0;
    private Question[] questionBank = new Question []{
            //create.instantiate questions objects
            new Question(R.string.question_amendments,false),
            new Question(R.string.question_constitution,true),
            new Question(R.string.question_declaration,true),
            new Question(R.string.question_independence_rights,true),
            new Question(R.string.question_religion,true),
            new Question(R.string.question_government,false),
            new Question(R.string.question_government_feds,false),
            new Question(R.string.question_government_senators,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // this will help us access all the objects from the layout such as text view and also buttons etc
        binding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);

        binding.questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());

        binding.trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        binding.falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        //we will be getting the next button
        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this will help the array object not go out of bounce and will go back to the first question
                currentQuestionIndex  = (currentQuestionIndex + 1) % questionBank.length; // this question will increment
                updateQuestion();
                Log.d("MainActivity","onCreate: " + questionBank[currentQuestionIndex++].getAnswerResId());
            }
        });

        binding.prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestionIndex > 0){
                    currentQuestionIndex = (currentQuestionIndex - 1)  % questionBank.length;
                    updateQuestion();
                }

            }
        });

    }

    private void checkAnswer(boolean userChoseCorrect){

        boolean answerIsCorrect = questionBank[currentQuestionIndex].isAnswerTrue();
        Log.d("MainActivity", String.valueOf(answerIsCorrect));
        int messageId;
        if(answerIsCorrect == userChoseCorrect){
            messageId = R.string.correct_answer;
        }else{
            messageId = R.string.wrong_answer;
        }

        Snackbar.make(binding.imageView,messageId, Snackbar.LENGTH_SHORT).show();

    }

    private void updateQuestion() {
        binding.questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }
}