package com.example.game.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.models.Constants;

public class BallJumperActivity extends BaseActivity {
    /**
     * The activity that is commenced once the "Play" or "Retry" button is pressed in Game1.
     */

    // === Instance Variables ===

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
        account.incrementLevel(getApplicationContext().getFilesDir());
        account.incrementScore(score, getApplicationContext().getFilesDir());
        account.decrementHitPoints(hitPoints, getApplicationContext().getFilesDir());
        account.incrementGamesPlayed(getApplicationContext().getFilesDir());
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
