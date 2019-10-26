package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateAccountActivity extends AppCompatActivity {

    EditText inputName;
    Button button;
    Button button2;
    AccountManager acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        button = findViewById(R.id.createButton2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Todo: create account (perhaps by passing info back to MainActivity).
                // May also send this back to main. For now it will do that.

                // if()
                toMainMenu();
            }
        });

        inputName = (EditText) findViewById(R.id.createName);

        button2 = findViewById(R.id.backButton);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toMainMenu();
            }
        });
    }

    public void toMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
