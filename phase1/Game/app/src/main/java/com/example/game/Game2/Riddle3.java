package com.example.game.Game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.Account;
import com.example.game.R;

public class Riddle3 extends AppCompatActivity {
    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2_riddle3);
        account = (Account) getIntent().getSerializableExtra("ac");
    }

    /** Called when the user taps upper "None of the above" button */
    public void rightGuess3(View view) {
        account.incrementScore(100);
        account.incrementLevel();
        Intent intent = new Intent(this, Win.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }

    /** Called when the user taps any other button */
    public void wrongGuess3(View view) {
        account.decrementHitPoints(1);
        Intent intent = new Intent(this, Wrong3.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}
