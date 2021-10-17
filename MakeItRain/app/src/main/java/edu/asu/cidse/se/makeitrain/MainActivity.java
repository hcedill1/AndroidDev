package edu.asu.cidse.se.makeitrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    //private Button makeItRain;
    // private Button showInfo;
    private TextView moneyValue;
    private TextView celebrationOutTxt;
    private int moneyCounter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //makeItRain = findViewById(R.id.buttonMakeItRain);
        moneyValue = findViewById(R.id.moneyValue);
        celebrationOutTxt = findViewById(R.id.celebration_text);

        //differnt view of lambda
//        makeItRain.setOnClickListener(v -> {
//            //TAG is any id that you are trying to attach to this console log
//            //this shows that when the button is clicked on it works. you go to logcat and then click button
//            //and then Log.d will be triggered when button is clicked
//            Log.d("MainActivity", "onClick: Make It Rain!!");
//
//        });

    }

    //this is another way to trigger the button is by going into the acitivity main and adding onClick events on a button
    // this should print out make it rain when button make it rain is clicked on
    //why are we passing the view type? its because if we dont pass the view android will not know the
    //hiararchy of the button. Because everything inherits from the view class, so internally it will know
    //that the button view Make it rain will be triggered. so you must pass view, in order for android
    //studio to know what to trigger.
    public void showMoney(View view) {
        //this will allow you format the type of currency dollar
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter = moneyCounter + 1000;
        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));
        //this will be setting the color when the number value reaches over 20000
        if(moneyCounter >= 20000){
            celebrationOutTxt.setText(R.string.celebrationOut);
            //this set number value to turn into white
            moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,
                    R.color.white));
            Log.d("MainActivity","Higher than 20000, " + moneyCounter );
        }
        //so why does this not work "moneyValue.setText(moneyCounter);" its because the setText only wants to return
        //a text value NOT an integer. what we can do is use valueof that will convert int to a string.

        Log.d("MainActivity", "onClick Make it Rain " + moneyCounter);
    }

    public void showInfo(View view) {
        //Context is how it already knows how things are going to be layed out on the android screen.
//        Toast.makeText(MainActivity.this,R.string.app_info,Toast.LENGTH_SHORT)
//        .show();
        //there is another widget which is called snackbar better than toast

        Snackbar.make(moneyValue,R.string.app_info,Snackbar.LENGTH_LONG)
                .setAction("More", view1 ->{
                    Log.d("Snack","show info : Snackbar More");
                })
                .show();


    }




}