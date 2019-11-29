package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameEnd extends AppCompatActivity {
    /**
     * Text displaying player stats
     */
    private TextView lives, scores;

    /**
     * Code to execute when the Activity is created.
     *
     * @param savedInstanceState A Bundle containing possibly previous states of this Activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);

        //Customizes the Activity based on User preference.
        getWindow().getDecorView().setBackgroundResource(BaseActivity.account.getBackground());

        lives = findViewById(R.id.livesText_GameEnd);
        lives.setText(String.valueOf(BaseActivity.account.getHitPoints()));

        scores = findViewById(R.id.scoreText_GameEnd);
        scores.setText(String.valueOf(BaseActivity.account.getCurrentScore()));
    }

    /**
     * Called when the user taps the "To Main Menu" button. Takes User to the main menu of the App.
     *
     * @param view The View of the Activity.
     */
    public void toMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        //Passes the account into Intent so it can be used accessed in MainActivity.
        BaseActivity.account.resetValues(getApplicationContext());
        startActivity(intent);
    }
}
