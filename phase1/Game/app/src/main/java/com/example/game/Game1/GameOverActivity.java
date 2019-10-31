package com.example.game.Game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.Account;
import com.example.game.Game2.Game2Activity;
import com.example.game.MainActivity;
import com.example.game.R;

public class GameOverActivity extends AppCompatActivity {

    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        // Score Labels
        TextView scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        TextView highScoreLabel = (TextView) findViewById(R.id.highScoreLabel);

        // Get score from players session
        int score = getIntent().getIntExtra("SCORE", 0);

        // Change scoreLabel text to show what player got after session
        scoreLabel.setText("Score : " + score);

        // Saving high scores
        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE", 0);

        // If score is greater than highScore update highScore
        if (score > highScore) {
            highScoreLabel.setText("High Score : " + score);

            // Save
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", score);
            editor.commit();
        } else {
            highScoreLabel.setText("High Score : " + highScore);
        }

        account = getIntent().getParcelableExtra("ac");
    }

    /** Called when the user taps the "Retry" button */
    public void retry(View view) {
        Intent intent = new Intent(this, BallJumperActivity.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }

    /** Called when the user taps the "To Home" button */
    public void toHome(View view) {
        Intent intent = new Intent(this, Game1Activity.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }

    /** Called when the user taps the "To Game Two" button */
    public void nextGame(View view) {
        Intent intent = new Intent(this, Game2Activity.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }

    /** Called when the user taps the "To Main Menu" button */
    public void toMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
