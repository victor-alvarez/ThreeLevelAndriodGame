package com.example.game.Game3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.R;

/**
 * Play Activity for Game 3.
 */
public class Game3PlayActivity extends AppCompatActivity {

    /**
     * Game Loop for this Game.
     */
    private Game3View game3View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game3View = new Game3View(this);
        setContentView(game3View);
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
     * Handles cases when Activity is stopped.
     */
    @Override
    protected void onStop() {
        super.onStop();
    }
}
