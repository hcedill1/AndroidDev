package edu.asu.cidse.se.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import edu.asu.cidse.se.bio.data.Bio;
import edu.asu.cidse.se.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //Activity Main binding works almost the same way as findMyId but less expensive
    private ActivityMainBinding binding;
    private final Bio bio = new Bio();
//    private EditText enterHobbies;
//    private TextView hobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //we dont need this for data binding
//        setContentView(R.layout.activity_main);
//        enterHobbies = findViewById(R.id.enter_hobbies);
//        hobbies = findViewById(R.id.hobbies_text);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        bio.setName("Hernan Cedillo");
        binding.setBio(bio);
        binding.doneButton.setOnClickListener(v -> {
            addHobbies(v);
        });



    }

    public void addHobbies(View view) {
      // bio.setHobbies(String.format("Hobbies: %s", binding.enterHobbies.getText().toString().trim()));
       binding.hobbiesText.setText(String.format("Hobbies: %s", binding.enterHobbies.getText().toString().trim()));
        //this will refresh the user interface
        binding.invalidateAll();
        binding.hobbiesText.setVisibility(View.VISIBLE);
        //dont need this for binding data
//        hobbies.setText(String.format("Hobbies: %s", enterHobbies.getText().toString().trim()));
//        hobbies.setVisibility(View.VISIBLE);

        //we will hide keyboard when the button is clicked done
        InputMethodManager inputMethodManager =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}