package edu.asu.cidse.se.systempreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //so when we have something that we never change we invoke a static
    private static final String MESSAGE_ID = "messages_prefs";
    private TextView showMessageTextView;
    private EditText enterMessage;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMessageTextView = findViewById(R.id.show_message);
        enterMessage = findViewById(R.id.enter_message);
        saveButton = findViewById(R.id.save_button);

        
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = enterMessage.getText().toString().trim();
                //we only want this application to have access to this file which is why we set it to
                //MODE PRIVATE
                //every time we create a shared preferences you need a MESSAGE_ID so what is the id of the shared preference file
                //it is saved as an xml file
                SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
                //we need to invoke the editor, so know we are able to have sharedEdit point to where out shared preferences is
                //it has to come with an editor in order to start writing
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //only the editor will be able to use and grab information
                //so this is a structure like a hashmap so we have key and value pairs
                editor.putString("message", message);

                //right here we are saving to disk.
                editor.apply();
            }
        });

        //Get data back from shared preferences
        //to get stuff back
        SharedPreferences getShareData = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
        String value = getShareData.getString("message","Nothing yet");
        showMessageTextView.setText(value);
    }
}