package com.example.game.Game1;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.Account;
import com.example.game.BaseActivity;

public class BallJumperActivity extends BaseActivity {
    /**
     * The activity that is commenced once the "Play" or "Retry" button is pressed in Game1.
     */

    // === Instance Variables ===

    Account account;

    /**
     * Creates the GamePanel that is displayed on screen.
     *
     * @param savedInstanceState the saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow()
                .setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;

        setContentView(new GamePanel(this));
        account = (Account) getIntent().getSerializableExtra("ac");
    }

    /**
     * Starts the GameOverActivity and updates the account with Game1 statistics.
     *
     * @param score     the score from Game1.
     * @param hitPoints the hit-points from Game1.
     */
    public void gameOver(int score, int hitPoints) {
        Intent intent = new Intent(this, GameOverActivity.class);
        intent.putExtra("SCORE", score);
        account.incrementLevel(getApplicationContext());
        account.incrementScore(score, getApplicationContext());
        account.decrementHitPoints(hitPoints, getApplicationContext());
        account.incrementGamesPlayed(getApplicationContext());
        intent.putExtra("ac", account);
        startActivity(intent);
    }

    /**
     * Stops this activity.
     */
    @Override
    public void onStop() {
        super.onStop();
        finish();
    }
}
