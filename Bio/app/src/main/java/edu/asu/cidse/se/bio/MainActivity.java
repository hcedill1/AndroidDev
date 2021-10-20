package edu.asu.cidse.se.bio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import edu.asu.cidse.se.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //Activity Main binding works almost the same way as findMyId but less expensive
    private ActivityMainBinding binding;
    private EditText enterHobbies;
    private TextView hobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterHobbies = findViewById(R.id.enter_hobbies);
        hobbies = findViewById(R.id.hobbies_text);
    }

    public void addHobbies(View view) {
        hobbies.setText(String.format("Hobbies: %s", enterHobbies.getText().toString().trim()));
        hobbies.setVisibility(View.VISIBLE);

        //we will hide keyboard when the button is clicked done
        InputMethodManager inputMethodManager =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}