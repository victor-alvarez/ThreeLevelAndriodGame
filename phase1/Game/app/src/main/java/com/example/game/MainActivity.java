package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText inputName;
    Button button;
    Button button2;
    Button button3;

    SharedPreferences mPreferences;

    AccountManager accountManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (mPreferences.getInt("Colour", 0) == 1) {
            getWindow().getDecorView().setBackgroundResource(R.color.background1);
        }

        //TODO: Load in account information to accountManager

        button = findViewById(R.id.settingsButton_MainActivity);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openOptions();
            }
        });

        inputName = (EditText) findViewById(R.id.accountNameText_MainActivity);

        button2 = findViewById(R.id.inputButton_MainActivity);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //if (inputName.getText().toString().equals(temp)){
                //TODO: Do something with the correct account to pass instructions about data
                // and starting point
                startGame();
                //}
            }
        });

        button3 = findViewById(R.id.createButton_MainActivity);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createAccount();
            }
        });


    }

    public void openOptions() {
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    public void startGame() {
        /* TODO:
        Do something different depending on the selected account. Game manager should handle this
        in the backend.
         */
        Intent intent = new Intent(this, Game1Activity.class);
        //Intent.putExtra("ac", accountManager);
        startActivity(intent);
    }

    public void createAccount() {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }
}
