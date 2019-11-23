package com.example.game.Game2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.GameOver;
import com.example.game.R;

public class Wrong1 extends BaseActivity {
    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2_riddle1_wrong);

        account = (Account) getIntent().getSerializableExtra("ac");

        if (account.getCustomization()[0] == 1) {
            getWindow().getDecorView().setBackgroundResource(R.color.background1);
        }
    }

    /** Called when the user taps the "Back to the Riddle" button */
    public void back1(View view) {
        Intent intent = new Intent(this, Riddle1.class);
        account.decrementHitPoints(5, getApplicationContext());
        account.incrementScore(-3, getApplicationContext());
        if (account.getSave()[1] <= 0){
            //Ran out of lives
            intent = new Intent(this, GameOver.class);
        }
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
