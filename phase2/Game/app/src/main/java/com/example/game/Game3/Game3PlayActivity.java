package com.example.game.Game3;

import android.content.Intent;
import android.os.Bundle;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.GameOver;
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
     * Code to execute when the Activity is created.
     *
     * @param savedInstanceState A Bundle containing possibly previous states of this Activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Creates view for Game 3.
        super.onCreate(savedInstanceState);
        String difficulty = getIntent().getStringExtra("DIFFICULTY");
        game3View = new Game3View(this, difficulty);
        setContentView(game3View);

        //Customizes the Activity based on User preference.
//        getWindow().getDecorView().setBackgroundResource(account.getBackground());
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
    protected void gameOver(String winner, int hitpoints, int numMoves) {
        Intent intent = new Intent(this, Game3ExitActivity.class);
        intent.putExtra("EXTRA_WINNER", winner);
        intent.putExtra("EXTRA_MOVES", numMoves);
        account.incrementLevel(getApplicationContext().getFilesDir());
        account.incrementScore(hitpoints, getApplicationContext().getFilesDir());
        account.decrementHitPoints(100 - hitpoints, getApplicationContext().getFilesDir());
        account.incrementGamesPlayed(getApplicationContext().getFilesDir());
        if (account.getHitPoints() <= 0){
            //Ran out of lives
            intent = new Intent(this, GameOver.class);
        }
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
