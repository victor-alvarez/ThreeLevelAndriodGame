package com.example.game.Game2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.R;

public class Riddle2 extends BaseActivity {
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
        setContentView(R.layout.activity_game2_riddle2);

        account = (Account) getIntent().getSerializableExtra("ac");

        if (account.getCustomization()[0] == 1) {
            getWindow().getDecorView().setBackgroundResource(R.color.background1);
        }

        lives = findViewById(R.id.livesText_Riddle2);
        lives.setText(String.valueOf(account.getSave()[1]));

        scores = findViewById(R.id.scoreText_Riddle2);
        scores.setText(String.valueOf(account.getSave()[2]));
    }

    /** Called when the user taps the "McMurdo Dry Valleys, Antarctica" button */
    public void rightGuess2(View view) {
        //account.incrementScore(10, context);
        //if (account.save[1] ==0) {//lose screen}
        Intent intent = new Intent(this, Riddle3.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }

    /** Called when the user taps any other button */
    public void wrongGuess2(View view) {
        //account.decrementHitPoints(1, context);
        Intent intent = new Intent(this, Wrong2.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
