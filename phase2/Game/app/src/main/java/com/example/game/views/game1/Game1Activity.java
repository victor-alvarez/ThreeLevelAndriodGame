package com.example.game.views.game1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.BaseActivity;
import com.example.game.MainActivity;
import com.example.game.R;
import com.example.game.views.game1.BallJumperActivity;

public class Game1Activity extends BaseActivity {
    /**
     * The main UI for Game1.
     */

    // === Instance Variables ===

    /**
     * Creates layout that is displayed on screen.
     *
     * @param savedInstanceState the saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        assert BaseActivity.account!= null;
        getWindow().getDecorView().setBackgroundResource(BaseActivity.account.getBackground());
    }

    /**
     * Called when the user taps the "Play" button
     *
     * @param view the view that is connected to this method.
     */
    public void playGameEasy(View view) {
        Intent intent = new Intent(this, BallJumperActivity.class);
        intent.putExtra("difficulty", "easy");
        startActivity(intent);
    }

    public void playGameNormal(View view) {
        Intent intent = new Intent(this, BallJumperActivity.class);
        intent.putExtra("difficulty", "normal");
        startActivity(intent);
    }

    public void playGameHard(View view) {
        Intent intent = new Intent(this, BallJumperActivity.class);
        intent.putExtra("difficulty", "hard");
        startActivity(intent);
    }

    /**
     * Called when the user taps the "To Main Menu" button
     *
     * @param view the view that is connected to this method.
     */
    public void toMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
