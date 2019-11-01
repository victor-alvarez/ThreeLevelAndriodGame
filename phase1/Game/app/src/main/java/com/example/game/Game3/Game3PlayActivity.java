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
    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game3View = new Game3View(this);
        setContentView(game3View);

        account = (Account) getIntent().getSerializableExtra("ac");

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

    protected void gameOver(String winner){
        Intent intent = new Intent(this, Game3ExitActivity.class);
        intent.putExtra("EXTRA_WINNER", winner);
        account.incrementLevel(getApplicationContext());
        account.incrementScore(15, getApplicationContext());
        intent.putExtra("ac", account);
        startActivity(intent);
    }

    /**
     * Handles cases when Activity is stopped.
     */
    @Override
    protected void onStop(){
        super.onStop();
        finish();
    }
}
