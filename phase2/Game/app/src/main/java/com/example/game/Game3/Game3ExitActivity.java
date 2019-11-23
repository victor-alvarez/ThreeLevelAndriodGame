package com.example.game.Game3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.GameEnd;
import com.example.game.R;

/**
 * Exit Activity for Game 3.
 */
public class Game3ExitActivity extends BaseActivity {

    /**
     * Account of the User currently playing this game.
     */
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

        //Sets the view for this Activity.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_exit);

        //Draws the TextView showing the Result of the game that just ended.
        TextView gameResult = (TextView) findViewById(R.id.gameResult);
        gameResult.setText(getIntent().getStringExtra("EXTRA_WINNER"));
        gameResult.setTextColor(Color.BLUE);
        gameResult.setTextSize(50);

        //Account information is passed in.
        account = (Account) getIntent().getSerializableExtra("ac");

        //Customizes the Activity based on User preference.
        if (account.getCustomization()[0] == 1) {
            getWindow().getDecorView().setBackgroundResource(R.color.background1);
        }

        lives = findViewById(R.id.livesText_Game3Activity2);
        lives.setText(String.valueOf(account.getSave()[1]));

        scores = findViewById(R.id.scoreText_Game3Activity2);
        scores.setText(String.valueOf(account.getSave()[2]));
    }

    /**
     * Called when the user taps the "Retry" button. Restarts the game for the User.
     *
     * @param view The View of the Activity.
     */
    public void retry(View view) {
        Intent intent = new Intent(this, Game3PlayActivity.class);

        account.decrementLevel(getApplicationContext());
        //Passes the account into Intent so it can be used accessed in Game3PlayActivity.
        intent.putExtra("ac", account);
        startActivity(intent);
    }

    /**
     * Called when the user taps the "To Main Menu" button. Takes User to the main menu of the App.
     *
     * @param view The View of the Activity.
     */
    public void toEndGame(View view) {
        Intent intent = new Intent(this, GameEnd.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
