package com.example.game.Game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.Account;
import com.example.game.BaseActivity;
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
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
