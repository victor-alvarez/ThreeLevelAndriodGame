package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.models.ActivityDataResponseActions;

public class GameEnd extends AppCompatActivity implements ActivityDataResponseActions {
    /**
     * Text displaying player stats
     */
    private TextView lives, scores;

    private ActivityDataPresenter presenter;

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

        presenter = new ActivityDataPresenter(this, new ActivityDataUseCases());
    }

    public void resetAndMoveTo(View view) {
        presenter.resetDataValues(getApplicationContext().getFilesDir());
    }

    @Override
    public void reactToReset() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
