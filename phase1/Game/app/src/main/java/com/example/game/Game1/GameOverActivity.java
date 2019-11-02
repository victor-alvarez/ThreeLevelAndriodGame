package com.example.game.Game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.Game2.Game2Activity;
import com.example.game.MainActivity;
import com.example.game.R;

public class GameOverActivity extends BaseActivity {

    Account account;

    /**
     * Text displaying the addiction counter (so the number of games played including retries)
     */
    TextView lives, scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        account = (Account) getIntent().getSerializableExtra("ac");

        // Score Labels
        TextView scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        TextView highScoreLabel = (TextView) findViewById(R.id.highScoreLabel);

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
            editor.commit();

        } else {
            highScoreLabel.setText("High Score : " + highScore);
        }

        account = (Account) getIntent().getSerializableExtra("ac");

        if (account.getCustomization()[0] == 1) {
            getWindow().getDecorView().setBackgroundResource(R.color.background1);
        }

        lives = findViewById(R.id.livesText_GameOverActivity);
        lives.setText(String.valueOf(account.getSave()[1]));

        scores = findViewById(R.id.scoreText_GameOverActivity);
        scores.setText(String.valueOf(account.getSave()[2]));
    }

    /** Called when the user taps the "Retry" button */
    public void retry(View view) {
        Intent intent = new Intent(this, BallJumperActivity.class);
        account.decrementLevel(getApplicationContext());
        intent.putExtra("ac", account);
        startActivity(intent);
    }

    /** Called when the user taps the "To Game Two" button */
    public void nextGame(View view) {
        Intent intent = new Intent(this, Game2Activity.class);
        intent.putExtra("ac", account);
        account.incrementLevel(getApplicationContext());
        startActivity(intent);
    }

    /** Called when the user taps the "To Main Menu" button */
    public void toMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
