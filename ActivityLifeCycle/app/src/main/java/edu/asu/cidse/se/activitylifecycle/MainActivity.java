package edu.asu.cidse.se.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button showGuess;
    private EditText enterGuess;
    private final int REQUESTCODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //we are going to start off by grabbing the button
        showGuess = findViewById(R.id.button_guess);
        //grabbing the plain text view from plain_text to the next Guess Activity
        enterGuess = findViewById(R.id.guess_field);

        showGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //.getText() would sometimes get different characters that are not letters so
                //then it is converted to toString() in order to have those randome characters turn into
                //a string the trim for any of the junk left over like spaces etc


                String guess = enterGuess.getText().toString().trim();

                if(!guess.isEmpty()){
                    //so this will be passing the context from the main to the show guess activity
                    Intent intent = new Intent(MainActivity.this,ShowGuess.class);
                    intent.putExtra("name","Hernan");
                    //putExtra is an overloaded functions which means that you are able to pass any type
                    intent.putExtra("guess",guess);
                    //out activity is available because we are extending the app compat activity
                    //this is not expecting a result back
                    //startActivity(intent);
                    //so we can use this method so in order for onActivityResult() to work we use this method
                    startActivityForResult(intent, REQUESTCODE);


                }else{
                    Toast.makeText(MainActivity.this,"Enter Guess",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    //int request code whenever you want to request something or send something the request code is going to be resquestCode
    // resultCode internal protocol, the result that we are going to be receiveing is going to be internal
    //@Nullable means that could be null
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUESTCODE){
            assert data != null;
            String message = data.getStringExtra("message_back");
            Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
        }

    }
}