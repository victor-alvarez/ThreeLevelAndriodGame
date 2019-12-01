package com.example.game.viewLevel.game1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.BaseActivity;
import com.example.game.viewLevel.game2.Game2Activity;
import com.example.game.viewLevel.MainActivity;
import com.example.game.R;

/**
 * GameOverActivity class. This is what the player will see when they lose.
 */
public class GameOverActivity extends BaseActivity {

    /**
     * Text displaying the addiction counter (so the number of games played including retries)
     */
    TextView lives, scores;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        // Score Labels
        TextView scoreLabel = findViewById(R.id.scoreLabel);
        TextView highScoreLabel = findViewById(R.id.highScoreLabel);

        // Get score from players session
        int score = getIntent().getIntExtra("SCORE", 0);

        // Change scoreLabel text to show what player got after session
        scoreLabel.setText("Score : " + score);

        // Saving high scores
        SharedPreferences settings = getSharedPreferences("HIGH_SCORE", Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE", 0);

        // If score is greater than highScore update highScore
        if (score > highScore) {
            highScoreLabel.setText("High Score : " + score);

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", score);
            editor.apply();

        } else {
            highScoreLabel.setText("High Score : " + highScore);
        }

        assert account != null;
        getWindow().getDecorView().setBackgroundResource(account.getBackground());

        lives = findViewById(R.id.livesText_GameOverActivity);
        lives.setText(String.valueOf(account.getHitPoints()));

        scores = findViewById(R.id.scoreText_GameOverActivity);
        scores.setText(String.valueOf(account.getCurrentScore()));
    }

    /**
     * Called when the user taps the "Retry" button
     */
    public void retry(View view) {
        Intent intent = new Intent(this, BallJumperActivity.class);
        intent.putExtra("difficulty", getIntent().getStringExtra("difficulty"));
        account.decrementLevel(getApplicationContext().getFilesDir());
        startActivity(intent);
    }

    /**
     * Called when the user taps the "To Game Two" button
     */
    public void nextGame(View view) {
        Intent intent = new Intent(this, Game2Activity.class);
        account.incrementLevel(getApplicationContext().getFilesDir());
        startActivity(intent);
    }

    /**
     * Called when the user taps the "To Main Menu" button
     */
    public void toMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
