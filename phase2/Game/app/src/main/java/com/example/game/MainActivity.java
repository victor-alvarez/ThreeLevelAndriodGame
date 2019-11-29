package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.game.Game2.RiddleActivity;
import com.example.game.views.Game1Activity;
import com.example.game.views.GameOverActivity;
import com.example.game.Game2.Game2Activity;
import com.example.game.Game3.Game3Activity;
import com.example.game.Game3.Game3ExitActivity;

/**
 * Main menu activity in which the player may navigate to the settings menu, load their game from
 * the previous point they left off at or start a new game.
 */
public class MainActivity extends BaseActivity {
    /**
     * Text displaying player stats. addCoun is for addition counter, a counter for number of games
     * played including retries.
     */
    private TextView addCoun, lives, scores;

    /**
     * Code to execute when the Activity is created.
     *
     * @param savedInstanceState A Bundle containing possibly previous states of this Activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView icon = findViewById(R.id.User_Icon);

        getWindow().getDecorView().setBackgroundResource(account.getBackground());

        icon.setImageResource(account.getIcon());

        addCoun = findViewById(R.id.addCoun_MainActivity);
        addCoun.setText(String.valueOf(account.getGamesPlayed()));

        lives = findViewById(R.id.livesText_MainActivity);
        lives.setText(String.valueOf(account.getHitPoints()));

        scores = findViewById(R.id.scoreText_MainActivity);
        scores.setText(String.valueOf(account.getCurrentScore()));
    }

    /**
     * Called when the user taps the "Resume Game" button
     */
    public void resumeGame(View view) {
        int level = account.getLastAttemptedLevel();
        Intent intent;
        if (level == 0) {
            // Resets most of the values for the player as they are starting a new game
            account.resetValues(getApplicationContext().getFilesDir());
            intent = new Intent(this, Game1Activity.class);
        } else if (level == 1) {
            intent = new Intent(this, GameOverActivity.class);
        } else if (level == 2) {
            intent = new Intent(this, Game2Activity.class);
        } else if (level == 3) {
            intent = new Intent(this, Game3Activity.class);
        } else {
            intent = new Intent(this, Game3ExitActivity.class);
        }
        startActivity(intent);
    }

    /**
     * Called when the user taps the "Settings" button
     */
    public void openOptions(View view) {
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    /**
     * Called when the user taps the "Start Game" button
     */
    public void startGame(View view) {
        Intent intent = new Intent(this, Game1Activity.class);
        // Resets most of the values for the player as they are starting a new game
        account.resetValues(getApplicationContext().getFilesDir());
        startActivity(intent);
    }
}
