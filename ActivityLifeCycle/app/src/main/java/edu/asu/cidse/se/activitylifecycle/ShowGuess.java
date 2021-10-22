package edu.asu.cidse.se.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowGuess extends AppCompatActivity {
    private TextView showGuessTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);
        //this will put all of the stuff from intent that is put from the  main activity
       // Bundle extra = getIntent().getBundleExtra();
        showGuessTextView = findViewById(R.id.receive_text_view);



        if(getIntent().getStringExtra("guess") != null){
            String value  = getIntent().getStringExtra("guess");
            String name = getIntent().getStringExtra("name");
            showGuessTextView.setText(value);
            //showGuessTextView.setText(value);
        }

        showGuessTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("message_back", "DEEZ NUTZ");
                //we want to go backward we dont want to pass the startActivity result, this data is ready,
                //to be past on, this is saying that it is ok to send the data back
                setResult(RESULT_OK,intent);
                //so the activities that are being called while programming are being stacked
                //so what this finish does is that it pops the items in the stack.
                finish();
            }
        });

    }
}