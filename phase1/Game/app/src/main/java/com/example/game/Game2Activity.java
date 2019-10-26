package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game2Activity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        button = findViewById(R.id.game2Button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextGame();
            }
        });
    }

    public void nextGame() {
        Intent intent = new Intent(this, Game3Activity.class);
        startActivity(intent);
    }
}
