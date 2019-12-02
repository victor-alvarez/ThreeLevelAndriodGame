package com.example.game.viewLevel.game3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.BaseActivity;
import com.example.game.R;
import com.example.game.models.DataIncrementerUseCases;
import com.example.game.models.interfaces.DataIncrementerActions;
import com.example.game.presenters.DataIncrementerPresenter;
import com.example.game.viewLevel.ScoreboardActivity;

/**
 * Exit Activity for Game 3.
 */
public class Game3ExitActivity extends BaseActivity implements DataIncrementerActions {

    /**
     * Text displaying player stats
     */
    private TextView lives, scores;

    /**
     * Presenter which manages interactions with this view.
     */
    private DataIncrementerPresenter presenter;

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
        TextView gameResult = findViewById(R.id.gameResult);
        gameResult.setText(getIntent().getStringExtra("EXTRA_WINNER"));
        gameResult.setTextColor(Color.BLUE);
        gameResult.setTextSize(50);

        //Customizes the Activity based on User preference.
        getWindow().getDecorView().setBackgroundResource(account.getBackground());

        lives = findViewById(R.id.livesText_Game3Activity2);
        lives.setText(String.valueOf(account.getHitPoints()));

        scores = findViewById(R.id.scoreText_Game3Activity2);
        scores.setText(String.valueOf(account.getCurrentScore()));

        presenter = new DataIncrementerPresenter(this,
                new DataIncrementerUseCases());
    }

    /**
     * Called when the user taps the "Retry" button. Restarts the game for the User.
     *
     * @param view The View of the Activity.
     */
    public void retry(View view) {
        presenter.decrementLevel(getApplicationContext().getFilesDir());
    }

    /**
     * Called when the user taps the "To Main Menu" button. Takes User to the main menu of the App.
     *
     * @param view The View of the Activity.
     */
    public void toEndGame(View view) {
        presenter.incrementLevel(getApplicationContext().getFilesDir());
    }

    /**
     * Sends user back to the game.
     */
    @Override
    public void toRetry() {
        Intent intent = new Intent(this, Game3Activity.class);
        startActivity(intent);
    }

    /**
     * Sends user to the scoreboard screen.
     */
    @Override
    public void toNext() {
        Intent intent = new Intent(this, ScoreboardActivity.class);
        startActivity(intent);
    }
}
