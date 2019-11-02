package com.example.game.Game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.R;

public class Riddle3 extends BaseActivity {
    Account account;

    /**
     * Text displaying player stats
     */
    TextView lives, scores;

    /**
     * Code to execute when the Activity is created.
     *
     * @param savedInstanceState A Bundle containing possibly previous states of this Activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2_riddle3);

        account = (Account) getIntent().getSerializableExtra("ac");

        if (account.getCustomization()[0] == 1) {
            getWindow().getDecorView().setBackgroundResource(R.color.background1);
        }

        lives = findViewById(R.id.livesText_Riddle3);
        lives.setText(String.valueOf(account.getSave()[1]));

        scores = findViewById(R.id.scoreText_Riddle3);
        scores.setText(String.valueOf(account.getSave()[2]));
    }

    /** Called when the user taps upper "None of the above" button */
    public void rightGuess3(View view) {
        Intent intent = new Intent(this, Win.class);
        account.incrementLevel(getApplicationContext());
        account.incrementScore(20, getApplicationContext());
        intent.putExtra("ac", account);
        startActivity(intent);
    }

    /** Called when the user taps any other button */
    public void wrongGuess3(View view) {
        Intent intent = new Intent(this, Wrong3.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
