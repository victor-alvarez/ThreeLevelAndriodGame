package com.example.game.Game3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.R;

/**
 * Play Activity for Game 3.
 */
public class Game3PlayActivity extends BaseActivity {

    /**
     * Game Loop for this Game.
     */
    private Game3View game3View;

    /**
     * Account of the User currently playing this game.
     */
    Account account;

    /**
     * Code to execute when the Activity is created.
     *
     * @param savedInstanceState A Bundle containing possibly previous states of this Activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Creates view for Game 3.
        super.onCreate(savedInstanceState);
        game3View = new Game3View(this);
        setContentView(game3View);

        //Account information is passed in.
        account = (Account) getIntent().getSerializableExtra("ac");

        //Customizes the Activity based on User preference.
        if (account.getCustomization()[0] == 1) {
            getWindow().getDecorView().setBackgroundResource(R.color.background1);
        }
    }

    /**
     * Handles cases when Activity is paused.
     */
    @Override
    protected void onPause() {
        super.onPause();
        game3View.pause();
    }

    /**
     * Handles cases when Activity is resumed.
     */
    @Override
    protected void onResume() {
        super.onResume();
        game3View.resume();
    }

    /**
     * Handles the case when the game is done.
     *
     * @param winner    The winner of the game.
     * @param hitpoints The hitpoints the Player earned.
     */
    protected void gameOver(String winner, int hitpoints) {
        Intent intent = new Intent(this, Game3ExitActivity.class);
        intent.putExtra("EXTRA_WINNER", winner);
        account.incrementLevel(getApplicationContext());
        account.incrementScore(hitpoints, getApplicationContext());
        //TODO: add hit point decrement
        //account.decrementHitPoints();
        intent.putExtra("ac", account);
        startActivity(intent);
    }

    /**
     * Handles cases when Activity is stopped.
     */
    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
