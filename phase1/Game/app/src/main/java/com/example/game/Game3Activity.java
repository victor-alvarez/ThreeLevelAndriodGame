package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game3Activity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);

        button = findViewById(R.id.game3Button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextGame();
            }
        });
    }

    public void nextGame() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
