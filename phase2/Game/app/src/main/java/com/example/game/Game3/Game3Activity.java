package com.example.game.Game3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.MainActivity;
import com.example.game.R;

/**
 * Activity Class for Game 3
 */
public class Game3Activity extends BaseActivity {

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
        setContentView(R.layout.activity_game3);

        //Account information is passed in.
        account = (Account) getIntent().getSerializableExtra("ac");

        //Customizes the Activity based on User preference.
        if (account.getCustomization()[0] == 1) {
            getWindow().getDecorView().setBackgroundResource(R.color.background1);
        }

        lives = findViewById(R.id.livesText_Game3Activity);
        lives.setText(String.valueOf(account.getSave()[1]));

        scores = findViewById(R.id.scoreText_Game3Activity);
        scores.setText(String.valueOf(account.getSave()[2]));
    }

    /**
     * Called when the user taps the "To Main Menu" button. Takes User to main menu of the App.
     *
     * @param view The View of this Activity.
     */
    public void toMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        //Passes the account into Intent so it can be used accessed in MainActivity.
        intent.putExtra("ac", account);
        startActivity(intent);
    }

    /**
     * Called when user taps the "Play" ButtonObject. Takes User to Game 3 play screen.
     *
     * @param view The View of this Activity.
     */
    public void toPlay(View view) {
        Intent intent = new Intent(this, Game3PlayActivity.class);

        //Passes the account into Intent so it can be used accessed in GamePlay3Activity.
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
