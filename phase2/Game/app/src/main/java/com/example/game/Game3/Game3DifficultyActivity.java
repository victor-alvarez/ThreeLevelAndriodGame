package com.example.game.Game3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.R;


public class Game3DifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_difficulty);
    }

    public void playGameEasy(View view) {
        Intent intent = new Intent(this, Game3PlayActivity.class);
        intent.putExtra("DIFFICULTY", "easy");
        startActivity(intent);
    }

    public void playGameNormal(View view) {
        Intent intent = new Intent(this, Game3PlayActivity.class);
        intent.putExtra("DIFFICULTY", "normal");
        startActivity(intent);
    }

    public void playGameHard(View view) {
        Intent intent = new Intent(this, Game3PlayActivity.class);
        intent.putExtra("DIFFICULTY", "hard");
        startActivity(intent);
    }
}
