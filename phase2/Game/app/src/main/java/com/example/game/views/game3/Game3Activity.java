package com.example.game.views.game3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.BaseActivity;
import com.example.game.MainActivity;
import com.example.game.R;

/**
 * Activity Class for Game 3
 */
public class Game3Activity extends BaseActivity {

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

        //Customizes the Activity based on User preference.
//        assert BaseActivity.account!= null;
//        getWindow().getDecorView().setBackgroundResource(BaseActivity.account.getBackground());
//
//        lives = findViewById(R.id.livesText_Game3Activity);
//        lives.setText(String.valueOf(BaseActivity.account.getHitPoints()));
//
//        scores = findViewById(R.id.scoreText_Game3Activity);
//        scores.setText(String.valueOf(BaseActivity.account.getCurrentScore()));
    }

    public void toMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void playGameEasy(View view) {
        Intent intent = new Intent(this, Game3PlayActivity.class);
        intent.putExtra("DIFFICULTY", "easy");
        startActivity(intent);
    }

    public void playGameNormal(View view) {
        Intent intent = new Intent(this, Game3PlayActivity.class);
        intent.putExtra("DIFFICULTY", "normal");
        startActivity(intent);
    }

    public void playGameHard(View view) {
        Intent intent = new Intent(this, Game3PlayActivity.class);
        intent.putExtra("DIFFICULTY", "hard");
        startActivity(intent);
    }
}
